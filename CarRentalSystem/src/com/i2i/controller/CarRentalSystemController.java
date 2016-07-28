package com.i2i.controller;

import java.util.HashMap;
import java.util.Map;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.i2i.model.User;
import com.i2i.service.UserService;
import com.i2i.exception.UserDefinedException;

@Controller
public class CarRentalSystemController {
	UserService userService = new UserService();
	
	@RequestMapping("/register")
	public ModelAndView getRegisterForm(@ModelAttribute("user") User user,
			BindingResult result) {
		System.out.println("Register Form");
		return new ModelAndView("Register");
	}
	
	@RequestMapping("/saveUser")
	public ModelAndView saveUserData(@ModelAttribute("user") User user,
			BindingResult result) {
		try {
		    userService.addUser(user);
		} catch(UserDefinedException e) {
			System.out.println(e);
		}
		System.out.println("Save User Data");
		return new ModelAndView("redirect:/userList.html");
	}
	
	@RequestMapping("/userList")
	public ModelAndView getUserList() {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
		    model.put("user", userService.totalUsersDetails());
		} catch(UserDefinedException e) {
			System.out.println(e);
		}
		return new ModelAndView("UserDetails", model);

	}
}
