package com.manager.transfer.control;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.transfer.domain.Department;
import com.manager.transfer.domain.JobTransfer;
import com.manager.transfer.domain.Staff;
import com.manager.transfer.service.IJobManagementService;
import com.manager.transfer.service.IStaffService;
import com.manager.transfer.service.JobManagementService;
import com.manager.transfer.service.StaffService;

/**
 * Servlet implementation class StaffListQueryServlet
 */
@WebServlet("/StaffListQueryServlet")
public class StaffListQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaffListQueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		IStaffService iss =new StaffService();
		Department dep = new Department();
		dep.setD_name("");
		ArrayList<Staff> st = iss.queryStaffByDepartment(dep);
		request.setAttribute("st", st);
		
		IJobManagementService ijms = new JobManagementService();
		ArrayList<JobTransfer> jt =  ijms.queryjtByPreJobName("");
		request.setAttribute("jt", jt);
		

		request.getRequestDispatcher("/pages/transfer/job_transfer_pages.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
