package com.mmss.mapper;

import com.mmss.pojo.SysCarOil;
import com.mmss.pojo.SysCarOilExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysCarOilMapper {
    int countByExample(SysCarOilExample example);

    int deleteByExample(SysCarOilExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysCarOil record);

    int insertSelective(SysCarOil record);

    List<SysCarOil> selectByExample(SysCarOilExample example);

    SysCarOil selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysCarOil record, @Param("example") SysCarOilExample example);

    int updateByExample(@Param("record") SysCarOil record, @Param("example") SysCarOilExample example);

    int updateByPrimaryKeySelective(SysCarOil record);

    int updateByPrimaryKey(SysCarOil record);
}