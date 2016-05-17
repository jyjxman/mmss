package com.mmss.service.impl.user;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.mmss.mapper.SysMaterialMapper;
import com.mmss.pojo.SysMaterial;
import com.mmss.service.user.MaterialService;
import com.mmss.utils.DTree;
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

	@Override
	public List<DTree> findTree() {
		 List<DTree> trees = Lists.newArrayList();
		 List<SysMaterial> materials = sysMaterialMapper.findMaterialAll();
		for (SysMaterial sysMaterial : materials) {
			 DTree tree = new DTree();
			 tree.setId(sysMaterial.getId());
			 tree.setText(sysMaterial.getMaterialName());
			 trees.add(tree);
		}
		return trees;
	
	}

	
	

}
