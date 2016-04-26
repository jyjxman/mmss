package com.mmss.service.user;

import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.mmss.pojo.SysCarRepair;
import com.mmss.vo.CarRepairVo;

public interface CarRepairService {

	PageInfo<CarRepairVo> findDataGrid(Map<String, Object> map, Integer page, Integer rows);

	void addCarRepair(SysCarRepair carRepair);

	SysCarRepair findCarRepairById(Long id);

	void updateCarRepair(SysCarRepair carRepair);

	void deleteCarRepairById(Long id);

}
