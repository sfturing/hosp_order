package cn.sfturing.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author sfturing
 * 
 * @date 2017年5月19日
 */
@Controller
public class HospitalController {
	/**
	 * 医院主界面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/hosIndex", method = RequestMethod.GET)
	public String login(HttpSession session) {
		session.invalidate();
		return "hospital/hosIndex";
	}

}
