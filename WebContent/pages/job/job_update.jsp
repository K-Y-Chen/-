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

	</head>

	<body>
				<div class="cBody">
			<form id="addForm" class="layui-form" action="/code/JobUpdateServlet">
				<div class="layui-form-item">
					<label class="layui-form-label">岗位号</label>
					<div class="layui-input-inline shortInput">
						<%int jid = Integer.parseInt(request.getParameter("jid"));%> 
						<input type="text" name="id" value="<%=jid %>" required autocomplete="off" class="layui-input" readonly>
					</div>
					<i class="iconfont icon-huaban bt"></i>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label">岗位名称</label>
					<div class="layui-input-inline shortInput">
						<%String jname = request.getParameter("jname");%> 
						<input type="text" name="name" value="<%=jname %>" required autocomplete="off" class="layui-input">
					</div>
					<i class="iconfont icon-huaban bt"></i>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">岗位类型</label>
				    <div class="layui-input-inline">
				    <%String jtype = request.getParameter("jtype");%> 
				        <select name="type" id="type" required>
				      <option value ="manage">管理</option>
					  <option value ="tech">技术</option>
					  <option value ="mark">市场</option>
					  <option value ="sell">营销</option>
				        </select>
				    </div>
					<i class="iconfont icon-huaban bt"></i>
				</div>
				
				
				<div class="layui-form-item">
					<label class="layui-form-label">编制</label>
					<div class="layui-input-inline shortInput">
					<%String jsize = request.getParameter("jsize");%> 
						<input type="text" name="size" value="<%=jsize %>"  autocomplete="off" class="layui-input">
					</div>
					<i class="iconfont icon-huaban bt"></i>
				</div>

				
				
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit lay-filter="submitBut">立即提交</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</form>


		</div>
	</body>
</html>

		