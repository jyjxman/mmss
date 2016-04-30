<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<%@ include file="/commons/basejs.jsp" %>
<title>物资调度单处理列表</title>
<script type="text/javascript">
	function queryorder() {
		$("#queryOrderForm").submit();

	}
	
	function PageQuery(page_index,page_size){
		$("#page_index").val(page_index);
		$("#page_size").val(page_size);
		queryorder();
	}
</script>

</head>
<body>

	<form id="queryOrderForm" name="queryOrderForm"
		action="${baseurl}/schedule/listTaskList"
		method="post">
		<input type="hidden" id="page_index" name="page_index" value="1"/>
		<input type="hidden" id="page_size" name="page_size" value="15"> 
		<!-- <TABLE class="table_search">
			<TBODY>
				<TR>
					<TD class="left">采购单号：</td>
					<td><input type="text" name="orderCustom.name" /></TD>
					<TD class="left">采购单名称：</TD>
					<td><INPUT type="text" name="orderCustom.name" /></TD>

					<td><a id="btn" href="#" onclick="queryorder()"
						class="easyui-linkbutton" iconCls='icon-search'>查询</a></td>
				</TR>

			</TBODY>
		</TABLE> -->

		<TABLE class="toptable grid" >
			<TBODY>
				<tr>
					<td>任务id</td>
					<td>任务名称</td>
					<td>任务标识</td>
					<td>所属流程实例id</td>
					<td>负责人</td>
					<td>物资调度单名称</td>
					<td>指派车辆编号</td>
					<td>申请调度内容</td>
					<td>创建时间</td>
					<td>任务类型</td>
				</tr>
				<c:forEach items="${list }" var="order">
					<tr>
						<td class=category>${order.taskId}</td>
						<td class=category>${order.taskName }</td>
						<td class=category>${order.taskDefinitionKey }</td>
						<td class=category>${order.processinstanceid }</td>
						<td class=category>${order.assignee}</td>
						<td class=category>${order.name}</td>
						<td class=category>${order.content}</td>
						<td class=category>${order.carid}</td>
						<td class=category><fmt:formatDate value="${order.createtime}"
								pattern="yyyy-MM-dd hh:mm:ss" /></td>
						<td class=category>
						  
						<c:if
								test="${order.taskDefinitionKey=='submitOrder' }">
								<a href="${baseurl}/schedule/submitOrder.action?taskId=${order.taskId}">提交调度单</a>

							</c:if> <c:if test="${order.taskDefinitionKey=='checkOrder' }">
								<a
									href="${baseurl}/schedule/orderAudit.action?taskId=${order.taskId}&auditType=${order.taskDefinitionKey}&listId=${order.id}">部门经理审核</a>

							</c:if> <c:if test="${order.taskDefinitionKey=='disposeOrder' }">
								<a
									href="${baseurl}/schedule/orderAudit.action?taskId=${order.taskId}&auditType=${order.taskDefinitionKey}&listId=${order.id}">总经理审核</a>

							</c:if> 
						 
					
						</td>
					</tr>
				</c:forEach>
			</TBODY>
		</TABLE>

		
	</form>

</body>
</html>