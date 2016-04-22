package com.mmss.service.user;

import java.util.List;

import com.mmss.pojo.SysDept;
import com.mmss.utils.DTree;

public interface OrganizationService {

	List<DTree> findTree();

	List<SysDept> findTreeGrid();

	void addOrganization(SysDept organization);

	SysDept findOrganizationById(Long id);

	void updateOrganization(SysDept organization);

	void deleteOrganizationById(Long id);

}
