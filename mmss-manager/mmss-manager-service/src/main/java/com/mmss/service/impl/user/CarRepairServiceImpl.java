package com.mmss.service.impl.user;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mmss.mapper.SysCarRepairMapper;
import com.mmss.pojo.SysCarRepair;
import com.mmss.service.user.CarRepairService;
import com.mmss.vo.CarRepairVo;
@Service
@Transactional
public class CarRepairServiceImpl implements CarRepairService{
    @Autowired
    private SysCarRepairMapper sysCarRepairMapper;

	@Override
	public PageInfo<CarRepairVo> findDataGrid(Map<String, Object> map, Integer page, Integer rows) {
		PageHelper.startPage(page, rows);
		List<CarRepairVo> cars = sysCarRepairMapper.queryCarRepairByCodition(map);
		PageInfo<CarRepairVo> pageInfo = new PageInfo<CarRepairVo>(cars);
		return pageInfo;
	}

	@Override
	public void addCarRepair(SysCarRepair carRepair) {
		sysCarRepairMapper.insertSelective(carRepair);
	}

	@Override
	public SysCarRepair findCarRepairById(Long id) {
		return sysCarRepairMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateCarRepair(SysCarRepair carRepair) {
		sysCarRepairMapper.updateByPrimaryKeySelective(carRepair);
	}

	@Override
	public void deleteCarRepairById(Long id) {
		sysCarRepairMapper.deleteByPrimaryKey(id);
	}
    
}
