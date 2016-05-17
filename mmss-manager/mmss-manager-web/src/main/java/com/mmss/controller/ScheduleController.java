package com.mmss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mmss.service.user.ScheduleService;
import com.mmss.vo.ListCustom;
import com.mmss.vo.ListVo;

@Controller
@RequestMapping("/schedule")
public class ScheduleController extends BaseController {

	@Autowired
	private ScheduleService scheduleService;

	// 创建物资调度单页面方法
	@RequestMapping("/addList")
	public String addList(Model model) throws Exception {

		return "/workflow/addList";
	}

	// 创建物资调度单保存
	@RequestMapping("/addListSave")
	public String addOrderSave(ListVo listVo) throws Exception {

		// 用户id
		String userId = getCurrentUser().getId();

		// 调用 service保存调度单
		scheduleService.saveList(userId, listVo.getListCustom());

		// 返回到调度单处理列表
		return "redirect:listTaskList.do";
	}

	// 调度单单处理列表
	@RequestMapping("/listTaskList")
	public String orderTaskList(Model model) throws Exception {

		// 用户id
		String userId = getCurrentUser().getId();
		List<ListCustom> list = scheduleService.findListTaskList(userId);

		model.addAttribute("list", list);

		return "/workflow/listTaskList";
	}

	@RequestMapping("/submitOrder")
	public String submitOrder(String taskId) throws Exception {

		// 用户id
		String userId = getCurrentUser().getId();
		scheduleService.saveOrderSubmitStauts(userId, taskId);

		// 返回到采购单处理列表
		return "redirect:listTaskList.do";
	}

	@RequestMapping("/orderAudit")
	public String orderAudit(Model model, String taskId, String listId, String auditType) throws Exception {

		model.addAttribute("taskId", taskId);
		model.addAttribute("orderId", listId);
		model.addAttribute("auditType", auditType);

		return "/workflow/listAudit";
	}

	// 提交审核
	@RequestMapping("/submitOrderAudit")
	public String submitOrderAudit(String taskId, String listId, String auditType, ListVo listVo) throws Exception {

		// 用户id
		String userId = getCurrentUser().getId();
		scheduleService.saveOrderAuditStauts(taskId, userId, listId, auditType, listVo.getListAuditCustom());

		// 返回到采购单处理列表
		return "redirect:listTaskList.do";
	}

	// 当前运行采购流程查询
	@RequestMapping("/queryActivityOrder")
	public String queryActivityOrder(Model model) throws Exception {
		// 获取当前运行采购流程列表
		List<ListCustom> list = scheduleService.findActivityOrderList();
		model.addAttribute("list", list);

		return "/workflow/queryActivityOrder";

	}

	// 结束流程查询
	@RequestMapping("/queryHistoryOrder")
	public String queryHistoryOrder(Model model) throws Exception {

		// 已结束的流程实例
		List<ListCustom> list = scheduleService.findFinishedOrderList();
		model.addAttribute("list", list);

		return "/workflow/queryHistoryOrder";
	}

	// 根据 流程实例 id查询历史任务
	@RequestMapping("/queryOrderTaskByPid")
	public String queryOrderTaskByPid(Model model, String processInstanceId) throws Exception {

		List<ListCustom> list = scheduleService.findOrderTaskListByPid(processInstanceId);

		model.addAttribute("list", list);

		return "/workflow/queryOrderTaskByPid";
	}

	// 采购单组任务列表
	@RequestMapping("/orderGroupTaskList")
	public String orderGroupTaskList(Model model) throws Exception {

		// 用户id
		String userId = getCurrentUser().getId();
		List<ListCustom> list = scheduleService.findOrderGroupTaskList(userId);

		model.addAttribute("list", list);

		return "/workflow/orderGroupTaskList";
	}

	// 拾取组任务
	@RequestMapping("/claimTask")
	public String claimTask(String taskId) throws Exception {

		// 用户id
		String userId = getCurrentUser().getId();
		scheduleService.saveClaimTask(taskId, userId);

		// 返回采购单组任务列表
		return "redirect:orderGroupTaskList.action";
	}
}
