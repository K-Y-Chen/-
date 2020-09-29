package com.manager.transfer.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.transfer.service.*;
import com.manager.transfer.domain.*;


/**
 * Servlet implementation class StaffEntryServlet
 */
@WebServlet("/StaffEntryServlet")
public class StaffEntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaffEntryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String S_NAME = request.getParameter("S_NAME");
		String S_SEX = request.getParameter("S_SEX");
		String S_BIRTHDAY = request.getParameter("S_BIRTHDAY");
		
		String S_DEPARTMENTNAME = request.getParameter("S_DEPARTMENTNAME");
		IDepartmentService ids =new DepartmentService();
		int S_DEPARTMENTID = ids.queryIdDepartmentsByName(S_DEPARTMENTNAME).getD_id();
		
		String S_JOBNAME = request.getParameter("S_JOBNAME");
		IJobService ijs =new JobService();
		int S_JOBID = ijs.queryIdJobsByName(S_JOBNAME).getJ_id();
		
		String S_DATE = request.getParameter("S_DATE");
		String S_JSDATE = request.getParameter("S_JSDATE");
		String S_EINFORMATION = request.getParameter("S_EINFORMATION");
		String S_PSOURCE = request.getParameter("S_PSOURCE");
		String S_TEL = request.getParameter("S_TEL");
		
		String S_EMAIL = request.getParameter("S_EMAIL");
		String S_EDUCATION = request.getParameter("S_EDUCATION");
		String S_EXPERIENCE = request.getParameter("S_EXPERIENCE");
		String S_ESDATE = request.getParameter("S_ESDATE");
		String S_EEDATE = request.getParameter("S_EEDATE");//试用期结束日期，工作日期和上相等
		
		String S_FLANGUAGE = request.getParameter("S_FLANGUAGE");
		String S_FNAME = request.getParameter("S_FNAME");
		String S_FRELATION = request.getParameter("S_FRELATION");
		Boolean S_DISMISSION = Boolean.parseBoolean(request.getParameter("S_DISMISSION"));
		S_DISMISSION = false;
		String S_IDNUM = request.getParameter("S_IDNUM");

		IStaffService iss = new StaffService();
		Department dep = new Department();
		dep.setD_id(S_DEPARTMENTID);
		Job job = new Job();
		job.setJ_id(S_JOBID);
		Staff s = new Staff(S_NAME,S_SEX,S_BIRTHDAY,dep,job,
				S_DATE,S_JSDATE,S_EINFORMATION,S_PSOURCE,S_TEL,
				S_EMAIL,S_EDUCATION,S_EXPERIENCE,S_ESDATE,S_ESDATE,
				S_FLANGUAGE,S_FNAME,S_FRELATION,S_DISMISSION,S_IDNUM);
		
		iss.insertStaff(s);	//插入员工表
		
		IStaffTrailService ists = new StaffTrailService();
		s = iss.queryStaffByIdNum(S_IDNUM);
		StaffTrail st = new StaffTrail(s,S_ESDATE,S_EEDATE);
		ists.insertStaffTrail(st);
		
		//插入员工，需要再员工信息表中插入记录还需要再试用期中插入记录	
		request.getRequestDispatcher("/EmployeeQueryServlet").forward(request, response);
	}

}
