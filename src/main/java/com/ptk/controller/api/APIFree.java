package com.ptk.controller.api;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ptk.domain.FreeVO;
import com.ptk.persistence.FreeDAO;

@RestController
@RequestMapping("/apifree")
public class APIFree {
	
	@Inject
	private FreeDAO dao;
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	private static final Logger logger = LoggerFactory.getLogger(APIFree.class);
	
	@RequestMapping(value = "/Posting", method = RequestMethod.POST, produces = "application/text; charset=UTF-8")
	public String freebbsposting(@ModelAttribute FreeVO vo, @RequestParam("img") MultipartFile[] file) {
		String result;
		result = "";
		logger.info("성공!");
		logger.info(file[0].getOriginalFilename());
		logger.info(vo.getJSONString());
		//dao.FreebbsPosting(vo);
		return result;
	}
	

}
