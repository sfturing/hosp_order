package cn.sfturing.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.sfturing.entity.CommonUser;
/**
 * 
 * @author sfturing
 *
 * @date 2017年5月6日
 */
public interface CommonUserDao {
	/************************ 用户查找 ********************/
	// 通过id查找用户
	public CommonUser findCommonUserByUserId(long userId);

	// 通过身份证号查找用户
	public CommonUser findCommonUserByUserIdenf(String userIdenf);

	// 通过用户姓名查找用户
	public List<CommonUser> findCommonUserByUserName(String userName);

	// 通过用户邮箱查找用户
	public CommonUser findCommonUserByEmail(String userEmail);

	// 通过用户手机号查找用户
	public CommonUser findCommonUserByMobile(String userMobile);

	/******************** 用户插入 *************************/
	// 增加新用户
	public int insertCommonUser(CommonUser CommonUser);

	/******************** 用户删除（假删除） *************************/
	// 通过id删除
	public void deleteCommonUser(long id);

	// 通过身份证号删除
	public void deleteCommonUserByIdenf(String userIdenf);

	/******************** 用户修改信息（用户个人中心修改方法） *************************/
	// 修改用户密码，需要邮箱验证
	public int modifyPassWord(@Param("userEmail") String userEmail, @Param("newPassWord") String newPassWord);

	// 修改用户手机，需要邮箱验证
	public int modifyPhone(@Param("userEmail") String userEmail, @Param("newPhone") String newPhone);

	// 修改用户邮箱，需要申诉
	public int modifyEmail(@Param("userIdenf") String userIdenf, @Param("newEmail") String newEmail);

	// 更新验证码并设置发送时间
	public int sendVerification(@Param("userEmail") String userEmail,
			@Param("verificationCode") int verificationCode, @Param("updateTime") String updateTime);

	// 清空验证码
	public int clearVerification(String userEmail);

	// 激活用户
	public int activateCommonUser(String userEmail);
	
	//完善用户信息
	public int addUserInfo(@Param("userEmail") String userEmail,@Param("userIdenf") String userIdenf,@Param("userName") String userName,@Param("userMobile") String userMobile,@Param("userSex") String userSex);

	/****************************** 修改用户后台信息 ***************************************/
	// 更新最后登陆ip和最后登陆时间
	public int modifyIpAndTime(CommonUser CommonUser);
	

}
