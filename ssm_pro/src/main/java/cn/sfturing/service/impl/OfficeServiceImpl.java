package cn.sfturing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sfturing.dao.OfficeDao;
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

}
