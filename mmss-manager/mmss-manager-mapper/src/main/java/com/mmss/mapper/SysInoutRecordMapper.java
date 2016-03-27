package com.mmss.mapper;

import com.mmss.pojo.SysInoutRecord;
import com.mmss.pojo.SysInoutRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysInoutRecordMapper {
    int countByExample(SysInoutRecordExample example);

    int deleteByExample(SysInoutRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysInoutRecord record);

    int insertSelective(SysInoutRecord record);

    List<SysInoutRecord> selectByExample(SysInoutRecordExample example);

    SysInoutRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysInoutRecord record, @Param("example") SysInoutRecordExample example);

    int updateByExample(@Param("record") SysInoutRecord record, @Param("example") SysInoutRecordExample example);

    int updateByPrimaryKeySelective(SysInoutRecord record);

    int updateByPrimaryKey(SysInoutRecord record);
}