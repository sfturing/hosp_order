package cn.sfturing.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sfturing.entity.Area;
import cn.sfturing.service.AreaService;

@Controller
public class AreaController {
	@Autowired
	private AreaService areaAervice;
	/**
	 * 查询2级城市
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/findAreaByLevel2", method = RequestMethod.POST)
	public Map<String, Object> findAreaByLevel2(String areaName) {
		List<Area> area = areaAervice.findAreaByLevel(areaName);
		System.out.println(area);
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		rtnMap.put("area", area);
		return rtnMap;
	}
	
	/**
	 * 查询3级城市
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/findAreaByLevel3", method = RequestMethod.POST)
	public Map<String, Object> findAreaByLevel3(String areaName,String cityName) {
		List<Area> district = areaAervice.findAreaByLevel(areaName,cityName);
		System.out.println(district);
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		rtnMap.put("district", district);
		return rtnMap;
	}

}
