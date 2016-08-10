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

/**
 * <h1> CarRentalSystemController</h1>
 * 
 * @author sudhakar
 * @created 25-07-2016
 */
@Controller
public class CarRentalSystemController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	BookingService bookingService;
	
	@Autowired
    CarService carService;
	
	@Autowired
    MakeService makeService ;
	
	private Booking confirmBooking = null;
	private User currentUser = null;
	private int tempCarId ;
	private String currentAdmin = null;
	
	/**
	 * <p>The main home page method is used to show home page of Car Rental.</p>
	 * 
	 * @return ModelAndView
	 *          It returns to home page.
	 */
	@RequestMapping("/mainHome")
	public ModelAndView mainHomePage() {
		currentAdmin = null;
		currentUser = null;
		System.out.println("entering into main home");
		System.out.println("entering into 2nd main home");
		return new ModelAndView("homePage");
	}

	/**
	 * <p>The sign up method is used to show sign up page for user registration.</p>
	 * 
	 * @param carId
	 *         carId is used to find which car is going to book.
	 * @return ModelAndView
	 *          It returns to sign up page.
	 */
	@RequestMapping(value = "/signUp")
	public ModelAndView signUp(@RequestParam("car") int carId) {
		tempCarId = carId;
		return new ModelAndView("signUp");
	}
	
	/**
	 * <p>The go sign up method is used to show sign up page for user registration.</p>
	 * 
	 * @return ModelAndView
	 *          It returns to sign up page.
	 */
	@RequestMapping(value = "/goSignUp")
	public ModelAndView goSignUp() {
		return new ModelAndView("signUp");
	}
	
	/**
	 * <p>The admin login method is used to show admin log in page for admin login.</p>
	 * 
	 * @return ModelAndView
	 *          It returns to the admin login page.
	 */
	@RequestMapping("/admin")
	public ModelAndView adminLogIn() {
		return new ModelAndView("adminLogin");
	}
	
	/**
	 * <p>The admin method is used to show admin page for admin.</p>
	 * 
	 * @return ModelAndView
	 *          It returns to the admin page.
	 */
	@RequestMapping("/adminform")
	public ModelAndView admin() {
		return new ModelAndView("admin");
	}
	
	/**
	 * <p>The login form method is used to show login page for user login.</p>
	 * 
	 * @return ModelAndView
	 *          It  returns to the login page.
	 */
	@RequestMapping("/logIn")
	public ModelAndView logInForm() {
		return new ModelAndView("logIn");
	}
	
	/**
	 * <p>The add car method is used to show add new car page.</p>
	 * 
	 * @return ModelAndView
	 *          It returns to add new car page if admin is login.
	 * @return ModelAndView
	 *          It returns to admin login page if admin is not login.
	 */
    @RequestMapping("/addCar")
	public ModelAndView addCar() {
    	if (null == currentAdmin) {
			return new ModelAndView("adminLogin");
		} else {
		    return new ModelAndView("addNewCar");
		}
	}
	
    /**
     * <p>The assign make to car method is used to show assign make to car page.</p>
     * 
     * @return ModelAndView
	 *          It returns to admin login page if admin is not login.
     * @return ModelAndView
     *          It returns to assign make to login page if admin is login.
     */
	@RequestMapping("/assignMakeToCar")
	public ModelAndView assignMakeToCar() {
		if (null == currentAdmin) {
			return new ModelAndView("adminLogin");
		} else {
		    return new ModelAndView("assignMakeToCar");
		}
	}
	
	/**
	 * <p>The add make method is used to show add make page.</p>
	 * 
	 * @return ModelAndView
	 *          It returns to admin login page if admin is not login.
	 * @return ModelAndView
	 *          It returns to add new make page if admin is log in.
	 */
	@RequestMapping("/addMake")
	public ModelAndView addMake() {
		if (null == currentAdmin) {
			return new ModelAndView("adminLogin");
		} else {
		    return new ModelAndView("addNewMake");
		}
	}
	
	/**
	 * <p>The booking method is used to show booking page.</p>
	 * 
	 * @param booking
	 *         booking is used to find booking details from user.
	 * @param result
	 *         result it holds the result of binding page.
	 * @return ModelAndView
	 *          It returns to confirmBooking page if user is login.
	 * @return ModelAndView
	 *          It returns to login page if user is logout.
	 */
	@RequestMapping("/bookingSuccess")	
	public ModelAndView booking(@ModelAttribute("booking") Booking booking,BindingResult result) {
	    
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
		if (null == currentUser) {
			return new ModelAndView("logIn");
		} else {
			return new ModelAndView("confirmBooking", model);
		}
	}
	
	/**
	 * <p>The finalBooking method is used to show finalBooking page.</p>
	 * 
	 * @return ModelAndView
	 *          It returns to payment page if user is login.
	 * @return ModelAndView
	 *          It returns to login page if user is logout.
	 */
	@RequestMapping("/finalBooking")
	public ModelAndView finalBooking() {
		try {
		    Car car = carService.findCarById(tempCarId);
		    confirmBooking.setCar(car);
	    	confirmBooking.setUser(currentUser);
		    bookingService.addBooking(confirmBooking);
	    } catch (UserDefinedException e) {
		    System.out.println(e);
        }
		if (null == currentUser) {
			return new ModelAndView("logIn");
		} else {
			return new ModelAndView("payment");
		}
	}
	
	/**
	 * <p>The saveUserData method is used to save user details.</p>
	 * 
	 * @param user
	 *         It holds the details of user.
	 * @param result
	 *         It holds the result of binding page.
	 * @return ModelAndView
	 *          It returns to login page if user details are added.
	 */
	@RequestMapping("/saveUser")
	public ModelAndView saveUserData(@ModelAttribute("user") User user,
			BindingResult result) {
		try {
            java.sql.Timestamp createdAt = new java.sql.Timestamp(new java.util.Date().getTime());
            user.setCreatedAt(createdAt);
		    userService.addUser(user);
		} catch(UserDefinedException e) {
			System.out.println(e);
		}
		return new ModelAndView("logIn");
	}
	
	/**
	 * <p>The addNewCar method is used to show add new car page.</p>
	 * 
	 * @param car
	 *         It holds the details of car.
	 * @param result
	 *         It holds the result of binding page.
	 * @return ModelAndView
	 *          It returns to the admin page if car details are added.
	 */
	@RequestMapping("/carAddResult")
	public ModelAndView addNewCar(@ModelAttribute("car") Car car,BindingResult result) {
		try {
		    System.out.println(car);
		    java.sql.Time createdAt = new java.sql.Time(new java.util.Date().getTime());
            car.setCreatedAt(createdAt);
            System.out.println(createdAt);
		    carService.addCar(car);
		} catch(UserDefinedException e) {
			System.out.println(e);
		}
		return new ModelAndView("admin");
		
	}
		
	/**
	 * <p>The addNewMake method is used to show add new make page.</p>
	 * 
	 * @param make
	 *         It holds the details of make.
	 * @param result
	 *         It holds the result of binding page.
	 * @return ModelAndView
	 *          It returns to admin page if make details are added.
	 */
	@RequestMapping("/carMakeResult")
	public ModelAndView addNewMake(@ModelAttribute("make") Make make,BindingResult result) {
		try {
		    makeService.addMake(make);
		} catch(UserDefinedException e) {
			System.out.println(e);
		}
		return new ModelAndView("admin");
		
	}
	
	/**
	 * <p>The assignMakeToCar method is used to show assign Make To Car page.</p>
	 * 
	 * @param makeId
	 *         It holds the make id.
	 * @param carId
	 *         It holds the car id.
	 * @return ModelAndView
	 *          It returns to admin page if make is assigned to car.
	 */
	@RequestMapping(value = "/saveAssignMakeToCar", method=RequestMethod.POST)
	public ModelAndView assignMakeToCar(@RequestParam("makeId") int makeId , @RequestParam("carId") int carId) {
		try {
            Make make = makeService.findMakeById(makeId);
            Car car = carService.findCarById(carId);
		    Set<Car> cars = new HashSet<Car>();
		    cars.add(car);
            carService.assignMakeToCars(cars, make);
		} catch(UserDefinedException e) {
			System.out.println(e);
		}
		return new ModelAndView("admin");
	}
		
	/**
	 * <p>The carList method is used to show availableCars page.</p>
	 * 
	 * @return ModelAndView
	 *          It returns to availableCars page.
	 */
	@RequestMapping("/availableCar")
	public ModelAndView carList() {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			System.out.println("entering into available cars");
		    model.put("car", carService.totalCarsDetails());
		} catch(UserDefinedException e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return new ModelAndView("availableCars", model);
	}
	
	/**
	 * <p>The checkUser method is used to check whether the user is already registered or not.</p>
	 * 
	 * @param user
	 *         It holds the details of user. 
	 * @param result
	 *         It holds the result of binding page.
	 * @return ModelAndView
	 *          It returns to booking Car page if user is login.
	 */
	@RequestMapping("/checkUser")
	public ModelAndView checkUser(@ModelAttribute("user") User user,
     	   BindingResult result) {
		try {
			User checkUser = userService.findUser(user);
			currentUser = checkUser;
			if(null != checkUser && null != currentUser) {
				return new ModelAndView("bookingCar");
			} else {
				return new ModelAndView("logIn");
			}
		} catch (UserDefinedException e) {
			return new ModelAndView("errorInLogin");
	    }
	}
	
	/**
	 * <p>The checkAdmin method is used to check whether the admin is login or not.</p>
	 * 
	 * @param user
	 *         It holds the details of user admin.
	 * @param result
	 *         It holds the result of binding page.
	 * @return ModelAndView
	 *          It returns to admin page if admin name and password is correct.
	 * @return ModelAndView
	 *          It returns to admin login page if admin name and password is wrong.
	 */
	@RequestMapping("/checkAdmin")
	public ModelAndView checkAdmin(@ModelAttribute("user") User user,
     	   BindingResult result)  {
		System.out.println(user);
		try {
			String adminEmail = "admin@gmail.com";
			String adminPassword = "123456";
			if(adminEmail.equals(user.getEmail()) && adminPassword.equals(user.getPassword())) {
				currentAdmin = user.getEmail();
		    	return new ModelAndView("admin");
			} else {
				return new ModelAndView("adminLogin");
			}
		} catch (Exception e) {
			System.out.println(e);
			return new ModelAndView("adminLogin");
	    }
	}	
}