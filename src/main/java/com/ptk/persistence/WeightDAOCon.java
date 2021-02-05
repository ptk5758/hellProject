package com.ptk.persistence;

import java.util.List;

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
	
	@Override
	public List<WeightVO> getWeightList() {
		return sqlSession.selectList(NAMESPACE+".getWeightList");
	}
	
	@Override
	public List<WeightVO> getWeightList(String selectvalue) {
		return sqlSession.selectList(NAMESPACE+".getWeightListselect", selectvalue);
	}

}
