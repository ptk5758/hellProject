package com.ptk.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signupPage() {
		return "/user/signup";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)	
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect: /";
	}
	@RequestMapping(value = "/idsearch", method = RequestMethod.GET)
	public String loginPage() {
		return "/user/idsearch";
	}

}
