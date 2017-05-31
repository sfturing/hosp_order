package cn.sfturing.service;

import java.util.List;

import cn.sfturing.entity.Hospital;

/**
 * 
 * @author sfturing
 *
 * @date 2017年5月22日
 */
public interface HospitalService {
	// 查询推荐医院
	public List<Hospital> findHosByRe();

	// 通过医院id查找医院
	public Hospital findHosById(int id);

	// 通过医院名称查找医院
	public Hospital findHosByName(String hosptalName);

	// 查询支持预约医院数量
	public int findOrderHosNum(String province, String city, String district, Hospital hospital);

	// 查询支持预约医院
	public List<Hospital> findfindOrderHos(int start, int size);

	// 查询开放预约医院等级
	public List<String> findHosOpenGrade();

	// 查询医院等级
	public List<String> findHosGrade();

	// 查询开放预约医院类型	
	public List<String> findHosOpenNature();

	// 查询开放预约医院类型
	public List<String> findHosNature();

	// 通过条件查询开通预约医院

	public List<Hospital> findHosByConditon(String province, String city, String district, Hospital hospital, int start,
			int size);

	// 查询开通预约的医院

	public List<Hospital> findOpenHos();

	// 查询支持预约医院数量
	public int findAllHosNum(String province, String city, String district, Hospital hospital);
	// 通过条件查询开通预约医院

	public List<Hospital> findAllHosByConditon(String province, String city, String district, Hospital hospital, int start,
			int size);

}
