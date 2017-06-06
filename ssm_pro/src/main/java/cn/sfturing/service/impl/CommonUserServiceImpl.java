package cn.sfturing.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.sfturing.dao.CommonUserDao;
import cn.sfturing.entity.CommonUser;
import cn.sfturing.service.CommonUserService;
import cn.sfturing.utils.DateUtil;
import cn.sfturing.utils.DateUtil.DateFormat;

import cn.sfturing.utils.GetIP;
import cn.sfturing.utils.MD5;
import cn.sfturing.utils.MailUtil;

/**
 * 
 * @author sfturing
 *
 * @date 2017年5月6日
 */
@Service
public class CommonUserServiceImpl implements CommonUserService {

	@Autowired
	private CommonUserDao commonUserDao;
	@Autowired
	private DateUtil dateUtil;
	@Autowired
	private MailUtil mailUtil;

	private static Logger log = LoggerFactory.getLogger(CommonUserServiceImpl.class);

	// 登录业务/
	/**
	 * 用户登录 0:用户不存在 1:密码不正确 2:密码正确
	 */
	@Transactional
	@Override
	public int login(String userEmail, String userPassword, HttpServletRequest request) {
		CommonUser commonUser = commonUserDao.findCommonUserByEmail(userEmail);
		if (commonUser == null) {
			return 0; // 用户不存在就返回0
		} else {
			if (MD5.getMD5(userPassword).equals(commonUser.getUserPassword())) {
				commonUser.setLastLoginTime(dateUtil.getCurrentTime(DateFormat.YYYY_MM_DD_HH_mm_ss));
				commonUser.setLastLoginIp(GetIP.getIpAddr(request));
				commonUserDao.modifyIpAndTime(commonUser);
				return 2; // 用户密码正确返回2
			} else {
				return 1; // 用户密码错误返回1
			}
		}
	}

	/**
	 * 用户注册 0:用户身份证号已注册 1:用户邮箱已注册 2:用户手机号已注册 3:用户注册成功
	 */
	@Transactional
	public int sign(CommonUser commonUser, HttpServletRequest request) {
		/*String userIdenf = commonUser.getUserIdenf();
		if (commonUserDao.findCommonUserByUserIdenf(userIdenf) != null) {
			return 0;// 用户身份证号已注册
		}*/
		String userEmail = commonUser.getUserEmail();
		if (commonUserDao.findCommonUserByEmail(userEmail.trim()) != null) {
			return 1;// 用户邮箱已注册
		}
		/*String userMobile = commonUser.getUserMobile();
		if (commonUserDao.findCommonUserByMobile(userMobile) != null) {
			return 2;// 用户手机号已注册
		}*/
		// 将用户密码转为MD5格式
		String userpwd = commonUser.getUserPassword();
		commonUser.setUserPassword(MD5.getMD5(userpwd));
		// 设置注册ip
		commonUser.setRegIp(GetIP.getIpAddr(request));
		commonUser.setUpdateTime(dateUtil.getCurrentTime(DateFormat.YYYY_MM_DD_HH_mm_ss));
		commonUser.setUserEmail(commonUser.getUserEmail().trim());
		commonUserDao.insertCommonUser(commonUser);
		return 3;// 用户注册成功

	}

	@Override
	public boolean findPasswordCheck(String userEmail) {
		CommonUser commonUser = commonUserDao.findCommonUserByEmail(userEmail);
		if (commonUser != null) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean sendEmailCheck(CommonUser commonUser) {
		int verificationCode = (int) (Math.random() * (9000)) + 1000;
		log.info("验证码是:" + verificationCode);
		String updateTime = dateUtil.getCurrentTime(DateFormat.YYYY_MM_DD_HH_mm_ss);
		log.info(updateTime);
		String userEmail = commonUser.getUserEmail();
		log.info(userEmail);
		String email = commonUser.getUserEmail();
		log.info(email);
		String sender = "天津市医院预约系统";
		String title = "天津市医院预约挂号【验证码】";
		String content = verificationCode + "\n<br>验证码有效期为30分钟，请及时验证。";
		boolean isSuccess = mailUtil.sendMail(email, sender, title, content);
		if (isSuccess == true) {
			log.info("发送成功");
			commonUserDao.sendVerification(userEmail, verificationCode, updateTime);
			return true;
		} else {
			log.info("发送失败");
			return false;
		}
	}

	@Override
	public CommonUser findCommonUserByUserIdenf(String userIdenf) {

		return commonUserDao.findCommonUserByUserIdenf(userIdenf);
	}

	@Override
	public CommonUser findCommonUserByEmail(String userEmail) {

		return commonUserDao.findCommonUserByEmail(userEmail);
	}

	@Override
	public int findHeadway(String updateTime) {
		return dateUtil.timeSubtractionSecond(updateTime, dateUtil.getCurrentTime(DateFormat.YYYY_MM_DD_HH_mm_ss));

	}

	/**
	 * 0：验证码超时 1：验证码验证通过 2：验证码验证失败
	 */
	@Override
	public int checkVerification(int verificationCode, CommonUser commonUser) {
		// 验证时间是否超过30分钟
		if (findHeadway(commonUser.getUpdateTime()) > 1800) {
			return 0;// 返回值为0：代表验证码时间超过30分钟
		} else {
			if (verificationCode == commonUser.getVerificationCode()) {
				return 1;// 返回值为1，代表验证码验证通过，可以修改密码
			} else {
				return 2;// 返回值为2：代表验证码验证失败，重新输入验证码
			}
		}
	}

	/**
	 * 清空验证码以及发送时间
	 */
	@Override
	public int clearVerification(String userEmail) {

		return commonUserDao.clearVerification(userEmail);
	}

	/**
	 * 修改密码
	 */
	@Override
	public boolean modifyPassWord(String userIdenf, String newPassWord) {
		// 将用户密码转为MD5格式
		newPassWord = MD5.getMD5(newPassWord);
		if (commonUserDao.modifyPassWord(userIdenf, newPassWord) > 0) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * 完善个人信息
	 */
	@Override
	public int addUserInfo(String userEmail, String userIdenf, String userName, String userMobile,String userSex) {
		if (commonUserDao.findCommonUserByUserIdenf(userIdenf) != null) {
			return 0;// 用户身份证号已注册
		}
		if (commonUserDao.findCommonUserByMobile(userMobile) != null) {
			return 2;// 用户手机号已注册
		}
		commonUserDao.addUserInfo(userEmail, userIdenf, userName, userMobile,userSex);
		return 1; //用户更新成功
	}

	@Override
	public int modifySex(int userId, String userSex) {
		// TODO Auto-generated method stub
		return commonUserDao.modifySex(userId, userSex);
	}

	@Override
	public int modifyPhone(String userPhone, String userEmail) {
		
		if (commonUserDao.findCommonUserByMobile(userPhone) != null) {
			return 2;// 用户手机号已注册
		}
		commonUserDao.modifyPhone(userEmail, userPhone);
		
		return 1;
	}


}
