package com.manager.transfer.domain;

public class JobTransfer {
	private int	jt_id;	//	主键，自动增长
	private Job	jt_preJob;	//	调转前的岗位，外键
	private Job	jt_job;	//	调转后的岗位，外键
	private Staff jt_staffId;	//	调转员工，外键
	private String jt_type;	//	调转类型 （升职、降职、数据录入错误）
	private String jt_date;	//	调动日期
	public JobTransfer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JobTransfer(int jt_id, Job jt_preJob, Job jt_job, Staff jt_staffId, String jt_type, String jt_date) {
		super();
		this.jt_id = jt_id;
		this.jt_preJob = jt_preJob;
		this.jt_job = jt_job;
		this.jt_staffId = jt_staffId;
		this.jt_type = jt_type;
		this.jt_date = jt_date;
	}
	public JobTransfer(Job jt_preJob, Job jt_job, Staff jt_staffId, String jt_type, String jt_date) {
		super();
		this.jt_preJob = jt_preJob;
		this.jt_job = jt_job;
		this.jt_staffId = jt_staffId;
		this.jt_type = jt_type;
		this.jt_date = jt_date;
	}
	public int getJt_id() {
		return jt_id;
	}
	public void setJt_id(int jt_id) {
		this.jt_id = jt_id;
	}
	public Job getJt_preJob() {
		return jt_preJob;
	}
	public void setJt_preJob(Job jt_preJob) {
		this.jt_preJob = jt_preJob;
	}
	public Job getJt_job() {
		return jt_job;
	}
	public void setJt_job(Job jt_job) {
		this.jt_job = jt_job;
	}
	public Staff getJt_staffId() {
		return jt_staffId;
	}
	public void setJt_staffId(Staff jt_staffId) {
		this.jt_staffId = jt_staffId;
	}
	public String getJt_type() {
		return jt_type;
	}
	public void setJt_type(String jt_type) {
		this.jt_type = jt_type;
	}
	public String getJt_date() {
		return jt_date;
	}
	public void setJt_date(String jt_date) {
		this.jt_date = jt_date;
	}
	@Override
	public String toString() {
		return "JobTransfer [jt_id=" + jt_id + ", jt_preJob=" + jt_preJob + ", jt_job=" + jt_job + ", jt_staffId="
				+ jt_staffId + ", jt_type=" + jt_type + ", jt_date=" + jt_date + "]";
	}
	
}
