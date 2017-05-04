package cn.sfturing.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.sfturing.dao.CommonUserDao;
import cn.sfturing.entity.CommonUser;
import cn.sfturing.service.CommonUserService;
import cn.sfturing.utils.GetIP;

@Controller
public class CommonUserController {
	@Autowired
	private CommonUserService commonUserService;
	@Autowired
	private CommonUserDao commonUserDao;

	private static Logger log = LoggerFactory.getLogger(CommonUserController.class);

	/**
	 * 用户登陆界面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "user/login";
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
	public String loginSuccess(Model model, String userIdenf, String userPassword, HttpSession session	,
			HttpServletRequest request) {

		// 登录用户，并将登录后的状态码返回，如果是0用户不存在，如果是1那么密码错误，如果是2那么密码正确
		int result = commonUserService.login(userIdenf, userPassword, request);
		// 错误信息
		String error = "";
		// 查找这个用户
		CommonUser commonUser = commonUserDao.findCommonUserByUserIdenf(userIdenf);

		if (result == 2) {
			// 如果是2，那么登录成功，返回index
			model.addAttribute("user", commonUser);
			return "detail";
		} else if (result == 1) {
			error = "密码错误";
			log.info(error);
			model.addAttribute("error", error);
			return "user/login";
		} else {
			error = "该用户不存在";
			log.info(error);
			model.addAttribute("error", error);
			return "user/login";
		}

	}

	/**
	 * 用户注册界面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/sign", method = RequestMethod.GET)
	public String sign() {
		return "user/sign";
	}

	/**
	 * 
	 * @param commonUser
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/sign", method = RequestMethod.POST)
	public String insetUser(Model model, CommonUser commonUser, HttpServletRequest request) {
		// 注册用户: 0:用户身份证号已注册 1:用户邮箱已注册 2:用户手机号已注册 3:用户注册成功
		int result = commonUserService.sign(commonUser, request);
		// 错误信息
		String error = "";
		if (result == 0) {
			error = "用户身份证已被注册";
			log.info(error);
			model.addAttribute("error", error);
			return "user/sign";
		}
		if (result == 1) {
			error = "用户邮箱已注册已被注册";
			log.info(error);
			model.addAttribute("error", error);
			return "user/sign";
		}
		if (result == 2) {
			error = "用户手机号已被注册";
			log.info(error);
			model.addAttribute("error", error);
			return "user/sign";
		}
		
		error="注册成功，请登录账号";
		log.info(error);
		model.addAttribute("error", error);
		return "user/login";
	}

}
