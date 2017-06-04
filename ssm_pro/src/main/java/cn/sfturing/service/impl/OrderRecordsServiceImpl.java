package cn.sfturing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.sfturing.dao.OrderRecordsDao;
import cn.sfturing.entity.OrderRecords;
import cn.sfturing.service.OrderRecordsService;
@Service
public class OrderRecordsServiceImpl implements OrderRecordsService {
	@Autowired
	private OrderRecordsDao orderRecordsDao;
	@Override
	@Transactional
	public int insertOrderRecords(OrderRecords orderRecords) {
		// TODO Auto-generated method stub
		return orderRecordsDao.insertOrderRecords(orderRecords);
	}
	@Override
	public List<OrderRecords> findOrderRecordsByUserID(int UserID) {
		// TODO Auto-generated method stub
		return orderRecordsDao.findOrderRecordsByUserID(UserID);
	}
	@Override
	public int updateOrderSta1(int id) {
		// TODO Auto-generated method stub
		return orderRecordsDao.updateOrderSta1(id);
	}
	@Override
	public int findLastId() {
		// TODO Auto-generated method stub
		return orderRecordsDao.findLastId();
	}
	@Override
	public int updateOrderdiseaseInfo(String diseaseInfo,int id) {
		// TODO Auto-generated method stub
		return orderRecordsDao.updateOrderdiseaseInfo(diseaseInfo,id);
	}

}
