package com.mmss.mapper;

import com.mmss.pojo.SysStock;
import com.mmss.pojo.SysStockExample;
import com.mmss.vo.StockVo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface SysStockMapper {
    int countByExample(SysStockExample example);

    int deleteByExample(SysStockExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysStock record);

    int insertSelective(SysStock record);

    List<SysStock> selectByExample(SysStockExample example);

    SysStock selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysStock record, @Param("example") SysStockExample example);

    int updateByExample(@Param("record") SysStock record, @Param("example") SysStockExample example);

    int updateByPrimaryKeySelective(SysStock record);

    int updateByPrimaryKey(SysStock record);

	List<StockVo> queryStocklByCondition(Map<String, Object> map);

	SysStock findStock(Map<String, Object> map);

}