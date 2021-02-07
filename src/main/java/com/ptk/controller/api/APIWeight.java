package com.ptk.controller.api;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ptk.domain.PageManager;
import com.ptk.domain.PageVO;
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
			
		}
		logger.info(vo.toString());
		double height = (vo.getHeight()/(double)100);
		double weight = vo.getWeight();
		double bmi = weight/(height*height);
		vo.setBmi(Double.parseDouble(String.format("%.2f", bmi)));
		logger.info(vo.getBmi()+"<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		if(vo.getBmi() >= 30d) {
			vo.setBmi_status("고도 비만");
		} else if(vo.getBmi() >= 25d) {
			vo.setBmi_status("비만");
		} else if(vo.getBmi() >= 23d) {
			vo.setBmi_status("과체중");
		} else if(vo.getBmi() >= 18.5d) {
			vo.setBmi_status("정상");
		} else {
			vo.setBmi_status("저체중");
		}
		dao.insertWeight(vo);
		String result;
		result = vo.toString();
		return result;
		
	}
	
	@RequestMapping(value = "/getBMIList", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public String getBMIList() {
		String result;
		PageVO page = new PageVO();
		PageManager pmg = new PageManager(page);
		logger.info(pmg.getPage().toString());		
		List<WeightVO> list = dao.getWeightList_Page(pmg.getPage());
		
		if(list.isEmpty()) {
			result = "{\"count\":\"0\"}";
		} else {
			
			result = "{\"count\":\""+list.size()+"\",\"list\":[";		
			
			for(int i=0; i<list.size(); i++) {
				
				WeightVO vo = list.get(i);
				result += vo.toString();
				
				if(i+1 == list.size()) {
					result += "]}";
				} else {
					result += ",";
				}
				
			}
		}
		
		return result;
	}
	
	@RequestMapping(value = "/getBMIList", method = RequestMethod.GET, produces = "application/json; charset=UTF-8", params = {"selectvalue"})
	public String getBMIList(@RequestParam("selectvalue") String selectvalue) {
		String result;
		logger.info(selectvalue);
		List<WeightVO> list = dao.getWeightList(selectvalue);
		if(list.isEmpty()) {
			result = "{\"count\":\"0\"}";
		} else {
			
			result = "{\"count\":\""+list.size()+"\",\"list\":[";		
			
			for(int i=0; i<list.size(); i++) {
				
				WeightVO vo = list.get(i);
				result += vo.toString();
				
				if(i+1 == list.size()) {
					result += "]}";
				} else {
					result += ",";
				}
				
			}
		}
		
		return result;
	}

}

















