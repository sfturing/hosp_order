package cn.sfturing.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.sfturing.dao.HospitalDao;
import cn.sfturing.entity.Hospital;
import cn.sfturing.entity.Office;
import cn.sfturing.service.HospitalService;
import cn.sfturing.service.OfficeService;
import cn.sfturing.utils.PageUtils;

/**
 * 
 * @author sfturing
 * 
 * @date 2017年5月19日
 */
@Controller
public class HospitalController {

	@Autowired
	private HospitalService hospitalService;
	@Autowired
	private HospitalDao hospitalDao;
	@Autowired
	private OfficeService officeService;
	@Autowired
	private PageUtils pageUtils;

	/**
	 * 医院主界面(推荐医院)
	 * 
	 * @return
	 */
	@RequestMapping(value = "/hosIndex", method = RequestMethod.GET)
	public String hosIdex(Model model) {
		List<Hospital> hospitalRe = hospitalService.findHosByRe();
		model.addAttribute("hospital", hospitalRe);
		return "hospital/hosIndex";
	}

	/**
	 * 医院详情
	 * 
	 * @return
	 */
	@RequestMapping(value = "/hosInfoShow/{id}", method = RequestMethod.GET)
	public String hosInfoShow(Model model, @PathVariable(value = "id") int id) {
		// 通过传入的id返回医院的详细信息
		Hospital hospital = hospitalService.findHosById(id);
		String a;
		// 通过医院的名称返回医院科室信息
		List<Office> office = officeService.findOfficeByHosName(hospital.getHospitalName());
		// 预留通知查询
		//
		model.addAttribute("hos", hospital);
		model.addAttribute("office", office);
		return "hospital/hosInfoShow";
	}

	/**
	 * 全部支持预约的医院
	 * 
	 * @return
	 */
	@RequestMapping(value = "/orderHos/{page}", method = RequestMethod.GET)
	public String orderHos(Model model, @PathVariable("page") int page) {
		pageUtils.setCurrentPage(page);
		System.out.println(hospitalService.findOrderHosNum());
		pageUtils.setTotalRecord(hospitalService.findOrderHosNum());
		int start;
		if (pageUtils.getCurrentPage() == 0) {
			start = 0;
		} else {
			start = pageUtils.getPageRecord() * (pageUtils.getCurrentPage() - 1);
		}
		List<Hospital> hospital = hospitalService.findfindOrderHos(start, pageUtils.getPageRecord());
		model.addAttribute("hospital", hospital);
		model.addAttribute("pages", pageUtils);
		System.out.println(pageUtils.getCurrentPage());
		return "hospital/orderHos";
	}

}
