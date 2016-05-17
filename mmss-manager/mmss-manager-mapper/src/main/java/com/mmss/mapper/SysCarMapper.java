package com.mmss.mapper;

import com.mmss.pojo.SysCar;
import com.mmss.pojo.SysCarExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface SysCarMapper {
    int countByExample(SysCarExample example);

    int deleteByExample(SysCarExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysCar record);

    int insertSelective(SysCar record);

    List<SysCar> selectByExample(SysCarExample example);

    SysCar selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysCar record, @Param("example") SysCarExample example);

    int updateByExample(@Param("record") SysCar record, @Param("example") SysCarExample example);

    int updateByPrimaryKeySelective(SysCar record);

    int updateByPrimaryKey(SysCar record);

	List<SysCar> queryCarByName(Map<String, Object> map);

	List<SysCar> findCaryAllByStatus();
}