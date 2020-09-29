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
			<form id="addForm" class="layui-form" action="/code/StaffEntryServlet">
				
				
				<div class="layui-form-item">
					<label class="layui-form-label">员工姓名</label>
					<div class="layui-input-inline shortInput"> 
						<input type="text" name="S_NAME"  required autocomplete="off" class="layui-input">
					</div>
					<i class="iconfont icon-huaban bt"></i>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label">性别</label>
				    <div class="layui-input-inline">
				        <select name="S_SEX" id="type" required>
				      <option value ="男">男</option>
					  <option value ="女">女</option>
				        </select>
				    </div>				    
					<i class="iconfont icon-huaban bt"></i>
				</div>
				
				
				<div class="layui-form-item">
					<label class="layui-form-label">出生日期</label>
					<div class="layui-input-inline shortInput"> 
						<input type="text" name="S_BIRTHDAY"  value="1970-01-01" autocomplete="off" class="layui-input">
					</div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label">部门</label>
				    <div class="layui-input-inline">
				    
				<select name="S_DEPARTMENTNAME" id="id1">
				
				<c:forEach items="${requestScope.departmentname}" var="ed" >
					
						<option value="${ed.departmentname }" >${ed.departmentname }</option>
					
				</c:forEach>
				</select> 
				    </div>
					<i class="iconfont icon-huaban bt"></i>
				</div>
				
				
				
				<div class="layui-form-item">
					<label class="layui-form-label">岗位类型</label>
				    <div class="layui-input-inline">
				    
		<select name="S_JOBNAME" id="id2">
				
				<c:forEach items="${requestScope.jobname}" var="ej" >
					<option value="${ej.jobname }" >${ej.jobname }</option>
					
				</c:forEach>
		</select> 
				    </div>
					<i class="iconfont icon-huaban bt"></i>
				</div>
				
								
				<div class="layui-form-item">
					<label class="layui-form-label">入职日期</label>
					<div class="layui-input-inline shortInput">
						<input type="text" name="S_DATE" value="1970-01-01"  autocomplete="off" class="layui-input">
					</div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label">参加工作日期</label>
					<div class="layui-input-inline shortInput">
						<input type="text" name="S_JSDATE" value="1970-01-01"  autocomplete="off" class="layui-input">
					</div>
				</div>

			
				<div class="layui-form-item">
					<label class="layui-form-label">用工形式</label>
				    <div class="layui-input-inline">
				        <select name="S_EINFORMATION" id="type" required>
				      <option value ="正式员工">正式员工</option>
					  <option value ="临时员工">临时员工</option>
				        </select>
				    </div>				    
					<i class="iconfont icon-huaban bt"></i>
				</div>


				<div class="layui-form-item">
					<label class="layui-form-label">人员来源</label>
				    <div class="layui-input-inline">
				        <select name="S_PSOURCE" id="type" required>
				      <option value ="其他">其他</option>
					  <option value ="社会招聘">社会招聘</option>
					  <option value ="校园招聘">校园招聘</option>
				        </select>
				    </div>				    
					<i class="iconfont icon-huaban bt"></i>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">联系方式</label>
					<div class="layui-input-inline shortInput">
						<input type="text" name="S_TEL"   autocomplete="off" class="layui-input">
					</div>
				</div>


				<div class="layui-form-item">
					<label class="layui-form-label">电子邮件</label>
					<div class="layui-input-inline shortInput">
						<input type="text" name="S_EMAIL"   autocomplete="off" class="layui-input">
					</div>
				</div>


				
				<div class="layui-form-item">
					<label class="layui-form-label">最高学历</label>
				    <div class="layui-input-inline">
				        <select name="S_EDUCATION" id="type" required>
				      <option value ="高中及以下">高中及以下</option>
				      <option value ="本科">本科</option>
					  <option value ="大专">大专</option>
					  <option value ="研究生">研究生</option>
					  <option value ="无">无</option>

				        </select>
				    </div>				    
					<i class="iconfont icon-huaban bt"></i>
				</div>

				


				<div class="layui-form-item layui-form-text">
					<label class="layui-form-label">工作经历</label>
					<div class="layui-input-block">
						<textarea name="S_EXPERIENCE" id="editor" placeholder="请输入内容" style="display: none;"></textarea>
						<script>
							layui.use('layedit', function() {
								var layedit = layui.layedit;
								//插入图片接口配置，要求接口返回的格式JSON如下
								/*{
								  "code": 0 //0表示成功，其它失败
								  ,"msg": "" //提示信息 //一般上传失败后返回
								  ,"data": {
								    "src": "图片路径"
								    ,"title": "图片名称" //可选
								  }
								}*/
								layedit.set({
									uploadImage: {
										url: '' //接口url
									}
								});
								layedit.build('editor', {
									tool: [
										'strong' //加粗
										, 'italic' //斜体
										, 'underline' //下划线
										, 'del' //删除线
										, '|' //分割线
										, 'left' //左对齐
										, 'center' //居中对齐
										, 'right' //右对齐
										, '|' //分割线
										, 'link' //超链接
										, 'unlink' //清除链接
										, 'face' //表情
										, 'image' //插入图片
									]
								}); //建立编辑器						
							});
						</script>
					</div>
				</div>
				
				
				<div class="layui-form-item">
					<label class="layui-form-label">该经历起始年月</label>
					<div class="layui-input-inline shortInput">
						<input type="text" name="S_ESDATE" value="1970-01-01"  autocomplete="off" class="layui-input">
					</div>
				</div>
				
				
				<div class="layui-form-item">
					<label class="layui-form-label">该经历结束年月</label>
					<div class="layui-input-inline shortInput">
						<input type="text" name="S_EESDATE" value="1970-01-01"  autocomplete="off" class="layui-input">
					</div>
				</div>


				<div class="layui-form-item">
					<label class="layui-form-label">外国语种</label>
				    <div class="layui-input-inline">
				        <select name="S_FLANGUAGE" id="type" required>
				      <option value ="英语">英语</option>
					  <option value ="法语">法语</option>
					  <option value ="日语">日语</option>
					  <option value ="无">无</option>
				        </select>
				    </div>				    
					<i class="iconfont icon-huaban bt"></i>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">员工亲属姓名</label>
					<div class="layui-input-inline shortInput">
						<input type="text" name="S_FNAME"   autocomplete="off" class="layui-input">
					</div>
				</div>



				<div class="layui-form-item">
					<label class="layui-form-label">员工亲属关系</label>
				    <div class="layui-input-inline">
				        <select name="S_FRELATION" id="type" required>
				      <option value ="父亲">父亲</option>
					  <option value ="母亲">母亲</option>
					  <option value ="配偶">配偶</option>
					  <option value ="空">空</option>
				        </select>
				    </div>				    
					<i class="iconfont icon-huaban bt"></i>
				</div>

				
				<div class="layui-form-item">
					<label class="layui-form-label">身份证号</label>
					<div class="layui-input-inline shortInput">
						<input type="text" name="S_IDNUM"  autocomplete="off" class="layui-input">
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

		