package cn.sfturing.service;

import java.util.List;

import cn.sfturing.entity.OrderRecords;

public interface OrderRecordsService {

	// 插入新预约记录
	public int insertOrderRecords(OrderRecords orderRecords);

	// 根据用户id查找预约记录
	public List<OrderRecords> findOrderRecordsByUserID(int UserId);

	// 根据预约id更改订单状态为已提交订单
	public int updateOrderSta1(int id);

	// 根据预约id更改订单的疾病信息
	public int updateOrderdiseaseInfo(String diseaseInfo,int id);

	// 取得最后插入的id
	public int findLastId();

}
