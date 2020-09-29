package com.manager.transfer.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.transfer.domain.Department;
import com.manager.transfer.domain.DepartmentTransfer;
import com.manager.transfer.domain.Staff;
import com.manager.transfer.service.DepartmentManagementService;
import com.manager.transfer.service.DepartmentService;
import com.manager.transfer.service.IDepartmentManagementService;
import com.manager.transfer.service.IDepartmentService;
import com.manager.transfer.service.IStaffService;
import com.manager.transfer.service.StaffService;

/**
 * Servlet implementation class DepTransServlet
 */
@WebServlet("/DepTransServlet")
public class DepTransServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepTransServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");		
		IStaffService isss =new StaffService();
		int s_id = Integer.parseInt(request.getParameter("sid"));System.out.println(s_id);
		String preName = request.getParameter("prename");System.out.println(preName);
		String name = request.getParameter("name");System.out.println(name);

		//插入部门调动信息
		IDepartmentManagementService idms = new DepartmentManagementService();
		
		//获得调转部门id
		IDepartmentService ids = new DepartmentService();
		Department dep1 = ids.queryIdDepartmentsByName(preName);//通过部门名称调转前部门id
		Department dep2 = ids.queryIdDepartmentsByName(name);//通过部门名称调转后部门id

		Staff s = new Staff();
		s.setS_id(s_id);		//员工id
		String type = "主动调动";//主动调动，被动调动，数据错误 三种类型
		DepartmentTransfer dt = new DepartmentTransfer(dep1,dep2,s,type,"无","2020-02-02");
		idms.insertDepartmentTransfer(dt);
		
		//更新员工的部门信息
		s.setS_departmentId(dep2);
		isss.updateStaffDepartmentById(s);
		response.sendRedirect("pages/transfer/jumpToStaffListServletForDep.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
