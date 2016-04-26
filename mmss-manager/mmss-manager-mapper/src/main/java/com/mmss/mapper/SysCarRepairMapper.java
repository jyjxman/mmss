package com.mmss.mapper;

import com.mmss.pojo.SysCarRepair;
import com.mmss.pojo.SysCarRepairExample;
import com.mmss.vo.CarRepairVo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface SysCarRepairMapper {
    int countByExample(SysCarRepairExample example);

    int deleteByExample(SysCarRepairExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysCarRepair record);

    int insertSelective(SysCarRepair record);

    List<SysCarRepair> selectByExample(SysCarRepairExample example);

    SysCarRepair selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysCarRepair record, @Param("example") SysCarRepairExample example);

    int updateByExample(@Param("record") SysCarRepair record, @Param("example") SysCarRepairExample example);

    int updateByPrimaryKeySelective(SysCarRepair record);

    int updateByPrimaryKey(SysCarRepair record);

	List<CarRepairVo> queryCarRepairByCodition(Map<String, Object> map);
}