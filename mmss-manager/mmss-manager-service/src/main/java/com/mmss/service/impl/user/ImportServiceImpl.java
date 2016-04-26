package com.mmss.service.impl.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mmss.mapper.SysImportMapper;
import com.mmss.pojo.SysImport;
import com.mmss.service.user.ImportService;
@Service
@Transactional
public class ImportServiceImpl implements ImportService {

	@Autowired
	private SysImportMapper sysImportMapper;

	@Override
	public SysImport findImportById(Long id) {
		return sysImportMapper.selectByPrimaryKey(id);
	}
}
