package cn.sfturing.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sfturing.dao.OfficeDao;
import cn.sfturing.entity.Hospital;
import cn.sfturing.entity.Office;
import cn.sfturing.service.OfficeService;

@Service
public class OfficeServiceImpl implements OfficeService {
	@Autowired
	private OfficeDao officeDao;

	@Override
	public List<Office> findOfficeByHosName(String hospitalName) {

		return officeDao.findOfficeByHosName(hospitalName);
	}

	@Override
	public List<Office> findHosByRe(Map<String, Object> officeMap) {
		// TODO Auto-generated method stub
		return officeDao.findHosByRe(officeMap);
	}

	@Override
	public int findHosByReNum(List<Hospital> hospital) {
		// TODO Auto-generated method stub
		return officeDao.findHosByReNum(hospital);
	}

	@Override
	public Office findOfficeById(int id) {
		// TODO Auto-generated method stub
		return officeDao.findOfficeById(id);
	}

	
}
