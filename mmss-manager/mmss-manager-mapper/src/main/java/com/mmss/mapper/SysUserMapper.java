package com.mmss.mapper;

import com.mmss.pojo.SysUser;
import com.mmss.pojo.SysUserExample;
import com.mmss.pojo.SysUserQueryModel;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.mmss.utils.PageInfo;
import com.mmss.vo.UserVo;
public interface SysUserMapper {
    int countByExample(SysUserExample example);

    int deleteByExample(SysUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    List<SysUser> selectByExample(SysUserExample example);

    SysUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByExample(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
    
    List<SysUser> getByConditionPage(SysUserQueryModel sysUserQueryModel);

	SysUser findUserById(String userid);

	List<SysUser> queryUserList();

	List findUserPageCondition(PageInfo pageInfo);

	int findUserPageCount(PageInfo pageInfo);

	SysUser findUserByLoginName(String username);

	UserVo findUserVoById(String id);

	void updateUser(SysUser user);

	void deleteById(String id);
}