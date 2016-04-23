package com.mmss.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.mmss.pojo.SysUserRole;
import com.mmss.pojo.SysUserRoleExample;

public interface SysUserRoleMapper {
    int countByExample(SysUserRoleExample example);

    int deleteByExample(SysUserRoleExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    List<SysUserRole> selectByExample(SysUserRoleExample example);

    SysUserRole selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysUserRole record, @Param("example") SysUserRoleExample example);

    int updateByExample(@Param("record") SysUserRole record, @Param("example") SysUserRoleExample example);

    int updateByPrimaryKeySelective(SysUserRole record);

    int updateByPrimaryKey(SysUserRole record);
    
	List<SysUserRole> findUserRoleByUserId(String id);

	void deleteById(String id);

	List<String> findRoleIdListByUserId(String userId);
}