package com.mmss.mapper;

import com.mmss.pojo.SysCarAccident;
import com.mmss.pojo.SysCarAccidentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysCarAccidentMapper {
    int countByExample(SysCarAccidentExample example);

    int deleteByExample(SysCarAccidentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysCarAccident record);

    int insertSelective(SysCarAccident record);

    List<SysCarAccident> selectByExample(SysCarAccidentExample example);

    SysCarAccident selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysCarAccident record, @Param("example") SysCarAccidentExample example);

    int updateByExample(@Param("record") SysCarAccident record, @Param("example") SysCarAccidentExample example);

    int updateByPrimaryKeySelective(SysCarAccident record);

    int updateByPrimaryKey(SysCarAccident record);
}