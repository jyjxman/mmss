package com.mmss.service.impl.user;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mmss.mapper.SysExportMapper;
import com.mmss.pojo.SysExport;
import com.mmss.service.user.ExportService;
import com.mmss.vo.ExportVo;

@Service
@Transactional
public class ExportServiceImpl implements ExportService {

	@Autowired
	private SysExportMapper sysExportMapper;

	@Override
	public SysExport findExportById(Long id) {
		return sysExportMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<ExportVo> findDataGrid(Map<String, Object> map, Integer page, Integer rows) {
		PageHelper.startPage(page, rows);
		List<ExportVo> exportVos = sysExportMapper.queryExportlByCondition(map);
		PageInfo<ExportVo> pageInfo = new PageInfo<ExportVo>(exportVos);
		return pageInfo;
	}

	@Override
	public void addExport(SysExport export) {
		sysExportMapper.insertSelective(export);
	}

	@Override
	public void updateExport(SysExport export) {
		sysExportMapper.updateByPrimaryKeySelective(export);
	}

	@Override
	public void deleteExportById(Long id) {
		sysExportMapper.deleteByPrimaryKey(id);
	}
}
