package com.manager.employee.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.employee.domain.Employee;
import com.manager.employee.service.EmployeeService;
import com.manager.employee.service.IEmployeeService;


/**
 * Servlet implementation class EmployeeQuery
 */
@WebServlet("/EmployeeQueryServlet")
public class EmployeeQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeQueryServlet() {
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
		String employeeName = request.getParameter("employeename");
		IEmployeeService ps = new EmployeeService();
//		System.out.println(employeeName);
		if(employeeName == null) {
			employeeName = "";
		}
		ArrayList<Employee> employees = ps.queryEmployee(employeeName);
		
		request.setAttribute("es", employees);
		request.getRequestDispatcher("/pages/staff/staff_list.jsp").forward(request, response);
		
	}

}
