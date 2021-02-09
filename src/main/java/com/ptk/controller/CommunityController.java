package com.ptk.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ptk.domain.Community;
import com.ptk.domain.NoticeVO;

@Controller
@RequestMapping("/bbs/")
public class CommunityController {
	
	private static final Logger logger = LoggerFactory.getLogger(CommunityController.class);
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String bbsPage() {
		
		return  "/bbs/bbs";		
	}
	@RequestMapping(value = "/notice", method = RequestMethod.GET)
	public String noticelistPage() {
		return "/bbs/notice/notice";
	}
	
	@RequestMapping(value = "/notice/posting", method = RequestMethod.GET)
	public String noticepostingPage() {
		return "/bbs/notice/noticeposting";
	}
	
	
	@RequestMapping(value = "/free", method = RequestMethod.GET)
	public String freebbsPage() {
		return "/bbs/free/free";
	}
	
	@RequestMapping(value ="/free/posting", method = RequestMethod.GET)
	public String freebbsposting() {		
		return "/bbs/free/posting";
	}
	
	

}
