package com.ptk.controller.api;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ptk.domain.MemberVO;
import com.ptk.domain.User;
import com.ptk.persistence.UserDAO;

@RestController
@RequestMapping("/apiuser")
public class APIUser {
	
	@Inject
	private UserDAO dao;
	
	private static final Logger logger = LoggerFactory.getLogger(APIUser.class);
	
	/**
	 * 회원가입 메서드
	 * @param vo
	 * @return
	 */
	@RequestMapping(value = "/signup", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	public String userSignup(@RequestBody MemberVO vo, HttpSession session) {		
		User user = vo;
		
		dao.signupUser(user);		
		if(user instanceof MemberVO) {
			logger.info("니가생각한그거 맞음");
		} else {
			logger.info("니가생각한그거 아님");
		}
		session.setAttribute("sessionID", vo.getId());
		session.setAttribute("sessionNickName", vo.getNickname());
		session.setAttribute("sessionLevel", 1);
		return user.toString();
	}

}
