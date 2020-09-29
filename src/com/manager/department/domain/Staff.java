package com.manager.department.domain;

public class Staff {
	private int s_id;//员工号
	private String s_name;//姓名
	private String s_sex;//性别
	private String s_birthday;//出生日期
	private String s_departmentname;//部门名
	private String s_jobname;//岗位名
	private String s_departmentid;//部门号
	private String s_jobid;//岗位号
	private String s_date;//入职日期
	private String s_jsdate;//参加工作日期
	private String s_einformation;//用工形式
	private String s_psource;//人员来源
	private String s_tel;//联系电话
	private String s_email;//电子邮件
	private String s_education;//学历
	private String s_experience;//工作经历
	private String s_esdate;//经历阶段起始日期
	private String s_eedate;//经历阶段截止日期
	private String s_flanguage;//外国语种
	private String s_fname;//亲属姓名
	private String s_frelation;//亲属关系
	private boolean s_dismission;//是否离职
	private String s_idnum;//身份证号
	
	public Staff() {
		super();
	}

	public Staff(int s_id, String s_name, String s_sex, String s_departmentname, String s_jobname) {
		super();
		this.s_id = s_id;
		this.s_name = s_name;
		this.s_sex = s_sex;
		this.s_departmentname = s_departmentname;
		this.s_jobname = s_jobname;
	}

	public Staff(int s_id, String s_name, String s_sex, String s_departmentid, String s_jobid, String s_einformation,
			String s_psource, String s_education, String s_flanguage, String s_frelation) {
		super();
		this.s_id = s_id;
		this.s_name = s_name;
		this.s_sex = s_sex;
		this.s_departmentid = s_departmentid;
		this.s_jobid = s_jobid;
		this.s_einformation = s_einformation;
		this.s_psource = s_psource;
		this.s_education = s_education;
		this.s_flanguage = s_flanguage;
		this.s_frelation = s_frelation;
	}

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public String getS_sex() {
		return s_sex;
	}

	public void setS_sex(String s_sex) {
		this.s_sex = s_sex;
	}

	public String getS_birthday() {
		return s_birthday;
	}

	public void setS_birthday(String s_birthday) {
		this.s_birthday = s_birthday;
	}

	public String getS_departmentname() {
		return s_departmentname;
	}

	public void setS_departmentname(String s_departmentname) {
		this.s_departmentname = s_departmentname;
	}

	public String getS_jobname() {
		return s_jobname;
	}

	public void setS_jobname(String s_jobname) {
		this.s_jobname = s_jobname;
	}

	public String getS_departmentid() {
		return s_departmentid;
	}

	public void setS_departmentid(String s_departmentid) {
		this.s_departmentid = s_departmentid;
	}

	public String getS_jobid() {
		return s_jobid;
	}

	public void setS_jobid(String s_jobid) {
		this.s_jobid = s_jobid;
	}

	public String getS_date() {
		return s_date;
	}

	public void setS_date(String s_date) {
		this.s_date = s_date;
	}

	public String getS_jsdate() {
		return s_jsdate;
	}

	public void setS_jsdate(String s_jsdate) {
		this.s_jsdate = s_jsdate;
	}

	public String getS_einformation() {
		return s_einformation;
	}

	public void setS_einformation(String s_einformation) {
		this.s_einformation = s_einformation;
	}

	public String getS_psource() {
		return s_psource;
	}

	public void setS_psource(String s_psource) {
		this.s_psource = s_psource;
	}

	public String getS_tel() {
		return s_tel;
	}

	public void setS_tel(String s_tel) {
		this.s_tel = s_tel;
	}

	public String getS_email() {
		return s_email;
	}

	public void setS_email(String s_email) {
		this.s_email = s_email;
	}

	public String getS_education() {
		return s_education;
	}

	public void setS_education(String s_education) {
		this.s_education = s_education;
	}

	public String getS_experience() {
		return s_experience;
	}

	public void setS_experience(String s_experience) {
		this.s_experience = s_experience;
	}

	public String getS_esdate() {
		return s_esdate;
	}

	public void setS_esdate(String s_esdate) {
		this.s_esdate = s_esdate;
	}

	public String getS_eedate() {
		return s_eedate;
	}

	public void setS_eedate(String s_eedate) {
		this.s_eedate = s_eedate;
	}

	public String getS_flanguage() {
		return s_flanguage;
	}

	public void setS_flanguage(String s_flanguage) {
		this.s_flanguage = s_flanguage;
	}

	public String getS_fname() {
		return s_fname;
	}

	public void setS_fname(String s_fname) {
		this.s_fname = s_fname;
	}

	public String getS_frelation() {
		return s_frelation;
	}

	public void setS_frelation(String s_frelation) {
		this.s_frelation = s_frelation;
	}

	public boolean isS_dismission() {
		return s_dismission;
	}

	public void setS_dismission(boolean s_dismission) {
		this.s_dismission = s_dismission;
	}

	public String getS_idnum() {
		return s_idnum;
	}

	public void setS_idnum(String s_idnum) {
		this.s_idnum = s_idnum;
	}


	
	
	
	
}
