package com.mmss.service.impl.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mmss.mapper.SysStockMapper;
import com.mmss.pojo.SysStock;
import com.mmss.service.user.StockService;

@Service
@Transactional
public class StockServiceImpl implements StockService {

	@Autowired
	private SysStockMapper sysStockMapper;

	@Override
	public SysStock findStockById(Long id) {
		return sysStockMapper.selectByPrimaryKey(id);
	}
}
