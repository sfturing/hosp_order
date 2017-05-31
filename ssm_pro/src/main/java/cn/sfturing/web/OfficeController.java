package cn.sfturing.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.sfturing.entity.CommonCondition;
import cn.sfturing.entity.Doctor;
import cn.sfturing.entity.Hospital;
import cn.sfturing.entity.Office;
import cn.sfturing.service.DoctorService;
import cn.sfturing.service.HospitalService;
import cn.sfturing.service.OfficeService;
import cn.sfturing.utils.PageUtils;

@Controller
public class OfficeController {
	@Autowired
	private HospitalService hospitalService;
	@Autowired
	private OfficeService officeService;
	@Autowired
	private PageUtils pageUtils;
	@Autowired
	private DoctorService doctorService;

	/**
	 * 科室主界面(推荐科室)
	 * 
	 * @return
	 */
	@RequestMapping(value = "/officeIndex/{page}")
	public String officeIdex(Model model, @PathVariable("page") int page) {
		// 查询推荐的医院
		List<Hospital> hospitalRe = hospitalService.findHosByRe();
		// 设置页面
		pageUtils.setCurrentPage(page);
		pageUtils.setTotalRecord(officeService.findOfficeByReNum(hospitalRe));
		int start;
		if (pageUtils.getCurrentPage() == 0) {
			start = 0;
		} else {
			start = pageUtils.getPageRecord() * (pageUtils.getCurrentPage() - 1);
		}
		Map<String, Object> officeMap = new HashMap<String, Object>();
		officeMap.put("list", hospitalRe);
		officeMap.put("start", start);
		officeMap.put("size", 20);
		List<Office> officeRe = officeService.findOfficeByRe(officeMap);
		model.addAttribute("pages", pageUtils);
		model.addAttribute("officeRe", officeRe);
		return "office/officeIndex";
	}

	/**
	 * 科室详情
	 * 
	 * @return
	 */
	@RequestMapping(value = "/officeInfoShow/{id}", method = RequestMethod.GET)
	public String hosInfoShow(Model model, @PathVariable(value = "id") int id) {
		Office office = officeService.findOfficeById(id);
		Hospital hospital = hospitalService.findHosByName(office.getHospitalName());
		List<Doctor> doctor = doctorService.findAreaByHosAndOfficeName(office.getHospitalName(),
				office.getOfficesName());
		model.addAttribute("office", office);
		model.addAttribute("hos", hospital);
		model.addAttribute("doctor", doctor);
		return "office/officeInfoShow";
	}

	/**
	 * 全部科室
	 * 
	 * @return
	 */
	@RequestMapping(value = "/orderOffice/{page}")
	public String orderOffcie(Model model, @PathVariable("page") int page, @ModelAttribute("province") String province,
			@ModelAttribute("city") String city, @ModelAttribute("district") String district, Office office) {
		// 将输入条件传回前台
		CommonCondition commonCondition = new CommonCondition();
		commonCondition.setHospitalName(office.getHospitalName());
		commonCondition.setOfficesName(office.getOfficesName());
		// 设置页面
		pageUtils.setCurrentPage(page);
		pageUtils.setTotalRecord(officeService.findOrderOfficeNum(office));
		int start;
		if (pageUtils.getCurrentPage() == 0) {
			start = 0;
		} else {
			start = pageUtils.getPageRecord() * (pageUtils.getCurrentPage() - 1);
		}
		List<Office> officeRe = officeService.findOfficeByConditon(office, start, 20);
		model.addAttribute("pages", pageUtils);
		model.addAttribute("officeRe", officeRe);
		// 查询条件
		model.addAttribute("commonCondition", commonCondition);
		return "office/orderOffice";
	}

}
