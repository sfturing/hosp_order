package cn.sfturing.service;

import java.util.List;

import cn.sfturing.entity.Office;

public interface OfficeService {
	
	//通过医院名称查询科室
	public List<Office> findOfficeByHosName(String hospitalName);

}


