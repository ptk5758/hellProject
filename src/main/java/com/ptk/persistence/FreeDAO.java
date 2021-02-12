package com.ptk.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ptk.domain.FreeVO;
import com.ptk.domain.SearchVO;

@Repository
public class FreeDAO implements CommunityDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "com.ptk.mapper.FreeBBSMapper";
	
	@Override
	public int gettotalList() {
		return sqlSession.selectOne(NAMESPACE+".getTotalList");
	}
	
	public void FreebbsPosting(FreeVO vo) {
		sqlSession.insert(NAMESPACE+".bbsinsert", vo);
	}
	
	public List<FreeVO> getList() {
		return sqlSession.selectList(NAMESPACE+".getFreevoList");
	}
	
	public FreeVO getFreeItem(Integer uid) {
		return sqlSession.selectOne(NAMESPACE+".getFreeVO", uid);
	}
	
	public void refUpdate(Integer uid) {
		sqlSession.update(NAMESPACE+".refUpdate", uid);
	}
	
	public void likeDo(FreeVO vo) {
		sqlSession.insert(NAMESPACE+".likeDo", vo);
	}
	
	public boolean getLikeValue(Map<String, Object> map) {
		return sqlSession.selectOne(NAMESPACE+".getLikeValue", map);
	}
	
	public void likeDelete(Map<String, Object> map) {
		sqlSession.delete(NAMESPACE+".likedelete", map);
	}
	
	public List<FreeVO> getFreeVOSearch(SearchVO search) {
		System.out.println(search.getSelecttitle());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("selecttitle", search.getSelecttitle());
		map.put("inputvalue", search.getInputvalue());
		return sqlSession.selectList(NAMESPACE+".getFreeVOSearch", map);
	}
	

}
