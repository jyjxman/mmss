package com.mmss.mapper;

import com.mmss.pojo.SysPurBusList;
import com.mmss.pojo.SysPurBusListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysPurBusListMapper {
    int countByExample(SysPurBusListExample example);

    int deleteByExample(SysPurBusListExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysPurBusList record);

    int insertSelective(SysPurBusList record);

    List<SysPurBusList> selectByExample(SysPurBusListExample example);

    SysPurBusList selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysPurBusList record, @Param("example") SysPurBusListExample example);

    int updateByExample(@Param("record") SysPurBusList record, @Param("example") SysPurBusListExample example);

    int updateByPrimaryKeySelective(SysPurBusList record);

    int updateByPrimaryKey(SysPurBusList record);
}