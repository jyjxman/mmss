<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
<style>
.left {
	float: left;
}

.right {
	float: right;
}

.table tbody tr td {
	vertical-align: middle;
}

.modal .modal-body {
	padding: 20px 80px 0;
}

.modal .modal-body ul {
	list-style-type: none;
}

.modal .modal-body ul li {
	height: 32px;
	font-size: 14px;
}

.modal .modal-body ul li label {
	font-weight: normal;
	width: 70px;
	height: 15px;;
	margin: 0;
}

.modal .modal-body ul li label span {
	display: inline-block;
	float: right;
	vertical-align: middle;
	color: #666;
}

.modal .modal-body ul li input {
	width: 260px;;
}
/*覆盖bootstrap属性*/
.alert {
	padding: 5px;
}

fieldset {
	width: 100%;
	padding: 5px 25px;
	margin: 0;
	border: 1px solid #787B7D;
}

legend {
	width: auto;
	padding: 0;
	color: #787B7D;
	border: 0;
	border-bottom: 0px;
}
.table thead tr th{
text-align:center
}
</style>
</head>
 <link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/bootstrap-table.min.css" rel="stylesheet">
<link href="../css/animate.min.css" rel="stylesheet">
<link href="../css/style.min.css" rel="stylesheet">
<script type="text/javascript" src="../js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="../js/kkpager.min.js"></script>
<link rel="stylesheet" type="text/css" href="../css/kkpager_blue.css" />
<script src="../js/bootstrap.min.js"></script>

<body>
 <a class="btn btn-success" href="#">添加用户</a>
	<table class="table table-bordered  text-center table-striped">
									<thead>
										<tr class="info">
											<th>用户名</th>
											<th>真实名字</th>
											<th>联系地址</th>
											<th>联系电话</th>
											<th>状态</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${page.list }" var="user">
											<tr>
												<td>${user.usercode }</td>
												<td>${user.username }</td>
												<td>${user.adreess }</td>
												<td>${user.phone }</td>
												<c:if test="${user.locked =='0' }">
												<td>正常</td>
		                                       </c:if>
		                                       <c:if test="${user.locked =='1' }">
												<td>锁定</td>
		                                       </c:if>
												<td>
												    <a class="btn btn-warning" href="#">修改</a>
												    <a class="btn btn-primary" href="#">删除</a>
												</td>
										</c:forEach>
									</tbody>
								</table>
<div style="width:800px;margin:0 auto;">
<div id="kkpager"></div>
</div>
<script type="text/javascript">
function getParameter(name) { 
	var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); 
	var r = window.location.search.substr(1).match(reg); 
	if (r!=null) return unescape(r[2]); return null;
}
var ctx = '<%=request.getContextPath() %>';
//init
$(function(){
	var totalPage = ${page.pages};
	var totalRecords = ${page.total};
	var pageNo = getParameter('pageNum');
	console.log(pageNo);
	if(!pageNo){
		pageNo = 1;
	 }
	//生成分页
	//有些参数是可选的，比如lang，若不传有默认值

	kkpager.generPageHtml({
		pno : pageNo,
		//总页码
		total : totalPage,
		//总数据条数
		totalRecords : totalRecords,
		//链接前部
		hrefFormer : '${ctx}/user/manager',
		//链接尾部
		hrefLatter : '.do',
		getLink : function(n){
			return this.hrefFormer + this.hrefLatter + "?pageNum="+n;
		}
		/*
		,lang				: {
			firstPageText			: '首页',
			firstPageTipText		: '首页',
			lastPageText			: '尾页',
			lastPageTipText			: '尾页',
			prePageText				: '上一页',
			prePageTipText			: '上一页',
			nextPageText			: '下一页',
			nextPageTipText			: '下一页',
			totalPageBeforeText		: '共',
			totalPageAfterText		: '页',
			currPageBeforeText		: '当前第',
			currPageAfterText		: '页',
			totalInfoSplitStr		: '/',
			totalRecordsBeforeText	: '共',
			totalRecordsAfterText	: '条数据',
			gopageBeforeText		: '&nbsp;转到',
			gopageButtonOkText		: '确定',
			gopageAfterText			: '页',
			buttonTipBeforeText		: '第',
			buttonTipAfterText		: '页'
		}*/
		
		//,
		//mode : 'click',//默认值是link，可选link或者click
		//click : function(n){
		//	this.selectPage(n);
		//  return false;
		//}
	});
});
</script>
			
</body>
</html>