package com.manager.department.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.department.domain.Department;
import com.manager.department.service.DepartmentService;
import com.manager.department.service.IDepartmentService;

/**
 * Servlet implementation class DepartmentUpdateServlet
 */
@WebServlet("/DepartmentUpdateServlet")
public class DepartmentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		IDepartmentService ds = new DepartmentService();
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String ZHtype;
		if (type == "dep") {
			ZHtype = "部门";
		}
		else ZHtype = "公司";
		
		String tel = request.getParameter("tel");
		String date = request.getParameter("date");
		
		if (date == null)
		{
			date = "1970-01-01";
		}
		
		Department d = new Department(id,name,ZHtype,tel,date);
		ds.updateDepartment(d);
		request.getRequestDispatcher("/pages/department2/department_list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
