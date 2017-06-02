package cn.sfturing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sfturing.dao.HelpQADao;
import cn.sfturing.entity.HelpQA;
import cn.sfturing.service.HelpQAService;
@Service
public class HelpQAServiceImpl implements HelpQAService {
	@Autowired
	private HelpQADao helpQADao;
	@Override
	public List<HelpQA> findQAByType(String questionType) {
		// TODO Auto-generated method stub
		return helpQADao.findQAByType(questionType);
	}

}
