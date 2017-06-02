package cn.sfturing.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.sfturing.entity.HelpQA;
import cn.sfturing.service.HelpQAService;
/**
 * 
 * @author sfturing
 *
 * @date 2017年6月1日
 */
@Controller
public class HelpController {
	@Autowired
	private HelpQAService helpQAService;
	/**
	 * 用户帮助首页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/help", method = RequestMethod.GET)
	public String helpIndex(Model model) {
		List<HelpQA> commonQA = helpQAService.findQAByType("常见问题");
		List<HelpQA> signQA = helpQAService.findQAByType("如何注册");
		List<HelpQA> accountQA = helpQAService.findQAByType("帐号管理");
		model.addAttribute("commonQA", commonQA);
		model.addAttribute("signQA", signQA);
		model.addAttribute("accountQA", accountQA);
		return "help/helpIndex";
	}

}
