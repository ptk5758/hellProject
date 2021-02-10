package com.ptk.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ptk.controller.api.APIFree;
import com.ptk.domain.Community;
import com.ptk.domain.FreeVO;
import com.ptk.domain.NoticeVO;
import com.ptk.persistence.CommunityDAO;
import com.ptk.persistence.FreeDAO;

@Controller
@RequestMapping("/bbs/")
public class CommunityController {
	
	@Inject
	private CommunityDAO dao;
	
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
	
	@RequestMapping(value ="/free/{uid}", method = RequestMethod.GET)
	public String freebbsview(@PathVariable("uid") Integer uid, Model model) {
		
		//APIFree api = new APIFree();		
		//logger.info(api.getFreeVO(uid));
		
		model.addAttribute("uid", uid);
		return "/bbs/free/view";
	}
	
	

}
