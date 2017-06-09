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
	public int updateOrderdiseaseInfo(String diseaseInfo, int id) {
		// TODO Auto-generated method stub
		return orderRecordsDao.updateOrderdiseaseInfo(diseaseInfo, id);
	}

	@Override
	public int cancelOrder(int id) {
		int ver = 0;//代表非发生更改事件 
		OrderRecords orderRecords = orderRecordsDao.findOrderById(id);
		if (orderRecords.getIsSuccess() == 1 && orderRecords.getIsSend() == 1) {
			// 预约保留 黑名单管理，审核并且通知后取消，需要拉入黑名单 1级惩罚
			orderRecordsDao.cancelOrder2(id);
			ver = 1;//代表更改了cancel为1
		}
		if (orderRecords.getIsSuccess() == 1 && orderRecords.getIsSend() == 0) {
			// 预约保留 黑名单管理，审核后取消，需要拉入黑名单 2级惩罚
			orderRecordsDao.cancelOrder2(id);
			ver = 2;//代表更改了cancel为2
		}
		if (orderRecords.getIsSuccess() == 0) {
			// 审核前通过，取消订单状态无影响仅作提醒
			orderRecordsDao.cancelOrder1(id);
			ver = 3;//代表更改了cancel为1
		}
		return ver;
	}

}
