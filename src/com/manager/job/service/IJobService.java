package com.manager.job.service;

import java.util.ArrayList;

import com.manager.department.domain.Staff;
import com.manager.job.domain.Job;

public interface IJobService {
	//获取岗位表所有信息
	public ArrayList<Job> queryJobs();
	
	//通过编号名称查找岗位信息
	public ArrayList<Job> queryJobsById(int id);
	
	//通过名称编号名称查找岗位信息
	public ArrayList<Job> queryJobsByName(String name);
	
	//通过类型查找岗位信息
	public ArrayList<Job> queryJobsByType(String type);
	
	//查询指定岗位下当前在职员工信息
	public ArrayList<Staff> queryStaffsInJob(String Jobname);
	
	//新建一个岗位
	public boolean insertJob(Job j);
	
	//修改已有岗位的信息
	public boolean updateJob(Job j);
	
	//删除一个岗位
	public boolean deleteJobByName(Job j);
}
