package com.mmss.service.impl.user;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mmss.mapper.SysMaterialMapper;
import com.mmss.mapper.SysRepositoryMapper;
import com.mmss.pojo.SysMaterial;
import com.mmss.service.user.MaterialService;
@Service
@Transactional
public class MaterialServiceImpl implements MaterialService {
    @Autowired 
    private SysMaterialMapper sysMaterialMapper;
	@Override
	public PageInfo<SysMaterial> findDataGrid(Map<String, Object> map, Integer page, Integer rows) {
		PageHelper.startPage(page, rows);
		List<SysMaterial> materials = sysMaterialMapper.queryMaterialByName(map);
		PageInfo<SysMaterial> pageInfo = new PageInfo<SysMaterial>(materials);
		return pageInfo;
	}

	@Override
	public void addMaterial(SysMaterial material) {
       sysMaterialMapper.insertSelective(material);		
	}

	@Override
	public SysMaterial findMaterialById(Long id) {
		return sysMaterialMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateMaterial(SysMaterial material) {
        sysMaterialMapper.updateByPrimaryKeySelective(material);	
	}

	@Override
	public void deleteMaterialById(Long id) {
     sysMaterialMapper.deleteByPrimaryKey(id);		
	}

	
	

}
