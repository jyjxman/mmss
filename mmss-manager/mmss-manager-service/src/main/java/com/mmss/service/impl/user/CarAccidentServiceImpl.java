package com.mmss.service.impl.user;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mmss.mapper.SysCarAccidentMapper;
import com.mmss.pojo.SysCarAccident;
import com.mmss.service.user.CarAccidentService;
import com.mmss.vo.CarAccidentVo;
import com.mmss.vo.CarRepairVo;
@Service
@Transactional
public class CarAccidentServiceImpl implements CarAccidentService{

	@Autowired
	private SysCarAccidentMapper sysCarAccidentMapper;

	@Override
	public PageInfo<CarAccidentVo> findDataGrid(Map<String, Object> map, Integer page, Integer rows) {
		PageHelper.startPage(page, rows);
		List<CarAccidentVo> cars = sysCarAccidentMapper.queryCarAccidentByCodition(map);
		PageInfo<CarAccidentVo> pageInfo = new PageInfo<CarAccidentVo>(cars);
		return pageInfo;
	}

	@Override
	public void addCarAccident(SysCarAccident carAccident) {
           sysCarAccidentMapper.insertSelective(carAccident);		
	}

	@Override
	public SysCarAccident findCarAccidentById(Long id) {
		return sysCarAccidentMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateCarAccident(SysCarAccident carAccident) {
		sysCarAccidentMapper.updateByPrimaryKeySelective(carAccident);
	}

	@Override
	public void deleteCarAccidentrById(Long id) {
        sysCarAccidentMapper.deleteByPrimaryKey(id);		
	}
	
	
}
