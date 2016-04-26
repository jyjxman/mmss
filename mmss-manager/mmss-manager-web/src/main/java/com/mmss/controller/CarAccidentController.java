package com.mmss.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import com.mmss.pojo.SysCarAccident;
import com.mmss.service.user.CarAccidentService;
import com.mmss.service.user.CarInfoService;
import com.mmss.utils.EasyUIResult;
import com.mmss.utils.OtherResult;
import com.mmss.vo.CarAccidentVo;

@Controller
@RequestMapping("/caraccident")
public class CarAccidentController extends BaseController{
	
	private static Logger LOGGER = LoggerFactory.getLogger(CarAccidentController.class);

	
	@Autowired
	private CarAccidentService carAccidentService;
	
	 @Autowired
     private CarInfoService carInfoService;
     
     @RequestMapping(value="/manager", method=RequestMethod.GET)
 	public String manager(){
 		
 		return "/car/caraccident";
 	}
 	@RequestMapping(value="/dataGrid",method=RequestMethod.POST)
 	@ResponseBody
 	public EasyUIResult dataGrid(CarAccidentVo carAccident, Integer page, Integer rows){
 		Map<String, Object> map = Maps.newHashMap();
 		
 		if (carAccident.getCarid() != null) {
			map.put("carid", carAccident.getCarid());
		}
 		if (carAccident.getCreatedateStart() != null) {
			map.put("startTime", carAccident.getCreatedateStart());
		}
 		if (carAccident.getCreatedateEnd() != null) {
			map.put("endTime", carAccident.getCreatedateEnd());
		}
 		PageInfo<CarAccidentVo> pageInfo = carAccidentService.findDataGrid(map, page , rows);
 		return new EasyUIResult(pageInfo.getTotal(), pageInfo.getList());
 		
 	}
 	
 	
 	   @RequestMapping(value = "/addPage", method = RequestMethod.GET)
 	    public String addPage() {
 	        return "/car/caraccidentAdd";
 	    }
 	   
 	

 	    /**
 	     * 添加车辆修理
 	     *
 	     * @param carRepair
 	     * @return
 	     */
 	    @RequestMapping("/add")
 	    @ResponseBody
 	    public OtherResult add(SysCarAccident carAccident) {
 	    	OtherResult result = new OtherResult();
 	    	SysCar car = new SysCar();
 	        try {
 	        	carAccidentService.addCarAccident(carAccident);
 	        	car.setStatus("1");
 	        	car.setState("0");
 	        	car.setId(carAccident.getCarid());
 	        	carInfoService.updateCarStatusById(car);
 	            result.setSuccess(true);
 	            result.setMsg("添加成功！");
 	            return result;
 	        } catch (RuntimeException e) {
 	            LOGGER.info("添加车辆修理失败：{}", e);
 	            result.setMsg(e.getMessage());
 	            return result;
 	        }
 	    }
 	    /**
 	     * 编辑车辆事故页
 	     *
 	     * @param request
 	     * @param id
 	     * @return
 	     */
 	    @RequestMapping("/editPage")
 	    public String editPage(HttpServletRequest request, Long id) {
 	    	SysCarAccident caraccident = carAccidentService.findCarAccidentById(id);
 	        request.setAttribute("caraccident", caraccident);
 	        return "/car/caraccidentEdit";
 	    }

 	    /**
 	     * 编辑车辆修理
 	     *
 	     * @param carrepair
 	     * @return
 	     */
 	    @RequestMapping("/edit")
 	    @ResponseBody
 	    public OtherResult edit(SysCarAccident carAccident) {
 	    	OtherResult result = new OtherResult();
 	        try {
 	        	carAccidentService.updateCarAccident(carAccident);
 	            result.setSuccess(true);
 	            result.setMsg("编辑成功！");
 	            return result;
 	        } catch (RuntimeException e) {
 	            LOGGER.info("编辑车辆事故失败：{}", e);
 	            result.setMsg(e.getMessage());
 	            return result;
 	        }
 	    }

 	    /**
 	     * 删除车辆事故
 	     *
 	     * @param id
 	     * @return
 	     */
 	    @RequestMapping("/delete")
 	    @ResponseBody
 	    public OtherResult delete(Long id) {
 	    	OtherResult result = new OtherResult();
 	        try {
 	        	carAccidentService.deleteCarAccidentrById(id);
 	            result.setMsg("删除成功！");
 	            result.setSuccess(true);
 	            return result;
 	        } catch (RuntimeException e) {
 	            LOGGER.info("删除车辆事故失败：{}", e);
 	            result.setMsg(e.getMessage());
 	            return result;
 	        }
 	    }
}