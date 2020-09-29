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


import com.manager.transfer.domain.JobTransfer;
import com.manager.transfer.domain.Staff;
import com.manager.transfer.service.IJobManagementService;
import com.manager.transfer.service.IStaffService;
import com.manager.transfer.service.JobManagementService;
import com.manager.transfer.service.StaffService;

/**
 * Servlet implementation class JobExportServlet
 */
@WebServlet("/JobExportServlet")
public class JobExportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobExportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
//查找所有岗位调转信息
		IJobManagementService ijms = new JobManagementService();
		ArrayList<JobTransfer> jts =  ijms.queryjtByPreJobName("");
// 操作导出excel
		//excel标题
		String title = "岗位调动员工报表";
		//excel列头信息
		String[] rowsName = new String[] { "员工编号", "姓名", "原岗位名称", "现岗位名称" };
		List<Object[]> dataList = new ArrayList<Object[]>();
		Object[] objs = null;
		for (int i = 0; i < jts.size(); i++) {
			JobTransfer jt = jts.get(i);
		    objs = new Object[rowsName.length];
		    objs[0] = jt.getJt_staffId().getS_id();
		    objs[1] = jt.getJt_staffId().getS_name();
		    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			objs[2] = jt.getJt_preJob().getJ_name();
			objs[3] = jt.getJt_job().getJ_name();
			dataList.add(objs);
	}
//给文件命名。随机命名
		String fileName = "Excel-" + String.valueOf(System.currentTimeMillis()).substring(4, 13) + ".xls";
		//告诉浏览器数据格式，将头和数据传到前台
		String headStr = "attachment; filename=\"" + fileName + "\"";
		response.setContentType("APPLICATION/OCTET-STREAM");
		response.setHeader("Content-Disposition", headStr);
		OutputStream out = response.getOutputStream();		
		//调用poi的工具类
		ExportExcel ex = new ExportExcel(title, rowsName, dataList);
		try {
		ex.export(out);
		} catch (Exception e) {
		e.printStackTrace();
		}
		out.flush();
		out.close();
		
//		response.sendRedirect("/code/pages/transfer/jumpToStaffListServlet.html");
}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
