package cn.sfturing.web;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 
 * @author sfturing
 *
 * @date 2017年6月2日
 */
@Controller
public class OrderController {
	/**
	 * 用户预约首页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/orderIndex", method = RequestMethod.GET)
	public String orderIndex() {
		
		return "order/orderIndex";
	}

}
