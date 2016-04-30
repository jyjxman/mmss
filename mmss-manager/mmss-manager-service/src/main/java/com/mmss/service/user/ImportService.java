package com.mmss.service.user;

import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.mmss.pojo.SysImport;
import com.mmss.vo.ImportVo;

public interface ImportService {

	SysImport findImportById(Long id);

	PageInfo<ImportVo> findDataGrid(Map<String, Object> map, Integer page, Integer rows);

	void addImport(SysImport imp);

	void updateImport(SysImport imp);

	void deleteImportById(Long id);

}
