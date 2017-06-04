package cn.sfturing.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 * 
 * @author sfturing
 *
 * @date 2017年4月28日
 */
public class CommonUser {
	//userid
	private int userId;
	//user身份证号
	private String userIdenf;
	//user姓名
	private String userName;
	//user性别
	private String userSex;
	//user密码
	private String userPassword;
	//user邮箱
	private String userEmail;
	//user手机
	private String userMobile;
	//user注册时间
	private Timestamp regTime;
	//user注册ip
	private String regIp;
	//user最后登录时间
	private String lastLoginTime;
	//user最后登录的ip
	private String lastLoginIp;
	//user验证码发送时间
	private String updateTime;
	//验证码
	private int verificationCode;
	//User是否激活状态。0：表示未激活，1：表示以激活，可以挂号
	private int status;
	//user是否存在。0：修改密码校验码，1：完善信息校验码
	private int isdelete;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserIdenf() {
		return userIdenf;
	}
	public void setUserIdenf(String userIdenf) {
		this.userIdenf = userIdenf;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	public Timestamp getRegTime() {
		return regTime;
	}
	public void setRegTime(Timestamp regTime) {
		this.regTime = regTime;
	}
	public String getRegIp() {
		return regIp;
	}
	public void setRegIp(String regIp) {
		this.regIp = regIp;
	}
	public String getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public String getLastLoginIp() {
		return lastLoginIp;
	}
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public int getVerificationCode() {
		return verificationCode;
	}
	public void setVerificationCode(int verificationCode) {
		this.verificationCode = verificationCode;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}
	@Override
	public String toString() {
		return "CommonUser [userId=" + userId + ", userIdenf=" + userIdenf + ", userName=" + userName + ", userSex="
				+ userSex + ", userPassword=" + userPassword + ", userEmail=" + userEmail + ", userMobile=" + userMobile
				+ ", regTime=" + regTime + ", regIp=" + regIp + ", lastLoginTime=" + lastLoginTime + ", lastLoginIp="
				+ lastLoginIp + ", updateTime=" + updateTime + ", verificationCode=" + verificationCode + ", status="
				+ status + ", isdelete=" + isdelete + "]";
	}
	

}
