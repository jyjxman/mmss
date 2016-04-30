package com.mmss.controller;

import java.util.Date;
import java.util.HashMap;
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
import com.mmss.pojo.SysImport;
import com.mmss.pojo.SysStock;
import com.mmss.service.user.ImportService;
import com.mmss.service.user.StockService;
import com.mmss.utils.EasyUIResult;
import com.mmss.utils.OtherResult;
import com.mmss.vo.ImportVo;

@Controller
@RequestMapping("/import")
public class ImportController extends BaseController {
	private static Logger LOGGER = LoggerFactory.getLogger(ImportController.class);

	@Autowired
	private ImportService importService;
	
	@Autowired
	private StockService stockService;

	@RequestMapping(value = "/manager", method = RequestMethod.GET)
	public String manager() {
		return "/material/import";
	}

	@RequestMapping(value = "/addPage", method = RequestMethod.GET)
	public String addPage() {
		return "/material/importAdd";
	}
    @RequestMapping("/editPage")
    public String editPage(HttpServletRequest request, Long id) {
        SysImport port = importService.findImportById(id);
        request.setAttribute("port", port);
        return "/material/importEdit";
    }
    

	@RequestMapping(value="/dataGrid",method=RequestMethod.POST)
	@ResponseBody
	public EasyUIResult dataGrid(ImportVo importVo, Integer page, Integer rows){
		Map<String, Object> map = Maps.newHashMap();
		if (StringUtils.isNoneBlank(importVo.getMaterialName())) {
			map.put("name", importVo.getMaterialName());
		}
		if (importVo.getCreatedateStart() != null) {
			map.put("startTime", importVo.getCreatedateStart());
		}
		if (importVo.getCreatedateEnd() != null) {
			map.put("endTime", importVo.getCreatedateEnd());
		}
		PageInfo<ImportVo> pageInfo = importService.findDataGrid(map, page , rows);
		return new EasyUIResult(pageInfo.getTotal(), pageInfo.getList());
		
	}
    @RequestMapping("/add")
    @ResponseBody
    public OtherResult add(SysImport imp) {
    	OtherResult result = new OtherResult();
    	Map<String, Object> map = new HashMap<>();
        try {
        	imp.setImpodate(new Date());
        	importService.addImport(imp);
        	map.put("material", imp.getMaterialId());
        	map.put("repository", imp.getRepositoryId());
        	SysStock sysStock = stockService.findStockByMidAndRid(map);
        	if (sysStock !=null) {
        		SysStock sysStock2 = new SysStock();
        		sysStock2.setId(sysStock.getId());
            	sysStock2.setStocknum(sysStock.getStocknum()+imp.getImponum());
            	stockService.updateStock(sysStock2);
			}
            result.setSuccess(true);
            result.setMsg("添加成功！");
            return result;
        } catch (RuntimeException e) {
            LOGGER.info("添加入库信息失败：{}", e);
            result.setMsg(e.getMessage());
            return result;
        }
    }
    
    @RequestMapping("/edit")
    @ResponseBody
    public OtherResult edit(SysImport imp) {
    	OtherResult result = new OtherResult();
    	Map<String, Object> map = new HashMap<>();
        try {
        	importService.updateImport(imp);	
        	map.put("material", imp.getMaterialId());
        	map.put("repository", imp.getRepositoryId());
        	SysStock sysStock = stockService.findStockByMidAndRid(map);
        	if (sysStock !=null) {
        		SysStock sysStock2 = new SysStock();
        		sysStock2.setId(sysStock.getId());
            	sysStock2.setStocknum(sysStock.getStocknum()+imp.getImponum());
            	stockService.updateStock(sysStock2);
			}
            result.setSuccess(true);
            result.setMsg("编辑成功！");
            return result;
        } catch (RuntimeException e) {
            LOGGER.info("编辑入库信息失败：{}", e);
            result.setMsg(e.getMessage());
            return result;
        }
    }
    
    @RequestMapping("/delete")
    @ResponseBody
    public OtherResult delete(Long id) {
    	OtherResult result = new OtherResult();
        try {
        	importService.deleteImportById(id);
            result.setMsg("删除成功！");
            result.setSuccess(true);
            return result;
        } catch (RuntimeException e) {
            LOGGER.info("删除入库信息失败：{}", e);
            result.setMsg(e.getMessage());
            return result;
        }
    }
}
