package com.ptk.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ptk.domain.WeightVO;


@Repository
public class WeightDAOCon implements WeightDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "com.ptk.mapper.WeightMapper";
	
	@Override
	public void insertWeight(WeightVO vo) {
		sqlSession.insert(NAMESPACE+".weightInsert", vo);
	}

}
