package com.mmss.mapper;

import com.mmss.pojo.SysStorage;
import com.mmss.pojo.SysStorageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysStorageMapper {
    int countByExample(SysStorageExample example);

    int deleteByExample(SysStorageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysStorage record);

    int insertSelective(SysStorage record);

    List<SysStorage> selectByExample(SysStorageExample example);

    SysStorage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysStorage record, @Param("example") SysStorageExample example);

    int updateByExample(@Param("record") SysStorage record, @Param("example") SysStorageExample example);

    int updateByPrimaryKeySelective(SysStorage record);

    int updateByPrimaryKey(SysStorage record);
}