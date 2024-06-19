package com.example.demo.controller;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Entityclass;
import com.example.demo.service.UserService;

@Controller
public class ControllerClass {
	@Autowired
	private UserService service;

	@GetMapping("/loginPage")
	public String loginPage(Model model) {
		Entityclass entityclass = new Entityclass();
		model.addAttribute("entityclass", entityclass);

		return "login";

	}

	@PostMapping("/loginSucces")
	public String loginUser(@ModelAttribute("entityclass") Entityclass entityclass) {
		 String result="error";
		 System.out.println(entityclass);
			if(entityclass.getPassword().equals(entityclass.getCpassword())) {
				try {
					 service.registerUser(entityclass);
	                   result="home";
				}
				catch(Exception e) {
					result="error";
					
				}
			}

		return "loginS";
	}

	@GetMapping("/")
	public String register(Model model) {
		Entityclass entityclass = new Entityclass();
		model.addAttribute("entityclass", entityclass);
		return "register";
	}

	@PostMapping("/registerUser")
	public String registerUser(@ModelAttribute("entityclass") Entityclass entityclass) {
		String result = "error";
		System.out.println(entityclass);
		if (entityclass.getPassword().equals(entityclass.getCpassword())) {
			try {
				service.registerUser(entityclass);
				result = "login";
			} catch (Exception e) {
				result = "error";

			}
		}
		return result;
	}
}
