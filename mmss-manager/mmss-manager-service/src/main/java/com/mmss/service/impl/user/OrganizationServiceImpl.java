package com.mmss.service.impl.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.mmss.mapper.SysDeptMapper;
import com.mmss.pojo.SysDept;
import com.mmss.service.user.OrganizationService;
import com.mmss.utils.DTree;
@Service
public class OrganizationServiceImpl implements OrganizationService {
	@Autowired
	private SysDeptMapper sysDeptMapper;

	@Override
	public List<DTree> findTree() {
		 List<DTree> trees = Lists.newArrayList();

	        List<SysDept> organizationFather = sysDeptMapper.findOrganizationAllByPidNull();

	        if (organizationFather != null) {
	            for (SysDept organizationOne : organizationFather) {
	                DTree treeOne = new DTree();

	                treeOne.setId(organizationOne.getId());
	                treeOne.setText(organizationOne.getName());
	                treeOne.setIconCls(organizationOne.getIcon());

	                List<SysDept> organizationSon = sysDeptMapper.findOrganizationAllByPid(organizationOne.getId());

	                if (organizationSon != null) {
	                    List<DTree> tree = Lists.newArrayList();
	                    for (SysDept organizationTwo : organizationSon) {
	                        DTree treeTwo = new DTree();
	                        treeTwo.setId(organizationTwo.getId());
	                        treeTwo.setText(organizationTwo.getName());
	                        treeTwo.setIconCls(organizationTwo.getIcon());
	                        tree.add(treeTwo);
	                    }
	                    treeOne.setChildren(tree);
	                } else {
	                    treeOne.setState("closed");
	                }
	                trees.add(treeOne);
	            }
	        }
	        return trees;
	}

	@Override
	public List<SysDept> findTreeGrid() {
		// TODO Auto-generated method stub
		return sysDeptMapper.findOrganizationAll();
	}

	@Override
	public void addOrganization(SysDept organization) {
		sysDeptMapper.insert(organization);	
	}

	@Override
	public SysDept findOrganizationById(Long id) {
		return sysDeptMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateOrganization(SysDept organization) {
       sysDeptMapper.updateByPrimaryKeySelective(organization);		
	}

	@Override
	public void deleteOrganizationById(Long id) {
		sysDeptMapper.deleteByPrimaryKey(id);
		
	}

}
