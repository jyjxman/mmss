package com.mmss.mapper;

import com.mmss.pojo.SysExport;
import com.mmss.pojo.SysExportExample;
import com.mmss.vo.ExportVo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface SysExportMapper {
    int countByExample(SysExportExample example);

    int deleteByExample(SysExportExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysExport record);

    int insertSelective(SysExport record);

    List<SysExport> selectByExample(SysExportExample example);

    SysExport selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysExport record, @Param("example") SysExportExample example);

    int updateByExample(@Param("record") SysExport record, @Param("example") SysExportExample example);

    int updateByPrimaryKeySelective(SysExport record);

    int updateByPrimaryKey(SysExport record);

	List<ExportVo> queryExportlByCondition(Map<String, Object> map);
}