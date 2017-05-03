package cn.sfturing.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.sfturing.dao.CommonUserDao;
import cn.sfturing.entity.CommonUser;
import cn.sfturing.service.CommonUserService;
import cn.sfturing.utils.GetIP;
import cn.sfturing.utils.MD5;

@Controller
public class CommonUserController {
	@Autowired
	private CommonUserService commonUserService;
	@Autowired
	private CommonUserDao commonUserDao;
	
	/**
	 * 用户登陆界面
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(){
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
	public String loginSuccess(Model model,String userIdenf, String userPassword, HttpSession httpSession,HttpServletRequest request){

	
		// 登录用户，并将登录后的状态码返回，如果是0用户不存在，如果是1那么密码错误，如果是2那么密码正确
		int result = commonUserService.login(userIdenf, userPassword,request);

		// 查找这个用户
		CommonUser commonUser = commonUserDao.findCommonUserByUserIdenf(userIdenf);
		
		if (result == 2) {
			// 如果是2，那么登录成功，返回index
			String ip = GetIP.getIpAddr(request);
			commonUser.setLastLoginIp(ip);
			model.addAttribute("user", commonUser);
			return "detail";
		} else if (result == 1) {
			System.out.println("密码错误");
			return "user/login";
		} else {
			System.out.println("用户不存在");
			return "user/login";
		}

	}
	
	/**
	 * 用户注册界面
	 * @return
	 */
	@RequestMapping(value = "/sign", method = RequestMethod.GET)
	public String sign(){
		return "user/sign";
	}
	
	@RequestMapping(value = "/sign", method = RequestMethod.POST)
	public String insetUser(CommonUser commonUser,HttpServletRequest request){
		String userpwd = commonUser.getUserPassword();
		System.out.println(userpwd);
		String a = MD5.getMD5(userpwd);
		System.out.println(a);
		/*commonUserDao.insertCommonUser(commonUser);*/
		System.out.println("aaaa");
		return "NewFile";
	}

}
