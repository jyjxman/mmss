package com.mmss.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.mmss.pojo.SysRole;
import com.mmss.pojo.SysRoleExample;
import com.mmss.utils.PageInfo;

public interface SysRoleMapper {
    int countByExample(SysRoleExample example);

    int deleteByExample(SysRoleExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    List<SysRole> selectByExample(SysRoleExample example);

    SysRole selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    int updateByExample(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

	List<SysRole> findRoleAll();

	List findRolePageCondition(PageInfo pageInfo);

	int findRolePageCount(PageInfo pageInfo);

	List<String> findResourceIdListByRoleId(String id);

	List<String> findRoleResourceIdListByRoleId(String id);

}