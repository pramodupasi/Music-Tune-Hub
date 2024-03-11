package com.kodnest.tunehub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kodnest.tunehub.entity.User;
import com.kodnest.tunehub.serviceimpl.UserServiceImpl;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsersController {

	@Autowired
	UserServiceImpl serviceImpl;

	@PostMapping("/register")
	public String addUsers(@ModelAttribute User user){

		//		System.out.println(user.getUsername() +" "+user.getEmail() +" "
		//		+user.getPassword()+" "+" "+user.getGender()+" "+user.getRole()+" "+user.getAddress());


		//email taken from registration form
		String email = user.getEmail();

		//checking if email as in registration form 
		// is present in DB or not.
		boolean status = serviceImpl.emailExists(email);

		if(status == false) {
			serviceImpl.addUsers(user);
			System.out.println("User Added");
		}
		else {
			System.out.println("User already exists");
		}

		return "home";
	}


	@PostMapping("/validate")
	public String validate(@RequestParam("email") String email,
			@RequestParam("password") String password, HttpSession session) {

		if(serviceImpl.validateUser(email, password) == true){
			
			String role = serviceImpl.getRole(email);

			session.setAttribute("email", email);
			
			if(role.equals("admin")) {

				return "adminhome";
			}
			else {

				return "customerhome";
			}
		}
		else {
			return "login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";	
	}
	
}
