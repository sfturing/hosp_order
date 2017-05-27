package cn.sfturing.service;

import java.util.List;
import java.util.Map;

import cn.sfturing.entity.Hospital;
import cn.sfturing.entity.Office;

public interface OfficeService {

	// 通过医院名称查询科室
	public List<Office> findOfficeByHosName(String hospitalName);
	//通过id查询科室信息
	public Office findOfficeById(int id);

	// 推荐9个开通预约挂号的医院的科室
	public List<Office> findHosByRe(Map<String, Object> officeMap);

	// 推荐9个开通预约挂号的医院的科室数量
	public int findHosByReNum(List<Hospital> hospital);

}
