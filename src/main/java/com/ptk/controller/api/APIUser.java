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
	
	/**
	 * 로그인 메서드
	 */
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/text; charset=UTF-8")
	public String userlogin(@RequestBody MemberVO vo, HttpSession session) {
		logger.info(vo.toString());
		User user = vo;
		String result;
		if(dao.logincheck(user)) {
			logger.info("존재함");
			vo = getMemberObject(vo.getId());
			session.setAttribute("sessionID", vo.getId());
			session.setAttribute("sessionNickName", vo.getNickname());
			session.setAttribute("sessionLevel", 1);
			result = vo.toString();			
		} else {
			logger.info("존재안함");
			result = "{\"msg\":\"실패\",\"comment\":\"아이디 또는 비밀번호가 일치하지 않습니다.\"}";
		}
		return result;
	}
	
	@RequestMapping(value = "/idsearch", method = RequestMethod.POST, produces = "application/text; charset=UTF-8")
	public String userIdsearch(@RequestBody MemberVO vo) {
		String result;
		result = "";
		logger.info(vo.toString());
		User user = vo;
		if(dao.idsearch(user)) {
			logger.info("아이디가 존재함");
			user = (MemberVO) dao.idsearchReturn(user);
			logger.info(user.toString());
			result = user.toString();
		} else {
			logger.info("아이디가 존재하지 않음");
			result = "{\"msg\":\"실패\",\"comment\":\"아이디를 찾을수 없습니다.\"}";
		}
		return result;
	}
	
	private MemberVO getMemberObject(String id) {		
		return dao.getMemberVO(id);
	}

}
