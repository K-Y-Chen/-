package com.manager.job.control;

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
import com.manager.job.domain.Job;
import com.manager.job.service.IJobService;
import com.manager.job.service.JobService;

/**
 * Servlet implementation class JobDeleteServlet
 */
@WebServlet("/JobDeleteServlet")
public class JobDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobDeleteServlet() {
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
		IJobService js = new JobService();
		ArrayList<Job> jobs = js.queryJobs();
		request.setAttribute("jobs", jobs);
		//response.sendRedirect("/Demo-0831/productInsert.jsp");
		//跳转：请求转发，发的一次请求
		request.getRequestDispatcher("/pages/job/job_maintain.jsp").forward(request, response);
	}

}
