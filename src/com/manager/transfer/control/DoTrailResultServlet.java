package com.manager.transfer.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.transfer.domain.Dismission;
import com.manager.transfer.domain.Staff;
import com.manager.transfer.domain.StaffCheck;
import com.manager.transfer.domain.StaffTrail;
import com.manager.transfer.service.DismissionService;
import com.manager.transfer.service.IDismissionService;
import com.manager.transfer.service.IStaffCheckService;
import com.manager.transfer.service.IStaffService;
import com.manager.transfer.service.IStaffTrailService;
import com.manager.transfer.service.StaffCheckService;
import com.manager.transfer.service.StaffService;
import com.manager.transfer.service.StaffTrailService;

/**
 * Servlet implementation class DoTrailResultServlet
 */
@WebServlet("/DoTrailResultServlet")
public class DoTrailResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoTrailResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String result = request.getParameter("result");//System.out.println(result);
		int s_id = Integer.parseInt(request.getParameter("sid"));
		//System.out.println(s_id);
		
		if (result.equals("pass")) {
			//员工转正操作，在考核表中添加转正信息。
			//System.out.println("转正");
			IStaffTrailService ists = new StaffTrailService();
			IStaffCheckService iscs = new StaffCheckService();
			StaffTrail st = new StaffTrail();
			
			ArrayList<StaffTrail> alsc = ists.queryStaffTrailByStaffId(s_id);//通过员工id获得试用表记录
			for(StaffTrail sst:alsc) {	
				st = sst;
			}
			StaffCheck sc1 = new StaffCheck(st,"优秀","转正","2020-01-01");//通过试用表对象id添加考核表
			iscs.insertStaffCheck(sc1);	//在考核表中添加转正信息
		}
		else if (result == "delay") {
			//员工延迟操作，在考核表中添加转正信息。
			IStaffTrailService ists = new StaffTrailService();
			IStaffCheckService iscs = new StaffCheckService();
			StaffTrail st = new StaffTrail();
			
			ArrayList<StaffTrail> alsc = ists.queryStaffTrailByStaffId(s_id);//通过员工id获得试用表记录
			for(StaffTrail sst:alsc) {	
				st = sst;
			}
			StaffCheck sc1 = new StaffCheck(st,"良好","延期","2020-01-01");//通过试用表对象id添加考核表
			iscs.insertStaffCheck(sc1);	//在考核表中添加转正信息
		}
		else if (result == "no_pass") {
			//员工延迟操作，在考核表中添加转正信息。
			IStaffTrailService ists = new StaffTrailService();
			IStaffCheckService iscs = new StaffCheckService();
			StaffTrail st = new StaffTrail();
			
			ArrayList<StaffTrail> alsc = ists.queryStaffTrailByStaffId(s_id);//通过员工id获得试用表记录
			for(StaffTrail sst:alsc) {	
				st = sst;
			}
			StaffCheck sc1 = new StaffCheck(st,"不合格","不通过","2020-01-01");//通过试用表对象id添加考核表
			iscs.insertStaffCheck(sc1);	//在考核表中添加转正信息
			Staff s = new Staff();		//员工表更改离职信息
			s.setS_id(s_id);	//获得员工编号并设置
			s.setS_dismission(true);//将离职信息设置为假
			IStaffService iss = new StaffService();
			iss.updateStaffDismissionById(s);//将员工信息表离职信息更改	
			
			IDismissionService ids = new DismissionService();//在离职表中添加离职信息
			Dismission dismission = new Dismission(s,"2099-12-31","试用期未通过",false);
			ids.insertDismission(dismission);
		}
		
		response.sendRedirect("/code/pages/transfer/jumpToSearchTrailServlet.html");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
