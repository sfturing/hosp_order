package cn.sfturing.dao;

import java.util.List;

import cn.sfturing.entity.Hospital;

/**
 * 
 * @author sfturing
 *
 * @date 2017年5月19日
 */
public interface HospitalDao {
	// 通过医院id查询医院
	public Hospital findHosById(int id);

	// 通过医院名称查找医院
	public List<Hospital> findHosByName(String hospitalName);
	
	// 推荐9个开通预约挂号的医院
	public List<Hospital> findHosByRe();
	
	

}
