package com.manager.report;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.transfer.domain.Department;
import com.manager.transfer.domain.DepartmentTransfer;
import com.manager.transfer.domain.Staff;
import com.manager.transfer.service.DepartmentManagementService;
import com.manager.transfer.service.IDepartmentManagementService;
import com.manager.transfer.service.IStaffService;
import com.manager.transfer.service.StaffService;

/**
 * Servlet implementation class FormalExportServlet
 */
@WebServlet("/FormalExportServlet")
public class FormalExportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormalExportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		IStaffService iss = new StaffService();//通过部门名称查找转正员工
		Department dep = new Department();
		dep.setD_name("");//部门名称
		ArrayList<Staff> staffs = iss.queryStaffCheckByDepartment(dep);
		
// 操作导出excel
		//excel标题
		String title = "新聘员工报表";
		//excel列头信息
		String[] rowsName = new String[] { "员工编号", "姓名", "性别", "部门", "岗位", "入职日期"};
		List<Object[]> dataList = new ArrayList<Object[]>();
		Object[] objs = null;
		for (int i = 0; i < staffs.size(); i++) {
			Staff st = staffs.get(i);
		    objs = new Object[rowsName.length];
		    objs[0] = st.getS_id();
		    objs[1] = st.getS_name();
			objs[2] = st.getS_sex();
			objs[3] = st.getS_departmentId().getD_name();
			objs[4] = st.getS_jobId().getJ_name();
			objs[5] = st.getS_date();			
			dataList.add(objs);
	}
//给文件命名。随机命名
		String fileName = "Excel-" + String.valueOf(System.currentTimeMillis()).substring(4, 13) + ".xls";
		//告诉浏览器数据格式，将头和数据传到前台
		String headStr = "attachment; filename=\"" + fileName + "\"";
		response.setContentType("APPLICATION/OCTET-STREAM");
		response.setHeader("Content-Disposition", headStr);
		OutputStream out = response.getOutputStream();		
		//调用poi的工具类
		ExportExcel ex = new ExportExcel(title, rowsName, dataList);
		try {
		ex.export(out);
		} catch (Exception e) {
		e.printStackTrace();
		}
		out.flush();
		out.close();	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
