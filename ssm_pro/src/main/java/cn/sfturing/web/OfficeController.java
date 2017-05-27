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
	 * 医院主界面(推荐医院)
	 * 
	 * @return
	 */
	@RequestMapping(value = "/officeIndex/{page}")
	public String hosIdex(Model model, @PathVariable("page") int page) {
		//查询推荐的医院
		List<Hospital> hospitalRe = hospitalService.findHosByRe();
		// 设置页面
		pageUtils.setCurrentPage(page);
		pageUtils.setTotalRecord(officeService.findHosByReNum(hospitalRe));
		System.out.println(officeService.findHosByReNum(hospitalRe));
		int start;
		if (pageUtils.getCurrentPage() == 0) {
			start = 0;
		} else {
			start = pageUtils.getPageRecord() * (pageUtils.getCurrentPage() - 1);
		}
		Map<String, Object> officeMap = new HashMap<String, Object>();
		officeMap.put("list", hospitalRe);
		officeMap.put("start", start);
		officeMap.put("size", pageUtils.getPageRecord());
		List<Office> officeRe = officeService.findHosByRe(officeMap);
		model.addAttribute("pages", pageUtils);
		model.addAttribute("hospitalRe", hospitalRe);
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
		Hospital hospital = hospitalService.findHosByName(office.gethospitalName());
		List<Doctor> doctor = doctorService.findAreaByHosAndOfficeName(office.gethospitalName(), office.getOfficesName());
		model.addAttribute("office", office);
		model.addAttribute("hos", hospital);
		return "office/officeInfoShow";
	}

}
