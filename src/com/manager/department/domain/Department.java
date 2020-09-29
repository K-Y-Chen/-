package com.manager.department.domain;

public class Department {
	private int d_id;//部门号
	private String d_name;//部门名称
	private String d_type;//类型
	private String d_tel;//电话
	private String d_date;//成立日期
	public Department(int d_id, String d_name, String d_type, String d_tel, String d_date) {
		super();
		this.d_id = d_id;
		this.d_name = d_name;
		this.d_type = d_type;
		this.d_tel = d_tel;
		this.d_date = d_date;
	}
	public int getD_id() {
		return d_id;
	}
	public void setD_id(int d_id) {
		this.d_id = d_id;
	}
	public String getD_name() {
		return d_name;
	}
	public void setD_name(String d_name) {
		this.d_name = d_name;
	}
	public String getD_type() {
		return d_type;
	}
	public void setD_type(String d_type) {
		this.d_type = d_type;
	}
	public String getD_tel() {
		return d_tel;
	}
	public void setD_tel(String d_tel) {
		this.d_tel = d_tel;
	}
	public String getD_date() {
		return d_date;
	}
	public void setD_date(String d_date) {
		this.d_date = d_date;
	}
	public Department(String d_name, String d_type, String d_tel, String d_date) {
		super();
		this.d_name = d_name;
		this.d_type = d_type;
		this.d_tel = d_tel;
		this.d_date = d_date;
	}
	public Department() {
		super();
	}
	
	
}
