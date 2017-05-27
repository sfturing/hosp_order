package cn.sfturing.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.sfturing.entity.Hospital;

/**
 * 
 * @author sfturing
 *
 * @date 2017年5月19日
 */
public interface HospitalDao {
	// 通过医院id查询医院
	public Hospital findHosById(int id);

	// 通过医院名称查找医院
	public Hospital findHosByName(String hospitalName);

	// 推荐9个开通预约挂号的医院
	public List<Hospital> findHosByRe();

	// 查询全部支持预约医院的数量
	public int findOrderHosNum(@Param("hospitalName") String hospitalName,@Param("isMedicalInsurance") String isMedicalInsurance,
			@Param("hospitalGrade") String hospitalGrade, @Param("hospitalNature") String hospitalNature,
			@Param("hospitalAddress") String hospitalAddress, @Param("hospitalArea") String hospitalArea);

	// 查询全部支持预约的医院
	public List<Hospital> findOrderHos(@Param("start") int start, @Param("size") int size);

	// 查询开通医院的所有等级
	public List<String> findHosOpenGrade();

	// 查询医院所有等级
	public List<String> findHosGrade();

	// 查询开通医院的所有类型
	public List<String> findHosOpenNature();

	// 查询所遇医院的所有类型
	public List<String> findHosNature();

	// 根据条件查询已开通预约的医院
	public List<Hospital> findHosByCondition(@Param("hospitalName") String hospitalName,@Param("isMedicalInsurance") String isMedicalInsurance,
			@Param("hospitalGrade") String hospitalGrade, @Param("hospitalNature") String hospitalNature,
			@Param("hospitalAddress") String hospitalAddress, @Param("hospitalArea") String hospitalArea,
			@Param("start") int start, @Param("size") int size);

}
