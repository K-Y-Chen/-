package com.manager.job.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.manager.job.domain.Job;
import com.manager.job.service.IJobService;
import com.manager.job.service.JobService;



/**
 * Servlet implementation class JobAddServlet
 */
@WebServlet("/JobAddServlet")
public class JobAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobAddServlet() {
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
		
		request.setCharacterEncoding("utf-8");
		IJobService js = new JobService();
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String ZHtype = null;
		switch(type) {
		case "manage":
			ZHtype = "管理";
			break;
		case "tech":
			ZHtype = "技术";
			break;
		case "mark":
			ZHtype = "市场";
			break;
		case "sell":
			ZHtype = "营销";
			break;
		}
		
		int size = Integer.parseInt(request.getParameter("size"));

		Job j = new Job(name,ZHtype,size);
		js.insertJob(j);
		request.getRequestDispatcher("/pages/job/job_list.jsp").forward(request, response);
		
	}

}
