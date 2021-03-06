package com.mmss.vo;

import java.util.Date;

import com.mmss.pojo.SysPurBusList;

public class ListCustom extends SysPurBusList{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1950430187702871042L;

		//任务id
		private String taskId;
		
		//任务名称
		private String taskName;
		
		//任务标识 
		public String taskDefinitionKey;
		
		//任务负责人
		private String assignee;

		// 当前运行结点
		private String activityId;

		// 流程开始执行时间
		private Date processInstance_startTime;

		// 流程结束执行时间
		public Date processInstance_endTime;

		// 任务开始执行时间
		private Date task_startTime;
		
		//任务负责人姓名
		private String relName;

		// 任务结束执行时间
		public Date task_endTime;
		public String getTaskId() {
			return taskId;
		}

		public void setTaskId(String taskId) {
			this.taskId = taskId;
		}

		public String getTaskName() {
			return taskName;
		}

		public void setTaskName(String taskName) {
			this.taskName = taskName;
		}

		public String getTaskDefinitionKey() {
			return taskDefinitionKey;
		}

		public void setTaskDefinitionKey(String taskDefinitionKey) {
			this.taskDefinitionKey = taskDefinitionKey;
		}

		public String getAssignee() {
			return assignee;
		}

		public void setAssignee(String assignee) {
			this.assignee = assignee;
		}

		public String getActivityId() {
			return activityId;
		}

		public void setActivityId(String activityId) {
			this.activityId = activityId;
		}

		public Date getProcessInstance_startTime() {
			return processInstance_startTime;
		}

		public void setProcessInstance_startTime(Date processInstance_startTime) {
			this.processInstance_startTime = processInstance_startTime;
		}

		public Date getProcessInstance_endTime() {
			return processInstance_endTime;
		}

		public void setProcessInstance_endTime(Date processInstance_endTime) {
			this.processInstance_endTime = processInstance_endTime;
		}

		public Date getTask_startTime() {
			return task_startTime;
		}

		public void setTask_startTime(Date task_startTime) {
			this.task_startTime = task_startTime;
		}

		public Date getTask_endTime() {
			return task_endTime;
		}

		public void setTask_endTime(Date task_endTime) {
			this.task_endTime = task_endTime;
		}

		public String getRelName() {
			return relName;
		}

		public void setRelName(String relName) {
			this.relName = relName;
		}
		
		
		
}
