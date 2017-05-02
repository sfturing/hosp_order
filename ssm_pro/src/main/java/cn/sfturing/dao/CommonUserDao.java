package cn.sfturing.dao;

import org.apache.ibatis.annotations.Param;

import cn.sfturing.entity.CommonUser;



public interface CommonUserDao {
	/*
	 * 查找用户
	 */
	public CommonUser findCommonUserByUserId(long userId);
	
	public CommonUser findCommonUserByUserIdenf(String userIdenf);

	public CommonUser findCommonUserByUserName(String userName);

	public CommonUser findCommonUserByEmail(String userEmail);

	public CommonUser findCommonUserByMobile(String userMobile);

	/*
	 * 插入更新和删除
	 */
	public int insertCommonUser(CommonUser CommonUser);
	//通过id删除
	public void deleteCommonUser(long id);
	//通过身份证号删除
	public void deleteCommonUserByIdenf(String userIdenf);

	/*
	 * 更改用户密码、手机号码以及激活邮箱
	 */
	public int midifyPassWord(@Param("CommonUserName") String CommonUserName, @Param("newPassWord") String newPassWord)
			throws Exception;

	public int midifyPhone(@Param("CommonUserName") String CommonUserName, @Param("newPhone") String newPhone);

	public int activateCommonUser(String email);

}
