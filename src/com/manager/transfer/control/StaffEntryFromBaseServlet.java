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
 * Servlet implementation class StaffEntryFromBaseServlet
 */
@WebServlet("/StaffEntryFromBaseServlet")
public class StaffEntryFromBaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaffEntryFromBaseServlet() {
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
		
		//点击入职后需要的操作
		IStaffService iss = new StaffService();
		Staff s = new Staff();
		int s_id = Integer.parseInt(request.getParameter("sid"));
		s.setS_id(s_id);//获得员工编号并设置
		s.setS_dismission(false);//将离职信息设置为假
		iss.updateStaffDismissionById(s);//将员工信息表离职信息更改
		
		IBaseService ibs = new BaseService();		
		Base base = new Base();
		base.setB_staffId(s);	
		ibs.deleteBase(base);//通过员工Id删除人才库中记录
		
		response.sendRedirect("/code/pages/transfer/jump_baselist.html");
		
	}
}
