package com.manager.transfer.domain;

public class Base {
	private int b_id;//员工编号，外键
	private Staff b_staffId;//员工编号，外键
	public Base() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Base(Staff b_staffId) {
		super();
		this.b_staffId = b_staffId;
	}
	public Base(int b_id, Staff b_staffId) {
		super();
		this.b_id = b_id;
		this.b_staffId = b_staffId;
	}
	public int getB_id() {
		return b_id;
	}
	public void setB_id(int b_id) {
		this.b_id = b_id;
	}
	public Staff getB_staffId() {
		return b_staffId;
	}
	public void setB_staffId(Staff b_staffId) {
		this.b_staffId = b_staffId;
	}
	@Override
	public String toString() {
		return "Base [b_id=" + b_id + ", b_staffId=" + b_staffId + "]";
	}
	
	
}
