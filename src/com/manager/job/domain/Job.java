package com.manager.job.domain;

public class Job {
	private int j_id;//主键，自动增长
	private String j_name;//岗位名称
	private String j_type;//岗位类型（管理，技术，营销，市场）
	private int j_size;//岗位编制
	public Job(int j_id, String j_name, String j_type, int j_size) {
		super();
		this.j_id = j_id;
		this.j_name = j_name;
		this.j_type = j_type;
		this.j_size = j_size;
	}
	public int getJ_id() {
		return j_id;
	}
	public void setJ_id(int j_id) {
		this.j_id = j_id;
	}
	public String getJ_name() {
		return j_name;
	}
	public void setJ_name(String j_name) {
		this.j_name = j_name;
	}
	public String getJ_type() {
		return j_type;
	}
	public void setJ_type(String j_type) {
		this.j_type = j_type;
	}
	public int getJ_size() {
		return j_size;
	}
	public void setJ_size(int j_size) {
		this.j_size = j_size;
	}
	public Job(String j_name, String j_type, int j_size) {
		super();
		this.j_name = j_name;
		this.j_type = j_type;
		this.j_size = j_size;
	}
	public Job(String j_name) {
		super();
		this.j_name = j_name;
	}

	
	
}
