package com.manager.employee.domain;


public class Employee {
private int employeeid;
private String employeename;
private String employeesex;
private String employeebirthday;

private Department employeedepartment;
private Job employeejob;

private String employeedate;//入职日期
private String enployeejsdate;//参加工作日期
private String employeeinformation;//用工形式（正式员工，临时员工）
private String employeesource;//人员来源（校园招聘，社会招聘，其它）
private String employeetel;
private String employeemali;
private String employeeeducation;//最高学历（高中及以下，大专，本科，研究生）
private String employeeexperience;//某一阶段从事工作或学习经历
private String employeeesdate;//该阶段的起始年月
private String employeeeedate;//该阶段的截止年月
private String employeeflanguage;//外国语种（英语，日语，法语）
private String employeefname;//员工亲属的姓名
private String employeefrelation;//员工亲属与本人关系（父亲、母亲、配偶）
private int employeedismission;//是否离职
private String employeeidnum;//身份证号

public Employee() {
	super();
	// TODO Auto-generated constructor stub
}



public Employee(int employeeid, String employeename, String employeesex, String employeebirthday,
		Department employeedepartment, Job employeejob, String employeedate, String enployeejsdate,
		String employeeinformation, String employeesource, String employeetel, String employeemali,
		String employeeeducation, String employeeexperience, String employeeesdate, String employeeeedate,
		String employeeflanguage, String employeefname, String employeefrelation, int employeedismission,
		String employeeidnum) {
	super();
	this.employeeid = employeeid;
	this.employeename = employeename;
	this.employeesex = employeesex;
	this.employeebirthday = employeebirthday;
	this.employeedepartment = employeedepartment;
	this.employeejob = employeejob;
	this.employeedate = employeedate;
	this.enployeejsdate = enployeejsdate;
	this.employeeinformation = employeeinformation;
	this.employeesource = employeesource;
	this.employeetel = employeetel;
	this.employeemali = employeemali;
	this.employeeeducation = employeeeducation;
	this.employeeexperience = employeeexperience;
	this.employeeesdate = employeeesdate;
	this.employeeeedate = employeeeedate;
	this.employeeflanguage = employeeflanguage;
	this.employeefname = employeefname;
	this.employeefrelation = employeefrelation;
	this.employeedismission = employeedismission;
	this.employeeidnum = employeeidnum;
}



public Employee(int employeeid, String employeename) {
	super();
	this.employeeid = employeeid;
	this.employeename = employeename;
}

public Employee(int employeeid, String employeename, String employeesex,String employeetel, Department employeedepartment, Job employeejob
		) {
	super();
	this.employeeid = employeeid;
	this.employeename = employeename;
	this.employeesex = employeesex;
	this.employeetel = employeetel;
	this.employeedepartment = employeedepartment;
	this.employeejob = employeejob;
}



public int getEmployeeid() {
	return employeeid;
}



public void setEmployeeid(int employeeid) {
	this.employeeid = employeeid;
}



public String getEmployeename() {
	return employeename;
}



public void setEmployeename(String employeename) {
	this.employeename = employeename;
}



public String getEmployeesex() {
	return employeesex;
}



public void setEmployeesex(String employeesex) {
	this.employeesex = employeesex;
}



public String getEmployeebirthday() {
	return employeebirthday;
}



public void setEmployeebirthday(String employeebirthday) {
	this.employeebirthday = employeebirthday;
}



public Department getEmployeedepartment() {
	return employeedepartment;
}



public void setEmployeedepartment(Department employeedepartment) {
	this.employeedepartment = employeedepartment;
}



public Job getEmployeejob() {
	return employeejob;
}



public void setEmployeejob(Job employeejob) {
	this.employeejob = employeejob;
}



public String getEmployeedate() {
	return employeedate;
}



public void setEmployeedate(String employeedate) {
	this.employeedate = employeedate;
}



public String getEnployeejsdate() {
	return enployeejsdate;
}



public void setEnployeejsdate(String enployeejsdate) {
	this.enployeejsdate = enployeejsdate;
}



public String getEmployeeinformation() {
	return employeeinformation;
}



public void setEmployeeinformation(String employeeinformation) {
	this.employeeinformation = employeeinformation;
}



public String getEmployeesource() {
	return employeesource;
}



public void setEmployeesource(String employeesource) {
	this.employeesource = employeesource;
}



public String getEmployeetel() {
	return employeetel;
}



public void setEmployeetel(String employeetel) {
	this.employeetel = employeetel;
}



public String getEmployeemali() {
	return employeemali;
}



public void setEmployeemali(String employeemali) {
	this.employeemali = employeemali;
}



public String getEmployeeeducation() {
	return employeeeducation;
}



public void setEmployeeeducation(String employeeeducation) {
	this.employeeeducation = employeeeducation;
}



public String getEmployeeexperience() {
	return employeeexperience;
}



public void setEmployeeexperience(String employeeexperience) {
	this.employeeexperience = employeeexperience;
}



public String getEmployeeesdate() {
	return employeeesdate;
}



public void setEmployeeesdate(String employeeesdate) {
	this.employeeesdate = employeeesdate;
}



public String getEmployeeeedate() {
	return employeeeedate;
}



public void setEmployeeeedate(String employeeeedate) {
	this.employeeeedate = employeeeedate;
}



public String getEmployeeflanguage() {
	return employeeflanguage;
}



public void setEmployeeflanguage(String employeeflanguage) {
	this.employeeflanguage = employeeflanguage;
}



public String getEmployeefname() {
	return employeefname;
}



public void setEmployeefname(String employeefname) {
	this.employeefname = employeefname;
}



public String getEmployeefrelation() {
	return employeefrelation;
}



public void setEmployeefrelation(String employeefrelation) {
	this.employeefrelation = employeefrelation;
}



public int getEmployeedismission() {
	return employeedismission;
}



public void setEmployeedismission(int employeedismission) {
	this.employeedismission = employeedismission;
}



public String getEmployeeidnum() {
	return employeeidnum;
}



public void setEmployeeidnum(String employeeidnum) {
	this.employeeidnum = employeeidnum;
}



}