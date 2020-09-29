package com.manager.transfer.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.manager.transfer.domain.Job;
import com.manager.transfer.domain.JobTransfer;
import com.manager.transfer.domain.Staff;

import com.manager.transfer.service.IJobManagementService;
import com.manager.transfer.service.IJobService;
import com.manager.transfer.service.IStaffService;
import com.manager.transfer.service.JobManagementService;
import com.manager.transfer.service.JobService;
import com.manager.transfer.service.StaffService;



/**
 * Servlet implementation class JobTransServlet
 */
@WebServlet("/JobTransServlet")
public class JobTransServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobTransServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		request.setCharacterEncoding("utf-8");		
		IStaffService isss =new StaffService();
		int s_id = Integer.parseInt(request.getParameter("sid"));//System.out.println(s_id);
		String preName = request.getParameter("prename");//System.out.println(preName);
		String name = request.getParameter("jname");//System.out.println(name);
		IJobManagementService ijms = new JobManagementService();

		IJobService ijs = new JobService();//获得调转岗位id
		Job job1 = ijs.queryIdJobsByName(preName);//通过岗位名称调转前部门id
		Job job2 = ijs.queryIdJobsByName(name);//通过岗位名称调转后部门id

		Staff s = new Staff();
		s.setS_id(s_id);		//员工id
		String type = "升职"; //升职、降职、数据录入错误 三种类型
		JobTransfer jt = new JobTransfer(job1,job2,s,type,"2020-02-02");
		ijms.insertJobTransfer(jt);
		
		//更新员工的岗位信息
		s.setS_jobId(job2);
		isss.updateStaffJobById(s);
		
		response.sendRedirect("pages/transfer/jumpToStaffListServlet.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
