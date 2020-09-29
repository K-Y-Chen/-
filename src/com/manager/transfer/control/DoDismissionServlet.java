package com.manager.transfer.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.transfer.domain.Base;
import com.manager.transfer.domain.Department;
import com.manager.transfer.domain.Dismission;
import com.manager.transfer.domain.Staff;
import com.manager.transfer.service.BaseService;
import com.manager.transfer.service.DismissionService;
import com.manager.transfer.service.IBaseService;
import com.manager.transfer.service.IDismissionService;
import com.manager.transfer.service.IStaffService;
import com.manager.transfer.service.StaffService;

/**
 * Servlet implementation class DoDismissionServlet
 */
@WebServlet("/DoDismissionServlet")
public class DoDismissionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoDismissionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String sid = request.getParameter("sid");
		//System.out.println(sid);
		String type = request.getParameter("type");
		//System.out.println(type);
		String result = request.getParameter("result");
//		System.out.println(result);		
		boolean pool = true;
		if (result == "0")
			pool = false;
//		System.out.println(result);	
		String date = request.getParameter("date");
		
		//��ְ����
		//Ա����Ϣ�������ְ������ְ���������Ϣ���������˲ſ����˲ſ���������Ϣ
		IStaffService iss = new StaffService();
		Staff staff = new Staff();
		staff.setS_id(Integer.parseInt(sid));
		staff.setS_dismission(true);//������ְΪ��
		iss.updateStaffDismissionById(staff);//����Ա������ְ���ֻҪid���Ժ���ְ����				
		IDismissionService ids = new DismissionService();
		Dismission dis = new Dismission(staff,date,type,true);
		ids.insertDismission(dis);//����ְ���������Ϣ��
				
		if(pool == true) {
			//���˲ſ��в����¼
			Base base = new Base(staff);
			IBaseService ibs = new BaseService();
			ibs.insertBase(base);
		}
		
		response.sendRedirect("/code/pages/transfer/jumpToDismission2.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
