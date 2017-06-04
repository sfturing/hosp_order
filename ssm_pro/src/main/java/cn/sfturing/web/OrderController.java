package cn.sfturing.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.sfturing.entity.CommonUser;
import cn.sfturing.entity.OrderRecords;
import cn.sfturing.service.CommonUserService;
import cn.sfturing.service.OrderRecordsService;
/**
 * 
 * @author sfturing
 *
 * @date 2017年6月2日
 */
@Controller
public class OrderController {

	@Autowired
	private CommonUserService commnUserService;
	@Autowired
	private OrderRecordsService orderRecordsService;

	private static Logger log = LoggerFactory.getLogger(OrderController.class);

	/**
	 * 用户预约首页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/orderIndex", method = RequestMethod.GET)
	public String orderIndex() {

		return "order/orderInfo";
	}

	/**
	 * 用户预约
	 * 
	 * @return
	 */
	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public String order(String orderInfoValue, String hospitalName, String officesName, String doctorName,
			String userIdenf, Model model, String doctorImg) {
		//分解传入的时间以及时间段
		String orderInfoValueArry[] = orderInfoValue.split(",");
		String transact_date = orderInfoValueArry[0];
		String transact_time = orderInfoValueArry[1];
		CommonUser commonUser = commnUserService.findCommonUserByUserIdenf(userIdenf);
		OrderRecords orderRecords = new OrderRecords();
		// 设置orderRecords
		orderRecords.setUserID((int) commonUser.getUserId());
		orderRecords.setTransactTime(transact_time);
		orderRecords.setTransactDate(transact_date);
		orderRecords.setHospitalName(hospitalName);
		orderRecords.setOfficesName(officesName);
		orderRecords.setDoctorName(doctorName);
		// 设置预约识别码 0代表只选择时间段，未提交订单
		orderRecords.setOrderVer(0);
		log.info("插入订单，待提交！");
		// 插入订单
		orderRecordsService.insertOrderRecords(orderRecords);
		// 设置最后插入的id(不会发生并发性问题，是根据线程查询的)
		int id = orderRecordsService.findLastId();
		System.out.println(id);
		orderRecords.setId(id);
		model.addAttribute("orderRecords", orderRecords);
		model.addAttribute("commonUser", commonUser);
		model.addAttribute("doctorImg", doctorImg);
		return "order/orderInfo";
	}

	/**
	 * 提交订单
	 * 
	 * @return
	 */
	@RequestMapping(value = "/orderUserCenter", method = RequestMethod.POST)
	public String OrderUserCenter(Model model, int userID, int id, String diseaseInfo) {
		orderRecordsService.updateOrderSta1(id);
		orderRecordsService.updateOrderdiseaseInfo(diseaseInfo,id);
		//通过userId查询所有订单，为个人中心提供
		List<OrderRecords> orderRecords = orderRecordsService.findOrderRecordsByUserID(userID);
		log.info("插入订单，已提交订单！");
		model.addAttribute("orderRecords", orderRecords);
		return "userCenter/userCenter";

	}

}
