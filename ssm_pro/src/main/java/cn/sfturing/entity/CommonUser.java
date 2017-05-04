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
	private long userId;
	private String userIdenf;
	private String userName;
	private String userSex;
	private String userPassword;
	private String userEmail;
	private String userMobile;
	private Timestamp regTime;
	private String regIp;
	private String lastLoginTime;
	private String lastLoginIp;
	private String updateTime;
	private Byte stetus;
	private int isdelete;
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
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
	public Byte getStetus() {
		return stetus;
	}
	public void setStetus(Byte stetus) {
		this.stetus = stetus;
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
				+ lastLoginIp + ", updateTime=" + updateTime + ", stetus=" + stetus + ", isdelete=" + isdelete + "]";
	}

}
