package com.mmss.service.user;

import java.util.List;

import com.mmss.pojo.SysRole;
import com.mmss.utils.DTree;
import com.mmss.utils.PageInfo;

public interface RoleService {

	List<DTree> findTree();

	void findDataGrid(PageInfo pageInfo);

	void addRole(SysRole role);

	SysRole findRoleById(String id);

	void updateRole(SysRole role);

	void deleteRoleById(String id);

	List<String> findResourceIdListByRoleId(String id);

	void updateRoleResource(String id, String resourceIds);

}
