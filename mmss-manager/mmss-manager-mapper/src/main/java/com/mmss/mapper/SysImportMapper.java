package com.mmss.mapper;

import com.mmss.pojo.SysImport;
import com.mmss.pojo.SysImportExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysImportMapper {
    int countByExample(SysImportExample example);

    int deleteByExample(SysImportExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysImport record);

    int insertSelective(SysImport record);

    List<SysImport> selectByExample(SysImportExample example);

    SysImport selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysImport record, @Param("example") SysImportExample example);

    int updateByExample(@Param("record") SysImport record, @Param("example") SysImportExample example);

    int updateByPrimaryKeySelective(SysImport record);

    int updateByPrimaryKey(SysImport record);
}