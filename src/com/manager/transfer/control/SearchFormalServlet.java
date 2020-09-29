package com.manager.transfer.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.transfer.domain.Department;
import com.manager.transfer.domain.Staff;
import com.manager.transfer.service.IStaffService;
import com.manager.transfer.service.StaffService;

/**
 * Servlet implementation class SearchFormalServlet
 */
@WebServlet("/SearchFormalServlet")
public class SearchFormalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchFormalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String d_name = request.getParameter("dname");
		if (d_name == null) d_name = "";
		IStaffService iss = new StaffService();//通过部门名称查找转正员工
		Department dep = new Department();
		dep.setD_name(d_name);//部门名称
		ArrayList<Staff> staffs = iss.queryStaffCheckByDepartment(dep);
		
		request.setAttribute("st",staffs);
		request.getRequestDispatcher("pages/transfer/formal_list.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
