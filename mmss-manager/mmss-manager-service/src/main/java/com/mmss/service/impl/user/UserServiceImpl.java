package com.mmss.service.impl.user;

import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mmss.mapper.SysPermissionMapperCustom;
import com.mmss.mapper.SysUserMapper;
import com.mmss.mapper.SysUserRoleMapper;
import com.mmss.pojo.SysPermission;
import com.mmss.pojo.SysUser;
import com.mmss.pojo.SysUserExample;
import com.mmss.pojo.SysUserQueryModel;
import com.mmss.pojo.SysUserRole;
import com.mmss.service.user.UserService;
import com.mmss.utils.UUIDBuild;
import com.mmss.vo.UserVo;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	private static Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private SysUserMapper sysUserMapper;
	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;

	@Autowired
	private SysPermissionMapperCustom sysPermissionMapperCustom;

	@Override
	public SysUser findSysUserByUserCode(String userCode) {
		SysUserExample sysUserExample = new SysUserExample();
		SysUserExample.Criteria criteria = sysUserExample.createCriteria();
		criteria.andUsercodeEqualTo(userCode);

		List<SysUser> list = sysUserMapper.selectByExample(sysUserExample);

		if (list != null && list.size() == 1) {
			return list.get(0);
		}

		return null;
	}

	@Override
	public List<SysPermission> findMenuListByUserId(String id) throws Exception {
		return sysPermissionMapperCustom.findMenuListByUserId(id);
	}

	@Override
	public List<SysPermission> findPermissionListByUserId(String userid) throws Exception {
		return sysPermissionMapperCustom.findPermissionListByUserId(userid);
	}

	@Override
	public List<SysUser> getByConditionPage(SysUserQueryModel sysUserQueryModel) {
		// TODO Auto-generated method stub
		return sysUserMapper.getByConditionPage(sysUserQueryModel);
	}

	@Override
	public SysUser findUserById(String userid) {
		// TODO Auto-generated method stub
		return sysUserMapper.findUserById(userid);
	}

	@Override
	public List<SysPermission> findSubMenuListByUserId(String userid) throws Exception {
		// TODO Auto-generated method stub
		return sysPermissionMapperCustom.findSubMenuListByUserId(userid);
	}

    @Override
	public PageInfo<SysUser> getUserList(Integer pageNum, Integer pageSize) {
		  PageHelper.startPage(pageNum, pageSize);
		  List<SysUser> users = sysUserMapper.queryUserList();
		  PageInfo<SysUser> pageInfo = new PageInfo<SysUser>(users);
		return pageInfo;
	}

	@Override
	public void findDataGrid(com.mmss.utils.PageInfo pageInfo) {
		// TODO Auto-generated method stub
		pageInfo.setRows(sysUserMapper.findUserPageCondition(pageInfo));
        pageInfo.setTotal(sysUserMapper.findUserPageCount(pageInfo));
	}

	@Override
	public SysUser findUserByLoginName(String username) {
		// TODO Auto-generated method stub
		return sysUserMapper.findUserByLoginName(username);
	}
	@Override
	public void addUser(UserVo userVo) {
		// TODO Auto-generated method stub
		 SysUser user = new SysUser();
	        try {
	            PropertyUtils.copyProperties(user, userVo);
	        } catch (Exception e) {
	            LOGGER.error("类转换异常：{}", e);
	            throw new RuntimeException("类型转换异常：{}", e);
	        }
	        user.setId(UUIDBuild.getUUID());
	        sysUserMapper.insert(user);

	        String id = user.getId();
	        String[] roles = userVo.getRoleIds().split(",");
	        SysUserRole userRole = new SysUserRole();

	        for (String string : roles) {
	        	userRole.setId(UUIDBuild.getUUID());
	            userRole.setSysUserId(id);
	            userRole.setSysRoleId(string);
	            sysUserRoleMapper.insert(userRole);
	        }
		
	}

	@Override
	public UserVo findUserVoById(String id) {
		// TODO Auto-generated method stub
		return sysUserMapper.findUserVoById(id);
	}

	@Override
	public void updateUser(UserVo userVo) {
		// TODO Auto-generated method stub
		SysUser user = new SysUser();
        try {
            PropertyUtils.copyProperties(user, userVo);
        } catch (Exception e) {
            LOGGER.error("类转换异常：{}", e);
            throw new RuntimeException("类型转换异常：{}", e);
        }
        sysUserMapper.updateUser(user);
        String id = userVo.getId();
        List<SysUserRole> userRoles = sysUserRoleMapper.findUserRoleByUserId(id);
        if (userRoles != null && (!userRoles.isEmpty())) {
            for (SysUserRole userRole : userRoles) {
                sysUserRoleMapper.deleteById(userRole.getId());
            }
        }

        String[] roles = userVo.getRoleIds().split(",");
        SysUserRole userRole = new SysUserRole();
        for (String string : roles) {
        	userRole.setId(UUIDBuild.getUUID());
            userRole.setSysUserId(id);
            userRole.setSysRoleId(string);
            sysUserRoleMapper.insert(userRole);
        }
	}

	@Override
	public void deleteUserById(String id) {
		// TODO Auto-generated method stub
		sysUserMapper.deleteById(id);
        List<SysUserRole> userRoles = sysUserRoleMapper.findUserRoleByUserId(id);
        if (userRoles != null && (!userRoles.isEmpty())) {
            for (SysUserRole userRole : userRoles) {
                sysUserRoleMapper.deleteById(userRole.getId());
            }
        }
	}

}
