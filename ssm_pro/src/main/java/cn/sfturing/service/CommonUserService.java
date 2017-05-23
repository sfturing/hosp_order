package cn.sfturing.service;

import javax.servlet.http.HttpServletRequest;


import cn.sfturing.entity.CommonUser;
/**
 * 
 * @author sfturing
 *
 * @date 2017年5月6日
 */
public interface CommonUserService {
	/**
	 * 用户登录，根据身份证号进行登录
	 * 
	 * @param email
	 *            登录的身份证号
	 * @param passWord
	 *            登录的密码
	 * @return
	 * @throws Exception
	 */
	public int login(String userEmail, String userPassword, HttpServletRequest request);

	/**
	 * 用户注册
	 * 
	 * @param commonUser
	 * @return
	 */
	public int sign(CommonUser commonUser, HttpServletRequest request);

	/**
	 * 用户找回密码邮箱是否匹配
	 * 
	 * @param userIdenf
	 * @param userEmail
	 * @return
	 */
	public boolean findPasswordCheck(String userEmail);
	
	/**
	 * 发送邮件并返回发送结果
	 * @param commonUser
	 * @return
	 */
	public boolean sendEmailCheck(CommonUser commonUser);

	/**
	 * 通过用户身份证号查找用户
	 * 
	 * @param userIdenf
	 * @return
	 */
	public CommonUser findCommonUserByUserIdenf(String userIdenf);

	/**
	 * 通过用户邮箱查找用户
	 * 
	 * @param userEmail
	 * @return
	 */
	public CommonUser findCommonUserByEmail(String userEmail);
	
	/**
	 * 查询验证码发送时间
	 * @return
	 */
	public int findHeadway(String updateTime);
	/**
	 * 检查验证码是否正确
	 * @param verificationCode
	 * @return
	 */
	public int checkVerification(int verificationCode,CommonUser commonUser);
	/**
	 * 清空验证码以及发送时间
	 * @param userIdenf
	 * @return
	 */
	public int clearVerification(String userEmail);
	/**
	 * 修改新密码
	 * @param userIdenf
	 * @param newPassWord
	 * @return
	 */
	public boolean modifyPassWord( String userEmail,String newPassWord);
	/**
	 * 完善个人信息
	 * @param userEmail
	 * @param userIdenf
	 * @param userName
	 * @param userMobile
	 * @return
	 */
	public int addUserInfo(String userEmail,String userIdenf,String userName, String userMobile,String userSex);
	


}
