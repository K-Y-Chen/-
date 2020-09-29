package com.manager.job.service;

import java.util.ArrayList;

import com.manager.department.domain.Staff;
import com.manager.job.dao.IJobDao;
import com.manager.job.dao.JobDao;
import com.manager.job.domain.Job;



public class JobService implements IJobService{
	
	@Override
	public ArrayList<Job> queryJobs() {

		IJobDao j = new JobDao();
		return j.queryJobs();
	}

	@Override
	public ArrayList<Job> queryJobsById(int id) {
		IJobDao j = new JobDao();
		return j.queryJobsById(id);
	}

	@Override
	public ArrayList<Job> queryJobsByName(String name) {
		IJobDao j = new JobDao();
		return j.queryJobsByName(name);
	}

	@Override
	public ArrayList<Job> queryJobsByType(String type) {
		IJobDao j = new JobDao();
		return j.queryJobsByType(type);
	}

	@Override
	public ArrayList<Staff> queryStaffsInJob(String Jobname) {
		IJobDao j = new JobDao();
		return j.queryStaffsInJob(Jobname);
	}

	@Override
	public boolean insertJob(Job d) {
		IJobDao ij = new JobDao();
		return ij.insertJob(d);
	}

	@Override
	public boolean updateJob(Job d) {
		IJobDao ij = new JobDao();
		return ij.updateJob(d);
	}

	@Override
	public boolean deleteJobByName(Job j) {
		IJobDao ij = new JobDao();
		return ij.deleteJobByName(j);
	}

//	public static void main(String[] args) {
//		IJobDao j = new JobDao();
//		Job job = new Job(3,"猪","技术",1);
//		j.queryStaffsInDep("执行总裁");
//		//d.updateDepartment(dep);
//
//	}

}
