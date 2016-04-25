package com.mmss.service.impl.user;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.mmss.mapper.SysPermissionMapper;
import com.mmss.mapper.SysRoleMapper;
import com.mmss.mapper.SysUserRoleMapper;
import com.mmss.pojo.SysPermission;
import com.mmss.pojo.SysUser;
import com.mmss.service.user.ResourceService;
import com.mmss.utils.Config;
import com.mmss.utils.DTree;
@Service
public class ResourceServiceImpl implements ResourceService {
	@Autowired
	private SysPermissionMapper resourceMapper;
	@Autowired 
	private SysUserRoleMapper sysUserRoleMapper;
	@Autowired
	private SysRoleMapper sysRoleMapper;

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

	@Override
	public List<SysPermission> findResourceAll() {
		return resourceMapper.findResourceAll();
	}

	@Override
	public void addResource(SysPermission resource) {
		resourceMapper.insert(resource);
		
	}

	@Override
	public List<DTree> findTree(SysUser user) {
		List<DTree> trees = Lists.newArrayList();
        // 超级管理
        if (user.getUsercode().equals("admin")) {
            List<SysPermission> resourceFather = resourceMapper.findResourceAllByTypeAndPidNull(Config.RESOURCE_MENU);
            if (resourceFather == null) {
                return null;
            }

            for (SysPermission resourceOne : resourceFather) {
                DTree treeOne = new DTree();

                treeOne.setId(resourceOne.getId());
                treeOne.setText(resourceOne.getName());
                treeOne.setIconCls(resourceOne.getIcon());
                treeOne.setAttributes(resourceOne.getUrl());
                List<SysPermission> resourceSon = resourceMapper.findResourceAllByTypeAndPid(Config.RESOURCE_MENU, resourceOne.getId());

                if (resourceSon != null) {
                    List<DTree> tree = Lists.newArrayList();
                    for (SysPermission resourceTwo : resourceSon) {
                        DTree treeTwo = new DTree();
                        treeTwo.setId(resourceTwo.getId());
                        treeTwo.setText(resourceTwo.getName());
                        treeTwo.setIconCls(resourceTwo.getIcon());
                        treeTwo.setAttributes(resourceTwo.getUrl());
                        tree.add(treeTwo);
                    }
                    treeOne.setChildren(tree);
                } else {
                    treeOne.setState("closed");
                }
                trees.add(treeOne);
            }
            return trees;
        }

        // 普通用户
        Set<SysPermission> resourceIdList = Sets.newHashSet();
        List<String> roleIdList = sysUserRoleMapper.findRoleIdListByUserId(user.getId());
        for (String i : roleIdList) {
            List<SysPermission> resourceIdLists = sysRoleMapper.findResourceIdListByRoleIdAndType(i);
            for (SysPermission resource: resourceIdLists) {
                resourceIdList.add(resource);
            }
        }
        for (SysPermission resource : resourceIdList) {
                if (resource != null && resource.getParentid() == null) {
                    DTree treeOne = new DTree();
                    treeOne.setId(resource.getId());
                    treeOne.setText(resource.getName());
                    treeOne.setIconCls(resource.getIcon());
                    treeOne.setAttributes(resource.getUrl());
                    List<DTree> tree = Lists.newArrayList();
                    for (SysPermission resourceTwo : resourceIdList) {
                        if (resourceTwo.getParentid() != null && resource.getId().longValue() == resourceTwo.getParentid().longValue()) {
                            DTree treeTwo = new DTree();
                            treeTwo.setId(resourceTwo.getId());
                            treeTwo.setText(resourceTwo.getName());
                            treeTwo.setIconCls(resourceTwo.getIcon());
                            treeTwo.setAttributes(resourceTwo.getUrl());
                            tree.add(treeTwo);
                        }
                    }
                    treeOne.setChildren(tree);
                    trees.add(treeOne);
                }
        }
        return trees;
	}

	@Override
	public List<DTree> findAllTree() {
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

	@Override
	public SysPermission findResourceById(Long id) {
		return resourceMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateResource(SysPermission resource) {
		resourceMapper.updateByPrimaryKeySelective(resource);		
	}

	@Override
	public void deleteResourceById(Long id) {
		resourceMapper.deleteByPrimaryKey(id);	
	}

}
