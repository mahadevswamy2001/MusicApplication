package com.example.dmeo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dmeo.entity.Users;
import com.example.dmeo.servies.UserServies;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	UserServies service;

	@PostMapping("/register")
	public String addUser(@ModelAttribute Users user) {

		boolean userStatus = service.emailExists(user.getEmail());

		if (userStatus == false) {
			System.out.println("User Added");
			service.addUser(user);
		} else {
			System.out.println("User Alredy exist");
		}

		return "home";
	}

	@PostMapping("/validate")
	public String validate(@RequestParam("email") String email, @RequestParam("password") String password,
			HttpSession session) {
		if (service.validUser(email, password)) {
			String role = service.getRole(email);
			session.setAttribute(email, email);
			if (role.equals("Admin")) {
				return "adminHome";
			} else {
				return "costomerHome";
			}

		} else {
			return "login";
		}
	}

	@GetMapping("/pay")
	public String pay(@RequestParam String email) {

		boolean paymentStatus = false;

		if (paymentStatus) {
			Users user = service.getUsers(email);
			user.setPremiun(true);
			service.updateUser(user);
		}

		return "login";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}
}
