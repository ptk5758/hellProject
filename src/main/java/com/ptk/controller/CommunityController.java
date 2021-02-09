package com.ptk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/bbs/")
public class CommunityController {
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String bbsPage() {
		return  "/bbs/bbs";
	}

}
