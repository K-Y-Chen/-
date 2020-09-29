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
			<div class="console">
				<script>
					layui.use('form', function() {
						var form = layui.form;
				
						//监听提交
						form.on('submit(formDemo)', function(data) {
							layer.msg(JSON.stringify(data.field));
							return false;
						});
					});
					function checkEntry(url){
						if(confirm("确定员工入职选项？")){
							//
							location.href = url;
						}
						else{
							//放弃
						}
							
					}
				</script>
			</div>
			
			
			<table class="layui-table">
				<thead>
					<tr>
						<th>流水号</th>
						<th>员工号</th>
						<th>姓名</th>
						<th>离职时间</th>
						<th>类型</th>
						<th>是否进入人才库</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${requestScope.ds }" var = "ds">
						<tr>
							<td>${ds.d_id }</td>
							<td>${ds.d_staffId.s_id }</td>
							<td>${ds.d_staffId.s_name }</td>
							<td>${ds.d_date }</td>
							<td>${ds.d_type }</td>
							<td>${ds.d_pool }</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		<script>					
				function toUrl(url){			
					location.href = url;				
				}
		</script>
			<button type="submit" class="layui-btn" onClick="javascript:toUrl('/code/DismissionExportServlet')">
			导出表格
			</button>		
			
				
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