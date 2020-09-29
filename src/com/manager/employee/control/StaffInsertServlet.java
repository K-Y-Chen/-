package com.manager.employee.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.employee.domain.Department;
import com.manager.employee.domain.Employee;
import com.manager.employee.domain.Job;
import com.manager.employee.service.DepartmentService;
import com.manager.employee.service.EmployeeService;
import com.manager.employee.service.IDepartmentService;
import com.manager.employee.service.IEmployeeService;
import com.manager.employee.service.IJobService;
import com.manager.employee.service.JobService;

/**
 * Servlet implementation class StaffInsertServlet
 */
@WebServlet("/StaffInsertServlet")
public class StaffInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaffInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int eid = 1;
		IEmployeeService ps = new EmployeeService();
		Employee p =ps.queryEmployeeByID(eid);
		
		IDepartmentService dns = new DepartmentService();
		ArrayList<Department> dname = dns.queryDepartment();
		
		IJobService jns = new JobService();
		ArrayList<Job> jname = jns.queryJob();
		
		request.setAttribute("departmentname", dname);
		request.setAttribute("jobname", jname);
		request.setAttribute("employee", p);
		request.getRequestDispatcher("/pages/staff/staff_insert.jsp").forward(request, response);
		
	}

}
