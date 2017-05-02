package cn.sfturing.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.sfturing.dao.CommonUserDao;
import cn.sfturing.entity.CommonUser;
import cn.sfturing.service.CommonUserService;

@Controller
public class CommonUserController {
	@Autowired
	private CommonUserService commonUserService;
	@Autowired
	private CommonUserDao commonUserDao;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(){
		return "login";
	}

	/**
	 * 用户登陆验证
	 * 
	 * @param email
	 * @param passWord
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginSuccess(Model model,String userIdenf, String userPassword, HttpSession httpSession) throws Exception {

	
		// 登录用户，并将登录后的状态码返回，如果是0用户不存在，如果是1那么密码错误，如果是2那么密码正确
		int result = commonUserService.login(userIdenf, userPassword);

		// 查找这个用户
		CommonUser commonUser = commonUserDao.findCommonUserByUserIdenf(userIdenf);

		if (result == 2) {
			// 如果是2，那么登录成功，返回index
			model.addAttribute("user", commonUser);
			return "detail";
		} else if (result == 1) {
			System.out.println("密码错误");
			return "login";
		} else {
			System.out.println("用户不存在");
			return "login";
		}

	}

}
