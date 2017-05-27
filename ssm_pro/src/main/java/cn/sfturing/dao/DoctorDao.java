package cn.sfturing.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.sfturing.entity.Doctor;

public interface DoctorDao {
	// 根据地区医院名称和科室查询
	public List<Doctor> findAreaByHosAndOfficeName(@Param("hospitalName") String hospitalName,@Param("OfficeName")String OfficeName);


}
