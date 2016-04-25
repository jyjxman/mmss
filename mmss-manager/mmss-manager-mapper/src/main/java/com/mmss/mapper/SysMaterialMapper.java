package com.mmss.mapper;

import com.mmss.pojo.SysMaterial;
import com.mmss.pojo.SysMaterialExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface SysMaterialMapper {
    int countByExample(SysMaterialExample example);

    int deleteByExample(SysMaterialExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysMaterial record);

    int insertSelective(SysMaterial record);

    List<SysMaterial> selectByExample(SysMaterialExample example);

    SysMaterial selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysMaterial record, @Param("example") SysMaterialExample example);

    int updateByExample(@Param("record") SysMaterial record, @Param("example") SysMaterialExample example);

    int updateByPrimaryKeySelective(SysMaterial record);

    int updateByPrimaryKey(SysMaterial record);

	List<SysMaterial> queryMaterialByName(Map<String, Object> map);
}