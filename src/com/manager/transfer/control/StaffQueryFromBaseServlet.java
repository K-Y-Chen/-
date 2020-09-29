package com.manager.transfer.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.transfer.domain.Base;
import com.manager.transfer.domain.Staff;
import com.manager.transfer.service.BaseService;
import com.manager.transfer.service.IBaseService;
import com.manager.transfer.service.IStaffService;
import com.manager.transfer.service.StaffService;

/**
 * Servlet implementation class StaffQueryFromBaseServlet
 */
@WebServlet("/StaffQueryFromBaseServlet")
public class StaffQueryFromBaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaffQueryFromBaseServlet() {
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
		IStaffService iss = new StaffService();
		ArrayList<Staff> staffs = iss.queryStaffByBase();//里面由所有人才库中的员工信息，由部门名和岗位名，注意部门岗位为对象
		
		request.setAttribute("st", staffs);
		
		request.getRequestDispatcher("/pages/transfer/base_list.jsp").forward(request, response);
		
	}

}
