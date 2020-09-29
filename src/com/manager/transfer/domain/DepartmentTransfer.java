package com.manager.transfer.domain;

public class DepartmentTransfer {
	private int dt_id;	//	调转编号，主键，自动增长
	private Department dt_preDepartment;	//	调转前的部门，外键
	private Department dt_department;	//	调转后的部门，外键
	private Staff dt_staffID;	//	调转员工，外键
	private String dt_type;	//	调转类型（主动调动，被动调动，数据错误）
	private String dt_reason;	//	调转原因
	private String dt_date;	//	调动日期
	public DepartmentTransfer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DepartmentTransfer(Department dt_preDepartment, Department dt_department, Staff dt_staffID, String dt_type,
			String dt_reason, String dt_date) {
		super();
		this.dt_preDepartment = dt_preDepartment;
		this.dt_department = dt_department;
		this.dt_staffID = dt_staffID;
		this.dt_type = dt_type;
		this.dt_reason = dt_reason;
		this.dt_date = dt_date;
	}
	public DepartmentTransfer(int dt_id, Department dt_preDepartment, Department dt_department, Staff dt_staffID,
			String dt_type, String dt_reason, String dt_date) {
		super();
		this.dt_id = dt_id;
		this.dt_preDepartment = dt_preDepartment;
		this.dt_department = dt_department;
		this.dt_staffID = dt_staffID;
		this.dt_type = dt_type;
		this.dt_reason = dt_reason;
		this.dt_date = dt_date;
	}
	public int getDt_id() {
		return dt_id;
	}
	public void setDt_id(int dt_id) {
		this.dt_id = dt_id;
	}
	public Department getDt_preDepartment() {
		return dt_preDepartment;
	}
	public void setDt_preDepartment(Department dt_preDepartment) {
		this.dt_preDepartment = dt_preDepartment;
	}
	public Department getDt_department() {
		return dt_department;
	}
	public void setDt_department(Department dt_department) {
		this.dt_department = dt_department;
	}
	public Staff getDt_staffID() {
		return dt_staffID;
	}
	public void setDt_staffID(Staff dt_staffID) {
		this.dt_staffID = dt_staffID;
	}
	public String getDt_type() {
		return dt_type;
	}
	public void setDt_type(String dt_type) {
		this.dt_type = dt_type;
	}
	public String getDt_reason() {
		return dt_reason;
	}
	public void setDt_reason(String dt_reason) {
		this.dt_reason = dt_reason;
	}
	public String getDt_date() {
		return dt_date;
	}
	public void setDt_date(String dt_date) {
		this.dt_date = dt_date;
	}
	@Override
	public String toString() {
		return "DepartmentTransfer [dt_id=" + dt_id + ", dt_preDepartment=" + dt_preDepartment + ", dt_department="
				+ dt_department + ", dt_staffID=" + dt_staffID + ", dt_type=" + dt_type + ", dt_reason=" + dt_reason
				+ ", dt_date=" + dt_date + "]";
	}
	
}
