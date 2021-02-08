package com.ptk.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ptk.domain.User;

@Repository
public class UserDAOCon implements UserDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "com.ptk.mapper.UserMapper";
	
	@Override
	public void signupUser(User user) {
		sqlSession.insert(NAMESPACE+".signupUser", user);
	}

}