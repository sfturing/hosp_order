package cn.sfturing.dao;
import java.util.List;

/**
 * 
 * @author sfturing
 *
 * @date 2017年5月19日
 */
import cn.sfturing.entity.Area;
public interface AreaDao {
	//根据地区id查询
	public Area findAreaById(int id);
	
	//根据地区名称查找城市信息
	public List<Area> findAreaByName(String areaName);
	
	//根据区县等级查找城市信息
	public List<Area> findAreaByLevel(int level);
	
	//根据区县姓名查找父级1级城市
	public List<Area> findAreaFatherByName(String areaName);
}
