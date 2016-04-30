package com.mmss.service.impl.user;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mmss.mapper.SysStockMapper;
import com.mmss.pojo.SysStock;
import com.mmss.service.user.StockService;
import com.mmss.vo.StockVo;

@Service
@Transactional
public class StockServiceImpl implements StockService {

	@Autowired
	private SysStockMapper sysStockMapper;

	@Override
	public SysStock findStockById(Long id) {
		return sysStockMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<StockVo> findDataGrid(Map<String, Object> map, Integer page, Integer rows) {
		PageHelper.startPage(page, rows);
		List<StockVo> stockVos = sysStockMapper.queryStocklByCondition(map);
		PageInfo<StockVo> pageInfo = new PageInfo<StockVo>(stockVos);
		return pageInfo;
		
	}

	@Override
	public void addStock(SysStock stock) {
		sysStockMapper.insertSelective(stock);
	}

	@Override
	public void updateStock(SysStock stock) {
		sysStockMapper.updateByPrimaryKeySelective(stock);
	}

	@Override
	public void deleteStockById(Long id) {
      sysStockMapper.deleteByPrimaryKey(id);		
	}

	@Override
	public SysStock findStockByMidAndRid(Map<String, Object> map) {
		return sysStockMapper.findStock(map);
	}

	
}
