package cn.sfturing.entity;



public class CommonCondition {

	// 医院名称
	private String hospitalName;
	// String isMedicalInsurance;
	// 医院等级
	private String hospitalGrade;
	// 医院类型
	private String hospitalNature;
	// String hospitalAddressString;
	// String hospitalArea;
	// int start;
	// int size;
	//省
	private String province;
	//城市
	private String city;
	//地区
	private String district;
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getHospitalGrade() {
		return hospitalGrade;
	}
	public void setHospitalGrade(String hospitalGrade) {
		this.hospitalGrade = hospitalGrade;
	}
	public String getHospitalNature() {
		return hospitalNature;
	}
	public void setHospitalNature(String hospitalNature) {
		this.hospitalNature = hospitalNature;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	@Override
	public String toString() {
		return "CommonCondition [hospitalName=" + hospitalName + ", hospitalGrade=" + hospitalGrade
				+ ", hospitalNature=" + hospitalNature + ", province=" + province + ", city=" + city + ", district="
				+ district + "]";
	}
	
	
}
