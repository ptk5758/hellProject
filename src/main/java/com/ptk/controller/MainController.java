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
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Inject
	private WeightDAO dao;
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String mainPage() {
		return "/main";
	}
	
	@RequestMapping(value = "/main", method = RequestMethod.POST)
	public String mainPageTEST(WeightVO vo) {
		
		logger.info(vo.toString());
		dao.insertWeight(vo);
		return "/main";
	}

}
