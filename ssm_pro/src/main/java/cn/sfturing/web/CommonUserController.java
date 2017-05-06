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

import cn.sfturing.entity.CommonUser;
import cn.sfturing.service.CommonUserService;
import cn.sfturing.utils.MailUtil;

/**
 * 
 * @author sfturing
 *
 * @date 2017年5月6日
 */
@Controller
public class CommonUserController {
	@Autowired
	private CommonUserService commonUserService;
	/*
	 * @Autowired private CommonUserDao commonUserDao;
	 */

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
	public String login(Model model, String userIdenf, String userPassword, HttpSession session,
			HttpServletRequest request) {

		// 登录用户，并将登录后的状态码返回，如果是0用户不存在，如果是1那么密码错误，如果是2那么密码正确
		int result = commonUserService.login(userIdenf, userPassword, request);
		// 错误信息
		String error = "";
		// 查找这个用户
		CommonUser commonUser = commonUserService.findCommonUserByUserIdenf(userIdenf);

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
	 * 用户注册
	 * 
	 * @param commonUser
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/sign", method = RequestMethod.POST)
	public String sign(Model model, CommonUser commonUser, HttpServletRequest request) {
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

		error = "注册成功，请登录账号";
		log.info(error);
		model.addAttribute("error", error);
		return "user/login";
	}

	/**
	 * 用户找回密码
	 * 
	 * @return
	 */
	@RequestMapping(value = "/findPassword", method = RequestMethod.GET)
	public String findPassword() {
		return "user/findPassword";
	}

	/**
	 * 用户找回密码
	 * 
	 * @return
	 */
	@RequestMapping(value = "/findPassword", method = RequestMethod.POST)
	public String findPassword(Model model, String userIdenf, String userEmail) {
		// 错误信息
		String error = "";
		// 通过输入的身份证查找用户
		CommonUser commonUser = commonUserService.findCommonUserByUserIdenf(userIdenf);
		// 用户不存在返回找回密码页面
		if (commonUser == null) {
			error = "用户不存在，请检查后输入";
			log.info(error);
			model.addAttribute("error", error);
			return "user/findPassword";
		} else {
			// 输入的邮箱与密码不匹配，返回找回密码界面
			String email = commonUser.getUserEmail();
			log.info(email);
			log.info(userEmail);
			if (!userEmail.equals(email)) {
				error = "邮箱不匹配，请检查后输入";
				log.info(error);
				model.addAttribute("error", error);
				return "user/findPassword";
			} else {
				if(commonUserService.findHeadway(commonUser.getUpdateTime()) < 300){
					error = "5分钟内只能发送一封邮件";
					log.info(error);
					model.addAttribute("error", error);
					return "user/findPassword";
				}
				commonUserService.sendEmailCheck(commonUser);
				return "/user/checkVerification";
			}
		}
	}
	
	/**
	 * 检查验证码界面
	 * @return
	 */
	@RequestMapping(value = "/checkVerification", method = RequestMethod.POST)
	public String checkVerification(Model model,String verificationCode){
		
		return "/user/updatePassword";
	}
	
	
	
	
	
	
	
	
}
