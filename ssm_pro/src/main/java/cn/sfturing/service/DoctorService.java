package cn.sfturing.service;

import java.util.List;

import cn.sfturing.entity.Doctor;

public interface DoctorService {
	// 根据地区医院名称和科室查询
	public List<Doctor> findAreaByHosAndOfficeName(String hospitalName, String OfficeName);

}
