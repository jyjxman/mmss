package com.mmss.service.user;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.mmss.pojo.SysCar;
import com.mmss.utils.DTree;

public interface CarInfoService {

	PageInfo<SysCar> findDataGrid(Map<String, Object> map, Integer page, Integer rows);

	void addCar(SysCar car);

	SysCar findCarById(Long id);

	void updateCar(SysCar car);

	void deleteCarById(Long id);

	void updateCarStatusById(SysCar car);

	List<DTree> findTree();

}
