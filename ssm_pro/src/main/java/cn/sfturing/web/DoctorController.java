package cn.sfturing.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.sfturing.entity.CommonCondition;
import cn.sfturing.entity.Doctor;
import cn.sfturing.entity.Hospital;
import cn.sfturing.service.DoctorService;
import cn.sfturing.service.HospitalService;
import cn.sfturing.utils.PageUtils;

/**
 * 
 * @author sfturing
 *
 * @date 2017年5月31日
 */
@Controller
public class DoctorController {
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private HospitalService hospitalService;
	@Autowired
	private PageUtils pageUtils;

	/**
	 * 医生主界面(推荐医生)
	 * 
	 * @return
	 */
	@RequestMapping(value = "/doctorIndex/{page}")
	public String officeIdex(Model model, @PathVariable("page") int page) {
		// 查询推荐的医院
		List<Hospital> hospitalRe = hospitalService.findHosByRe();
		// 设置页面
		pageUtils.setCurrentPage(page);
		pageUtils.setTotalRecord(doctorService.findDoctorByReNum(hospitalRe));
		int start;
		if (pageUtils.getCurrentPage() == 0) {
			start = 0;
		} else {
			start = pageUtils.getPageRecord() * (pageUtils.getCurrentPage() - 1);
		}
		Map<String, Object> doctorMap = new HashMap<String, Object>();
		doctorMap.put("list", hospitalRe);
		doctorMap.put("start", start);
		doctorMap.put("size", pageUtils.getPageRecord());
		List<Doctor> doctorRe = doctorService.findDoctorByRe(doctorMap);
		model.addAttribute("pages", pageUtils);
		model.addAttribute("doctorRe", doctorRe);
		return "doctor/doctorIndex";
	}

	/**
	 * 医生详情
	 * 
	 * @return
	 */
	@RequestMapping(value = "/doctorInfoShow/{id}", method = RequestMethod.GET)
	public String hosInfoShow(Model model, @PathVariable(value = "id") int id) {
		Doctor doctor = doctorService.findDoctorById(id);
		Hospital hospital = hospitalService.findHosByName(doctor.getHospitalName());
		model.addAttribute("hos", hospital);
		model.addAttribute("doctor", doctor);
		return "doctor/doctorInfoShow";
	}

	/**
	 * 全部医生
	 * 
	 * @return
	 */
	@RequestMapping(value = "/allDoctor/{page}")
	public String orderOffcie(Model model, @PathVariable("page") int page, Doctor doctor) {
		// 将输入条件传回前台
		CommonCondition commonCondition = new CommonCondition();
		commonCondition.setHospitalName(doctor.getHospitalName());
		commonCondition.setOfficesName(doctor.getOfficesName());
		commonCondition.setDoctorName(doctor.getDoctorName());
		commonCondition.setDoctorTitle(doctor.getDoctorTitle());
		commonCondition.setDoctorDegree(doctor.getDoctorDegree());
		commonCondition.setDoctorAdministrative(doctor.getDoctorAdministrative());
		pageUtils.setCurrentPage(page);
		pageUtils.setTotalRecord(doctorService.findDoctorNum(doctor));
		int start;
		if (pageUtils.getCurrentPage() == 0) {
			start = 0;
		} else {
			start = pageUtils.getPageRecord() * (pageUtils.getCurrentPage() - 1);
		}
		List<Doctor> doctorRe = doctorService.findDoctorByCondition(doctor, start, pageUtils.getPageRecord());
		// 查询医生的职位
		List<String> doctorTitle = doctorService.findDoctorTitle();
		List<String> doctorAdministrative = doctorService.findDoctorAdministrative();
		List<String> doctorDegree = doctorService.findDoctorDegree();
		model.addAttribute("pages", pageUtils);
		model.addAttribute("doctorRe", doctorRe);
		// 查询条件
		model.addAttribute("commonCondition", commonCondition);
		// 将查询的医生职称传到前台
		model.addAttribute("doctorTitle", doctorTitle);
		model.addAttribute("doctorAdministrative", doctorAdministrative);
		model.addAttribute("doctorDegree", doctorDegree);
		return "doctor/doctor";
	}

}
