package cn.sfturing.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 
 * @author sfturing
 *
 * @date 2017年5月19日
 */
import cn.sfturing.entity.Area;

public interface AreaDao {
	// 根据地区id查询
	public Area findAreaById(int id);

	// 根据地区名称查找城市信息
	public List<Area> findAreaByName(String areaName);

	// 查找等级为1的城市
	public List<Area> findAreaByLevel1();

	// 查找等级为2的城市
	public List<Area> findAreaByLevel2(String areaName);

	// 查找等级为3的城市
	public List<Area> findAreaByLevel3(@Param("areaName") String areaName, @Param("cityName") String cityName);

	// 根据区县姓名查找父级1级城市
	public List<Area> findAreaFatherByName(String areaName);
}
