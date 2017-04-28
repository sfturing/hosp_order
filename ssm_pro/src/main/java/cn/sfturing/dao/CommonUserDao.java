package cn.sfturing.dao;

import org.apache.ibatis.annotations.Param;

import cn.sfturing.entity.CommonUser;



public interface CommonUserDao {
	/*
	 * 查找用户
	 */
	public CommonUser findCommonUserByUserId(long id) throws Exception;
	
	public CommonUser findCommonUserByUserIdenf(String userIdenf) throws Exception;

	public CommonUser findCommonUserByUserName(String userName) throws Exception;

	public CommonUser findCommonUserByEmail(String email) throws Exception;

	public CommonUser findCommonUserByPhone(String phone) throws Exception;

	/*
	 * 插入更新和删除
	 */
	public int insertCommonUser(CommonUser CommonUser) throws Exception;

	public void deleteCommonUser(long id) throws Exception;

	/*
	 * 更改用户密码、手机号码以及激活邮箱
	 */
	public int midifyPassWord(@Param("CommonUserName") String CommonUserName, @Param("newPassWord") String newPassWord)
			throws Exception;

	public int midifyPhone(@Param("CommonUserName") String CommonUserName, @Param("newPhone") String newPhone) throws Exception;

	public int activateCommonUser(String email) throws Exception;

}
