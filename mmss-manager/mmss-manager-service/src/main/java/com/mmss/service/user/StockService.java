package com.mmss.service.user;

import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.mmss.pojo.SysStock;
import com.mmss.vo.StockVo;

public interface StockService {

	SysStock findStockById(Long id);

	PageInfo<StockVo> findDataGrid(Map<String, Object> map, Integer page, Integer rows);

	void addStock(SysStock stock);

	void updateStock(SysStock stock);

	void deleteStockById(Long id);

	SysStock findStockByMidAndRid(Map<String, Object> map);


}
