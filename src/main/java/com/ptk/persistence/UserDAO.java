package com.ptk.persistence;

import com.ptk.domain.MemberVO;
import com.ptk.domain.User;

public interface UserDAO {
	/**
	 * 회원가입 메서드 
	 */
	public void signupUser(User user);
	/**
	 * 로그인 할때 유저가 존재하는지 체크하는 메서드 
	 */
	public boolean logincheck(User user);
	/**
	 * 아이디 값으로 유저의 객체를 받아오는 메서드
	 */
	public MemberVO getMemberVO(String id);	
	/**
	 * 이름 이메일 값으로 유저의 체크하는 메서드
	 */	
	public boolean idsearch(User user);
	/**
	 * 아이디 검색후 빈 리턴 메서드
	 */
	public MemberVO idsearchReturn(User user);
	
	/**
	 * 비멀번호 찾기 메서드
	 */
	public MemberVO pwsearchReturn(User user);
	
	

}
