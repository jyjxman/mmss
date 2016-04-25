package com.mmss.service.user;

import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.mmss.pojo.SysMaterial;

public interface MaterialService {

	PageInfo<SysMaterial> findDataGrid(Map<String, Object> map, Integer page, Integer rows);

	void addMaterial(SysMaterial material);

	SysMaterial findMaterialById(Long id);

	void updateMaterial(SysMaterial material);

	void deleteMaterialById(Long id);


}
