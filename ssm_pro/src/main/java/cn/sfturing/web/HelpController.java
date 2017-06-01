package cn.sfturing.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * 
 * @author sfturing
 *
 * @date 2017年6月1日
 */
@Controller
public class HelpController {
	
	/**
	 * 用户帮助首页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/help", method = RequestMethod.GET)
	public String helpIndex() {
		return "help/helpIndex";
	}

}
