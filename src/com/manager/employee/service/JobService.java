package com.manager.employee.service;

import java.util.ArrayList;

import com.manager.employee.dao.IJobDao;
import com.manager.employee.dao.JobDao;
import com.manager.employee.domain.Job;


public class JobService implements IJobService {

	@Override
	public ArrayList<Job> queryJob() {
		IJobDao jd = new JobDao();
		return jd.getAllJNames(); 

	}

}
