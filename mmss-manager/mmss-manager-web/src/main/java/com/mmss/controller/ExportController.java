package com.mmss.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mmss.pojo.SysExport;
import com.mmss.service.user.ExportService;

@Controller
@RequestMapping("/export")
public class ExportController extends BaseController {

	@Autowired
	private ExportService exportService;

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
}
