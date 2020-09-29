package com.manager.employee.domain;

public class Job {
	private int jobid;
	private String jobname;

	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Job(int jobid, String jobname) {
		super();
		this.jobid = jobid;
		this.jobname = jobname;
	}

	public int getJobid() {
		return jobid;
	}

	public void setJobid(int jobid) {
		this.jobid = jobid;
	}

	public String getJobname() {
		return jobname;
	}

	public void setJobname(String jobname) {
		this.jobname = jobname;
	}
	
	
	
}
