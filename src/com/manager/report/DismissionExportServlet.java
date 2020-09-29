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

import com.manager.transfer.domain.DepartmentTransfer;
import com.manager.transfer.domain.Dismission;
import com.manager.transfer.service.DepartmentManagementService;
import com.manager.transfer.service.DismissionService;
import com.manager.transfer.service.IDepartmentManagementService;
import com.manager.transfer.service.IDismissionService;

/**
 * Servlet implementation class DismissionExportServlet
 */
@WebServlet("/DismissionExportServlet")
public class DismissionExportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DismissionExportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		IDismissionService ids = new DismissionService();
		ArrayList<Dismission> ds = ids.querydByType("");
		
// ��������excel
		//excel����
		String title = "��ְԱ������";
		//excel��ͷ��Ϣ
		String[] rowsName = new String[] { "��ˮ��", "Ա�����", "����", "��ְʱ��", "����", "�Ƿ�����˲ſ�" };
		List<Object[]> dataList = new ArrayList<Object[]>();
		Object[] objs = null;
		for (int i = 0; i < ds.size(); i++) {
			Dismission d = ds.get(i);
		    objs = new Object[rowsName.length];
		    objs[0] = d.getD_id();
		    objs[1] = d.getD_staffId().getS_id();
		    objs[2] = d.getD_staffId().getS_name();
			objs[3] = d.getD_date();
			objs[4] = d.getD_type();
			objs[5] = (d.isD_pool()? "��" : "��");
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
