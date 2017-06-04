package cn.sfturing.web;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author sfturing
 *
 * @date 2017年5月6日
 */
@Controller
public class BaseController {
	private static Logger log = LoggerFactory.getLogger(BaseController.class);

	/**
	 * 用户主页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String indexOf() {
		return "index/index";
	}

	/**
	 * 用户主页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return "index/index";
	}

	/**
	 * 用户联系我们
	 * 
	 * @return
	 */
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contact() {
		return "contact/contactIndex";
	}
	/**
	 * 用户联系我们
	 * 
	 * @return
	 */
	@RequestMapping(value = "/logOff", method = RequestMethod.GET)
	public String logOff(HttpSession session) {
		session.invalidate();
		return "index/index";
	}


}
