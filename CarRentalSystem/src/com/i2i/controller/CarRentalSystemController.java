package com.i2i.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
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
	UserService userService = new UserService();
	BookingService bookingService = new BookingService();
	@RequestMapping("/signUp")
	public ModelAndView getRegisterForm() {
		System.out.println("Register Form");
		return new ModelAndView("Register");
	}
	
	
	@RequestMapping("/admin")
	public ModelAndView getAdminForm() {
		System.out.println("Login controller");
		return new ModelAndView("AdminLogin");
	}
	
	@RequestMapping("/adminform")
	public ModelAndView getAdmin() {
		System.out.println("Login controller");
		return new ModelAndView("Admin");
	}
	@RequestMapping("/mainHome")
	public ModelAndView getHomeForm() {
		System.out.println("Login controller");
		return new ModelAndView("HomePage");
	}
	
	@RequestMapping("/logIn")
	public ModelAndView getLoginForm() {
		System.out.println("Login controller");
		return new ModelAndView("Login");
	}
	
	/*@RequestMapping("/bookingCar")
	public ModelAndView getBookingForm() {
		System.out.println("from user to Booking car page");
		return new ModelAndView("BookingCar");
	}*/
	
	@RequestMapping("/addCar")
	public ModelAndView getCarAddForm() {
		System.out.println("Add CAR Controller");
		return new ModelAndView("NewCarAdd");
	}
	
	
	@RequestMapping("/addMake")
	public ModelAndView getMakeAddForm() {
		System.out.println("Add CAR Controller");
		return new ModelAndView("NewMakeAdd");
	}
	
	
	
	/*
	 * controller for add a new Bookking
	 */
	@RequestMapping("/bookingSucess")
	
	public ModelAndView getBookingCarForm(@ModelAttribute("booking") Booking booking,BindingResult result) {
		try {
			System.out.println("get Booking Car controller");
			bookingService.addBooking(booking);
			Date d1 = booking.getPickupDate();
            Date d2 = booking.getDropDate();
            long difference = d2.getTime() - d1.getTime();
            difference = difference + 1;
            int dayDifference = (int) (long) difference;
            int totalDays = dayDifference / (24 * 60 * 60 * 1000);
            System.out.println(totalDays +"days");
           // Set<Booking> bookings = new HashSet<Booking>();
		    //bookings.add(booking);
            //bookingService.assignUserToBookings(bookings, user);
		} catch (UserDefinedException e){
			System.out.println(e);
	    }
	    return new ModelAndView("Success");
	}
	
	/*
	 * contoller for careat a new user
	 */
	
	@RequestMapping("/saveUser")
	public ModelAndView saveUserData(@ModelAttribute("user") User user,
			BindingResult result) {
		try {
			System.out.println("Entering  Save User controller");
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
		    CarService carService = new CarService();
		    carService.addCar(car);
		} catch(UserDefinedException e) {
			System.out.println(e);
		}
		return new ModelAndView("Admin");
		
	}
	
	
	@RequestMapping("/carMakeResult")
	public ModelAndView addNewCar(@ModelAttribute("make") Make make,BindingResult result) {
		try {
		    System.out.println("Enter in to MAKEnew Car");
		    MakeService makeService = new MakeService();
		    makeService.addMake(make);
		} catch(UserDefinedException e) {
			System.out.println(e);
		}
		return new ModelAndView("Admin");
		
	}
	
		
	@RequestMapping("/availableCar")
	public ModelAndView getUserList() {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			CarService carService = new CarService();
		    model.put("car", carService.totalCarsDetails());
		} catch(UserDefinedException e) {
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
			System.out.println("check admin controller");
			User checkUser = userService.findUser(user);
			if(null != checkUser) {
				return new ModelAndView("Admin");
			}
		} catch (UserDefinedException e){
			return new ModelAndView("AdminLogin");
	    }
		return null;
	}
	
}
