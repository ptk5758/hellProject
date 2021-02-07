package com.ptk.persistence;

import java.util.List;

import com.ptk.domain.PageVO;
import com.ptk.domain.WeightVO;

public interface WeightDAO {
	
	public void insertWeight(WeightVO vo);
	public List<WeightVO> getWeightList();
	public List<WeightVO> getWeightList(String selectvalue);
	/**
	 * 페이징 된 리스트 출력하기
	 */
	public List<WeightVO> getWeightList_Page(PageVO page); 
}
