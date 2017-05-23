package cn.sfturing.entity;

/**
 * 
 * @author sfturing
 *
 * @date 2017年4月29日
 */
public class Hospital {
	// 医院id
	private int id;
	// 医院名称
	private String hospitalName;
	// 医院的地区
	private String hospitalArea;
	// 医院图片
	private String hospitalImg;
	// 院长姓名
	private String hospitalDeanName;
	// 建院年份
	private String hospitalYear;
	// 医院类型
	private String hospitalNature;
	// 医院等级
	private String hospitalGrade;
	// 是否医保
	private String isMedicalInsurance;
	// 医院设备介绍
	private String hospitalEquipment;
	// 医院介绍
	private String hospitalAbout;
	// 医院荣誉
	private String hospitalHonor;
	// 医院网址
	private String hospitalUrl;
	// 医院电话
	private String hospitalPhone;
	//医院地址
	private String hospitalAddress;
	//医院邮编
	private String hospitalPostCode;
	//医院公交路线
	private String hospitalBusRoute;
	// 医院科室数量
	private int hospitalOfficesNum;
	// 医保人数
	private int medicalInsuranceNum;
	// 医院病床数量
	private int hospitalBedNum;
	// 年门诊量
	private int outpatientNum;
	//是否开放预约
	private int isOpen;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getHospitalArea() {
		return hospitalArea;
	}
	public void setHospitalArea(String hospitalArea) {
		this.hospitalArea = hospitalArea;
	}
	public String getHospitalImg() {
		return hospitalImg;
	}
	public void setHospitalImg(String hospitalImg) {
		this.hospitalImg = hospitalImg;
	}
	public String getHospitalDeanName() {
		return hospitalDeanName;
	}
	public void setHospitalDeanName(String hospitalDeanName) {
		this.hospitalDeanName = hospitalDeanName;
	}
	public String getHospitalYear() {
		return hospitalYear;
	}
	public void setHospitalYear(String hospitalYear) {
		this.hospitalYear = hospitalYear;
	}
	public String getHospitalNature() {
		return hospitalNature;
	}
	public void setHospitalNature(String hospitalNature) {
		this.hospitalNature = hospitalNature;
	}
	public String getHospitalGrade() {
		return hospitalGrade;
	}
	public void setHospitalGrade(String hospitalGrade) {
		this.hospitalGrade = hospitalGrade;
	}
	public String getIsMedicalInsurance() {
		return isMedicalInsurance;
	}
	public void setIsMedicalInsurance(String isMedicalInsurance) {
		this.isMedicalInsurance = isMedicalInsurance;
	}
	public String getHospitalEquipment() {
		return hospitalEquipment;
	}
	public void setHospitalEquipment(String hospitalEquipment) {
		this.hospitalEquipment = hospitalEquipment;
	}
	public String getHospitalAbout() {
		return hospitalAbout;
	}
	public void setHospitalAbout(String hospitalAbout) {
		this.hospitalAbout = hospitalAbout;
	}
	public String getHospitalHonor() {
		return hospitalHonor;
	}
	public void setHospitalHonor(String hospitalHonor) {
		this.hospitalHonor = hospitalHonor;
	}
	public String getHospitalUrl() {
		return hospitalUrl;
	}
	public void setHospitalUrl(String hospitalUrl) {
		this.hospitalUrl = hospitalUrl;
	}
	public String getHospitalPhone() {
		return hospitalPhone;
	}
	public void setHospitalPhone(String hospitalPhone) {
		this.hospitalPhone = hospitalPhone;
	}
	public String getHospitalAddress() {
		return hospitalAddress;
	}
	public void setHospitalAddress(String hospitalAddress) {
		this.hospitalAddress = hospitalAddress;
	}
	public String getHospitalPostCode() {
		return hospitalPostCode;
	}
	public void setHospitalPostCode(String hospitalPostCode) {
		this.hospitalPostCode = hospitalPostCode;
	}
	public String getHospitalBusRoute() {
		return hospitalBusRoute;
	}
	public void setHospitalBusRoute(String hospitalBusRoute) {
		this.hospitalBusRoute = hospitalBusRoute;
	}
	public int getHospitalOfficesNum() {
		return hospitalOfficesNum;
	}
	public void setHospitalOfficesNum(int hospitalOfficesNum) {
		this.hospitalOfficesNum = hospitalOfficesNum;
	}
	public int getMedicalInsuranceNum() {
		return medicalInsuranceNum;
	}
	public void setMedicalInsuranceNum(int medicalInsuranceNum) {
		this.medicalInsuranceNum = medicalInsuranceNum;
	}
	public int getHospitalBedNum() {
		return hospitalBedNum;
	}
	public void setHospitalBedNum(int hospitalBedNum) {
		this.hospitalBedNum = hospitalBedNum;
	}
	public int getOutpatientNum() {
		return outpatientNum;
	}
	public void setOutpatientNum(int outpatientNum) {
		this.outpatientNum = outpatientNum;
	}
	public int getIsOpen() {
		return isOpen;
	}
	public void setIsOpen(int isOpen) {
		this.isOpen = isOpen;
	}
	@Override
	public String toString() {
		return "Hospital [id=" + id + ", hospitalName=" + hospitalName + ", hospitalArea=" + hospitalArea
				+ ", hospitalImg=" + hospitalImg + ", hospitalDeanName=" + hospitalDeanName + ", hospitalYear="
				+ hospitalYear + ", hospitalNature=" + hospitalNature + ", hospitalGrade=" + hospitalGrade
				+ ", isMedicalInsurance=" + isMedicalInsurance + ", hospitalEquipment=" + hospitalEquipment
				+ ", hospitalAbout=" + hospitalAbout + ", hospitalHonor=" + hospitalHonor + ", hospitalUrl="
				+ hospitalUrl + ", hospitalPhone=" + hospitalPhone + ", hospitalAddress=" + hospitalAddress
				+ ", hospitalPostCode=" + hospitalPostCode + ", hospitalBusRoute=" + hospitalBusRoute
				+ ", hospitalOfficesNum=" + hospitalOfficesNum + ", medicalInsuranceNum=" + medicalInsuranceNum
				+ ", hospitalBedNum=" + hospitalBedNum + ", outpatientNum=" + outpatientNum + ", isOpen=" + isOpen
				+ "]";
	}
	
	

}
