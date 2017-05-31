package cn.sfturing.entity;
/**
 * 
 * @author sfturing
 *
 * @date 2017年5月23日
 */
public class Office {
	//科室id
	private int id;
	//科室姓名
	private String officesName;
	//医院名称
	private String hospitalName;
	//医生数量
	private String doctorNum;
	//科室荣誉
	private String officesHonor;
	//科室设备
	private String officesEquipment; 
	//科室简介
	private String officesAbout;
	//科室诊疗范围
	private String officesDiagnosisScope;
	@Override
	public String toString() {
		return "Office [id=" + id + ", officesName=" + officesName + ", hospitalName=" + hospitalName + ", doctorNum="
				+ doctorNum + ", officesHonor=" + officesHonor + ", officesEquipment=" + officesEquipment
				+ ", officesAbout=" + officesAbout + ", officesDiagnosisScope=" + officesDiagnosisScope + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOfficesName() {
		return officesName;
	}
	public void setOfficesName(String officesName) {
		this.officesName = officesName;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getDoctorNum() {
		return doctorNum;
	}
	public void setDoctorNum(String doctorNum) {
		this.doctorNum = doctorNum;
	}
	public String getOfficesHonor() {
		return officesHonor;
	}
	public void setOfficesHonor(String officesHonor) {
		this.officesHonor = officesHonor;
	}
	public String getOfficesEquipment() {
		return officesEquipment;
	}
	public void setOfficesEquipment(String officesEquipment) {
		this.officesEquipment = officesEquipment;
	}
	public String getOfficesAbout() {
		return officesAbout;
	}
	public void setOfficesAbout(String officesAbout) {
		this.officesAbout = officesAbout;
	}
	public String getOfficesDiagnosisScope() {
		return officesDiagnosisScope;
	}
	public void setOfficesDiagnosisScope(String officesDiagnosisScope) {
		this.officesDiagnosisScope = officesDiagnosisScope;
	}
	
	
	

}
