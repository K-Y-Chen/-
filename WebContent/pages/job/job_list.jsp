<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core_1_1" prefix="c" %>
<!DOCTYPE html>
<html>
		<head>
	<%
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" +request.getServerName() + ":" +
		request.getServerPort() + path;
	%>
	
		<script>
		function toUrl(url){			
			location.href = url;				
		}
	</script>
	<base href="<%=basePath%>">
	
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1">
		<!-- Google Chrome Frame也可以让IE用上Chrome的引擎: -->
		<meta name="renderer" content="webkit">
		<!--国产浏览器高速模式-->
		<meta name="viewport" content="width=device-width, initial-scale=1">		
		<meta name="keywords" content="搜索关键字，以半角英文逗号隔开" />
		<title>人事管理系统</title>

		<!-- 公共样式 开始 -->
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/base.css">
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/iconfont.css">
		<script type="text/javascript" src="<%=basePath%>/framework/jquery-1.11.3.min.js"></script>
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/layui/css/layui.css">
		<script type="text/javascript" src="<%=basePath%>/layui/layui.js"></script>
		<!-- 滚动条插件 -->
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/jquery.mCustomScrollbar.css">
		<script src="<%=basePath%>/framework/jquery-ui-1.10.4.min.js"></script>
		<script src="<%=basePath%>/framework/jquery.mousewheel.min.js"></script>
		<script src="<%=basePath%>/framework/jquery.mCustomScrollbar.min.js"></script>
		<script src="<%=basePath%>/framework/cframe.js"></script><!-- 仅供所有子页面使用 -->
		<!-- 公共样式 结束 -->

	</head>

<body>

		<div class="cBody">
			<div class="console">
			
				<form class="layui-form" action="/code/JobListServlet">
					<div class="layui-form-item">
						<button class="layui-btn" >刷新</button>
					</div>
				</form>
				
				<form class="layui-form" action="/code/JobSearchServlet">
					<div class="layui-form-item">
						<div class="layui-input-inline">
							<input type="text" name="jobname" required lay-verify="required" placeholder="输入岗位名称" autocomplete="off" class="layui-input">
						</div>
						<button class="layui-btn" >搜索</button>
					</div>
				</form>

				<script>
					layui.use('form', function() {
						var form = layui.form;
				
						//监听提交
						form.on('submit(formDemo)', function(data) {
							layer.msg(JSON.stringify(data.field));
							return false;
						});
					});
				</script>
			</div>

<table class="layui-table">
				<thead>
					<tr>
						<th>岗位号</th>
						<th>岗位名称</th>
						<th>岗位类型</th>
						<th>编制</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
	<c:forEach items="${requestScope.jobs }" var = "j">
		<tr>
			<td>${j.j_id }</td>
			<td>${j.j_name }</td>
			<td>${j.j_type }</td>
			<td>${j.j_size }</td>
			<td>
				<button type="submit" class="layui-btn" 
				onClick="javascript:toUrl('/code/StaffInJobServlet?name=${j.j_name }')">基本人员信息</button>
			</td>
		</tr>
	</c:forEach>
				</tbody>
			</table>
</body>
</html>