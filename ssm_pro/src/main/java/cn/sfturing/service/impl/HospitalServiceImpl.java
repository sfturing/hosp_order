package cn.sfturing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sfturing.dao.HospitalDao;
import cn.sfturing.entity.Hospital;
import cn.sfturing.service.HospitalService;

/**
 * 
 * @author sfturing
 *
 * @date 2017年5月19日
 */
@Service
public class HospitalServiceImpl implements HospitalService {

	@Autowired
	private HospitalDao hospitalDao;

	@Override
	public List<Hospital> findHosByRe() {

		return hospitalDao.findHosByRe();
	}

	@Override
	public Hospital findHosById(int id) {
		
		return hospitalDao.findHosById(id);
	}

}
