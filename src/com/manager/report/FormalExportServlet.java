package com.manager.report;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.transfer.domain.Department;
import com.manager.transfer.domain.DepartmentTransfer;
import com.manager.transfer.domain.Staff;
import com.manager.transfer.service.DepartmentManagementService;
import com.manager.transfer.service.IDepartmentManagementService;
import com.manager.transfer.service.IStaffService;
import com.manager.transfer.service.StaffService;

/**
 * Servlet implementation class FormalExportServlet
 */
@WebServlet("/FormalExportServlet")
public class FormalExportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormalExportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		IStaffService iss = new StaffService();//ͨ���������Ʋ���ת��Ա��
		Department dep = new Department();
		dep.setD_name("");//��������
		ArrayList<Staff> staffs = iss.queryStaffCheckByDepartment(dep);
		
// ��������excel
		//excel����
		String title = "��ƸԱ������";
		//excel��ͷ��Ϣ
		String[] rowsName = new String[] { "Ա�����", "����", "�Ա�", "����", "��λ", "��ְ����"};
		List<Object[]> dataList = new ArrayList<Object[]>();
		Object[] objs = null;
		for (int i = 0; i < staffs.size(); i++) {
			Staff st = staffs.get(i);
		    objs = new Object[rowsName.length];
		    objs[0] = st.getS_id();
		    objs[1] = st.getS_name();
			objs[2] = st.getS_sex();
			objs[3] = st.getS_departmentId().getD_name();
			objs[4] = st.getS_jobId().getJ_name();
			objs[5] = st.getS_date();			
			dataList.add(objs);
	}
//���ļ��������������
		String fileName = "Excel-" + String.valueOf(System.currentTimeMillis()).substring(4, 13) + ".xls";
		//������������ݸ�ʽ����ͷ�����ݴ���ǰ̨
		String headStr = "attachment; filename=\"" + fileName + "\"";
		response.setContentType("APPLICATION/OCTET-STREAM");
		response.setHeader("Content-Disposition", headStr);
		OutputStream out = response.getOutputStream();		
		//����poi�Ĺ�����
		ExportExcel ex = new ExportExcel(title, rowsName, dataList);
		try {
		ex.export(out);
		} catch (Exception e) {
		e.printStackTrace();
		}
		out.flush();
		out.close();	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
