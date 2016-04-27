package com.mmss.service.user;

import java.util.List;

import com.mmss.vo.ListAuditCustom;
import com.mmss.vo.ListCustom;

public interface ScheduleService {

	void saveList(String userId, ListCustom listCustom)throws Exception;

	List<ListCustom> findListTaskList(String userId)throws Exception;

	void saveOrderSubmitStauts(String userId, String taskId) throws Exception;

	void saveOrderAuditStauts(String taskId, String userId, String listId, String auditType,
			ListAuditCustom listAuditCustom)throws Exception;

	List<ListCustom> findActivityOrderList()throws Exception;

	List<ListCustom> findOrderTaskListByPid(String processInstanceId)throws Exception;

	List<ListCustom> findOrderGroupTaskList(String userId)throws Exception;

	void saveClaimTask(String taskId, String candidateUserId)throws Exception;

	List<ListCustom> findFinishedOrderList()throws Exception;

}
