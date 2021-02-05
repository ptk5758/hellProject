package com.ptk.persistence;

import java.util.List;

import com.ptk.domain.WeightVO;

public interface WeightDAO {
	
	public void insertWeight(WeightVO vo);
	public List<WeightVO> getWeightList();
	public List<WeightVO> getWeightList(String selectvalue);

}
