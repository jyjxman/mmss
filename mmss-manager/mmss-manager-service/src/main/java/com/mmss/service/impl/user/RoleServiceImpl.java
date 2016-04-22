package com.mmss.service.impl.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.mmss.mapper.SysRoleMapper;
import com.mmss.mapper.SysRolePermissionMapper;
import com.mmss.pojo.SysRole;
import com.mmss.pojo.SysRolePermission;
import com.mmss.service.exception.ServiceException;
import com.mmss.service.user.RoleService;
import com.mmss.utils.DTree;
import com.mmss.utils.PageInfo;
import com.mmss.utils.UUIDBuild;
@Service
public class RoleServiceImpl implements RoleService{
	 private static Logger LOGGER = LoggerFactory.getLogger(RoleServiceImpl.class);
	@Autowired
	private SysRoleMapper roleMapper;
	@Autowired
	private SysRolePermissionMapper sysRolePermissionMapper;

	@Override
	public List<DTree> findTree() {
		 List<DTree> trees = Lists.newArrayList();
	        List<SysRole> roles = roleMapper.findRoleAll();
	        for (SysRole role : roles) {
	            DTree tree = new DTree();
	            tree.setId(Long.valueOf(role.getId()));
	            tree.setText(role.getName());

	            trees.add(tree);
	        }
	        return trees;
	}

	@Override
	public void findDataGrid(PageInfo pageInfo) {
		// TODO Auto-generated method stub
		pageInfo.setRows(roleMapper.findRolePageCondition(pageInfo));
        pageInfo.setTotal(roleMapper.findRolePageCount(pageInfo));
	}

	@Override
	public void addRole(SysRole role) {
		// TODO Auto-generated method stub
		int insert = roleMapper.insert(role);
        if (insert != 1) {
            LOGGER.warn("插入失败，参数：{}", role.toString());
            throw new ServiceException("插入失败");
        }
		
	}

	@Override
	public SysRole findRoleById(String id) {
		return roleMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateRole(SysRole role) {
		int update = roleMapper.updateByPrimaryKeySelective(role);
        if (update != 1) {
            LOGGER.warn("更新失败，参数：{}", role.toString());
            throw new ServiceException("更新失败");
        }
	}

	@Override
	public void deleteRoleById(String id) {
		 int update = roleMapper.deleteByPrimaryKey(id);
	     if (update != 1) {
	        LOGGER.warn("删除失败，id：{}", id);
	        throw new ServiceException("删除失败");
	    }    		
	}

	@Override
	public List<String> findResourceIdListByRoleId(String id) {
		// TODO Auto-generated method stub
		return roleMapper.findResourceIdListByRoleId(id);
	}

	@Override
	public void updateRoleResource(String id, String resourceIds) {
		// TODO Auto-generated method stub
		  // 先删除后添加,有点爆力
        List<String> roleResourceIdList = roleMapper.findRoleResourceIdListByRoleId(id);
        if (roleResourceIdList != null && (!roleResourceIdList.isEmpty())) {
            for (String roleResourceId : roleResourceIdList) {
            	sysRolePermissionMapper.deleteByPrimaryKey(roleResourceId);
            }
        }
        String[] resources = resourceIds.split(",");
        SysRolePermission roleResource = new SysRolePermission();
        for (String string : resources) {
        	roleResource.setId(UUIDBuild.getUUID());
            roleResource.setSysRoleId(id);
            roleResource.setSysPermissionId(string);
            sysRolePermissionMapper.insert(roleResource);
        }
		
	}

}
