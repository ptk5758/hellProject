package com.ptk.controller.api;

import java.net.Inet4Address;
import java.net.UnknownHostException;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ptk.domain.WeightVO;
import com.ptk.persistence.WeightDAO;

@RestController
@RequestMapping(value = "/apiWeight")
public class APIWeight {
	
	@Inject
	private WeightDAO dao;
	
	private static final Logger logger = LoggerFactory.getLogger(APIWeight.class);
	
	@RequestMapping(value = "/insertWeight", method = RequestMethod.POST, produces = "application/text; charset=UTF-8")
	public String insertWeight(@RequestBody WeightVO vo) {
		try {
			vo.setIp(Inet4Address.getLocalHost().getHostAddress());
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info(vo.toString());
		double height = (vo.getHeight()/(double)100);
		double weight = vo.getWeight();
		double bmi = weight/(height*height);
		vo.setBmi(Double.parseDouble(String.format("%.2f", bmi)));
		dao.insertWeight(vo);
		String result;
		result = vo.toString();
		return result;
		
	}

}
