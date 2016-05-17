package com.mmss.mapper;

import com.mmss.pojo.SysRepository;
import com.mmss.pojo.SysRepositoryExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface SysRepositoryMapper {
    int countByExample(SysRepositoryExample example);

    int deleteByExample(SysRepositoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysRepository record);

    int insertSelective(SysRepository record);

    List<SysRepository> selectByExample(SysRepositoryExample example);

    SysRepository selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysRepository record, @Param("example") SysRepositoryExample example);

    int updateByExample(@Param("record") SysRepository record, @Param("example") SysRepositoryExample example);

    int updateByPrimaryKeySelective(SysRepository record);

    int updateByPrimaryKey(SysRepository record);

	List<SysRepository> queryRepositoryByName(Map<String, Object> map);

	List<SysRepository> findRepositoryAll();
}