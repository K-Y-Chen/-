package com.manager.transfer.service;

import java.util.ArrayList;

import com.manager.transfer.dao.IJobManagementDao;
import com.manager.transfer.dao.JobManagementDao;
import com.manager.transfer.domain.JobTransfer;
import com.manager.transfer.domain.Staff;



public class JobManagementService implements IJobManagementService {

	@Override
	public boolean insertJobTransfer(JobTransfer jt) {
		IJobManagementDao ijms = new JobManagementDao();
		return ijms.insertJobTransfer(jt);
	}

	@Override
	public boolean updateJobTransfer(JobTransfer jt) {
		IJobManagementDao ijms = new JobManagementDao();
		return ijms.updateJobTransfer(jt);
	}

	@Override
	public boolean deleteJobTransfer(JobTransfer jt) {
		IJobManagementDao ijms = new JobManagementDao();
		return ijms.deleteJobTransfer(jt);
	}

	@Override
	public ArrayList<JobTransfer> queryjtById(int id) {
		IJobManagementDao ijms = new JobManagementDao();
		return ijms.queryjtById(id);
	}

	@Override
	public ArrayList<JobTransfer> queryjtByPreJobName(String preJobName) {
		IJobManagementDao ijms = new JobManagementDao();
		return ijms.queryjtByPreJobName(preJobName);
	}

	@Override
	public ArrayList<JobTransfer> queryjtByJobName(String JobName) {
		IJobManagementDao ijms = new JobManagementDao();
		return ijms.queryjtByJobName(JobName);
	}

	@Override
	public ArrayList<JobTransfer> queryjtByPreJobId(int preJobId) {
		IJobManagementDao ijms = new JobManagementDao();
		return ijms.queryjtByPreJobId(preJobId);
	}

	@Override
	public ArrayList<JobTransfer> queryjtByJobId(int jobId) {
		IJobManagementDao ijms = new JobManagementDao();
		return ijms.queryjtByJobId(jobId);
	}

	@Override
	public ArrayList<JobTransfer> queryjtByStaffId(int staffId) {
		IJobManagementDao ijms = new JobManagementDao();
		return ijms.queryjtByStaffId(staffId);
	}

	@Override
	public ArrayList<JobTransfer> queryjtByType(String type) {
		IJobManagementDao ijms = new JobManagementDao();
		return ijms.queryjtByType(type);
	}

	@Override
	public ArrayList<JobTransfer> queryjtByDate(String date) {
		IJobManagementDao ijms = new JobManagementDao();
		return ijms.queryjtByDate(date);
	}

	@Override
	public ArrayList<Staff> queryjtStaffb(String jobName) {
		IJobManagementDao ijms = new JobManagementDao();
		return ijms.queryjtStaffb(jobName);
	}

	@Override
	public ArrayList<Staff> queryjtStaffa(String jobName) {
		IJobManagementDao ijms = new JobManagementDao();
		return ijms.queryjtStaffa(jobName);
	}

}
