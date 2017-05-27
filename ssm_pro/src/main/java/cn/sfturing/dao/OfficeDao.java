package cn.sfturing.dao;

import java.util.List;
import java.util.Map;

import cn.sfturing.entity.Hospital;
import cn.sfturing.entity.Office;

/**
 * 
 * @author sfturing
 *
 * @date 2017年5月23日
 */
public interface OfficeDao {

	// 通过医院名称查询
	public List<Office> findOfficeByHosName(String hospitalName);
	
	//通过id查询医院的信息
	public Office findOfficeById(int id);

	// 推荐9个开通预约挂号的医院的科室
	public List<Office> findHosByRe(Map<String, Object> officeMap);

	// 推荐9个开通预约挂号的医院的科室的数量
	public int findHosByReNum(List<Hospital> hospital);
}
