package com.mmss.controller;

import java.util.List;
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
import com.mmss.pojo.SysRepository;
import com.mmss.service.user.RepositoryService;
import com.mmss.utils.DTree;
import com.mmss.utils.EasyUIResult;
import com.mmss.utils.OtherResult;

@Controller
@RequestMapping("/repository")
public class RepositoryController extends BaseController{
	private static Logger LOGGER = LoggerFactory.getLogger(RepositoryController.class);
	@Autowired
	private RepositoryService repositoryService;
	
	
	/**
     * 仓库资源树
     *
     * @return
     */
   /* @RequestMapping(value = "/tree", method = RequestMethod.POST)
    @ResponseBody
    public List<DTree> tree() {
        List<DTree> trees = repositoryService.findTree();
        return trees;
    }
*/
	@RequestMapping(value="/manager", method=RequestMethod.GET)
	public String manager(){
		
		return "material/repository";
	}
	@RequestMapping(value="/dataGrid",method=RequestMethod.POST)
	@ResponseBody
	public EasyUIResult dataGrid(SysRepository repository, Integer page, Integer rows){
		Map<String, Object> map = Maps.newHashMap();
		if (StringUtils.isNoneBlank(repository.getRepositoryName())) {
			map.put("name", repository.getRepositoryName());
		}
		
		PageInfo<SysRepository> pageInfo = repositoryService.findDataGrid(map, page , rows);
		return new EasyUIResult(pageInfo.getTotal(), pageInfo.getList());
		
	}
	
	
	   @RequestMapping(value = "/addPage", method = RequestMethod.GET)
	    public String addPage() {
	        return "/material/repositoryAdd";
	    }
	   
	

	    /**
	     * 添加仓库
	     *
	     * @param organization
	     * @return
	     */
	    @RequestMapping("/add")
	    @ResponseBody
	    public OtherResult add(SysRepository repository) {
	    	OtherResult result = new OtherResult();
	        try {
	        	repositoryService.addRepository(repository);
	            result.setSuccess(true);
	            result.setMsg("添加成功！");
	            return result;
	        } catch (RuntimeException e) {
	            LOGGER.info("添加仓库失败：{}", e);
	            result.setMsg(e.getMessage());
	            return result;
	        }
	    }
	    /**
	     * 编辑仓库页
	     *
	     * @param request
	     * @param id
	     * @return
	     */
	    @RequestMapping("/editPage")
	    public String editPage(HttpServletRequest request, Long id) {
	        SysRepository repository = repositoryService.findRepositoryById(id);
	        request.setAttribute("repository", repository);
	        return "/material/repositoryEdit";
	    }

	    /**
	     * 编辑仓库
	     *
	     * @param repository
	     * @return
	     */
	    @RequestMapping("/edit")
	    @ResponseBody
	    public OtherResult edit(SysRepository repository) {
	    	OtherResult result = new OtherResult();
	        try {
	            repositoryService.updateRepository(repository);
	            result.setSuccess(true);
	            result.setMsg("编辑成功！");
	            return result;
	        } catch (RuntimeException e) {
	            LOGGER.info("编辑仓库失败：{}", e);
	            result.setMsg(e.getMessage());
	            return result;
	        }
	    }

	    /**
	     * 删除仓库
	     *
	     * @param id
	     * @return
	     */
	    @RequestMapping("/delete")
	    @ResponseBody
	    public OtherResult delete(Long id) {
	    	OtherResult result = new OtherResult();
	        try {
	            repositoryService.deleteRepositoryById(id);
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
