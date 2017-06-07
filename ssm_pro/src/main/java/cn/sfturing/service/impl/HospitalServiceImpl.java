package cn.sfturing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sfturing.dao.FavouriteDao;
import cn.sfturing.dao.HospitalDao;
import cn.sfturing.entity.Favourite;
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
	@Autowired
	private FavouriteDao favouriteDao;

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

		if (hospital.getHospitalNature() != null && hospital.getHospitalNature().equals("默认")) {
			hospital.setHospitalNature(null);
		}
		if (hospital.getHospitalGrade() != null && hospital.getHospitalGrade().equals("默认")) {
			hospital.setHospitalGrade(null);
		}
		if (province != null && province.equals("默认")) {
			province = "";
		}
		if (city != null && city.equals("默认")) {
			city = "";
		}
		if (district != null && district.equals("默认")) {
			district = "";
		}

		if (province.equals("") && city.equals("") && district.equals("")) {

		} else if (!province.equals("") && city.equals("") && district.equals("")) {
			hospital.setHospitalAddress(province);
		} else if (!province.equals("") && !city.equals("") && district.equals("")) {
			hospital.setHospitalAddress(city);
		} else if (!province.equals("") && !city.equals("") && !district.equals("")) {
			hospital.setHospitalArea(district);
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
		if (hospital.getHospitalNature() != null && hospital.getHospitalNature().equals("默认")) {
			hospital.setHospitalNature(null);
		}
		if (hospital.getHospitalGrade() != null && hospital.getHospitalGrade().equals("默认")) {
			hospital.setHospitalGrade(null);
		}
		if (province != null && province.equals("默认")) {
			province = "";
		}
		if (city != null && city.equals("默认")) {
			city = "";
		}
		if (district != null && district.equals("默认")) {
			district = "";
		}

		if (province.equals("") && city.equals("") && district.equals("")) {

		} else if (!province.equals("") && city.equals("") && district.equals("")) {
			hospital.setHospitalAddress(province);
		} else if (!province.equals("") && !city.equals("") && district.equals("")) {
			hospital.setHospitalAddress(city);
		} else if (!province.equals("") && !city.equals("") && !district.equals("")) {
			hospital.setHospitalArea(district);
		}

		return hospitalDao.findHosByCondition(hospital.getHospitalName(), hospital.getIsMedicalInsurance(),
				hospital.getHospitalGrade(), hospital.getHospitalNature(), hospital.getHospitalAddress(),
				hospital.getHospitalArea(), start, size);
	}

	@Override
	public Hospital findHosByName(String hosptalName) {
		// TODO Auto-generated method stub
		return hospitalDao.findHosByName(hosptalName);
	}

	@Override
	public List<Hospital> findOpenHos() {
		// TODO Auto-generated method stub
		return hospitalDao.findOpenHos();
	}

	@Override
	public int findAllHosNum(String province, String city, String district, Hospital hospital) {

		if (hospital.getHospitalNature() != null && hospital.getHospitalNature().equals("默认")) {
			hospital.setHospitalNature(null);
		}
		if (hospital.getHospitalGrade() != null && hospital.getHospitalGrade().equals("默认")) {
			hospital.setHospitalGrade(null);
		}
		if (province != null && province.equals("默认")) {
			province = "";
		}
		if (city != null && city.equals("默认")) {
			city = "";
		}
		if (district != null && district.equals("默认")) {
			district = "";
		}

		if (province.equals("") && city.equals("") && district.equals("")) {

		} else if (!province.equals("") && city.equals("") && district.equals("")) {
			hospital.setHospitalAddress(province);
		} else if (!province.equals("") && !city.equals("") && district.equals("")) {
			hospital.setHospitalAddress(city);
		} else if (!province.equals("") && !city.equals("") && !district.equals("")) {
			hospital.setHospitalArea(district);
		}
		return hospitalDao.findAllHosNum(hospital.getHospitalName(), hospital.getIsMedicalInsurance(),
				hospital.getHospitalGrade(), hospital.getHospitalNature(), hospital.getHospitalAddress(),
				hospital.getHospitalArea());
	}

	@Override
	public List<Hospital> findAllHosByConditon(String province, String city, String district, Hospital hospital,
			int start, int size) {
		if (hospital.getHospitalNature() != null && hospital.getHospitalNature().equals("默认")) {
			hospital.setHospitalNature(null);
		}
		if (hospital.getHospitalGrade() != null && hospital.getHospitalGrade().equals("默认")) {
			hospital.setHospitalGrade(null);
		}
		if (province != null && province.equals("默认")) {
			province = "";
		}
		if (city != null && city.equals("默认")) {
			city = "";
		}
		if (district != null && district.equals("默认")) {
			district = "";
		}

		if (province.equals("") && city.equals("") && district.equals("")) {

		} else if (!province.equals("") && city.equals("") && district.equals("")) {
			hospital.setHospitalAddress(province);
		} else if (!province.equals("") && !city.equals("") && district.equals("")) {
			hospital.setHospitalAddress(city);
		} else if (!province.equals("") && !city.equals("") && !district.equals("")) {
			hospital.setHospitalArea(district);
		}

		return hospitalDao.findAllHosByCondition(hospital.getHospitalName(), hospital.getIsMedicalInsurance(),
				hospital.getHospitalGrade(), hospital.getHospitalNature(), hospital.getHospitalAddress(),
				hospital.getHospitalArea(), start, size);
	}

	/**
	 * 是否关注医院
	 * 如果第一次关注医院先插入记录，如果不是第一次，进行isLike的更改
	 */
	@Override
	public int favourite(int userId, int hospitalId) {
		
		if(favouriteDao.findFavByuserIdAndHosId(userId, hospitalId) == null){
			Favourite favourite = new Favourite();
			favourite.setUserId(userId);
			favourite.setHospitalId(hospitalId);
			//默认isLIke == 0
			favouriteDao.insetFavourite(favourite);	
		}
		Favourite favouriteInfo = favouriteDao.findFavByuserIdAndHosId(userId, hospitalId);
		int isLike = favouriteInfo.getIsLike();
		//如果isLIke == 0,则点击的是关注，设置isLike==1
		if(isLike == 0){
			favouriteDao.addFavourite(favouriteInfo.getId());
			isLike=1;
		}else{
			//如果isLIke == 1,则点击的是关注，设置isLike==0
			favouriteDao.cancelFavourite(favouriteInfo.getId());
			isLike=0;
		}
		return isLike;
	}

	@Override
	public List<Hospital> findFavHos(List<Favourite> favourites) {
		// TODO Auto-generated method stub
		return hospitalDao.findFavHos(favourites);
	}

}
