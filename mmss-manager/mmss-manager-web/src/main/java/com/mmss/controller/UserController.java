package com.mmss.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mmss.pojo.ActiveUser;
import com.mmss.pojo.SysPermission;
import com.mmss.pojo.SysRole;
import com.mmss.pojo.SysUser;
import com.mmss.service.user.UserService;
import com.mmss.utils.CryptographyUtil;
import com.mmss.utils.OtherResult;
import com.mmss.utils.PageInfo;
import com.mmss.utils.ResourceTree;
import com.mmss.utils.Result;
import com.mmss.utils.Tree;
import com.mmss.utils.UUIDBuild;
import com.mmss.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	private static Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	@Resource
	UserService userService;

	@RequestMapping(value="/manager", method=RequestMethod.GET)
	public String manager(Model model) {
		model.addAttribute("sessionInfo", getCurrentUser());
		System.out.println(getCurrentUser());
		return "admin/user";
	}

	@RequestMapping(value="/getMenus",method=RequestMethod.POST)
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

/*	@RequestMapping("list")
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
	}*/
 /*  @RequestMapping(value="/manager", method=RequestMethod.GET)
   public String getUserList(Model model, @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
           @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize){
	   PageInfo<SysUser> result = userService.getUserList(pageNum, pageSize);
	   
	   model.addAttribute("page", result);
	  
	    return "admin/userList";
   }*/
	   @RequestMapping(value = "/dataGrid", method = RequestMethod.POST)
	    @ResponseBody
	    public PageInfo dataGrid(UserVo userVo, Integer page, Integer rows, String sort, String order) {
	        PageInfo pageInfo = new PageInfo(page, rows);
	        Map<String, Object> condition = Maps.newHashMap();

	        if (StringUtils.isNoneBlank(userVo.getUsername())) {
	            condition.put("name", userVo.getUsername());
	        }
	        if (userVo.getDeptId() != null) {
	            condition.put("deptId", userVo.getDeptId());
	        }
	        if (userVo.getCreatedateStart() != null) {
	            condition.put("startTime", userVo.getCreatedateStart());
	        }
	        if (userVo.getCreatedateEnd() != null) {
	            condition.put("endTime", userVo.getCreatedateEnd());
	        }
	        pageInfo.setCondition(condition);
	        userService.findDataGrid(pageInfo);
	        return pageInfo;
	    }
	   /**
	     * 添加用户页
	     *
	     * @return
	     */
	    @RequestMapping(value = "/addPage", method = RequestMethod.GET)
	    public String addPage() {
	        return "/admin/userAdd";
	    }
	    /**
	     * 添加用户
	     *
	     * @param userVo
	     * @return
	     */
	    @RequestMapping(value = "/add", method = RequestMethod.POST)
	    @ResponseBody
	    public OtherResult add(UserVo userVo) {
	    	OtherResult result = new OtherResult();
	        SysUser u = userService.findUserByLoginName(userVo.getUsercode());
	        if (u != null) {
	            result.setMsg("用户名已存在!");
	            return result;
	        }
	        try {
	        	userVo.setSalt(userVo.getUsercode());
	        	userVo.setCreatetime(new Date());
	            userVo.setPassword(CryptographyUtil.md5(userVo.getPassword(), userVo.getUsercode()));
	            userService.addUser(userVo);
	            result.setSuccess(true);
	            result.setMsg("添加成功");
	            return result;
	        } catch (RuntimeException e) {
	            LOGGER.error("添加用户失败：{}", e);
	            result.setMsg(e.getMessage());
	            return result;
	        }
	        
	        
	        
	    }
	    
	    /**
	     * 编辑用户页
	     *
	     * @param id
	     * @param model
	     * @return
	     */
	    @RequestMapping("/editPage")
	    public String editPage(String id, Model model) {
	        UserVo userVo = userService.findUserVoById(id);
	        List<SysRole> rolesList = userVo.getRolesList();
	        List<String> ids = Lists.newArrayList();
	        for (SysRole role : rolesList) {
	            ids.add(role.getId());
	        }
	        model.addAttribute("roleIds", ids);
	        model.addAttribute("user", userVo);
	        return "/admin/userEdit";
	    }

	    /**
	     * 编辑用户
	     *
	     * @param userVo
	     * @return
	     */
	    @RequestMapping("/edit")
	    @ResponseBody
	    public OtherResult edit(UserVo userVo) {
	    	OtherResult result = new OtherResult();
	        SysUser user = userService.findUserByLoginName(userVo.getUsercode());
	        if (user != null && user.getId() != userVo.getId()) {
	            result.setMsg("用户名已存在!");
	            return result;
	        }
	        try {
	            userVo.setPassword(CryptographyUtil.md5(userVo.getPassword(), userVo.getUsercode()));
	            userVo.setSalt( userVo.getUsercode());
	            userService.updateUser(userVo);
	            result.setSuccess(true);
	            result.setMsg("修改成功！");
	            return result;
	        } catch (RuntimeException e) {
	            LOGGER.error("修改用户失败：{}", e);
	            result.setMsg(e.getMessage());
	            return result;
	        }
	    }
	    /**
	     * 删除用户
	     *
	     * @param id
	     * @return
	     */
	    @RequestMapping("/delete")
	    @ResponseBody
	    public OtherResult delete(String id) {
	    	OtherResult result = new OtherResult();
	        try {
	            userService.deleteUserById(id);
	            result.setMsg("删除成功！");
	            result.setSuccess(true);
	            return result;
	        } catch (RuntimeException e) {
	            LOGGER.error("删除用户失败：{}", e);
	            result.setMsg(e.getMessage());
	            return result;
	        }
	    }
	    
}
