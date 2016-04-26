package com.mmss.service.impl.user;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mmss.mapper.SysCarMapper;
import com.mmss.pojo.SysCar;
import com.mmss.service.user.CarInfoService;
@Service
@Transactional
public class CarInfoServiceImpl implements CarInfoService {
	@Autowired
	private SysCarMapper sysCarMapper;
	@Override
	public PageInfo<SysCar> findDataGrid(Map<String, Object> map, Integer page, Integer rows) {
		PageHelper.startPage(page, rows);
		List<SysCar> cars = sysCarMapper.queryCarByName(map);
		PageInfo<SysCar> pageInfo = new PageInfo<SysCar>(cars);
		return pageInfo;
	}
	@Override
	public void addCar(SysCar car) {
         sysCarMapper.insertSelective(car);		
	}
	@Override
	public SysCar findCarById(Long id) {
		return sysCarMapper.selectByPrimaryKey(id);
	}
	@Override
	public void updateCar(SysCar car) {
       sysCarMapper.updateByPrimaryKeySelective(car);
	}
	@Override
	public void deleteCarById(Long id) {
       sysCarMapper.deleteByPrimaryKey(id);
	}
	@Override
	public void updateCarStatusById(SysCar car) {
		sysCarMapper.updateByPrimaryKeySelective(car);
	}

}
