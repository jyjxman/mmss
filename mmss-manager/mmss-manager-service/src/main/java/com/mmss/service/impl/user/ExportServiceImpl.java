package com.mmss.service.impl.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mmss.mapper.SysExportMapper;
import com.mmss.pojo.SysExport;
import com.mmss.service.user.ExportService;
@Service
@Transactional
public class ExportServiceImpl implements ExportService {

	@Autowired
	private SysExportMapper sysExportMapper;

	@Override
	public SysExport findExportById(Long id) {
		return sysExportMapper.selectByPrimaryKey(id);
	}
}
