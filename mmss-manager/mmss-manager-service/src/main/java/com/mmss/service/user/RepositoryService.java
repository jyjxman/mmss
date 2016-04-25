package com.mmss.service.user;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.mmss.pojo.SysRepository;
import com.mmss.utils.DTree;

public interface RepositoryService {

	PageInfo<SysRepository> findDataGrid(Map<String, Object> map, Integer page, Integer rows);

	SysRepository findRepositoryById(Long id);

	void addRepository(SysRepository repository);

	void updateRepository(SysRepository repository);

	void deleteRepositoryById(Long id);

	List<DTree> findTree();

}
