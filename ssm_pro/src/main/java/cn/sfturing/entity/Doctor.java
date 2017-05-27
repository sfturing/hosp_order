package cn.sfturing.entity;

public class Doctor {

	// id
	private int id;
	// 医生姓名
	private String docotorame;
	// 医生性别
	private String doctorex;
	// 医院名称
	private String hospitalame;
	// 科室名称
	private String officesame;
	// 医生照片
	private String doctormg;
	// 医生职称
	private String doctoritle;
	// 教学支职称
	private String teachitle;
	// 行政职位
	private String doctordministrative;
	// 学位
	private String doctoregree;
	// 医生特长
	private String doctor_forte;
	// 医生关于
	private String doctorAbout;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDocotorame() {
		return docotorame;
	}

	public void setDocotorame(String docotorame) {
		this.docotorame = docotorame;
	}

	public String getDoctorex() {
		return doctorex;
	}

	public void setDoctorex(String doctorex) {
		this.doctorex = doctorex;
	}

	public String getHospitalame() {
		return hospitalame;
	}

	public void setHospitalame(String hospitalame) {
		this.hospitalame = hospitalame;
	}

	public String getOfficesame() {
		return officesame;
	}

	public void setOfficesame(String officesame) {
		this.officesame = officesame;
	}

	public String getDoctormg() {
		return doctormg;
	}

	public void setDoctormg(String doctormg) {
		this.doctormg = doctormg;
	}

	public String getDoctoritle() {
		return doctoritle;
	}

	public void setDoctoritle(String doctoritle) {
		this.doctoritle = doctoritle;
	}

	public String getTeachitle() {
		return teachitle;
	}

	public void setTeachitle(String teachitle) {
		this.teachitle = teachitle;
	}

	public String getDoctordministrative() {
		return doctordministrative;
	}

	public void setDoctordministrative(String doctordministrative) {
		this.doctordministrative = doctordministrative;
	}

	public String getDoctoregree() {
		return doctoregree;
	}

	public void setDoctoregree(String doctoregree) {
		this.doctoregree = doctoregree;
	}

	public String getDoctor_forte() {
		return doctor_forte;
	}

	public void setDoctor_forte(String doctor_forte) {
		this.doctor_forte = doctor_forte;
	}

	public String getDoctorAbout() {
		return doctorAbout;
	}

	public void setDoctorAbout(String doctorAbout) {
		this.doctorAbout = doctorAbout;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", docotorame=" + docotorame + ", doctorex=" + doctorex + ", hospitalame="
				+ hospitalame + ", officesame=" + officesame + ", doctormg=" + doctormg + ", doctoritle=" + doctoritle
				+ ", teachitle=" + teachitle + ", doctordministrative=" + doctordministrative + ", doctoregree="
				+ doctoregree + ", doctor_forte=" + doctor_forte + ", doctorAbout=" + doctorAbout + "]";
	}

}
