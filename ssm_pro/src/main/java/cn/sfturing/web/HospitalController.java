package cn.sfturing.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public String orderHos(Model model, @PathVariable("page") int page, @ModelAttribute("province") String province,
			@ModelAttribute("city") String city, @ModelAttribute("district") String district, Hospital hosp) {
		System.out.println(province+city+district+province.equals("")+city.equals("")+district.equals(""));
//		System.out.println(hosp.getHospitalNature()+hosp.getHospitalNature().equals("")+hosp.getHospitalGrade()+hosp.getHospitalGrade().equals("")+"%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		/*if(hosp.getHospitalNature().equals("默认")){
			hosp.setHospitalNature(null);
		}if(hosp.getHospitalGrade().equals("默认")){
			hosp.setHospitalGrade(null);
		}*/
		// 设置页面
		pageUtils.setCurrentPage(page);
		pageUtils.setTotalRecord(hospitalService.findOrderHosNum());
		int start;
		if (pageUtils.getCurrentPage() == 0) {
			start = 0;
		} else {
			start = pageUtils.getPageRecord() * (pageUtils.getCurrentPage() - 1);
		}
		// 查询医院数据
		List<Hospital> hospital = hospitalService.findHosByConditon(province,city,district,hosp,start, pageUtils.getPageRecord());
		// 查询医院等级
		List<String> hospGrade = hospitalService.findHosOpenGrade();
		// 查询医院类型
		List<String> hospNature = hospitalService.findHosOpenNature();
		model.addAttribute("hospital", hospital);
		model.addAttribute("pages", pageUtils);
		model.addAttribute("hospGrade", hospGrade);
		model.addAttribute("hospNature", hospNature);
		return "hospital/orderHos";
	}

}
