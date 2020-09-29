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
			
				<form class="layui-form" action="/code/DepartmentListServlet">
					<div class="layui-form-item">
						<button class="layui-btn" >刷新</button>
					</div>
				</form>
				
				<form class="layui-form" action="/code/DepartmentSearchServlet">
					<div class="layui-form-item">
						<div class="layui-input-inline">
							<input type="text" name="depname" required lay-verify="required" placeholder="输入部门名称" autocomplete="off" class="layui-input">
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
						<th>部门号</th>
						<th>部门名称</th>
						<th>部门类型</th>
						<th>联系方式</th>
						<th>成立日期</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
	<c:forEach items="${requestScope.deps }" var = "d">
		<tr>
			<td>${d.d_id }</td>
			<td>${d.d_name }</td>
			<td>${d.d_type }</td>
			<td>${d.d_tel }</td>
			<td>${d.d_date }</td>
			<td>
				<button type="submit" class="layui-btn" 
				onClick="javascript:toUrl('/code/StaffInDepServlet?name=${d.d_name }')">基本人员信息</button>
			</td>
		</tr>
	</c:forEach>
				</tbody>
			</table>
</body>
</html>