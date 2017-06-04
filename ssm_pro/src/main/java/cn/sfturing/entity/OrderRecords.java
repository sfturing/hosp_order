package cn.sfturing.entity;

import java.sql.Timestamp;
/**
 * 
 * @author sfturing
 *
 * @date 2017年5月22日
 */
public class OrderRecords {
	//预约id
	private int id;
	//用户ID
	private int UserID;
	//预约医院名称
	private String hospitalName;
	//预约科室名称
	private String officesName;
	//医生姓名
	private String doctorName;
	//预约日期
	private String transactDate;
	//预约时间段
	private String transactTime;
	//疾病信息
	private String diseaseInfo;
	//是否成功
	private int isSuccess;
	//是否发送邮件
	private int isSend;
	//是否取消
	private int isCancel;
	//预约识别码
	private int orderVer;
	//创建预约时间
	private Timestamp createTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getOfficesName() {
		return officesName;
	}
	public void setOfficesName(String officesName) {
		this.officesName = officesName;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getTransactDate() {
		return transactDate;
	}
	public void setTransactDate(String transactDate) {
		this.transactDate = transactDate;
	}
	public String getTransactTime() {
		return transactTime;
	}
	public void setTransactTime(String transactTime) {
		this.transactTime = transactTime;
	}
	public String getDiseaseInfo() {
		return diseaseInfo;
	}
	public void setDiseaseInfo(String diseaseInfo) {
		this.diseaseInfo = diseaseInfo;
	}
	public int getIsSuccess() {
		return isSuccess;
	}
	public void setIsSuccess(int isSuccess) {
		this.isSuccess = isSuccess;
	}
	public int getIsSend() {
		return isSend;
	}
	public void setIsSend(int isSend) {
		this.isSend = isSend;
	}
	public int getIsCancel() {
		return isCancel;
	}
	public void setIsCancel(int isCancel) {
		this.isCancel = isCancel;
	}
	public int getOrderVer() {
		return orderVer;
	}
	public void setOrderVer(int orderVer) {
		this.orderVer = orderVer;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "OrderRecords [id=" + id + ", UserID=" + UserID + ", hospitalName=" + hospitalName + ", officesName="
				+ officesName + ", doctorName=" + doctorName + ", transactDate=" + transactDate + ", transactTime="
				+ transactTime + ", diseaseInfo=" + diseaseInfo + ", isSuccess=" + isSuccess + ", isSend=" + isSend
				+ ", isCancel=" + isCancel + ", orderVer=" + orderVer + ", createTime=" + createTime + "]";
	}
	
	
	
	//
	
	
	
	
	

}
