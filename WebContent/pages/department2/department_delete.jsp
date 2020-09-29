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

	<script>
		function checkDelete(url){
			if(confirm("确定删除该部门吗？")){
				//删除
				location.href = url;
			}
			else{
				//放弃删除
			}
				
		}
		function checkUpdate(url){
			if(confirm("确定修改该部门吗？")){
				//
				location.href = url;
			}
			else{
				//放弃
			}
				
		}
	</script>

</head>

<body>
				<form class="layui-form" action="/code/DepartmentDeleteServlet">
					<div class="layui-form-item">
						<button class="layui-btn"  type="submit">刷新</button>
					</div>
				</form>


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
				<a href="code/pages/department2/department_update.jsp?dname=${d.d_name }&did=${d.d_id }&
				dtype=${d.d_type }&dtel=${d.d_tel }&ddate=${d.d_date }">修改信息</a>
				
				
				<a href="javascript:checkDelete('/code/DepDoDeleteServlet?dname=${d.d_name }&did=${d.d_id }&
				dtype=${d.d_type }&dtel=${d.d_tel }&ddate=${d.d_date }')">删除部门</a>			

			</td>
		</tr>
	</c:forEach>
				</tbody>
			</table>
</body>
</html>