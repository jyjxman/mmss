package com.mmss.service.user;

import java.util.List;

import com.mmss.pojo.SysPermission;
import com.mmss.pojo.SysUser;
import com.mmss.utils.DTree;

public interface ResourceService {

	List<DTree> findAllTrees();

	List<SysPermission> findResourceAll();

	void addResource(SysPermission resource);

	List<DTree> findTree(SysUser currentUser);

	List<DTree> findAllTree();

	SysPermission findResourceById(Long id);

	void updateResource(SysPermission resource);

	void deleteResourceById(Long id);

}
