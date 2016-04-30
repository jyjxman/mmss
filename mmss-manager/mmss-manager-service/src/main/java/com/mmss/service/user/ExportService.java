package com.mmss.service.user;

import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.mmss.pojo.SysExport;
import com.mmss.vo.ExportVo;

public interface ExportService {

	SysExport findExportById(Long id);

	PageInfo<ExportVo> findDataGrid(Map<String, Object> map, Integer page, Integer rows);

	void addExport(SysExport export);

	void updateExport(SysExport export);

	void deleteExportById(Long id);

}
