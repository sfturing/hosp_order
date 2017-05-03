package cn.sfturing.service;

import javax.servlet.http.HttpServletRequest;

import cn.sfturing.entity.CommonUser;

public interface CommonUserService {
	/**
	 * 用户登录，根据身份证号进行登录
	 * @param email		登录的身份证号
	 * @param passWord	登录的密码
	 * @return 
	 * @throws Exception 
	 */
	public int login(String userIdenf,String userPassword,HttpServletRequest request);
	/**
	 * 用户注册
	 * @param commonUser
	 * @return
	 */
	public int sign(CommonUser commonUser,HttpServletRequest request);
}
