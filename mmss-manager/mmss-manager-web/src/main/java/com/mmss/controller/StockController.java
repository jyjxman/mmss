package com.mmss.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mmss.pojo.SysStock;
import com.mmss.service.user.StockService;

@Controller
@RequestMapping("/stock")
public class StockController extends BaseController {

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
		return "/material/exportEdit";
	}
}
