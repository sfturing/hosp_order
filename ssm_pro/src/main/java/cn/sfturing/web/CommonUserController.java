package cn.sfturing.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sfturing.entity.CommonUser;
import cn.sfturing.entity.OrderRecords;
import cn.sfturing.service.CommonUserService;
import cn.sfturing.service.OrderRecordsService;

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
	@Autowired
	private OrderRecordsService orderRecordsService;
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
	public String login(HttpSession session) {
		session.invalidate();
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
	public String login(Model model, String userEmail, String userPassword, HttpSession session,
			HttpServletRequest request) {
		// 登录用户，并将登录后的状态码返回，如果是0用户不存在，如果是1那么密码错误，如果是2那么密码正确
		int result = commonUserService.login(userEmail.trim(), userPassword, request);
		// 错误信息
		String error = "";
		// 查找这个用户
		CommonUser commonUser = commonUserService.findCommonUserByEmail(userEmail);
		if (result == 2) {
			// 如果是2，那么登录成功，返回index
			model.addAttribute("user", commonUser);
			session.setAttribute("userInfo", commonUser);
			return "index/index";
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
	public String sign(HttpSession session) {
		session.invalidate();
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
		/*
		 * if (result == 0) { error = "用户身份证已被注册"; log.info(error);
		 * model.addAttribute("error", error); return "user/sign"; }
		 */
		if (result == 1) {
			error = "用户邮箱已被注册";
			log.info(error);
			model.addAttribute("error", error);
			return "user/sign";
		}
		/*
		 * if (result == 2) { error = "用户手机号已被注册"; log.info(error);
		 * model.addAttribute("error", error); return "user/sign"; }
		 */

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
	 * 用户修改手机
	 */
	@RequestMapping(value = "/modifiPhone", method = RequestMethod.GET)
	public String modifiPhone(final HttpSession session, Model model) {
		final CommonUser commonUser = (CommonUser) session.getAttribute("userInfo");
		// 单独开启线程发送邮件，防止用户等待时间过长，成功日志输出，失败也输出。
		new Thread(new Runnable() {
			public void run() {
				boolean isSuccess = commonUserService.sendEmailCheck(commonUser);
				if (isSuccess) {
					log.info(commonUser.getUserEmail() + "发送成功" + commonUser.getUpdateTime());
					CommonUser userMSG = commonUserService.findCommonUserByEmail(commonUser.getUserEmail());
					userMSG.setStatus(2);
					session.setAttribute("userMSG", userMSG);
				} else {
					log.info(commonUser.getUserEmail() + "发送失败" + commonUser.getUpdateTime());
				}
			}
		}).start();
		return "/user/checkVerification";
	}
	
	/**
	 * 用户修改手机
	 */
	@RequestMapping(value = "/modifiPhone", method = RequestMethod.POST)
	public String modifiPhone(String userMobile, HttpSession session,
			Model model) {
		CommonUser commonUser = (CommonUser) session.getAttribute("userInfo");
		String error = "";
		int result = commonUserService.modifyPhone(userMobile, commonUser.getUserEmail());
		
		if (result == 2) {
			error = "手机号已经被注册";
			log.info(error);
			model.addAttribute("error", error);
			return "user/modifiPhone";
		}
		CommonUser commonUser1 = commonUserService.findCommonUserByEmail(commonUser.getUserEmail());
		session.setAttribute("userInfo", commonUser1);
		return "redirect:/userCenter";
	}

	/**
	 * 用户找回密码
	 * 
	 * @return
	 */
	@RequestMapping(value = "/findPassword", method = RequestMethod.POST)
	public String findPassword(Model model, final String userEmail, final HttpSession session) {
		// 错误信息
		String error = "";
		// 通过输入的身份证查找用户
		final CommonUser commonUser = commonUserService.findCommonUserByEmail(userEmail);
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
			if (!userEmail.equals(email)) {
				error = "邮箱不匹配，请检查后输入";
				log.info(error);
				model.addAttribute("error", error);
				return "user/findPassword";
			} else {
				if (commonUserService.findHeadway(commonUser.getUpdateTime()) < 300) {
					error = "5分钟内只能发送一封邮件";
					log.info(error);
					model.addAttribute("error", error);
					return "user/findPassword";
				}
				// 单独开启线程发送邮件，防止用户等待时间过长，成功日志输出，失败也输出。
				new Thread(new Runnable() {
					public void run() {
						boolean isSuccess = commonUserService.sendEmailCheck(commonUser);
						if (isSuccess) {
							log.info(commonUser.getUserEmail() + "发送成功" + commonUser.getUpdateTime());
							CommonUser userMSG = commonUserService.findCommonUserByEmail(userEmail);
							userMSG.setStatus(0);
							session.setAttribute("userMSG", userMSG);
						} else {
							log.info(commonUser.getUserEmail() + "发送失败" + commonUser.getUpdateTime());
						}
					}
				}).start();
				return "/user/checkVerification";
			}
		}
	}

	/**
	 * 检查验证码界面 0：验证码超时 1：验证码验证通过 2：验证码验证失败
	 * 
	 * @return
	 */
	@RequestMapping(value = "/checkVerification", method = RequestMethod.POST)
	public String checkVerification(Model model, int verificationCode, HttpSession session) {
		CommonUser commonUser = (CommonUser) session.getAttribute("userMSG");
		System.out.println(commonUser.getStatus());
		int result = commonUserService.checkVerification(verificationCode, commonUser);
		System.out.println(result);
		// 错误信息
		String error = "";
		if (result == 0) {
			error = "发送时间已经超过30分钟，请重新发送。";
			log.info(error);
			model.addAttribute("error", error);
			return "user/checkVerification";
		}
		if (result == 2) {
			error = "您输入的验证码不正确，请重新输入。";
			log.info(error);
			model.addAttribute("error", error);
			return "user/checkVerification";
		}
		if (result == 1) {
			//commonUserService.clearVerification(commonUser.getUserEmail());
			//状态为0修改密码
			if (commonUser.getStatus() == 0) {
				System.out.println(commonUser.getStatus());
				return "/user/updatePassword";
			}
			//状态为1完善信息
			if (commonUser.getStatus() == 1) {
				System.out.println(commonUser.getStatus());
				return "user/addUserInfo";
			}
			//状态为2修改手机
			if (commonUser.getStatus() == 2) {
				System.out.println(commonUser.getStatus());
				return "user/modifiPhone";
			}

		}
		return "/user/checkVerification";
	}

	/**
	 * 用户更改密码
	 * 
	 * @return
	 */
	@RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
	public String updatePassword(String newPassWord, Model model, HttpSession session) {
		// 错误信息
		String error = "";
		CommonUser commonUser = (CommonUser) session.getAttribute("userMSG");
		boolean isSuccess = commonUserService.modifyPassWord(commonUser.getUserEmail(), newPassWord);
		if (isSuccess) {
			error = "密码修改成功";
			log.info(error);
			model.addAttribute("error", error);
			return "user/login";
		} else {
			error = "密码修改失败";
			log.info(error);
			model.addAttribute("error", error);
			return "user/updatePassword";
		}
	}

	/**
	 * 用户完善信息
	 */
	@RequestMapping(value = "/addUserInfo", method = RequestMethod.GET)
	public String addUserInfo(final HttpSession session, Model model) {
		final CommonUser commonUser = (CommonUser) session.getAttribute("userInfo");
		// 单独开启线程发送邮件，防止用户等待时间过长，成功日志输出，失败也输出。
		new Thread(new Runnable() {
			public void run() {
				boolean isSuccess = commonUserService.sendEmailCheck(commonUser);
				if (isSuccess) {
					log.info(commonUser.getUserEmail() + "发送成功" + commonUser.getUpdateTime());
					CommonUser userMSG = commonUserService.findCommonUserByEmail(commonUser.getUserEmail());
					userMSG.setStatus(1);
					session.setAttribute("userMSG", userMSG);
				} else {
					log.info(commonUser.getUserEmail() + "发送失败" + commonUser.getUpdateTime());
				}
			}
		}).start();
		return "/user/checkVerification";
	}

	/**
	 * 用户完善信息
	 */
	@RequestMapping(value = "/addUserInfo", method = RequestMethod.POST)
	public String addUserInfo(String userIdenf, String userName, String userMobile, String userSex, HttpSession session,
			Model model) {
		CommonUser commonUser = (CommonUser) session.getAttribute("userInfo");
		String error = "";
		int result = commonUserService.addUserInfo(commonUser.getUserEmail(), userIdenf, userName, userMobile, userSex);
		if (result == 0) {
			error = "身份证已经被注册";
			log.info(error);
			model.addAttribute("error", error);
			return "user/addUserInfo";
		}
		if (result == 2) {
			error = "手机号已经被注册";
			log.info(error);
			model.addAttribute("error", error);
			return "user/addUserInfo";
		}
		CommonUser commonUser1 = commonUserService.findCommonUserByEmail(commonUser.getUserEmail());
		session.setAttribute("userInfo", commonUser1);
		return "index/index";
	}

	/**
	 * 用户个人中心
	 */
	/**
	 *
	 * 
	 * @return
	 */
	@RequestMapping(value = "/userCenter", method = RequestMethod.GET)
	public String userCenter(HttpSession session, Model model) {
		CommonUser commonUser = (CommonUser) session.getAttribute("userInfo");
		if (commonUser != null) {
			List<OrderRecords> orderRecords = orderRecordsService.findOrderRecordsByUserID(commonUser.getUserId());
			model.addAttribute("orderRecords", orderRecords);
			model.addAttribute("commonUser", commonUser);
			return "userCenter/userCenter";
		}
		return "index/index";
	}
	
	/**
	 * 用户更改性别
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/updateSex", method = RequestMethod.POST)
	public Map<String, Object> updateSex(String userSex, Model model, HttpSession session) {
		CommonUser commonUser = (CommonUser) session.getAttribute("userInfo");
		int userId = commonUser.getUserId();
		if(userSex.equals("男")){
			commonUserService.modifySex(userId, "男");
		}else{
			commonUserService.modifySex(userId, "女");
		}
		String userSexInfo = commonUserService.findCommonUserByEmail(commonUser.getUserEmail()).getUserSex();
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		rtnMap.put("userSexInfo", userSexInfo);
		return rtnMap;
	}

}
