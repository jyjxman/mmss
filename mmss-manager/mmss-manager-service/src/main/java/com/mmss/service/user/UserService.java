package com.mmss.service.user;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.mmss.pojo.SysPermission;
import com.mmss.pojo.SysUser;
import com.mmss.pojo.SysUserQueryModel;
import com.mmss.vo.UserVo;

public interface UserService {

	SysUser findSysUserByUserCode(String userCode);

	List<SysPermission> findMenuListByUserId(String id) throws Exception;

	List<SysPermission> findPermissionListByUserId(String userid) throws Exception;
	
	List<SysPermission> findSubMenuListByUserId(String userid) throws Exception;

	List<SysUser> getByConditionPage(SysUserQueryModel sysUserQueryModel);

	SysUser findUserById(String userid);

	PageInfo<SysUser> getUserList(Integer pageNum, Integer pageSize);

	void findDataGrid(com.mmss.utils.PageInfo pageInfo);

	SysUser findUserByLoginName(String username);

	void addUser(UserVo userVo);

	UserVo findUserVoById(String id);

	void updateUser(UserVo userVo);

	void deleteUserById(String id);
}
