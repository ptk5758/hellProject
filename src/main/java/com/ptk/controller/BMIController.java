package com.ptk.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ptk.domain.WeightVO;
import com.ptk.persistence.WeightDAO;

@Controller
public class BMIController {
	
	private static final Logger logger = LoggerFactory.getLogger(BMIController.class);
	
	@Inject
	private WeightDAO dao;
	
	@RequestMapping(value = "/BMI", method = RequestMethod.GET)
	public String mainPage() {
		return "/BMI";
	}
	
	@RequestMapping(value = "/BMI/list", method = RequestMethod.GET)
	public String bmilistPage() {
		return "/BMIlist";
	}
	
	

}
