package cn.sfturing.entity;

public class Doctor {

	// id
	private int id;
	// 医生姓名
	private String doctorName;
	// 医生性别
	private String doctorSex;
	// 医院名称
	private String hospitalName;
	// 科室名称
	private String officesName;
	// 医生照片
	private String doctorImg;
	// 医生职称
	private String doctorTitle;
	// 教学支职称
	private String teachTitle;
	// 行政职位
	private String doctorAdministrative;
	// 学位
	private String doctorDegree;
	// 医生特长
	private String doctorForte;
	// 医生关于
	private String doctorAbout;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getDoctorSex() {
		return doctorSex;
	}
	public void setDoctorSex(String doctorSex) {
		this.doctorSex = doctorSex;
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
	public String getDoctorImg() {
		return doctorImg;
	}
	public void setDoctorImg(String doctorImg) {
		this.doctorImg = doctorImg;
	}
	public String getDoctorTitle() {
		return doctorTitle;
	}
	public void setDoctorTitle(String doctorTitle) {
		this.doctorTitle = doctorTitle;
	}
	public String getTeachTitle() {
		return teachTitle;
	}
	public void setTeachTitle(String teachTitle) {
		this.teachTitle = teachTitle;
	}
	public String getDoctorAdministrative() {
		return doctorAdministrative;
	}
	public void setDoctorAdministrative(String doctorAdministrative) {
		this.doctorAdministrative = doctorAdministrative;
	}
	public String getDoctorDegree() {
		return doctorDegree;
	}
	public void setDoctorDegree(String doctorDegree) {
		this.doctorDegree = doctorDegree;
	}
	public String getDoctorForte() {
		return doctorForte;
	}
	public void setDoctorForte(String doctorForte) {
		this.doctorForte = doctorForte;
	}
	public String getDoctorAbout() {
		return doctorAbout;
	}
	public void setDoctorAbout(String doctorAbout) {
		this.doctorAbout = doctorAbout;
	}
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", doctorName=" + doctorName + ", doctorSex=" + doctorSex + ", hospitalName="
				+ hospitalName + ", officesName=" + officesName + ", doctorImg=" + doctorImg + ", doctorTitle="
				+ doctorTitle + ", teachTitle=" + teachTitle + ", doctorAdministrative=" + doctorAdministrative
				+ ", doctorDegree=" + doctorDegree + ", doctorForte=" + doctorForte + ", doctorAbout=" + doctorAbout
				+ "]";
	}

}
