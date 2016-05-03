<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/commons/basejs.jsp" %>
<title>结束运行物资调度流程查询</title>
<script type="text/javascript">
	function queryorder() {
		$("#queryOrderForm").submit();

	}
</script>

</head>
<body>

	<form id="queryOrderForm" name="queryOrderForm"
		action="${baseurl}/schedule/queryHistoryOrder.do" method="post">

		

		<TABLE class="toptable grid">
			<TBODY>
				<tr>
					<td>流程实例id</td>
					<td>物资调度单名称</td>
					<td>指定车辆编号</td>
					<td>调度内容</td>
					<td>创建时间</td>
					<td>结束时间</td>
					<td>查看任务</td>

				</tr>
				<c:forEach items="${list}" var="order">
					<tr>
						<td class=category>${order.processinstanceid}</td>
						<td class=category>${order.name}</td>
						<td class=category>${order.carid}</td>
						<td class=category>${order.content}</td>
						<td class=category><fmt:formatDate
								value="${order.processInstance_startTime}" pattern="yyyy-MM-dd hh:mm:ss" /></td>
						<td class=category><fmt:formatDate
								value="${order.processInstance_endTime}" pattern="yyyy-MM-dd hh:mm:ss" /></td>
						<td class=category><a
							href="${baseurl}/schedule/queryOrderTaskByPid.action?processInstanceId=${order.processinstanceid}"
							target="_blank">查看任务</a></td>
						
					</tr>
				</c:forEach>
			</TBODY>
		</TABLE>

	</form>

</body>
</html>