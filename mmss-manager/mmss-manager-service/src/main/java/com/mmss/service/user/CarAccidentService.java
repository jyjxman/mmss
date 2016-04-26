package com.mmss.service.user;

import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.mmss.pojo.SysCarAccident;
import com.mmss.vo.CarAccidentVo;

public interface CarAccidentService {

	PageInfo<CarAccidentVo> findDataGrid(Map<String, Object> map, Integer page, Integer rows);

	void addCarAccident(SysCarAccident carAccident);

	SysCarAccident findCarAccidentById(Long id);

	void updateCarAccident(SysCarAccident carAccident);

	void deleteCarAccidentrById(Long id);

}
