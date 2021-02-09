package com.ptk.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ptk.domain.FreeVO;

@Repository
public class FreeDAO implements CommunityDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "com.ptk.mapper.FreeBBSMapper";
	
	public void FreebbsPosting(FreeVO vo) {
		sqlSession.insert(NAMESPACE+".bbsinsert", vo);
	}
	

}
