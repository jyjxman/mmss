<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1 , user-scalable=no">
<%@ include file="../common/global.jsp"%>
<link href="${ctx}/css/bootstrap-table.min.css" rel="stylesheet">
<link href="${ctx}/css/animate.min.css" rel="stylesheet">
<link href="${ctx}/css/style.min.css" rel="stylesheet">
<title>流程列表</title>
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
</style>
</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="ibox float-e-margins">
			<div class="ibox-title">
				<div class="ibox-tools">
					<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
					</a> <a class="close-link"> <i class="fa fa-times"></i>
					</a>
				</div>
			</div>
			<div class="ibox-content">
				<div class="row row-lg">
					<div class="col-sm-12">
						<div class="example-wrap">
							<div class="example">
								<p class="right">
									<span class="alert alert-info" role="alert"><strong>提示：</strong>点击xml或者png链接可以查看具体内容</span>
									<button class="btn btn-primary" type="button"
										data-toggle="collapse" data-target="#arrange"
										aria-expanded="false">
										<i class="glyphicon glyphicon-folder-open"></i> 文件部署
									</button>
								</p>

								<fieldset id="arrange" class="collapse">
									<legend>部署新流程</legend>
									<p>
										<strong>支持文件格式：</strong>zip、bar、bpmn、bpmn20.xml
									</p>
									<form action="${ctx }/workflow/deploy.do" method="post"
										enctype="multipart/form-data">
										<input type="file" name="file" /> <input type="submit"
											value="提交" />
									</form>
								</fieldset>

								<br />
								<table class="table table-bordered  text-center table-striped">
									<thead>
										<tr class="info">
											<th>流程实例号</th>
											<th>流程部署号</th>
											<th>名称</th>
											<th>KEY</th>
											<th>版本号</th>
											<th>XML</th>
											<th>图片</th>
											<th>部署时间</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${page.result }" var="object">
											<c:set var="process" value="${object[0] }" />
											<c:set var="deployment" value="${object[1] }" />
											<tr>
												<td>${process.id }</td>
												<td>${process.deploymentId }</td>
												<td>${process.name }</td>
												<td>${process.key }</td>
												<td>${process.version }</td>
												<td><a target="_blank"
													href='${ctx }/workflow/resource/read?processDefinitionId=${process.id}&resourceType=xml'>${process.resourceName }</a></td>
												<td><a target="_blank"
													href='${ctx }/workflow/resource/read?processDefinitionId=${process.id}&resourceType=image'>${process.diagramResourceName }</a></td>
												<td>${deployment.deploymentTime }</td>
												
												<td><a class="btn btn-warning"
													href='${ctx }/workflow/process/delete?deploymentId=${process.deploymentId}'>删除</a>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<tags:pagination page="${page}"
									paginationSize="${page.pageSize}" />
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>