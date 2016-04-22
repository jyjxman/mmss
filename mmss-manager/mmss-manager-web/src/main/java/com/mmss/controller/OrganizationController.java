package com.mmss.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mmss.pojo.SysDept;
import com.mmss.service.user.OrganizationService;
import com.mmss.utils.DTree;
import com.mmss.utils.OtherResult;

@Controller
@RequestMapping("/organization")
public class OrganizationController {
	
	private static Logger LOGGER = LoggerFactory.getLogger(OrganizationController.class);

	@Resource
	private OrganizationService organizationService;
	
	/**
     * 部门管理主页
     *
     * @return
     */
    @RequestMapping("/manager")
    public String manager() {
        return "/admin/organization";
    }
	
	 /**
     * 部门资源树
     *
     * @return
     */
    @RequestMapping(value = "/tree", method = RequestMethod.POST)
    @ResponseBody
    public List<DTree> tree() {
        List<DTree> trees = organizationService.findTree();
        return trees;
    }
    
    /**
     * 部门列表
     *
     * @return
     */
    @RequestMapping("/treeGrid")
    @ResponseBody
    public List<SysDept> treeGrid() {
        List<SysDept> treeGrid = organizationService.findTreeGrid();
        return treeGrid;
    }
    
    /**
     * 添加部门页
     *
     * @return
     */
    @RequestMapping("/addPage")
    public String addPage() {
        return "/admin/organizationAdd";
    }

    /**
     * 添加部门
     *
     * @param organization
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public OtherResult add(SysDept organization) {
    	OtherResult result = new OtherResult();
        try {
        	organization.setCreatetime(new Date());
            organizationService.addOrganization(organization);
            result.setSuccess(true);
            result.setMsg("添加成功！");
            return result;
        } catch (RuntimeException e) {
            LOGGER.info("添加部门失败：{}", e);
            result.setMsg(e.getMessage());
            return result;
        }
    }

    /**
     * 编辑部门页
     *
     * @param request
     * @param id
     * @return
     */
    @RequestMapping("/editPage")
    public String editPage(HttpServletRequest request, Long id) {
        SysDept organization = organizationService.findOrganizationById(id);
        request.setAttribute("organization", organization);
        return "/admin/organizationEdit";
    }

    /**
     * 编辑部门
     *
     * @param organization
     * @return
     */
    @RequestMapping("/edit")
    @ResponseBody
    public OtherResult edit(SysDept organization) {
    	OtherResult result = new OtherResult();
        try {
        	organization.setCreatetime(new Date());
            organizationService.updateOrganization(organization);
            result.setSuccess(true);
            result.setMsg("编辑成功！");
            return result;
        } catch (RuntimeException e) {
            LOGGER.info("编辑部门失败：{}", e);
            result.setMsg(e.getMessage());
            return result;
        }
    }

    /**
     * 删除部门
     *
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public OtherResult delete(Long id) {
    	OtherResult result = new OtherResult();
        try {
            organizationService.deleteOrganizationById(id);
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
