package cn.sfturing.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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
	
	//查询全部支持预约医院的数量
	public int findOrderHosNum();
	
	//查询全部支持预约的医院
	public List<Hospital> findOrderHos(@Param("start") int start, @Param("size") int size);
	
	

}
