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
			<form id="addForm" class="layui-form" action="/code/EmployeeDoUpdateServlet">
				<div class="layui-form-item">
					<label class="layui-form-label">员工号</label>
					<div class="layui-input-inline shortInput">
						<input type="text" name="employeeid" value="${requestScope.employee.employeeid }" required autocomplete="off" class="layui-input" readonly>
					</div>
					<i class="iconfont icon-huaban bt"></i>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label">员工姓名</label>
					<div class="layui-input-inline shortInput"> 
						<input type="text" name="employeename" value="${requestScope.employee.employeename }" required autocomplete="off" class="layui-input">
					</div>
					<i class="iconfont icon-huaban bt"></i>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label">性别</label>
					<div class="layui-input-inline shortInput"> 
						<input type="text" name="employeesex" value="${requestScope.employee.employeesex }" required autocomplete="off" class="layui-input">
					</div>
					<i class="iconfont icon-huaban bt"></i>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label">出生日期</label>
					<div class="layui-input-inline shortInput"> 
						<input type="text" name="employeebirthday" value="${requestScope.employee.employeebirthday}"  autocomplete="off" class="layui-input">
					</div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label">部门</label>
				    <div class="layui-input-inline">
				    
				<select name="department" id="id1">
				
				<c:forEach items="${requestScope.departmentname}" var="ed" >
					<c:if test="${ed.departmentid == requestScope.employee.employeedepartment.departmentid}">
						<option value="${ed.departmentid }" selected>${ed.departmentname }</option>
					</c:if>
					<c:if test="${ed.departmentid != requestScope.employee.employeedepartment.departmentid}">
						<option value="${ed.departmentid }" >${ed.departmentname }</option>
					</c:if>
					
				</c:forEach>
				</select> 
				    </div>
					<i class="iconfont icon-huaban bt"></i>
				</div>
				
				
				
				<div class="layui-form-item">
					<label class="layui-form-label">岗位类型</label>
				    <div class="layui-input-inline">
				    
		<select name="job" id="id2">
				
				<c:forEach items="${requestScope.jobname}" var="ej" >
					<c:if test="${ej.jobid == requestScope.employee.employeejob.jobid}">
						<option value="${ej.jobid }" selected>${ej.jobname }</option>
					</c:if>
					<c:if test="${ej.jobid != requestScope.employee.employeejob.jobid}">
						<option value="${ej.jobid }" >${ej.jobname }</option>
					</c:if>
					
				</c:forEach>
		</select> 
				    </div>
					<i class="iconfont icon-huaban bt"></i>
				</div>
				
								
				<div class="layui-form-item">
					<label class="layui-form-label">入职日期</label>
					<div class="layui-input-inline shortInput">
						<input type="text" name="employeedate" value="${requestScope.employee.employeedate}"  autocomplete="off" class="layui-input">
					</div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label">参加工作日期</label>
					<div class="layui-input-inline shortInput">
						<input type="text" name="enployeejsdate" value="${requestScope.employee.enployeejsdate}"  autocomplete="off" class="layui-input">
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">用工形式</label>
					<div class="layui-input-inline shortInput">
						<input type="text" name="employeeinformation" value="${requestScope.employee.employeeinformation}"  autocomplete="off" class="layui-input">
					</div>
					<i class="iconfont icon-huaban bt"></i>
				</div>


				<div class="layui-form-item">
					<label class="layui-form-label">人员来源</label>
					<div class="layui-input-inline shortInput">
						<input type="text" name="employeesource" value="${requestScope.employee.employeesource}"  autocomplete="off" class="layui-input">
					</div>
					<i class="iconfont icon-huaban bt"></i>
				</div>


				<div class="layui-form-item">
					<label class="layui-form-label">联系方式</label>
					<div class="layui-input-inline shortInput">
						<input type="text" name="employeetel" value="${requestScope.employee.employeetel}"  autocomplete="off" class="layui-input">
					</div>
				</div>


				<div class="layui-form-item">
					<label class="layui-form-label">电子邮件</label>
					<div class="layui-input-inline shortInput">
						<input type="text" name="employeemali" value="${requestScope.employee.employeemali}"  autocomplete="off" class="layui-input">
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">最高学历</label>
					<div class="layui-input-inline shortInput">
						<input type="text" name="employeeeducation" value="${requestScope.employee.employeeeducation}"  autocomplete="off" class="layui-input">
					</div>
					<i class="iconfont icon-huaban bt"></i>
				</div>


				<div class="layui-form-item">
					<label class="layui-form-label">工作经历</label>
					<div class="layui-input-inline shortInput">
						<input type="text" name="employeeexperience" value="${requestScope.employee.employeeexperience}"  autocomplete="off" class="layui-input">
					</div>
				</div>


				<div class="layui-form-item">
					<label class="layui-form-label">该经历起始年月</label>
					<div class="layui-input-inline shortInput">
						<input type="text" name="employeeesdate" value="${requestScope.employee.employeeesdate}"  autocomplete="off" class="layui-input">
					</div>
				</div>
				
				
				<div class="layui-form-item">
					<label class="layui-form-label">该经历结束年月</label>
					<div class="layui-input-inline shortInput">
						<input type="text" name="employeeeedate" value="${requestScope.employee.employeeeedate}"  autocomplete="off" class="layui-input">
					</div>
				</div>
				


				<div class="layui-form-item">
					<label class="layui-form-label">外国语种</label>
					<div class="layui-input-inline shortInput">
						<input type="text" name="employeeflanguage" value="${requestScope.employee.employeeflanguage}"  autocomplete="off" class="layui-input">
					</div>
					<i class="iconfont icon-huaban bt"></i>
				</div>


				<div class="layui-form-item">
					<label class="layui-form-label">员工亲属姓名</label>
					<div class="layui-input-inline shortInput">
						<input type="text" name="employeefname" value="${requestScope.employee.employeefname}"  autocomplete="off" class="layui-input">
					</div>
				</div>


				<div class="layui-form-item">
					<label class="layui-form-label">员工亲属关系</label>
					<div class="layui-input-inline shortInput">
						<input type="text" name="employeefrelation" value="${requestScope.employee.employeefrelation}"  autocomplete="off" class="layui-input">
					</div>
					<i class="iconfont icon-huaban bt"></i>
				</div>


				<div class="layui-form-item">
					<label class="layui-form-label">是否离职</label>
					<div class="layui-input-inline shortInput">
						<input type="text" name="employeedismission" value="${requestScope.employee.employeedismission}"  autocomplete="off" class="layui-input">
					</div>
					<i class="iconfont icon-huaban bt"></i>
				</div>


				<div class="layui-form-item">
					<label class="layui-form-label">身份证号</label>
					<div class="layui-input-inline shortInput">
						<input type="text" name="employeeidnum" value="${requestScope.employee.employeeidnum}"  autocomplete="off" class="layui-input">
					</div>
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

		