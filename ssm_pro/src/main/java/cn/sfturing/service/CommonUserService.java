package cn.sfturing.service;



public interface CommonUserService {
	/**
	 * 用户登录，根据身份证号进行登录
	 * @param email		登录的身份证号
	 * @param passWord	登录的密码
	 * @return 
	 * @throws Exception 
	 */
	public int login(String userIdenf,String userPassword) throws Exception;
	
}
