package com.ptk.controller.api;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ptk.domain.FreeVO;
import com.ptk.persistence.FreeDAO;

@RestController
@RequestMapping("/apifree")
public class APIFree {
	
	@Inject
	private FreeDAO dao;
	
	private static final Logger logger = LoggerFactory.getLogger(APIFree.class);
	
	@RequestMapping(value = "/Posting", method = RequestMethod.POST, produces = "application/text; charset=UTF-8")
	public String freebbsposting(@RequestBody FreeVO vo) {
		String result;
		result = "";
		logger.info("성공!");
		logger.info(vo.getJSONString());
		dao.FreebbsPosting(vo);
		return result;
	}
	

}
