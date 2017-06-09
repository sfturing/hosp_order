package cn.sfturing.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.sfturing.entity.OrderRecords;

public interface OrderRecordsDao {
	// 根据id查询单条预约记录
	public OrderRecords findOrderById(int id);

	// 增加预约新纪录
	public int insertOrderRecords(OrderRecords orderRecords);

	// 根据用户id查找预约记录
	public List<OrderRecords> findOrderRecordsByUserID(int UserID);

	// 根据预约id更改订单状态为已提交订单
	public int updateOrderSta1(int id);

	// 根据预约id更改订单的疾病信息
	public int updateOrderdiseaseInfo(@Param("diseaseInfo") String diseaseInfo, @Param("id") int id);

	// 取得最后插入的id
	public int findLastId();

	// 查找需要发送通知邮件的订单
	public List<OrderRecords> findNeedNoticeOrder();

	// 修改发送成功 is_send=1
	public int updateSendSuccess(int id);

	// 修改发送失败 is_send=2（send为发送邮件失败，保留接口，对_send=2的用户进行检查或者人工通知）
	public int updateSendFailed(int id);

	// 取消订单设置状态为1
	public int cancelOrder1(int id);

	// 取消订单设置状态为2
	public int cancelOrder2(int id);

}
