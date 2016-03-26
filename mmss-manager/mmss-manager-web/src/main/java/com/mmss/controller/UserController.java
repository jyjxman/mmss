package com.mmss.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mmss.pojo.ActiveUser;
import com.mmss.pojo.SysPermission;
import com.mmss.pojo.SysUser;
import com.mmss.pojo.SysUserQueryModel;
import com.mmss.service.user.UserService;
import com.mmss.utils.ResourceTree;
import com.mmss.utils.Result;
import com.mmss.utils.Tree;

@Controller
public class UserController extends BaseController {
	@Resource
	UserService userService;

	@RequestMapping("userController/manager")
	public String manager() {
		return "admin/user";
	}

	@RequestMapping("userController/getMenus")
	@ResponseBody
	public Result getMenus() {
		// 从shiro的session中取activeUser
		Subject subject = SecurityUtils.getSubject();
		// 取身份信息
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Result result = new Result();
		List<SysPermission> menus = activeUser.getMenus();
		List<ResourceTree> list = new ArrayList<>();
	
		List<SysPermission> subMenus = activeUser.getSubmenus();
		for (SysPermission sysPermission : menus) {
			ResourceTree resourceTree = new ResourceTree();
			Tree tree = null;
			resourceTree.setIcon(sysPermission.getIcon());
			resourceTree.setId(Long.toString(sysPermission.getId()));
			resourceTree.setUrl(sysPermission.getUrl());
			resourceTree.setText(sysPermission.getName());
			List<Tree> trees = new ArrayList<>();
			for (SysPermission sysSubmenus : subMenus) {
				tree = new Tree();
				if (sysPermission.getId().equals(sysSubmenus.getParentid())) {
					
					tree.setIcon(sysSubmenus.getIcon());
					tree.setId(Long.toString(sysSubmenus.getId()));
					tree.setText(sysSubmenus.getName());
					tree.setUrl(sysSubmenus.getUrl());
					trees.add(tree);
					resourceTree.setMenus(trees);
				}
				
			}
			
			list.add(resourceTree);
		
		}
		result.setData(list);

		return result;
	}

	@RequestMapping("list")
	public String list() {
		SysUserQueryModel sysUserQueryModel = new SysUserQueryModel();
		sysUserQueryModel.getPage().setNowPage(0);
		sysUserQueryModel.getPage().setPageShow(2);
		List<SysUser> list = userService.getByConditionPage(sysUserQueryModel);
		sysUserQueryModel.getPage().setRows(list);
		System.out.println(list);
		System.out.println(sysUserQueryModel.getPage().getTotalCount());
		System.out.println(sysUserQueryModel.getPage().getNowPage());
		System.out.println(sysUserQueryModel.getPage().getStart());
		System.out.println(sysUserQueryModel.getPage().getTotalPage());

		System.out.println(sysUserQueryModel.getPage().getRows());
		return "/index";
	}
}
