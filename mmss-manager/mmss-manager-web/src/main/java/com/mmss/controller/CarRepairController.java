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
import com.mmss.pojo.SysCarRepair;
import com.mmss.service.user.CarInfoService;
import com.mmss.service.user.CarRepairService;
import com.mmss.utils.EasyUIResult;
import com.mmss.utils.OtherResult;
import com.mmss.vo.CarRepairVo;

@Controller
@RequestMapping("carrepair")
public class CarRepairController extends BaseController{
	
	private static Logger LOGGER = LoggerFactory.getLogger(CarRepairController.class);
     @Autowired
     private CarRepairService carRepairService;
     @Autowired
     private CarInfoService carInfoService;
     
     @RequestMapping(value="/manager", method=RequestMethod.GET)
 	public String manager(){
 		
 		return "/car/carrepair";
 	}
 	@RequestMapping(value="/dataGrid",method=RequestMethod.POST)
 	@ResponseBody
 	public EasyUIResult dataGrid(CarRepairVo carrepair, Integer page, Integer rows){
 		Map<String, Object> map = Maps.newHashMap();
 		
 		if (carrepair.getCarid() != null) {
			map.put("carid", carrepair.getCarid());
		}
 		if (carrepair.getCreatedateStart() != null) {
			map.put("startTime", carrepair.getCreatedateStart());
		}
 		if (carrepair.getCreatedateEnd() != null) {
			map.put("endTime", carrepair.getCreatedateEnd());
		}
 		PageInfo<CarRepairVo> pageInfo = carRepairService.findDataGrid(map, page , rows);
 		return new EasyUIResult(pageInfo.getTotal(), pageInfo.getList());
 		
 	}
 	
 	
 	   @RequestMapping(value = "/addPage", method = RequestMethod.GET)
 	    public String addPage() {
 	        return "/car/carrepairAdd";
 	    }
 	   
 	

 	    /**
 	     * 添加车辆修理
 	     *
 	     * @param carRepair
 	     * @return
 	     */
 	    @RequestMapping("/add")
 	    @ResponseBody
 	    public OtherResult add(SysCarRepair carRepair) {
 	    	OtherResult result = new OtherResult();
 	    	SysCar car = new SysCar();
 	        try {
 	        	carRepairService.addCarRepair(carRepair);
 	        	car.setStatus("1");
 	        	car.setState("0");
 	        	car.setId(carRepair.getCarid());
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
 	     * 编辑车辆修理页
 	     *
 	     * @param request
 	     * @param id
 	     * @return
 	     */
 	    @RequestMapping("/editPage")
 	    public String editPage(HttpServletRequest request, Long id) {
        SysCarRepair carrepair = carRepairService.findCarRepairById(id);
 	        request.setAttribute("carrepair", carrepair);
 	        return "/car/carrepairEdit";
 	    }

 	    /**
 	     * 编辑车辆修理
 	     *
 	     * @param carrepair
 	     * @return
 	     */
 	    @RequestMapping("/edit")
 	    @ResponseBody
 	    public OtherResult edit(SysCarRepair carRepair) {
 	    	OtherResult result = new OtherResult();
 	        try {
 	        	carRepairService.updateCarRepair(carRepair);
 	            result.setSuccess(true);
 	            result.setMsg("编辑成功！");
 	            return result;
 	        } catch (RuntimeException e) {
 	            LOGGER.info("编辑车辆修理失败：{}", e);
 	            result.setMsg(e.getMessage());
 	            return result;
 	        }
 	    }

 	    /**
 	     * 删除车辆修理
 	     *
 	     * @param id
 	     * @return
 	     */
 	    @RequestMapping("/delete")
 	    @ResponseBody
 	    public OtherResult delete(Long id) {
 	    	OtherResult result = new OtherResult();
 	        try {
 	        	carRepairService.deleteCarRepairById(id);
 	            result.setMsg("删除成功！");
 	            result.setSuccess(true);
 	            return result;
 	        } catch (RuntimeException e) {
 	            LOGGER.info("删除车辆修理失败：{}", e);
 	            result.setMsg(e.getMessage());
 	            return result;
 	        }
 	    }

}
