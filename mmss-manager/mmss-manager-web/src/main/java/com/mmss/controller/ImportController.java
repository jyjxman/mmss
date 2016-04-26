package com.mmss.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mmss.pojo.SysImport;
import com.mmss.service.user.ImportService;

@Controller
@RequestMapping("/import")
public class ImportController extends BaseController {

	@Autowired
	private ImportService importService;

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
        request.setAttribute("import", port);
        return "/material/importEdit";
    }
}
