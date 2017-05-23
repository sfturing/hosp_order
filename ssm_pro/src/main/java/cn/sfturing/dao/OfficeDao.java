package cn.sfturing.dao;

import java.util.List;

import cn.sfturing.entity.Office;

/**
 * 
 * @author sfturing
 *
 * @date 2017年5月23日
 */
public interface OfficeDao {
	
	//通过医院名称查询
	public List<Office> findOfficeByHosName(String hospitalName);

}
