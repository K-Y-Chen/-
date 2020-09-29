package com.manager.transfer.dao;

import java.util.ArrayList;

import com.manager.transfer.domain.JobTransfer;
import com.manager.transfer.domain.Staff;



public interface IJobManagementDao {
	//向岗位调动表插入记录
	public boolean insertJobTransfer(JobTransfer jt);
	public boolean updateJobTransfer(JobTransfer jt);
	public boolean deleteJobTransfer(JobTransfer jt);
	
	//通过流水编号查找岗位调动信息。
	//注意这些查询 返回的Job和Staff对象只有编号和名称。
	public ArrayList<JobTransfer> queryjtById(int id);

	
	//通过调转前部门的名称查找部门调动信息
	public ArrayList<JobTransfer> queryjtByPreJobName(String preJobName);
	//通过调转后部门的名称查找部门调动信息	
	public ArrayList<JobTransfer> queryjtByJobName(String JobName);
	
	//通过调转前部门的id查找部门调动信息
	public ArrayList<JobTransfer> queryjtByPreJobId(int preJobId);
	//通过调转后部门的id查找部门调动信息	
	public ArrayList<JobTransfer> queryjtByJobId(int jobId);
	//通过调转员工id查找部门调动信息		
	public ArrayList<JobTransfer> queryjtByStaffId(int staffId);
	//通过调转类型查找部门调动信息		
	public ArrayList<JobTransfer> queryjtByType(String type);
	//通过调转日期查找部门调动信息		
	public ArrayList<JobTransfer> queryjtByDate(String date);
	
	public ArrayList<Staff> queryjtStaffb(String jobName);//查询该岗位调走的员工
	public ArrayList<Staff> queryjtStaffa(String jobName);//查询该岗位调入的员工
}
