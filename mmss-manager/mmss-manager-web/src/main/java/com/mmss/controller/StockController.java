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
import com.mmss.pojo.SysStock;
import com.mmss.service.user.StockService;
import com.mmss.utils.EasyUIResult;
import com.mmss.utils.OtherResult;
import com.mmss.vo.StockVo;

@Controller
@RequestMapping("/stock")
public class StockController extends BaseController {
	private static Logger LOGGER = LoggerFactory.getLogger(StockController.class);
	@Autowired
	private StockService stockService;

	@RequestMapping(value = "/manager", method = RequestMethod.GET)
	public String manager() {
		return "/material/stock";
	}
	@RequestMapping(value = "/addPage", method = RequestMethod.GET)
	public String addPage() {
		return "/material/stockAdd";
	}
	@RequestMapping("/editPage")
	public String editPage(HttpServletRequest request, Long id) {
		SysStock stock = stockService.findStockById(id);
		request.setAttribute("stock", stock);
		return "/material/stockEdit";
	}
	
	@RequestMapping(value="/dataGrid",method=RequestMethod.POST)
	@ResponseBody
	public EasyUIResult dataGrid(StockVo stockVo, Integer page, Integer rows){
		Map<String, Object> map = Maps.newHashMap();
		if (StringUtils.isNoneBlank(stockVo.getMaterialName())) {
			map.put("name", stockVo.getMaterialName());
		}
		if (stockVo.getCreatedateStart() != null) {
			map.put("startTime", stockVo.getCreatedateStart());
		}
		if (stockVo.getCreatedateEnd() != null) {
			map.put("endTime", stockVo.getCreatedateEnd());
		}
		PageInfo<StockVo> pageInfo = stockService.findDataGrid(map, page , rows);
		return new EasyUIResult(pageInfo.getTotal(), pageInfo.getList());
		
	}
    @RequestMapping("/add")
    @ResponseBody
    public OtherResult add(SysStock stock) {
    	OtherResult result = new OtherResult();
        try {
        	stock.setUpdatdate(new Date());
        	stockService.addStock(stock);
            result.setSuccess(true);
            result.setMsg("添加成功！");
            return result;
        } catch (RuntimeException e) {
            LOGGER.info("添加库存失败：{}", e);
            result.setMsg(e.getMessage());
            return result;
        }
    }
    
    @RequestMapping("/edit")
    @ResponseBody
    public OtherResult edit(SysStock stock) {
    	OtherResult result = new OtherResult();
        try {
        	stock.setUpdatdate(new Date());
        	stockService.updateStock(stock);
            result.setSuccess(true);
            result.setMsg("编辑成功！");
            return result;
        } catch (RuntimeException e) {
            LOGGER.info("编辑库存失败：{}", e);
            result.setMsg(e.getMessage());
            return result;
        }
    }
    
    @RequestMapping("/delete")
    @ResponseBody
    public OtherResult delete(Long id) {
    	OtherResult result = new OtherResult();
        try {
        	stockService.deleteStockById(id);
            result.setMsg("删除成功！");
            result.setSuccess(true);
            return result;
        } catch (RuntimeException e) {
            LOGGER.info("删除库存失败：{}", e);
            result.setMsg(e.getMessage());
            return result;
        }
    }
}
