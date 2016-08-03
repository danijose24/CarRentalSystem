package com.i2i.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.i2i.model.Car;
import com.i2i.service.CarService;
import com.i2i.model.User;
import com.i2i.service.UserService;
import com.i2i.model.Booking;
import com.i2i.service.BookingService;
import com.i2i.model.Make;
import com.i2i.service.MakeService;
import com.i2i.exception.UserDefinedException;

@Controller
public class CarRentalSystemController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	BookingService bookingService;
	
	@Autowired
    CarService carService;
	
	private Booking confirmBooking = null;
	
	@RequestMapping(value = "/signUp")
	public ModelAndView getRegisterForm(@RequestParam("car") int carId) {
		System.out.println("entering into sign up");
		System.out.println(carId);
		getCarId(carId);
		return new ModelAndView("Register");
	}
	
	@RequestMapping(value = "/goSignUp")
	public ModelAndView goRegisterForm() {
		System.out.println("entering into sign up");
		return new ModelAndView("Register");
	}
	
	private int tempCarId;
	public void getCarId(int carId) {
		tempCarId = carId;
	}
	
	private User tempUser;
	public void getUserid(User user) {
		tempUser = user;
	}
	
	@RequestMapping("/admin")
	public ModelAndView getAdminForm() {
		System.out.println("entering into admin");
		return new ModelAndView("AdminLogin");
	}
	
	@RequestMapping("/adminform")
	public ModelAndView getAdmin() {
		System.out.println("entering into  admin form");
		return new ModelAndView("Admin");
	}
	@RequestMapping("/mainHome")
	public ModelAndView getHomeForm() {
		System.out.println("entering into home page");
		return new ModelAndView("HomePage");
	}
	
	@RequestMapping("/logIn")
	public ModelAndView getLoginForm() {
		System.out.println("entering into Login");
		return new ModelAndView("Login");
	}
	
    @RequestMapping("/addCar")
	public ModelAndView getCarAddForm() {
		System.out.println("entering into add car");
		return new ModelAndView("NewCarAdd");
	}
	
	@RequestMapping("/assignMakeToCar")
	public ModelAndView getAssignMakeToCar() {
		System.out.println("entering into add make");
		return new ModelAndView("AssignMakeToCar");
	}
	
	@RequestMapping("/addMake")
	public ModelAndView getMakeAddForm() {
		System.out.println("entering into add make");
		return new ModelAndView("AddNewMake");
	}
	
	@RequestMapping("/bookingSuccess")	
	public ModelAndView getBookingCarForm(@ModelAttribute("booking") Booking booking,BindingResult result) {
	    
		Map<String, Booking> model = new HashMap<String, Booking>();
		try {
		    confirmBooking = booking;
		    System.out.println("get Booking Car controller");
		    Car car = carService.findCarById(tempCarId);
		    Date d1 = booking.getPickupDate();
            Date d2 = booking.getDropDate();
            long difference = d2.getTime() - d1.getTime();
            int dayDifference = (int) (long) difference;
            int totalDays = dayDifference / (24 * 60 * 60 * 1000);
            totalDays = totalDays + 1;
            System.out.println(totalDays +"days");
            int amount = car.getMake().getRate() * totalDays;
            booking.setAmount(amount);
	        model.put("booking", booking);
	    } catch (UserDefinedException e) {
		    System.out.println(e);
        }
		return new ModelAndView("confirmBooking", model);
	}
	
	@RequestMapping("/finalBooking")
	public ModelAndView finalBooking() {
		try {
		    System.out.println("entering into final booking");
		    Car car = carService.findCarById(tempCarId);
		    confirmBooking.setCar(car);
	    	confirmBooking.setUser(tempUser);
		    bookingService.addBooking(confirmBooking);
	    } catch (UserDefinedException e) {
		    System.out.println(e);
        }
		return new ModelAndView("payment");
	}
	
	@RequestMapping("/saveUser")
	public ModelAndView saveUserData(@ModelAttribute("user") User user,
			BindingResult result) {
		try {
			System.out.println("Entering  Save User controller");
            java.sql.Time createdAt = new java.sql.Time(new java.util.Date().getTime());
            user.setCreatedAt(createdAt);
		    userService.addUser(user);
		} catch(UserDefinedException e) {
			System.out.println(e);
		}
		System.out.println("Save User Data");
		return new ModelAndView("Login");
	}
	
	/*
	 * controller to create a new car
	 */
	@RequestMapping("/carAddResult")
	public ModelAndView addNewCar(@ModelAttribute("car") Car car,BindingResult result) {
		try {
		    System.out.println("Enter in to Save new Car");
		    
		    carService.addCar(car);
		} catch(UserDefinedException e) {
			System.out.println(e);
		}
		return new ModelAndView("Admin");
		
	}
	@Autowired
    MakeService makeService ;
	
	@RequestMapping("/carMakeResult")
	public ModelAndView addNewCar(@ModelAttribute("make") Make make,BindingResult result) {
		try {
		    System.out.println("Enter in to MAKEnew Car");
		    makeService.addMake(make);
		} catch(UserDefinedException e) {
			System.out.println(e);
		}
		return new ModelAndView("Admin");
		
	}
	
	@RequestMapping(value = "/saveAssignMakeToCar", method=RequestMethod.POST)
	public ModelAndView assignMakeToCar(@RequestParam("makeId") int makeId , @RequestParam("carId") int carId) {
		try {
		    System.out.println("Enter in to assigning");
            Make make = makeService.findMakeById(makeId);
            Car car = carService.findCarById(carId);
		    Set<Car> cars = new HashSet<Car>();
		    cars.add(car);
            carService.assignMakeToCars(cars, make);
            System.out.println("make assigned successfully");
		} catch(UserDefinedException e) {
			System.out.println(e);
		}
		return new ModelAndView("Admin");
	}
		
	@RequestMapping("/availableCar")
	public ModelAndView getUserList() {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			System.out.println("entering into car list");
		    model.put("car", carService.totalCarsDetails());
		} catch(UserDefinedException e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return new ModelAndView("AvailableCars", model);
	}
	
	@RequestMapping("/checkUser")
	public ModelAndView getUser(@ModelAttribute("user") User user,
     	   BindingResult result)  {
		try {
			System.out.println("ENTER IN TO CHECK controller");
			User checkUser = userService.findUser(user);
			getUserid(checkUser);
			if(null != checkUser) {
				return new ModelAndView("BookingCar");
			}
		} catch (UserDefinedException e){
			return new ModelAndView("ErrorInLogin");
	    }
		return null;
	}
	
	@RequestMapping("/checkAdmin")
	public ModelAndView getAdmin(@ModelAttribute("user") User user,
     	   BindingResult result)  {
		try {
			String adminEmail = "admin@gmail.com";
			String adminPassword = "123456";
			if(adminEmail.equals(user.getEmail()) && adminPassword.equals(user.getPassword())) {
	
			    System.out.println("check admin controller");
		    	return new ModelAndView("Admin");
			} else {
				return new ModelAndView("AdminLogin");
			}
		} catch (Exception e) {
			System.out.println(e);
			return new ModelAndView("AdminLogin");
	    }
	}
}