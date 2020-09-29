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
 * Servlet implementation class EmployeeQueryByIdServlet
 */
@WebServlet("/EmployeeQueryByIdServlet")
public class EmployeeQueryByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeQueryByIdServlet() {
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
		String id = request.getParameter("eid");
		int eid = Integer.parseInt(id);
		IEmployeeService ps = new EmployeeService();
		Employee p =ps.queryEmployeeByID(eid);
		
		IDepartmentService dns = new DepartmentService();
		ArrayList<Department> dname = dns.queryDepartment();
		
		IJobService jns = new JobService();
		ArrayList<Job> jname = jns.queryJob();
		
		request.setAttribute("departmentname", dname);
		request.setAttribute("jobname", jname);
		request.setAttribute("employee", p);
		request.getRequestDispatcher("/pages/staff/staff_update.jsp").forward(request, response);
	}

}
