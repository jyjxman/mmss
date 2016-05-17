package com.mmss.service.impl.user;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.mmss.mapper.SysRepositoryMapper;
import com.mmss.pojo.SysRepository;
import com.mmss.service.user.RepositoryService;
import com.mmss.utils.DTree;
@Service
public class RepositoryServiceImpl implements RepositoryService {
	@Autowired
	private SysRepositoryMapper sysRepositoryMapper;

	@Override
	public PageInfo<SysRepository> findDataGrid(Map<String, Object> map, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        List<SysRepository> repositories = sysRepositoryMapper.queryRepositoryByName(map);
		  PageInfo<SysRepository> pageInfo = new PageInfo<SysRepository>(repositories);
		
		return pageInfo;
	}

	@Override
	public SysRepository findRepositoryById(Long id) {
		// TODO Auto-generated method stub
		return sysRepositoryMapper.selectByPrimaryKey(id);
	}

	@Override
	public void addRepository(SysRepository repository) {
		sysRepositoryMapper.insertSelective(repository);
	}

	@Override
	public void updateRepository(SysRepository repository) {
       sysRepositoryMapper.updateByPrimaryKeySelective(repository);		
	}

	@Override
	public void deleteRepositoryById(Long id) {
      sysRepositoryMapper.deleteByPrimaryKey(id);		
	}

	@Override
	public List<DTree> findTree() {
		 List<DTree> trees = Lists.newArrayList();
		 List<SysRepository> repositories = sysRepositoryMapper.findRepositoryAll();
		 for (SysRepository sysRepository : repositories) {
			 DTree tree = new DTree();
			 tree.setId(sysRepository.getId());
			 tree.setText(sysRepository.getRepositoryName());
			 trees.add(tree);
		}
		return trees;
	}

}
