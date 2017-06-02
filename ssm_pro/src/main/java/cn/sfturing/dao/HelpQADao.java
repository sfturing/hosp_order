package cn.sfturing.dao;

import java.util.List;

import cn.sfturing.entity.HelpQA;

public interface HelpQADao {
	//根据类型查找问题
	public List<HelpQA> findQAByType(String questionType);

}
