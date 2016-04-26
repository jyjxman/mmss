package com.mmss.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.mmss.pojo.SysCar;
import com.mmss.service.user.CarInfoService;
import com.mmss.utils.EasyUIResult;
import com.mmss.utils.OtherResult;
import com.mmss.vo.CarVo;

@Controller
@RequestMapping("/car")
public class CarInfoController extends BaseController{	
	private static Logger LOGGER = LoggerFactory.getLogger(CarInfoController.class);
	@Autowired
	private CarInfoService carInfoService;
	
	/**
     * 车辆信息页面
     *
     * @return
     */
    @RequestMapping(value = "/manager", method = RequestMethod.GET)
    public String manager() {
        return "/car/car";
    }
    @RequestMapping(value="/dataGrid",method=RequestMethod.POST)
	@ResponseBody
	public EasyUIResult dataGrid(CarVo carVo,Integer page, Integer rows){
		Map<String, Object> map = Maps.newHashMap();
		if (StringUtils.isNoneBlank(carVo.getName())) {
			map.put("name", carVo.getName());
		}
		if (carVo.getCreatedateStart() != null) {
			
			map.put("startTime", carVo.getCreatedateStart());
		}
		if (carVo.getCreatedateEnd() != null) {
			map.put("endTime", carVo.getCreatedateEnd());
		}
		
		PageInfo<SysCar> pageInfo = carInfoService.findDataGrid(map, page , rows);
		return new EasyUIResult(pageInfo.getTotal(), pageInfo.getList());
		
	}

	   @RequestMapping(value = "/addPage", method = RequestMethod.GET)
	    public String addPage() {
	        return "/car/carAdd";
	    }
	   
	

	    /**
	     * 添加物资
	     *
	     * @param organization
	     * @return
	     */
	    @RequestMapping("/add")
	    @ResponseBody
	    public OtherResult add(SysCar car) {
	    	OtherResult result = new OtherResult();
	        try {
	        	car.setCreattime(new Date());
	        	carInfoService.addCar(car);
	            result.setSuccess(true);
	            result.setMsg("添加成功！");
	            return result;
	        } catch (RuntimeException e) {
	            LOGGER.info("添加车辆信息失败：{}", e);
	            result.setMsg(e.getMessage());
	            return result;
	        }
	    }
	    /**
	     * 编辑车辆信息页
	     *
	     * @param request
	     * @param id
	     * @return
	     */
	    @RequestMapping("/editPage")
	    public String editPage(HttpServletRequest request, Long id) {
	        SysCar car = carInfoService.findCarById(id);
	        request.setAttribute("car", car);
	        return "/car/carEdit";
	    }

	    /**
	     * 编辑车辆信息
	     *
	     * @param car
	     * @return
	     */
	    @RequestMapping("/edit")
	    @ResponseBody
	    public OtherResult edit(SysCar car) {
	    	OtherResult result = new OtherResult();
	        try {
	        	carInfoService.updateCar(car);
	            result.setSuccess(true);
	            result.setMsg("编辑成功！");
	            return result;
	        } catch (RuntimeException e) {
	            LOGGER.info("编辑车辆信息失败：{}", e);
	            result.setMsg(e.getMessage());
	            return result;
	        }
	    }

	    /**
	     * 删除车辆信息
	     *
	     * @param id
	     * @return
	     */
	    @RequestMapping("/delete")
	    @ResponseBody
	    public OtherResult delete(Long id) {
	    	OtherResult result = new OtherResult();
	        try {
	        	carInfoService.deleteCarById(id);
	            result.setMsg("删除成功！");
	            result.setSuccess(true);
	            return result;
	        } catch (RuntimeException e) {
	            LOGGER.info("删除车辆信息失败：{}", e);
	            result.setMsg(e.getMessage());
	            return result;
	        }
	    }

}
