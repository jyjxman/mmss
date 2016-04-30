package com.mmss.service.impl.user;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mmss.mapper.SysImportMapper;
import com.mmss.pojo.SysImport;
import com.mmss.service.user.ImportService;
import com.mmss.vo.ExportVo;
import com.mmss.vo.ImportVo;

@Service
@Transactional
public class ImportServiceImpl implements ImportService {

	@Autowired
	private SysImportMapper sysImportMapper;

	@Override
	public SysImport findImportById(Long id) {
		return sysImportMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<ImportVo> findDataGrid(Map<String, Object> map, Integer page, Integer rows) {
		PageHelper.startPage(page, rows);
		List<ImportVo> importVos = sysImportMapper.queryImportlByCondition(map);
		PageInfo<ImportVo> pageInfo = new PageInfo<ImportVo>(importVos);
		return pageInfo;
	}

	@Override
	public void addImport(SysImport imp) {
		sysImportMapper.insert(imp);
	}

	@Override
	public void updateImport(SysImport imp) {
		sysImportMapper.updateByPrimaryKeySelective(imp);
	}

	@Override
	public void deleteImportById(Long id) {
		sysImportMapper.deleteByPrimaryKey(id);
	}
}
