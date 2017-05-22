package cn.sfturing.web;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.sfturing.entity.Hospital;
import cn.sfturing.service.HospitalService;

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
	@RequestMapping(value = "/hosInfoShow", method = RequestMethod.GET)
	public String hosInfoShow(Model model) {
		
		return "hospital/hosInfoShow";
	}

}
