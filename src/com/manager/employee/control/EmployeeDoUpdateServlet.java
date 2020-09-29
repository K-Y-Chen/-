package com.manager.employee.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.employee.domain.Department;
import com.manager.employee.domain.Employee;
import com.manager.employee.domain.Job;
import com.manager.employee.service.EmployeeService;
import com.manager.employee.service.IEmployeeService;


/**
 * Servlet implementation class EmployeeUpdateServlet
 */
@WebServlet("/EmployeeDoUpdateServlet")
public class EmployeeDoUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeDoUpdateServlet() {
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

		
		int employeeid = Integer.parseInt(request.getParameter("employeeid"));
		String employeename = request.getParameter("employeename");
		String employeesex = request.getParameter("employeesex");
		
		String employeebirthday = request.getParameter("employeebirthday");
		
		int employeedepartment=Integer.parseInt(request.getParameter("department"));
		Department ed=new Department(employeedepartment,null);
		
		int job=Integer.parseInt(request.getParameter("job"));
		Job ej=new Job(job,null);
		
		String employeedate = request.getParameter("employeedate");
		String enployeejsdate = request.getParameter("enployeejsdate");
		
		String employeeinformation = request.getParameter("employeeinformation");
		String employeesource = request.getParameter("employeesource");
		String employeetel = request.getParameter("employeetel");
		String employeemali = request.getParameter("employeemali");
		String employeeeducation = request.getParameter("employeeeducation");
		String employeeexperience = request.getParameter("employeeexperience");
		
		String employeeesdate = request.getParameter("employeeesdate");
		String employeeeedate = request.getParameter("employeeeedate");
		
		String employeeflanguage = request.getParameter("employeeflanguage");
		String employeefname = request.getParameter("employeefname");
		String employeefrelation = request.getParameter("employeefrelation");
		
		int employeedismission = Integer.parseInt(request.getParameter("employeedismission"));

			

		
		String employeeidnum = request.getParameter("employeeidnum");
		
		Employee e= new Employee(employeeid,employeename,employeesex,employeebirthday,ed,ej,employeedate
				,enployeejsdate,employeeinformation,employeesource,employeetel,employeemali,employeeeducation
				,employeeexperience,employeeesdate,employeeeedate,employeeflanguage,employeefname,
				employeefrelation,employeedismission,employeeidnum);


		
		IEmployeeService ps = new EmployeeService();
		boolean result = ps.updateEmployee(e);
		if(result == true) {
			response.sendRedirect("/code/pages/staff/jump_update.jsp");
		}
		else {
			
		}
	}

}
