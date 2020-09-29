package com.manager.department.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.department.domain.Department;
import com.manager.department.service.DepartmentService;
import com.manager.department.service.IDepartmentService;

/**
 * Servlet implementation class DepartmentListServlet
 */
@WebServlet("/DepartmentListServlet")
public class DepartmentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		IDepartmentService ds = new DepartmentService();
		ArrayList<Department> deps = ds.queryDepartments();
		request.setAttribute("deps", deps);

		//response.sendRedirect("/Demo-0831/productInsert.jsp");
		//跳转：请求转发，发的一次请求
		request.getRequestDispatcher("/pages/department2/department_list.jsp").forward(request, response);
		
	}

}
