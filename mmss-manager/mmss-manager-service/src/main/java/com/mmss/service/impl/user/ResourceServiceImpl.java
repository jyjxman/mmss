package com.mmss.service.impl.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.mmss.mapper.SysPermissionMapper;
import com.mmss.pojo.SysPermission;
import com.mmss.service.user.ResourceService;
import com.mmss.utils.Config;
import com.mmss.utils.DTree;
@Service
public class ResourceServiceImpl implements ResourceService {
	@Autowired
	private SysPermissionMapper resourceMapper;

	@Override
	public List<DTree> findAllTrees() {
		 List<DTree> treeOneList = Lists.newArrayList();

	        // 查询所有的一级树
	        List<SysPermission> resources = resourceMapper.findResourceAllByTypeAndPidNull(Config.RESOURCE_MENU);
	        if (resources == null) {
	            return null;
	        }

	        for (SysPermission resourceOne : resources) {
	            DTree treeOne = new DTree();

	            treeOne.setId(resourceOne.getId());
	            treeOne.setText(resourceOne.getName());
	            treeOne.setIconCls(resourceOne.getIcon());
	            treeOne.setAttributes(resourceOne.getUrl());

	            List<SysPermission> resourceSon = resourceMapper.findResourceAllByTypeAndPid(Config.RESOURCE_SUBMENU, resourceOne.getId());

	            if (resourceSon == null) {
	                treeOne.setState("closed");
	            } else {
	                List<DTree> treeTwoList = Lists.newArrayList();

	                for (SysPermission resourceTwo : resourceSon) {
	                    DTree treeTwo = new DTree();

	                    treeTwo.setId(resourceTwo.getId());
	                    treeTwo.setText(resourceTwo.getName());
	                    treeTwo.setIconCls(resourceTwo.getIcon());
	                    treeTwo.setAttributes(resourceTwo.getUrl());

	                    /***************************************************/
	                    List<SysPermission> resourceSons = resourceMapper.findResourceAllByTypeAndPid(Config.RESOURCE_BUTTON, resourceTwo.getId());

	                    if (resourceSons == null) {
	                        treeTwo.setState("closed");
	                    } else {
	                        List<DTree> treeThreeList = Lists.newArrayList();

	                        for (SysPermission resourceThree : resourceSons) {
	                            DTree treeThree = new DTree();

	                            treeThree.setId(resourceThree.getId());
	                            treeThree.setText(resourceThree.getName());
	                            treeThree.setIconCls(resourceThree.getIcon());
	                            treeThree.setAttributes(resourceThree.getUrl());

	                            treeThreeList.add(treeThree);
	                        }
	                        treeTwo.setChildren(treeThreeList);
	                    }
	                    /***************************************************/

	                    treeTwoList.add(treeTwo);
	                }
	                treeOne.setChildren(treeTwoList);
	            }

	            treeOneList.add(treeOne);
	        }
	        return treeOneList;
	}

}
