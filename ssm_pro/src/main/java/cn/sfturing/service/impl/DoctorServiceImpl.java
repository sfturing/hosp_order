package cn.sfturing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sfturing.dao.DoctorDao;
import cn.sfturing.entity.Doctor;
import cn.sfturing.service.DoctorService;
@Service
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	private DoctorDao doctorDao;

	@Override
	public List<Doctor> findAreaByHosAndOfficeName(String hospitalName, String OfficeName) {
		// TODO Auto-generated method stub
		return doctorDao.findAreaByHosAndOfficeName(hospitalName, OfficeName);
	}

}
