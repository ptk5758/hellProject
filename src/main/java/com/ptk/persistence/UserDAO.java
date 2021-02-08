package com.ptk.persistence;

import com.ptk.domain.MemberVO;
import com.ptk.domain.User;

public interface UserDAO {
	
	public void signupUser(User user);
	public boolean logincheck(User user);
	public MemberVO getMemberVO(String id);

}
