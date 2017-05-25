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

	@Override
	public int findOrderHosNum(String province, String city, String district, Hospital hospital) {
		if (province.equals("") && city.equals("") && district.equals("")) {

		} else if (!province.equals("") && city.equals("") && district.equals("")) {
			hospital.setHospitalAddress(province);
		} else if (!province.equals("") && !city.equals("") && district.equals("")) {
			hospital.setHospitalAddress(city);
		} else if (!province.equals("") && !city.equals("") && !district.equals("")) {
			hospital.setHospitalArea(district);
		}
		if (hospital.getHospitalNature() != null && hospital.getHospitalGrade() != null) {
			if (hospital.getHospitalNature().equals("默认")) {
				hospital.setHospitalNature(null);
			}
			if (hospital.getHospitalGrade().equals("默认")) {
				hospital.setHospitalGrade(null);
			}
		}
		return hospitalDao.findOrderHosNum(hospital.getHospitalName(), hospital.getIsMedicalInsurance(),
				hospital.getHospitalGrade(), hospital.getHospitalNature(), hospital.getHospitalAddress(),
				hospital.getHospitalArea());
	}


	@Override
	public List<Hospital> findfindOrderHos(int start, int size) {

		return hospitalDao.findOrderHos(start, size);
	}

	@Override
	public List<String> findHosOpenGrade() {
		// TODO Auto-generated method stub
		return hospitalDao.findHosOpenGrade();
	}

	@Override
	public List<String> findHosGrade() {
		// TODO Auto-generated method stub
		return hospitalDao.findHosGrade();
	}

	@Override
	public List<String> findHosOpenNature() {
		// TODO Auto-generated method stub
		return hospitalDao.findHosOpenNature();
	}

	@Override
	public List<String> findHosNature() {
		// TODO Auto-generated method stub
		return hospitalDao.findHosNature();
	}

	@Override
	public List<Hospital> findHosByConditon(String province, String city, String district, Hospital hospital, int start,
			int size) {
		if (province.equals("") && city.equals("") && district.equals("")) {

		} else if (!province.equals("") && city.equals("") && district.equals("")) {
			hospital.setHospitalAddress(province);
		} else if (!province.equals("") && !city.equals("") && district.equals("")) {
			hospital.setHospitalAddress(city);
		} else if (!province.equals("") && !city.equals("") && !district.equals("")) {
			hospital.setHospitalArea(district);
		}
		if (hospital.getHospitalNature() != null && hospital.getHospitalGrade() != null) {
			if (hospital.getHospitalNature().equals("默认")) {
				hospital.setHospitalNature(null);
			}
			if (hospital.getHospitalGrade().equals("默认")) {
				hospital.setHospitalGrade(null);
			}
		}
		return hospitalDao.findHosByCondition(hospital.getHospitalName(), hospital.getIsMedicalInsurance(),
				hospital.getHospitalGrade(), hospital.getHospitalNature(), hospital.getHospitalAddress(),
				hospital.getHospitalArea(), start, size);
	}

	
}
