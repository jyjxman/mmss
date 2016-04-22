package com.mmss.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Maps;
import com.mmss.pojo.SysRole;
import com.mmss.service.user.RoleService;
import com.mmss.utils.DTree;
import com.mmss.utils.OtherResult;
import com.mmss.utils.PageInfo;

@Controller
@RequestMapping("/role")
public class RoleController extends BaseController{
	private static Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleService roleService;
    
    
    /**
     * 权限管理页
     *
     * @return
     */
    @RequestMapping(value = "/manager", method = RequestMethod.GET)
    public String manager() {
        return "/admin/role";
    }
    
    @RequestMapping(value = "/dataGrid", method = RequestMethod.POST)
    @ResponseBody
    public PageInfo dataGrid(SysRole role, Integer page, Integer rows, String sort, String order) {
        PageInfo pageInfo = new PageInfo(page, rows);
        Map<String, Object> condition = Maps.newHashMap();
        pageInfo.setCondition(condition);

        roleService.findDataGrid(pageInfo);
        return pageInfo;
    }
    
    /**
     * 权限树
     *
     * @return
     */
    @RequestMapping(value = "/tree", method = RequestMethod.POST)
    @ResponseBody
    public List<DTree> tree() {
        return roleService.findTree();
    }
    /**
     * 添加权限页
     *
     * @return
     */
    @RequestMapping(value = "/addPage", method = RequestMethod.GET)
    public String addPage() {
        return "/admin/roleAdd";
    }

    /**
     * 添加权限
     *
     * @param role
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public OtherResult add(SysRole role) {
    	OtherResult result = new OtherResult();
        try {
            roleService.addRole(role);
            result.setSuccess(true);
            result.setMsg("添加成功！");
            return result;
        } catch (RuntimeException e) {
            logger.error("添加角色失败：{}", e);
            result.setMsg(e.getMessage());
            return result;
        }
    }
    /**
     * 编辑权限页
     *
     * @param request
     * @param id
     * @return
     */
    @RequestMapping("/editPage")
    public String editPage(HttpServletRequest request, String id) {
        SysRole role = roleService.findRoleById(id);
        request.setAttribute("role", role);
        return "/admin/roleEdit";
    }

    /**
     * 编辑权限
     *
     * @param role
     * @return
     */
    @RequestMapping("/edit")
    @ResponseBody
    public OtherResult edit(SysRole role) {
    	OtherResult result = new OtherResult();
        try {
            roleService.updateRole(role);
            result.setSuccess(true);
            result.setMsg("编辑成功！");
            return result;
        } catch (RuntimeException e) {
            logger.error("编辑角色失败：{}", e);
            result.setMsg(e.getMessage());
            return result;
        }
    }
    /**
     * 删除权限
     *
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public OtherResult delete(String id) {
    	OtherResult result = new OtherResult();
        try {
            roleService.deleteRoleById(id);
            result.setMsg("删除成功！");
            result.setSuccess(true);
            return result;
        } catch (RuntimeException e) {
            logger.error("删除角色失败：{}", e);
            result.setMsg(e.getMessage());
            return result;
        }
    }
    /**
     * 授权页面
     *
     * @param request
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/grantPage")
    public String grantPage(HttpServletRequest request, String id, Model model) {
        model.addAttribute("id", id);
        return "/admin/roleGrant";
    }

    /**
     * 授权页面页面根据角色查询资源
     *
     * @param request
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/findResourceIdListByRoleId")
    @ResponseBody
    public OtherResult findResourceByRoleId(HttpServletRequest request, String id, Model model) {
        OtherResult result = new OtherResult();
        try {
            List<String> resources = roleService.findResourceIdListByRoleId(id);
            result.setSuccess(true);
            result.setObj(resources);
            return result;
        } catch (RuntimeException e) {
            logger.error("角色查询资源失败：{}", e);
            result.setMsg(e.getMessage());
            return result;
        }
    }

    /**
     * 授权
     *
     * @param id
     * @param resourceIds
     * @return
     */
    @RequestMapping("/grant")
    @ResponseBody
    public OtherResult grant(String id, String resourceIds) {
    	OtherResult result = new OtherResult();
        try {
            roleService.updateRoleResource(id, resourceIds);
            result.setMsg("授权成功！");
            result.setSuccess(true);
            return result;
        } catch (RuntimeException e) {
            logger.error("授权成功失败：{}", e);
            result.setMsg(e.getMessage());
            return result;
        }
    }
   
    
}
