package com.manager.report;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.transfer.domain.DepartmentTransfer;
import com.manager.transfer.domain.JobTransfer;
import com.manager.transfer.service.DepartmentManagementService;
import com.manager.transfer.service.IDepartmentManagementService;

/**
 * Servlet implementation class DepExportServlet
 */
@WebServlet("/DepExportServlet")
public class DepExportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepExportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		IDepartmentManagementService idms = new DepartmentManagementService();
		ArrayList<DepartmentTransfer> dts =  idms.querydtByPreDepName("");
		
// ��������excel
		//excel����
		String title = "���ŵ���Ա������";
		//excel��ͷ��Ϣ
		String[] rowsName = new String[] { "Ա�����", "����", "ԭ��������", "�ֲ�������" };
		List<Object[]> dataList = new ArrayList<Object[]>();
		Object[] objs = null;
		for (int i = 0; i < dts.size(); i++) {
			DepartmentTransfer dt = dts.get(i);
		    objs = new Object[rowsName.length];
		    objs[0] = dt.getDt_staffID().getS_id();
		    objs[1] = dt.getDt_staffID().getS_name();
			objs[2] = dt.getDt_preDepartment().getD_name();
			objs[3] = dt.getDt_department().getD_name();
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
