package com.mmss.controller;

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
import com.mmss.pojo.SysMaterial;
import com.mmss.service.user.MaterialService;
import com.mmss.utils.EasyUIResult;
import com.mmss.utils.OtherResult;

@Controller
@RequestMapping("/material")
public class MaterialController extends BaseController{
	private static Logger LOGGER = LoggerFactory.getLogger(MaterialController.class);
	@Autowired
	private MaterialService materialService;
	
	@RequestMapping(value="/manager", method=RequestMethod.GET)
	public String manager(){
		
		return "material/material";
	}
	@RequestMapping(value="/dataGrid",method=RequestMethod.POST)
	@ResponseBody
	public EasyUIResult dataGrid(SysMaterial material, Integer page, Integer rows){
		Map<String, Object> map = Maps.newHashMap();
		if (StringUtils.isNoneBlank(material.getMaterialName())) {
			map.put("name", material.getMaterialName());
		}
		
		PageInfo<SysMaterial> pageInfo = materialService.findDataGrid(map, page , rows);
		return new EasyUIResult(pageInfo.getTotal(), pageInfo.getList());
		
	}
	
	
	   @RequestMapping(value = "/addPage", method = RequestMethod.GET)
	    public String addPage() {
	        return "/material/materialAdd";
	    }
	   
	

	    /**
	     * 添加物资
	     *
	     * @param organization
	     * @return
	     */
	    @RequestMapping("/add")
	    @ResponseBody
	    public OtherResult add(SysMaterial material) {
	    	OtherResult result = new OtherResult();
	        try {
	        	materialService.addMaterial(material);
	            result.setSuccess(true);
	            result.setMsg("添加成功！");
	            return result;
	        } catch (RuntimeException e) {
	            LOGGER.info("添加物资失败：{}", e);
	            result.setMsg(e.getMessage());
	            return result;
	        }
	    }
	    /**
	     * 编辑物资页
	     *
	     * @param request
	     * @param id
	     * @return
	     */
	    @RequestMapping("/editPage")
	    public String editPage(HttpServletRequest request, Long id) {
	        SysMaterial material = materialService.findMaterialById(id);
	        request.setAttribute("material", material);
	        return "/material/materialEdit";
	    }

	    /**
	     * 编辑物资
	     *
	     * @param material
	     * @return
	     */
	    @RequestMapping("/edit")
	    @ResponseBody
	    public OtherResult edit(SysMaterial material) {
	    	OtherResult result = new OtherResult();
	        try {
	        	materialService.updateMaterial(material);
	            result.setSuccess(true);
	            result.setMsg("编辑成功！");
	            return result;
	        } catch (RuntimeException e) {
	            LOGGER.info("编辑物资失败：{}", e);
	            result.setMsg(e.getMessage());
	            return result;
	        }
	    }

	    /**
	     * 删除仓库
	     *
	     * @param id
	     * @return
	     */
	    @RequestMapping("/delete")
	    @ResponseBody
	    public OtherResult delete(Long id) {
	    	OtherResult result = new OtherResult();
	        try {
	        	materialService.deleteMaterialById(id);
	            result.setMsg("删除成功！");
	            result.setSuccess(true);
	            return result;
	        } catch (RuntimeException e) {
	            LOGGER.info("删除部门失败：{}", e);
	            result.setMsg(e.getMessage());
	            return result;
	        }
	    }

}
