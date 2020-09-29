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
		function toUrl(url){			
			location.href = url;				
		}
	</script>
	</head>
	
	
<body>
		<div class="cBody">
			<div class="console">
				<form class="layui-form" action="">
					<div class="layui-form-item">
						<div class="layui-input-inline">
							<input type="text" name="dname" required lay-verify="required" placeholder="输入部门名称" autocomplete="off" class="layui-input">
						</div>
						<button class="layui-btn layui-btn-xs" type="submit"
				onClick="javascript:toUrl('/code//SearchFormalServlet')">检索</button>
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
						<th>员工号</th>
						<th>姓名</th>
						<th>性别</th>
						<th>部门</th>
						<th>岗位</th>
						<th>计划离职日期</th>
						<th>离职类型</th>
						<th>进入人才库</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${requestScope.st }" var = "s">
				<form action="/code/DoDismissionServlet?">
				<tr>
							<td>
								<input type="text" name="sid" readonly value="${s.s_id }" required 
								autocomplete="off" class="layui-input">
							</td>
							
							<td>
								<input type="text" readonly value="${s.s_name }" required 
								autocomplete="off" class="layui-input">
							</td>
							
							<td>
								<input type="text" readonly value="${s.s_sex }" required 
								autocomplete="off" class="layui-input">
							</td>
							
							<td>
								<input type="text" readonly value="${s.s_departmentId.d_name }" required 
								autocomplete="off" class="layui-input">
							</td>
							
							<td>
								<input type="text" readonly value="${s.s_jobId.j_name }" required 
								autocomplete="off" class="layui-input">
							</td>


							<td>
								<input type="text" name="date" value="1970-01-01"autocomplete="off" class="layui-input">
							</td>
							
							
							<td>
							
								<select name="type" class="layui-option">
						     		 <option class="layui-option" value ="主动辞职">主动辞职</option>
							 		 <option class="layui-option" value ="辞退">辞退</option>
							 		 <option class="layui-option" value ="退休">退休</option>
									 <option class="layui-option" value ="开除">开除</option>
							 		 <option class="layui-option" value ="试用期未通过">试用期未通过</option>
							 	</select>
					 	
				        	</td>
				        	<td>
								<input name="result" type="radio" value="1">是</input>
								<input name="result" type="radio" value="0">否	</input>
								<button class="layui-btn layui-btn-xs" type="submit">确定</button>			
							</td>	
				</tr>
				</form>
				</c:forEach>
				</tbody>
			</table>
			<!-- layUI 分页模块 -->
			<div id="pages"></div>
			<script>
				layui.use(['laypage', 'layer'], function() {
					var laypage = layui.laypage,
						layer = layui.layer;
				
					//总页数大于页码总数
					laypage.render({
					    elem: 'pages'
					    ,count: 100
					    ,layout: ['count', 'prev', 'page', 'next', 'limit', 'skip']
					    ,jump: function(obj){
					      console.log(obj)
					    }
					});
				});
			</script>
		</div>
	</body>

</html>