package com.mmss.service.impl.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricProcessInstanceQuery;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricTaskInstanceQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmss.mapper.SysPurBusListAuditMapper;
import com.mmss.mapper.SysPurBusListMapper;
import com.mmss.mapper.SysUserMapper;
import com.mmss.pojo.SysPurBusList;
import com.mmss.pojo.SysUser;
import com.mmss.service.user.ScheduleService;
import com.mmss.utils.ResourcesUtil;
import com.mmss.utils.UUIDBuild;
import com.mmss.vo.ListAuditCustom;
import com.mmss.vo.ListCustom;
@Service
public class ScheduleServiceImpl implements ScheduleService{
	
	@Autowired
	private SysPurBusListMapper sysPurBusListMapper;
	@Autowired
	private SysPurBusListAuditMapper sysPurBusListAuditMapper;
	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private TaskService taskService;

	@Autowired
	private HistoryService historyService;

	@Autowired
	private IdentityService identityService;
	@Override
	public void saveList(String userId, ListCustom listCustom) throws Exception{
		
		// 调用mapper向采购单表中插入一条记录
				// 生成 主键，采购单id
				String listId = UUIDBuild.getUUID();

				// 流程定义的key从配置文件获取
				String processDefinitionKey = ResourcesUtil.getValue(
						"diagrams.purchasingflow", "purchasingProcessDefinitionKey");// 采购流程标识
				// 业务标识
				String businessKey = listId;

				// 启动流程实例
				ProcessInstance processInstance = runtimeService
						.startProcessInstanceByKey(processDefinitionKey, businessKey);
				identityService.setAuthenticatedUserId(userId);
				// 启动的流程实例id
				String processInstance_id = processInstance.getProcessInstanceId();

				listCustom.setId(listId);
				// 创建采购单的时间
				listCustom.setCreatetime(new Date());
				// 创建用户id
				listCustom.setUserid(userId);

				// 设置流程实例的id
				listCustom.setProcessinstanceid(processInstance_id);

				sysPurBusListMapper.insert(listCustom);
		
	}

	@Override
	public List<ListCustom> findListTaskList(String userId) throws Exception {
		       // 流程定义key（流程定义的标识 ）
				String processDefinitionKey = ResourcesUtil.getValue(
						"diagrams.purchasingflow", "purchasingProcessDefinitionKey");
				// 任务 负责人
				String assignee = userId;
				// 创建查询对象
				TaskQuery taskQuery = taskService.createTaskQuery();

				// 设置查询条件
				taskQuery.taskAssignee(assignee);

				// 指定 流程定义key，只查询某个流程的任务
				taskQuery.processDefinitionKey(processDefinitionKey);

				// 设置排序 字段，根据任务创建时间降序
				taskQuery.orderByTaskCreateTime().desc();

				// 获取查询列表
				List<Task> list = taskQuery.list();
				// 需要返回的内容：任务id、任务标识 、任务名称、任务负责人、采购单名称、采购金额

				List<ListCustom> orderList = new ArrayList<ListCustom>();

				for (Task task : list) {

					ListCustom listCustom = new ListCustom();

					// 流程实例id
					String processInstanceId = task.getProcessInstanceId();
					// 根据流程实例id找到流程实例对象
					ProcessInstance processInstance = runtimeService
							.createProcessInstanceQuery()
							.processInstanceId(processInstanceId).singleResult();
					// 从流程实例对象中获取businessKey
					String businessKey = processInstance.getBusinessKey();
					// 根据businessKey查询业务系统
					// 采购单id
					String listId = businessKey;
					SysPurBusList purBusList = sysPurBusListMapper
							.selectByPrimaryKey(listId);
					// 获取采购单名称、采购金额等采购单信息
					// 将purBusOrder内容拷贝到orderCustom
					BeanUtils.copyProperties(purBusList, listCustom);

					// 下边向orderCustom开始设置任务信息
					// 任务id、任务标识 、任务名称、任务负责人
					// 任务id
					listCustom.setTaskId(task.getId());
					// 任务标识
					listCustom.setTaskDefinitionKey(task.getTaskDefinitionKey());
					// 任务名称
					listCustom.setTaskName(task.getName());
					// 任务负责人
					listCustom.setAssignee(task.getAssignee());
					SysUser sysUser = sysUserMapper.selectByPrimaryKey(task.getAssignee());
                    listCustom.setRelName(sysUser.getUsername());
					orderList.add(listCustom);
				}
				return orderList;
	}

	@Override
	public void saveOrderSubmitStauts(String userid, String taskId) throws Exception {
		
		
		// 根据任务id和assignee查询该任务
		Task task = taskService.createTaskQuery().taskId(taskId)
				.taskAssignee(userid).singleResult();

		if (task != null) {
			
			ListCustom listCustom = new ListCustom();

			// 根据 任务对象 获取流程实例 id
			String processInstanceId = task.getProcessInstanceId();
			// 查询流程实例 对象
			ProcessInstance processInstance = runtimeService
					.createProcessInstanceQuery()
					.processInstanceId(processInstanceId).singleResult();
			// 从流程实例 对象 中获取businessKey
			String businessKey = processInstance.getBusinessKey();
			// 根据 businessKey查询采购单信息
			
			SysPurBusList purBusOrder = sysPurBusListMapper.selectByPrimaryKey(businessKey);
			
			BeanUtils.copyProperties(purBusOrder, listCustom);
			
			//流程变量，值 为orderCustom即采购单信息
			Map<String, Object> variables = new HashMap<String, Object>();
			variables.put("order", listCustom);

			// 设置流程变量，值 为采购单信息
			taskService.complete(taskId,variables);
			
			// System.out.println("完成任务：" + taskId);
		}
	}

	@Override
	public void saveOrderAuditStauts(String taskId, String userid, String listid, String audittype,
			ListAuditCustom listAuditCustom) throws Exception {
		// 提交审核向pur_bus_order_audit表插入一条记录
		listAuditCustom.setId(UUIDBuild.getUUID());
		listAuditCustom.setUserid(userid);
		listAuditCustom.setAudittype(audittype);
		listAuditCustom.setListid(listid);
		listAuditCustom.setCreatetime(new Date());
				sysPurBusListAuditMapper.insert(listAuditCustom);

				// 调用activiti的api执行任务完成操作，将流程向后推进一步

				// 根据任务id和assignee查询该任务
				Task task = taskService.createTaskQuery().taskId(taskId)
						.taskAssignee(userid).singleResult();

				if (task != null) {
					Map<String, Object> variables = new HashMap<>();
					if (audittype.equals("checkOrder")) {
						variables.put("firstAudit", listAuditCustom);
					}else if (audittype.equals("disposeOrder")) {
						variables.put("secondAudit", listAuditCustom);
					}
					// 说明assignee是该任务的办理人，有权限完成
					taskService.complete(taskId,variables);
					// System.out.println("完成任务：" + taskId);
				}

		
		
	}

	@Override
	public List<ListCustom> findActivityOrderList()throws Exception{
		// 创建查询对象
				ProcessInstanceQuery processInstanceQuery = runtimeService
						.createProcessInstanceQuery();

				// 设置查询条件
				// 流程定义 key
				String processDefinitionKey = ResourcesUtil.getValue(
						"diagrams.purchasingflow", "purchasingProcessDefinitionKey");
				// 指定 流程定义key只查询该类流程的实例，比如key为采购流程，只查询采购流程实例
				processInstanceQuery.processDefinitionKey(processDefinitionKey);

				// 当前排序字段
				processInstanceQuery.orderByProcessInstanceId().desc();

				// 获取查询列表
				List<ProcessInstance> list = processInstanceQuery.list();

				// 单独 定义一个list，list中包括自定义的pojo(OrderCustom包括 流程实例 信息和业务系统 信息)
				List<ListCustom> orderList = new ArrayList<ListCustom>();
				for (ProcessInstance processInstance : list) {

					ListCustom listCustom = new ListCustom();

					// 比如key为采购流程，这个key就是采购单id
					String businesskey = processInstance.getBusinessKey();

					// 根据 businessKey获取采购单信息
					SysPurBusList purBusOrder = sysPurBusListMapper
							.selectByPrimaryKey(businesskey);
					// 将采购单信息拷贝到orderCustom中
					BeanUtils.copyProperties(purBusOrder, listCustom);

					// 向orderCustom中填充流程实例 信息

					// 当前运行的结点
					listCustom.setActivityId(processInstance.getActivityId());

					orderList.add(listCustom);

				}
				return orderList;
	}

	@Override
	public List<ListCustom> findOrderTaskListByPid(String processInstanceId) throws Exception {
		// 创建查询对象，用于查询历史 任务
				HistoricTaskInstanceQuery historicTaskInstanceQuery = historyService
						.createHistoricTaskInstanceQuery();

				// 设置查询条件
				// 设置taskAssignee只查询某个用户的历史 任务
				// historicTaskInstanceQuery.taskAssignee(taskAssignee);

				// 指定 流程定义 key，只查询该流程下所有流程实例 所有历史 任务
				String processDefinitionKey = "purchasingflow";
				historicTaskInstanceQuery.processDefinitionKey(processDefinitionKey);

				// 指定 流程实例 id,只查询该 流程实例 执行的历史 任务，流程实例 的id可以完成也可以未完成的
				historicTaskInstanceQuery.processInstanceId(processInstanceId);

				// 添加排序，按照任务执行时间先后顺序
				historicTaskInstanceQuery.orderByHistoricTaskInstanceStartTime().asc();

				List<HistoricTaskInstance> list = historicTaskInstanceQuery.list();

				// 即使这里只查询activiti中的数据，不关联查询业务的数据，也要单独定义
				// List<OrderCustom>，为了通过service和activiti和控制层隔离（解耦）
				List<ListCustom> orderList = new ArrayList<ListCustom>();
				for (HistoricTaskInstance historicTaskInstance : list) {
					ListCustom listCustom = new ListCustom();

					listCustom.setTaskId(historicTaskInstance.getId());// 任务id
					listCustom.setTaskName(historicTaskInstance.getName());// 任务名称
					listCustom.setAssignee(historicTaskInstance.getAssignee());// 任务负责人
					SysUser sysUser = sysUserMapper.selectByPrimaryKey(historicTaskInstance.getAssignee());
					listCustom.setRelName(sysUser.getUsername());
					listCustom.setTaskDefinitionKey(historicTaskInstance
							.getTaskDefinitionKey());// 任务标识
					listCustom.setTask_startTime(historicTaskInstance.getStartTime());// 任务开始时间
					listCustom.setTask_endTime(historicTaskInstance.getEndTime());// 任务结束时间

					orderList.add(listCustom);
				}
				return orderList;
	}

	@Override
	public List<ListCustom> findOrderGroupTaskList(String userId) throws Exception {
		// 任务查询对象
				TaskQuery taskQuery = taskService.createTaskQuery();

				// 候选人
				String candidateUser = userId;
				// 指定候选人,根据候选人查询组任务
				taskQuery.taskCandidateUser(candidateUser);

				// 流程定义key
				String processDefinitionKey = ResourcesUtil.getValue(
						"diagrams.purchasingflow", "purchasingProcessDefinitionKey");

				taskQuery.processDefinitionKey(processDefinitionKey);

				List<Task> list = taskQuery.list();

				List<ListCustom> orderList = new ArrayList<ListCustom>();
				for (Task task : list) {

					ListCustom listCustom = new ListCustom();

					// 下边的代码同采购单处理列表代码...

					// 流程实例id
					String processInstanceId = task.getProcessInstanceId();
					// 根据流程实例id找到流程实例对象
					ProcessInstance processInstance = runtimeService
							.createProcessInstanceQuery()
							.processInstanceId(processInstanceId).singleResult();
					// 从流程实例对象中获取businessKey
					String businessKey = processInstance.getBusinessKey();
					// 根据businessKey查询业务系统
					// 采购单id
					String orderId = businessKey;
					SysPurBusList purBusOrder = sysPurBusListMapper
							.selectByPrimaryKey(orderId);
					// 获取采购单名称、采购金额等采购单信息
					// 将purBusOrder内容拷贝到orderCustom
					BeanUtils.copyProperties(purBusOrder, listCustom);

					// 下边向orderCustom开始设置任务信息
					// 任务id、任务标识 、任务名称
					// 任务id
					listCustom.setTaskId(task.getId());
					// 任务标识
					listCustom.setTaskDefinitionKey(task.getTaskDefinitionKey());
					// 任务名称
					listCustom.setTaskName(task.getName());

					orderList.add(listCustom);
				}

				return orderList;
	}

	@Override
	public void saveClaimTask(String taskId, String candidateUserId) throws Exception {
		// 根据候选人和组任务id查询，如果有记录说明该 候选人有资格拾取该 任务
				Task task = taskService.createTaskQuery().taskId(taskId)
						.taskCandidateUser(candidateUserId).singleResult();

				if (task != null) {
					// 任务拾取
					taskService.claim(taskId, candidateUserId);

					System.out.println("任务拾取成功");
				}	
	}

	@Override
	public List<ListCustom> findFinishedOrderList() throws Exception {

		// 创建历史流程实例 查询对象
		HistoricProcessInstanceQuery historicProcessInstanceQuery = historyService
				.createHistoricProcessInstanceQuery();

		// 设置查询条件
		// 指定流程定义key，只查询某个业务流程的实例
		String processDefinitionKey = ResourcesUtil.getValue(
				"diagrams.purchasingflow", "purchasingProcessDefinitionKey");
		historicProcessInstanceQuery.processDefinitionKey(processDefinitionKey);

		// 设置只查询已完成的流程实例
		historicProcessInstanceQuery.finished();

		// 添加排序，按结束时间降序
		historicProcessInstanceQuery.orderByProcessInstanceEndTime().desc();

		// 数据列表
		List<HistoricProcessInstance> list = historicProcessInstanceQuery
				.list();
		List<ListCustom> orderList = new ArrayList<ListCustom>();
		for (HistoricProcessInstance historicProcessInstance : list) {

			ListCustom listCustom = new ListCustom();
			// 业务标识
			String businessKey = historicProcessInstance.getBusinessKey();
			// 根据 businessKey获取采购单信息
			SysPurBusList purBusOrder = sysPurBusListMapper
					.selectByPrimaryKey(businessKey);
			// 将采购单信息拷贝到orderCustom中
			BeanUtils.copyProperties(purBusOrder, listCustom);

			// 设置activiti的数据到ordercustom中
			listCustom.setProcessInstance_startTime(historicProcessInstance
					.getStartTime());// 执行开始时间
			listCustom.setProcessInstance_endTime(historicProcessInstance
					.getEndTime());// 执行结束时间

			orderList.add(listCustom);

		}

		return orderList;
	}

}
