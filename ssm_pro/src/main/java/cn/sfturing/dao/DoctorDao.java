package cn.sfturing.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.sfturing.entity.Doctor;
import cn.sfturing.entity.Hospital;

public interface DoctorDao {
	// 根据地区医院名称和科室查询
	public List<Doctor> findAreaByHosAndOfficeName(@Param("hospitalName") String hospitalName,
			@Param("OfficeName") String OfficeName);

	// 通过id查询医生的信息
	public Doctor findDoctorById(int id);

	// 推荐开通预约挂号的医院的医生
	public List<Doctor> findDoctorByRe(Map<String, Object> doctorMap);

	// 推荐开通预约挂号的医院的医生的数量
	public int findDoctorByReNum(List<Hospital> hospital);

	// 查询全部医生的数量
	public int findDoctorNum(@Param("hospitalName") String hospitalName, @Param("officesName") String officesName,
			@Param("doctorName") String doctorName, @Param("doctorAdministrative") String doctorAdministrative,
			@Param("doctorTitle") String doctorTitle, @Param("doctorDegree") String doctorDegree);

	// 根据条件查询医生
	public List<Doctor> findDoctorByCondition(@Param("hospitalName") String hospitalName, @Param("officesName") String officesName,
			@Param("doctorName") String doctorName, @Param("doctorAdministrative") String doctorAdministrative,
			@Param("doctorTitle") String doctorTitle, @Param("doctorDegree") String doctorDegree, @Param("start") int start, @Param("size") int size);
	//查询医生职称
	public List<String> findDoctorTitle();
	//查询医生行政职位
	public List<String> findDoctorAdministrative();
	//查询医生学位
	public List<String> findDoctorDegree();
}
