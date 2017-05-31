package cn.sfturing.entity;



public class CommonCondition {

	// 医院名称
	private String hospitalName;
	// String isMedicalInsurance;
	// 医院等级
	private String hospitalGrade;
	// 医院类型
	private String hospitalNature;
	//科室名称
	private String officesName;
	
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
	//医生姓名
	private String doctorName;
	//医生行政职位
	private String doctorAdministrative;
	//医生职称
	private String doctorTitle;
	//医生学位
	private String doctorDegree;
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
	public String getOfficesName() {
		return officesName;
	}
	public void setOfficesName(String officesName) {
		this.officesName = officesName;
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
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getDoctorAdministrative() {
		return doctorAdministrative;
	}
	public void setDoctorAdministrative(String doctorAdministrative) {
		this.doctorAdministrative = doctorAdministrative;
	}
	public String getDoctorTitle() {
		return doctorTitle;
	}
	public void setDoctorTitle(String doctorTitle) {
		this.doctorTitle = doctorTitle;
	}
	public String getDoctorDegree() {
		return doctorDegree;
	}
	public void setDoctorDegree(String doctorDegree) {
		this.doctorDegree = doctorDegree;
	}
	@Override
	public String toString() {
		return "CommonCondition [hospitalName=" + hospitalName + ", hospitalGrade=" + hospitalGrade
				+ ", hospitalNature=" + hospitalNature + ", officesName=" + officesName + ", province=" + province
				+ ", city=" + city + ", district=" + district + ", doctorName=" + doctorName + ", doctorAdministrative="
				+ doctorAdministrative + ", doctorTitle=" + doctorTitle + ", doctorDegree=" + doctorDegree + "]";
	}
	
	
	
	
	
}
