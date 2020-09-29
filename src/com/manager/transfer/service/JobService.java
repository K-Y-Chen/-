package com.manager.transfer.service;

import com.manager.transfer.dao.IJobDao;
import com.manager.transfer.dao.JobDao;
import com.manager.transfer.domain.Job;

public class JobService implements IJobService {

	@Override
	public Job queryIdJobsByName(String name) {
		IJobDao ijd = new JobDao();
		return ijd.queryIdJobsByName(name);
	}
//	public static void main(String [] args) {
//		IJobService idd =new JobService();
//		Job ds = idd.queryIdJobsByName("²É¹ºÖ÷¹Ü");
//		System.out.print(ds.getJ_id());
//	}
}
