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
import com.mmss.pojo.SysExport;
import com.mmss.pojo.SysStock;
import com.mmss.service.user.ExportService;
import com.mmss.service.user.StockService;
import com.mmss.utils.EasyUIResult;
import com.mmss.utils.OtherResult;
import com.mmss.vo.ExportVo;

@Controller
@RequestMapping("/export")
public class ExportController extends BaseController {
	private static Logger LOGGER = LoggerFactory.getLogger(ExportController.class);

	@Autowired
	private ExportService exportService;
	@Autowired
	private StockService stockService;

	@RequestMapping(value = "/manager", method = RequestMethod.GET)
	public String manager() {
		return "/material/export";
	}

	@RequestMapping(value = "/addPage", method = RequestMethod.GET)
	public String addPage() {
		return "/material/exportAdd";
	}

	@RequestMapping("/editPage")
	public String editPage(HttpServletRequest request, Long id) {
		SysExport port = exportService.findExportById(id);
		request.setAttribute("export", port);
		return "/material/exportEdit";
	}
	

	@RequestMapping(value="/dataGrid",method=RequestMethod.POST)
	@ResponseBody
	public EasyUIResult dataGrid(ExportVo exportVo, Integer page, Integer rows){
		Map<String, Object> map = Maps.newHashMap();
		if (StringUtils.isNoneBlank(exportVo.getMaterialName())) {
			map.put("name", exportVo.getMaterialName());
		}
		if (exportVo.getCreatedateStart() != null) {
			map.put("startTime", exportVo.getCreatedateStart());
		}
		if (exportVo.getCreatedateEnd() != null) {
			map.put("endTime", exportVo.getCreatedateEnd());
		}
		PageInfo<ExportVo> pageInfo = exportService.findDataGrid(map, page , rows);
		return new EasyUIResult(pageInfo.getTotal(), pageInfo.getList());
		
	}
    @RequestMapping("/add")
    @ResponseBody
    public OtherResult add(SysExport export) {
    	OtherResult result = new OtherResult();
    	Map<String, Object> map = new HashMap<>();
        try {
        	export.setExpodate(new Date());
        	exportService.addExport(export);
        	map.put("material", export.getMaterialId());
        	map.put("repository", export.getRepositoryId());
        	SysStock sysStock = stockService.findStockByMidAndRid(map);
        	if (sysStock !=null) {
        		SysStock sysStock2 = new SysStock();
        		sysStock2.setId(sysStock.getId());
            	sysStock2.setStocknum(sysStock.getStocknum()-export.getExponum());
            	stockService.updateStock(sysStock2);
			}
            result.setSuccess(true);
            result.setMsg("添加成功！");
            return result;
        } catch (RuntimeException e) {
            LOGGER.info("添加出库信息失败：{}", e);
            result.setMsg(e.getMessage());
            return result;
        }
    }
    
    @RequestMapping("/edit")
    @ResponseBody
    public OtherResult edit(SysExport export) {
    	OtherResult result = new OtherResult();
    	Map<String, Object> map = new HashMap<>();
        try {
        	exportService.updateExport(export);
        	map.put("material", export.getMaterialId());
        	map.put("repository", export.getRepositoryId());
        	SysStock sysStock = stockService.findStockByMidAndRid(map);
        	if (sysStock !=null) {
        		SysStock sysStock2 = new SysStock();
        		sysStock2.setId(sysStock.getId());
            	sysStock2.setStocknum(sysStock.getStocknum()-export.getExponum());
            	stockService.updateStock(sysStock2);
			}
            result.setSuccess(true);
            result.setMsg("编辑成功！");
            return result;
        } catch (RuntimeException e) {
            LOGGER.info("编辑出库信息失败：{}", e);
            result.setMsg(e.getMessage());
            return result;
        }
    }
    
    @RequestMapping("/delete")
    @ResponseBody
    public OtherResult delete(Long id) {
    	OtherResult result = new OtherResult();
        try {
        	exportService.deleteExportById(id);
            result.setMsg("删除成功！");
            result.setSuccess(true);
            return result;
        } catch (RuntimeException e) {
            LOGGER.info("删除出库信息失败：{}", e);
            result.setMsg(e.getMessage());
            return result;
        }
    }
}
