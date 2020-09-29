package com.manager.transfer.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.manager.transfer.domain.Department;
import com.manager.transfer.domain.Job;
import com.manager.transfer.domain.Staff;
import com.manager.department.dao.DBUtil;

public class StaffDao implements IStaffDao {

	@Override
	public boolean insertStaff(Staff s) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement psp =null;
		System.out.print(conn);
		String sql="insert into staff(S_NAME,S_SEX,S_BIRTHDAY,S_DEPARTMENTID,S_JOBID,S_DATE"
				+ ",S_JSDATE,S_EINFORMATION,S_PSOURCE,S_TEL,S_EMAIL,S_EDUCATION,S_EXPERIENCE"
				+ ",S_ESDATE,S_EEDATE,S_FLANGUAGE,S_FNAME,S_FRELATION,S_DISMISSION,S_IDNUM) "
				+"values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";		//20个属性，编号不插入，让自动增长
//		String sql1="INSERT INTO staff(S_NAME,S_SEX,S_BIRTHDAY,S_DEPARTMENTID,S_JOBID," + 
//				"S_DATE,S_JSDATE,S_EINFORMATION,S_PSOURCE,S_TEL," + 
//				"S_EMAIL,S_EDUCATION,S_EXPERIENCE,S_ESDATE,S_EEDATE," + 
//				"S_FLANGUAGE,S_FNAME,S_FRELATION,S_DISMISSION,S_IDNUM) \r\n" + 
//				"VALUES ('张五','男','2000-01-01',1,2,\r\n" + 
//				"'2020-01-01','2020-01-02','正式员工','校园招聘','123456789132',\r\n" + 
//				"'zhang3@qq.com','本科','大学学习','2010-01-01','2014-02-01',\r\n" + 
//				"'英语','李四','母亲',0,'112458966523664523')";
		try {
			psp = conn.prepareStatement(sql);
			
			psp.setString(1, s.getS_name());	//姓名
			psp.setString(2, s.getS_sex());		//性别（男，女）
			psp.setString(3, s.getS_birthday());	//出生日期
			psp.setInt(4, s.getS_departmentId().getD_id());	//部门号，外键
			psp.setInt(5, s.getS_jobId().getJ_id());		//岗位号，外键
			psp.setString(6, s.getS_date());		//入职日期
			psp.setString(7, s.getS_jsDate());		//参加工作日期
			psp.setString(8, s.getS_eInformation());	//用工形式（正式员工，临时员工）
			psp.setString(9, s.getS_pSource());		//人员来源（校园招聘，社会招聘，其它）
			psp.setString(10, s.getS_Tel());	//联系电话
			psp.setString(11, s.getS_email());	//电子邮件
			psp.setString(12, s.getS_education());	//最高学历（高中及以下，大专，本科，研究生）
			psp.setString(13, s.getS_exprience());	//某一阶段从事工作或学习经历
			psp.setString(14, s.getS_esDate());		//该阶段的起始年月
			psp.setString(15, s.getS_eeDate());	//该阶段的截止年月	
			psp.setString(16, s.getS_fLanguage());		//外国语种（英语，日语，法语）
			psp.setString(17, s.getS_fName());		//员工亲属的姓名
			psp.setString(18, s.getS_fRelation());	//员工亲属与本人关系（父亲、母亲、配偶）
			psp.setBoolean(19, s.isS_dismission());//是否离职	
			psp.setString(20, s.getS_idNum());	//身份证号
			
			psp.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			DBUtil.close(psp,conn);
		}
		return true;
	}

	@Override
	public boolean updateStaffDismissionById(Staff s) {
		Connection conn = DBUtil.getConnection();
		System.out.println(conn);
		String sql="update staff "
				+ " SET S_DISMISSION = ? "
				+" WHERE S_ID = ?";
		
		PreparedStatement psp = null;
		try {
			psp = conn.prepareStatement(sql);
			psp.setInt(2, s.getS_id());
			psp.setBoolean(1, s.isS_dismission());
			
			psp.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			DBUtil.close(psp,conn);
		}
		return true;
	}

	@Override
	public boolean updateStaffDepartmentById(Staff s) {
		Connection conn = DBUtil.getConnection();
		System.out.println(conn);
		String sql="update staff "
				+ " SET S_DEPARTMENTID = ? "
				+" WHERE S_ID = ?";
		
		PreparedStatement psp = null;
		try {
			psp = conn.prepareStatement(sql);
			psp.setInt(2, s.getS_id());
			psp.setInt(1, s.getS_departmentId().getD_id());
			
			psp.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			DBUtil.close(psp,conn);
		}
		return true;
	}

	@Override
	public boolean updateStaffJobById(Staff s) {
		Connection conn = DBUtil.getConnection();
		System.out.println(conn);
		String sql="update staff "
				+ " SET S_JOBID = ? "
				+" WHERE S_ID = ?";
		
		PreparedStatement psp = null;
		try {
			psp = conn.prepareStatement(sql);
			psp.setInt(2, s.getS_id());
			psp.setInt(1, s.getS_jobId().getJ_id());
			
			psp.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			DBUtil.close(psp,conn);
		}
		return true;
	}
	
	@Override
	public ArrayList<Staff> queryStaffTrailByDepartment(Department dep) {
		Connection conn = DBUtil.getConnection();
		ArrayList<Staff> st = new ArrayList<>();
		ResultSet rs = null;
		System.out.println(conn);
		String sql="select S_ID,S_NAME,S_SEX,S_BIRTHDAY,S_DEPARTMENTID,S_JOBID"
				+ ",S_DATE,S_JSDATE,S_EINFORMATION,S_PSOURCE,S_TEL"
				+ ",S_EMAIL,S_EDUCATION,S_EXPERIENCE,S_ESDATE,S_EEDATE"
				+ ",S_FLANGUAGE,S_FNAME,S_FRELATION,S_DISMISSION,S_IDNUM"
				+ ",D_NAME,J_NAME"
				+ " from Staff s, department d,job j, staff_trail st "
				+ " where st.ST_STAFFID = s.S_ID AND s.S_DEPARTMENTID = d.D_ID AND s.S_JOBID=j.J_ID"
				+ " AND st.ST_ID NOT IN(SELECT SC_NUM FROM staff_check) "
				+ " AND d.D_NAME like ? ";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,"%"+dep.getD_name()+"%");
			rs = ps.executeQuery();
			while(rs.next()) {			
				int s_id = rs.getInt(1);	//员工号，主键，自动增长
				String s_name = rs.getString(2);	//姓名
				String s_sex = rs.getString(3);	//性别（1男，2女）
				String s_birthday = rs.getString(4);	//出生日期				
				int d_id = rs.getInt(5);	//部门号，外键
				int j_id = rs.getInt(6);	//岗位号，外键
				 
				String s_date = rs.getString(7);		//入职日期
				String s_jsDate = rs.getString(8);	//参加工作日期
				String s_eInformation = rs.getString(9);	//用工形式（正式员工，临时员工）
				String s_pSource = rs.getString(10);	//人员来源（校园招聘，社会招聘，其它）
				String s_Tel = rs.getString(11);		//联系电话
				
				String s_email = rs.getString(12); 	//电子邮件
				String s_education = rs.getString(13);	//最高学历（高中及以下，大专，本科，研究生）
				String s_exprience = rs.getString(14);	//某一阶段从事工作或学习经历
				String s_esDate = rs.getString(15);	//该阶段的起始年月
				String s_eeDate = rs.getString(16);	//该阶段的截止年月
				
				String s_fLanguage = rs.getString(17);	//外国语种（英语，日语，法语）
				String s_fName = rs.getString(18);		//员工亲属的姓名
				String s_fRelation = rs.getString(19);	//员工亲属与本人关系（父亲、母亲、配偶）
				boolean s_dismission = rs.getBoolean(20);	//是否离职
				String s_idNum = rs.getString(21);		//身份证号
				
				String d_name = rs.getString(22);
				String j_name = rs.getString(23);
				Department d = new Department();
				d.setD_id(d_id);
				d.setD_name(d_name);
				Job j = new Job();
				j.setJ_id(j_id);
				j.setJ_name(j_name);				
				
				Staff s = new Staff(s_id,s_name,s_sex,s_birthday,d,j
						,s_date,s_jsDate,s_eInformation,s_pSource,s_Tel
						,s_email,s_education,s_exprience,s_esDate,s_eeDate
						,s_fLanguage,s_fName,s_fRelation,s_dismission,s_idNum);
				st.add(s);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ps, conn);
		}
		
		return st;//注意返回值中部门和岗位只有id和名称信息有效。
	}

	@Override
	public ArrayList<Staff> queryStaffTrailByJob(Job job) {
		Connection conn = DBUtil.getConnection();
		ArrayList<Staff> st = new ArrayList<>();
		ResultSet rs = null;
		System.out.println(conn);
		String sql="select S_ID,S_NAME,S_SEX,S_BIRTHDAY,S_DEPARTMENTID,S_JOBID"
				+ ",S_DATE,S_JSDATE,S_EINFORMATION,S_PSOURCE,S_TEL"
				+ ",S_EMAIL,S_EDUCATION,S_EXPERIENCE,S_ESDATE,S_EEDATE"
				+ ",S_FLANGUAGE,S_FNAME,S_FRELATION,S_DISMISSION,S_IDNUM"
				+ ",D_NAME,J_NAME"
				+ " from Staff s, department d,job j, staff_trail st "
				+ " where st.ST_STAFFID = s.S_ID AND s.S_DEPARTMENTID = d.D_ID AND s.S_JOBID=j.J_ID"
				+ " AND st.ST_ID NOT IN(SELECT SC_NUM FROM staff_check) "
				+ " AND j.J_NAME like ? ";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,"%"+job.getJ_name()+"%");
			rs = ps.executeQuery();
			while(rs.next()) {			
				int s_id = rs.getInt(1);	//员工号，主键，自动增长
				String s_name = rs.getString(2);	//姓名
				String s_sex = rs.getString(3);	//性别（1男，2女）
				String s_birthday = rs.getString(4);	//出生日期				
				int d_id = rs.getInt(5);	//部门号，外键
				int j_id = rs.getInt(6);	//岗位号，外键
				 
				String s_date = rs.getString(7);		//入职日期
				String s_jsDate = rs.getString(8);	//参加工作日期
				String s_eInformation = rs.getString(9);	//用工形式（正式员工，临时员工）
				String s_pSource = rs.getString(10);	//人员来源（校园招聘，社会招聘，其它）
				String s_Tel = rs.getString(11);		//联系电话
				
				String s_email = rs.getString(12); 	//电子邮件
				String s_education = rs.getString(13);	//最高学历（高中及以下，大专，本科，研究生）
				String s_exprience = rs.getString(14);	//某一阶段从事工作或学习经历
				String s_esDate = rs.getString(15);	//该阶段的起始年月
				String s_eeDate = rs.getString(16);	//该阶段的截止年月
				
				String s_fLanguage = rs.getString(17);	//外国语种（英语，日语，法语）
				String s_fName = rs.getString(18);		//员工亲属的姓名
				String s_fRelation = rs.getString(19);	//员工亲属与本人关系（父亲、母亲、配偶）
				boolean s_dismission = rs.getBoolean(20);	//是否离职
				String s_idNum = rs.getString(21);		//身份证号
				
				String d_name = rs.getString(22);
				String j_name = rs.getString(23);
				Department d = new Department();
				d.setD_id(d_id);
				d.setD_name(d_name);
				Job j = new Job();
				j.setJ_id(j_id);
				j.setJ_name(j_name);				
				
				Staff s = new Staff(s_id,s_name,s_sex,s_birthday,d,j
						,s_date,s_jsDate,s_eInformation,s_pSource,s_Tel
						,s_email,s_education,s_exprience,s_esDate,s_eeDate
						,s_fLanguage,s_fName,s_fRelation,s_dismission,s_idNum);
				st.add(s);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ps, conn);
		}
		
		return st;//注意返回值中部门和岗位只有id和名称信息有效。
	}

	@Override
	public ArrayList<Staff> queryStaffCheckByDepartment(Department dep) {
		Connection conn = DBUtil.getConnection();
		ArrayList<Staff> st = new ArrayList<>();
		ResultSet rs = null;
		System.out.println(conn);
		String sql="select S_ID,S_NAME,S_SEX,S_BIRTHDAY,S_DEPARTMENTID,S_JOBID"
				+ ",S_DATE,S_JSDATE,S_EINFORMATION,S_PSOURCE,S_TEL"
				+ ",S_EMAIL,S_EDUCATION,S_EXPERIENCE,S_ESDATE,S_EEDATE"
				+ ",S_FLANGUAGE,S_FNAME,S_FRELATION,S_DISMISSION,S_IDNUM"
				+ ",D_NAME,J_NAME"
				+ " from Staff s, department d,job j, staff_trail st, staff_check sc "
				+ " where st.ST_STAFFID = s.S_ID AND s.S_DEPARTMENTID = d.D_ID AND s.S_JOBID=j.J_ID"
				+ " AND st.ST_ID = sc.SC_NUM AND sc.SC_RESULT='转正' "
				+ " AND d.D_NAME like ? ";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,"%"+dep.getD_name()+"%");
			rs = ps.executeQuery();
			while(rs.next()) {			
				int s_id = rs.getInt(1);	//员工号，主键，自动增长
				String s_name = rs.getString(2);	//姓名
				String s_sex = rs.getString(3);	//性别（1男，2女）
				String s_birthday = rs.getString(4);	//出生日期				
				int d_id = rs.getInt(5);	//部门号，外键
				int j_id = rs.getInt(6);	//岗位号，外键
				 
				String s_date = rs.getString(7);		//入职日期
				String s_jsDate = rs.getString(8);	//参加工作日期
				String s_eInformation = rs.getString(9);	//用工形式（正式员工，临时员工）
				String s_pSource = rs.getString(10);	//人员来源（校园招聘，社会招聘，其它）
				String s_Tel = rs.getString(11);		//联系电话
				
				String s_email = rs.getString(12); 	//电子邮件
				String s_education = rs.getString(13);	//最高学历（高中及以下，大专，本科，研究生）
				String s_exprience = rs.getString(14);	//某一阶段从事工作或学习经历
				String s_esDate = rs.getString(15);	//该阶段的起始年月
				String s_eeDate = rs.getString(16);	//该阶段的截止年月
				
				String s_fLanguage = rs.getString(17);	//外国语种（英语，日语，法语）
				String s_fName = rs.getString(18);		//员工亲属的姓名
				String s_fRelation = rs.getString(19);	//员工亲属与本人关系（父亲、母亲、配偶）
				boolean s_dismission = rs.getBoolean(20);	//是否离职
				String s_idNum = rs.getString(21);		//身份证号
				
				String d_name = rs.getString(22);
				String j_name = rs.getString(23);
				Department d = new Department();
				d.setD_id(d_id);
				d.setD_name(d_name);
				Job j = new Job();
				j.setJ_id(j_id);
				j.setJ_name(j_name);				
				
				Staff s = new Staff(s_id,s_name,s_sex,s_birthday,d,j
						,s_date,s_jsDate,s_eInformation,s_pSource,s_Tel
						,s_email,s_education,s_exprience,s_esDate,s_eeDate
						,s_fLanguage,s_fName,s_fRelation,s_dismission,s_idNum);
				st.add(s);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ps, conn);
		}
		
		return st;//注意返回值中部门和岗位只有id和名称信息有效。
	}

	@Override
	public ArrayList<Staff> queryStaffCheckByJob(Job job) {
		Connection conn = DBUtil.getConnection();
		ArrayList<Staff> st = new ArrayList<>();
		ResultSet rs = null;
		System.out.println(conn);
		String sql="select S_ID,S_NAME,S_SEX,S_BIRTHDAY,S_DEPARTMENTID,S_JOBID"
				+ ",S_DATE,S_JSDATE,S_EINFORMATION,S_PSOURCE,S_TEL"
				+ ",S_EMAIL,S_EDUCATION,S_EXPERIENCE,S_ESDATE,S_EEDATE"
				+ ",S_FLANGUAGE,S_FNAME,S_FRELATION,S_DISMISSION,S_IDNUM"
				+ ",D_NAME,J_NAME"
				+ " from Staff s, department d,job j, staff_trail st, staff_check sc "
				+ " where st.ST_STAFFID = s.S_ID AND s.S_DEPARTMENTID = d.D_ID AND s.S_JOBID=j.J_ID"
				+ " AND st.ST_ID = sc.SC_NUM AND sc.SC_RESULT='转正' "
				+ " AND j.J_NAME like ? ";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,"%"+job.getJ_name()+"%");
			rs = ps.executeQuery();
			while(rs.next()) {			
				int s_id = rs.getInt(1);	//员工号，主键，自动增长
				String s_name = rs.getString(2);	//姓名
				String s_sex = rs.getString(3);	//性别（1男，2女）
				String s_birthday = rs.getString(4);	//出生日期				
				int d_id = rs.getInt(5);	//部门号，外键
				int j_id = rs.getInt(6);	//岗位号，外键
				 
				String s_date = rs.getString(7);		//入职日期
				String s_jsDate = rs.getString(8);	//参加工作日期
				String s_eInformation = rs.getString(9);	//用工形式（正式员工，临时员工）
				String s_pSource = rs.getString(10);	//人员来源（校园招聘，社会招聘，其它）
				String s_Tel = rs.getString(11);		//联系电话
				
				String s_email = rs.getString(12); 	//电子邮件
				String s_education = rs.getString(13);	//最高学历（高中及以下，大专，本科，研究生）
				String s_exprience = rs.getString(14);	//某一阶段从事工作或学习经历
				String s_esDate = rs.getString(15);	//该阶段的起始年月
				String s_eeDate = rs.getString(16);	//该阶段的截止年月
				
				String s_fLanguage = rs.getString(17);	//外国语种（英语，日语，法语）
				String s_fName = rs.getString(18);		//员工亲属的姓名
				String s_fRelation = rs.getString(19);	//员工亲属与本人关系（父亲、母亲、配偶）
				boolean s_dismission = rs.getBoolean(20);	//是否离职
				String s_idNum = rs.getString(21);		//身份证号
				
				String d_name = rs.getString(22);
				String j_name = rs.getString(23);
				Department d = new Department();
				d.setD_id(d_id);
				d.setD_name(d_name);
				Job j = new Job();
				j.setJ_id(j_id);
				j.setJ_name(j_name);				
				
				Staff s = new Staff(s_id,s_name,s_sex,s_birthday,d,j
						,s_date,s_jsDate,s_eInformation,s_pSource,s_Tel
						,s_email,s_education,s_exprience,s_esDate,s_eeDate
						,s_fLanguage,s_fName,s_fRelation,s_dismission,s_idNum);
				st.add(s);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ps, conn);
		}
		
		return st;//注意返回值中部门和岗位只有id和名称信息有效。
	}
	
	@Override
	public ArrayList<Staff> queryStaffByBase() {
		Connection conn = DBUtil.getConnection();
		ArrayList<Staff> st = new ArrayList<>();
		ResultSet rs = null;
		System.out.println(conn);
		String sql="select S_ID,S_NAME,S_SEX,S_BIRTHDAY,S_DEPARTMENTID,S_JOBID"
				+ ",S_DATE,S_JSDATE,S_EINFORMATION,S_PSOURCE,S_TEL"
				+ ",S_EMAIL,S_EDUCATION,S_EXPERIENCE,S_ESDATE,S_EEDATE"
				+ ",S_FLANGUAGE,S_FNAME,S_FRELATION,S_DISMISSION,S_IDNUM"
				+ ",D_NAME,J_NAME"
				+ " from base b,Staff s, department d,job j"
				+ " where b.B_STAFFID = s.S_ID AND s.S_DEPARTMENTID = d.D_ID AND s.S_JOBID=j.J_ID ";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {			
				int s_id = rs.getInt(1);	//员工号，主键，自动增长
				String s_name = rs.getString(2);	//姓名
				String s_sex = rs.getString(3);	//性别（1男，2女）
				String s_birthday = rs.getString(4);	//出生日期				
				int d_id = rs.getInt(5);	//部门号，外键
				int j_id = rs.getInt(6);	//岗位号，外键
				 
				String s_date = rs.getString(7);		//入职日期
				String s_jsDate = rs.getString(8);	//参加工作日期
				String s_eInformation = rs.getString(9);	//用工形式（正式员工，临时员工）
				String s_pSource = rs.getString(10);	//人员来源（校园招聘，社会招聘，其它）
				String s_Tel = rs.getString(11);		//联系电话
				
				String s_email = rs.getString(12); 	//电子邮件
				String s_education = rs.getString(13);	//最高学历（高中及以下，大专，本科，研究生）
				String s_exprience = rs.getString(14);	//某一阶段从事工作或学习经历
				String s_esDate = rs.getString(15);	//该阶段的起始年月
				String s_eeDate = rs.getString(16);	//该阶段的截止年月
				
				String s_fLanguage = rs.getString(17);	//外国语种（英语，日语，法语）
				String s_fName = rs.getString(18);		//员工亲属的姓名
				String s_fRelation = rs.getString(19);	//员工亲属与本人关系（父亲、母亲、配偶）
				boolean s_dismission = rs.getBoolean(20);	//是否离职
				String s_idNum = rs.getString(21);		//身份证号
				
				String d_name = rs.getString(22);
				String j_name = rs.getString(23);
				Department d = new Department();
				d.setD_id(d_id);
				d.setD_name(d_name);
				Job j = new Job();
				j.setJ_id(j_id);
				j.setJ_name(j_name);				
				
				Staff s = new Staff(s_id,s_name,s_sex,s_birthday,d,j
						,s_date,s_jsDate,s_eInformation,s_pSource,s_Tel
						,s_email,s_education,s_exprience,s_esDate,s_eeDate
						,s_fLanguage,s_fName,s_fRelation,s_dismission,s_idNum);
				st.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ps, conn);
		}	
		return st;//注意返回值中部门和岗位只有id和名称信息有效。
	}

	@Override
	public ArrayList<Staff> queryStaffByDis() {
		Connection conn = DBUtil.getConnection();
		ArrayList<Staff> st = new ArrayList<>();
		ResultSet rs = null;
		System.out.println(conn);
		String sql="select S_ID,S_NAME,S_SEX,S_BIRTHDAY,S_DEPARTMENTID,S_JOBID"
				+ ",S_DATE,S_JSDATE,S_EINFORMATION,S_PSOURCE,S_TEL"
				+ ",S_EMAIL,S_EDUCATION,S_EXPERIENCE,S_ESDATE,S_EEDATE"
				+ ",S_FLANGUAGE,S_FNAME,S_FRELATION,S_DISMISSION,S_IDNUM"
				+ ",D_NAME,J_NAME"
				+ " from Staff s, department d,job j"
				+ " where s.S_DISMISSION = 0  AND s.S_DEPARTMENTID = d.D_ID AND s.S_JOBID=j.J_ID ";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {			
				int s_id = rs.getInt(1);	//员工号，主键，自动增长
				String s_name = rs.getString(2);	//姓名
				String s_sex = rs.getString(3);	//性别（1男，2女）
				String s_birthday = rs.getString(4);	//出生日期				
				int d_id = rs.getInt(5);	//部门号，外键
				int j_id = rs.getInt(6);	//岗位号，外键
				 
				String s_date = rs.getString(7);		//入职日期
				String s_jsDate = rs.getString(8);	//参加工作日期
				String s_eInformation = rs.getString(9);	//用工形式（正式员工，临时员工）
				String s_pSource = rs.getString(10);	//人员来源（校园招聘，社会招聘，其它）
				String s_Tel = rs.getString(11);		//联系电话
				
				String s_email = rs.getString(12); 	//电子邮件
				String s_education = rs.getString(13);	//最高学历（高中及以下，大专，本科，研究生）
				String s_exprience = rs.getString(14);	//某一阶段从事工作或学习经历
				String s_esDate = rs.getString(15);	//该阶段的起始年月
				String s_eeDate = rs.getString(16);	//该阶段的截止年月
				
				String s_fLanguage = rs.getString(17);	//外国语种（英语，日语，法语）
				String s_fName = rs.getString(18);		//员工亲属的姓名
				String s_fRelation = rs.getString(19);	//员工亲属与本人关系（父亲、母亲、配偶）
				boolean s_dismission = rs.getBoolean(20);	//是否离职
				String s_idNum = rs.getString(21);		//身份证号
				
				String d_name = rs.getString(22);
				String j_name = rs.getString(23);
				Department d = new Department();
				d.setD_id(d_id);
				d.setD_name(d_name);
				Job j = new Job();
				j.setJ_id(j_id);
				j.setJ_name(j_name);				
				
				Staff s = new Staff(s_id,s_name,s_sex,s_birthday,d,j
						,s_date,s_jsDate,s_eInformation,s_pSource,s_Tel
						,s_email,s_education,s_exprience,s_esDate,s_eeDate
						,s_fLanguage,s_fName,s_fRelation,s_dismission,s_idNum);
				st.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ps, conn);
		}	
		return st;//注意返回值中部门和岗位只有id和名称信息有效。
	}
	
	
//	public static void main(String[] args) {
////		Department d = new Department();
////		d.setD_id(1);
////		Job j = new Job();
////		j.setJ_id(2);
////		Staff s = new Staff("张六","男","2000-01-01",d,j,
////				"2020-01-01","2020-01-02","正式员工","校园招聘","123456789134",
////				"zhang4@qq.com","本科","大学学习","2010-01-01","2014-02-01",
////				"英语","李六","母亲",false,"112458966523664524");
//		
//		StaffDao sd = new StaffDao();
////		Staff s = new Staff();
////		s.setS_id(1);
////		Job j = new Job();
////		j.setJ_id(1);
////		s.setS_jobId(j);
////		sd.updateStaffJobById(s);
//		Department dep = new Department();
//		dep.setD_name("销售");
//		
//		ArrayList<Staff> als = sd.queryStaffCheckByDepartment(dep);
//		for(Staff s:als) {
//			System.out.println(s.toString());
//			System.out.println(s.getS_departmentId().getD_name());
//			System.out.println(s.getS_jobId().getJ_name());
//		}
//		
//	}

	@Override
	public Staff queryStaffByIdNum(String idNum) {
		Connection conn = DBUtil.getConnection();
		String sql = "select S_ID from staff where S_IDNUM = ?";
		PreparedStatement ps = null;
		ResultSet rs  = null;
		Staff st =new Staff();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, idNum);
			rs = ps.executeQuery();
			
			while(rs.next()) {							
				int s_id = rs.getInt(1);
				
				st.setS_id(s_id);					
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		finally {
			DBUtil.close(ps, conn);
		}
		return st;	
	}
//	public static void main(String [] args) {
//		IStaffService idd =new StaffService();
//		Job job = new Job();
//		job.setJ_name("主管");
//		ArrayList<Staff> st = idd.queryStaffByJob(job);
//		for(Staff s:st) {
//			System.out.println(s.toString());
//		}
//		System.out.println(st.size());
//	}

	@Override
	public ArrayList<Staff> queryStaffByDepartment(Department dep) {
		Connection conn = DBUtil.getConnection();
		ArrayList<Staff> st = new ArrayList<>();
		ResultSet rs = null;
		System.out.println(conn);
		String sql="select S_ID,S_NAME,S_SEX,S_BIRTHDAY,S_DEPARTMENTID,S_JOBID"
				+ ",S_DATE,S_JSDATE,S_EINFORMATION,S_PSOURCE,S_TEL"
				+ ",S_EMAIL,S_EDUCATION,S_EXPERIENCE,S_ESDATE,S_EEDATE"
				+ ",S_FLANGUAGE,S_FNAME,S_FRELATION,S_DISMISSION,S_IDNUM"
				+ ",D_NAME,J_NAME"
				+ " from Staff s, department d,job j "
				+ " WHERE s.S_DEPARTMENTID = d.D_ID AND s.S_JOBID=j.J_ID"
				+ " AND d.D_NAME like ? ";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,"%"+dep.getD_name()+"%");
			rs = ps.executeQuery();
			while(rs.next()) {			
				int s_id = rs.getInt(1);	//员工号，主键，自动增长
				String s_name = rs.getString(2);	//姓名
				String s_sex = rs.getString(3);	//性别（1男，2女）
				String s_birthday = rs.getString(4);	//出生日期				
				int d_id = rs.getInt(5);	//部门号，外键
				int j_id = rs.getInt(6);	//岗位号，外键
				 
				String s_date = rs.getString(7);		//入职日期
				String s_jsDate = rs.getString(8);	//参加工作日期
				String s_eInformation = rs.getString(9);	//用工形式（正式员工，临时员工）
				String s_pSource = rs.getString(10);	//人员来源（校园招聘，社会招聘，其它）
				String s_Tel = rs.getString(11);		//联系电话
				
				String s_email = rs.getString(12); 	//电子邮件
				String s_education = rs.getString(13);	//最高学历（高中及以下，大专，本科，研究生）
				String s_exprience = rs.getString(14);	//某一阶段从事工作或学习经历
				String s_esDate = rs.getString(15);	//该阶段的起始年月
				String s_eeDate = rs.getString(16);	//该阶段的截止年月
				
				String s_fLanguage = rs.getString(17);	//外国语种（英语，日语，法语）
				String s_fName = rs.getString(18);		//员工亲属的姓名
				String s_fRelation = rs.getString(19);	//员工亲属与本人关系（父亲、母亲、配偶）
				boolean s_dismission = rs.getBoolean(20);	//是否离职
				String s_idNum = rs.getString(21);		//身份证号
				
				String d_name = rs.getString(22);
				String j_name = rs.getString(23);
				Department d = new Department();
				d.setD_id(d_id);
				d.setD_name(d_name);
				Job j = new Job();
				j.setJ_id(j_id);
				j.setJ_name(j_name);				
				
				Staff s = new Staff(s_id,s_name,s_sex,s_birthday,d,j
						,s_date,s_jsDate,s_eInformation,s_pSource,s_Tel
						,s_email,s_education,s_exprience,s_esDate,s_eeDate
						,s_fLanguage,s_fName,s_fRelation,s_dismission,s_idNum);
				st.add(s);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ps, conn);
		}
		
		return st;//注意返回值中部门和岗位只有id和名称信息有效。
	}

	@Override
	public ArrayList<Staff> queryStaffByJob(Job job) {
		Connection conn = DBUtil.getConnection();
		ArrayList<Staff> st = new ArrayList<>();
		ResultSet rs = null;
		System.out.println(conn);
		String sql="select S_ID,S_NAME,S_SEX,S_BIRTHDAY,S_DEPARTMENTID,S_JOBID"
				+ ",S_DATE,S_JSDATE,S_EINFORMATION,S_PSOURCE,S_TEL"
				+ ",S_EMAIL,S_EDUCATION,S_EXPERIENCE,S_ESDATE,S_EEDATE"
				+ ",S_FLANGUAGE,S_FNAME,S_FRELATION,S_DISMISSION,S_IDNUM"
				+ ",D_NAME,J_NAME"
				+ " from Staff s, department d,job j  "
				+ " where s.S_DEPARTMENTID = d.D_ID AND s.S_JOBID=j.J_ID"
				+ " AND j.J_NAME like ? ";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,"%"+job.getJ_name()+"%");
			rs = ps.executeQuery();
			while(rs.next()) {			
				int s_id = rs.getInt(1);	//员工号，主键，自动增长
				String s_name = rs.getString(2);	//姓名
				String s_sex = rs.getString(3);	//性别（1男，2女）
				String s_birthday = rs.getString(4);	//出生日期				
				int d_id = rs.getInt(5);	//部门号，外键
				int j_id = rs.getInt(6);	//岗位号，外键
				 
				String s_date = rs.getString(7);		//入职日期
				String s_jsDate = rs.getString(8);	//参加工作日期
				String s_eInformation = rs.getString(9);	//用工形式（正式员工，临时员工）
				String s_pSource = rs.getString(10);	//人员来源（校园招聘，社会招聘，其它）
				String s_Tel = rs.getString(11);		//联系电话
				
				String s_email = rs.getString(12); 	//电子邮件
				String s_education = rs.getString(13);	//最高学历（高中及以下，大专，本科，研究生）
				String s_exprience = rs.getString(14);	//某一阶段从事工作或学习经历
				String s_esDate = rs.getString(15);	//该阶段的起始年月
				String s_eeDate = rs.getString(16);	//该阶段的截止年月
				
				String s_fLanguage = rs.getString(17);	//外国语种（英语，日语，法语）
				String s_fName = rs.getString(18);		//员工亲属的姓名
				String s_fRelation = rs.getString(19);	//员工亲属与本人关系（父亲、母亲、配偶）
				boolean s_dismission = rs.getBoolean(20);	//是否离职
				String s_idNum = rs.getString(21);		//身份证号
				
				String d_name = rs.getString(22);
				String j_name = rs.getString(23);
				Department d = new Department();
				d.setD_id(d_id);
				d.setD_name(d_name);
				Job j = new Job();
				j.setJ_id(j_id);
				j.setJ_name(j_name);				
				
				Staff s = new Staff(s_id,s_name,s_sex,s_birthday,d,j
						,s_date,s_jsDate,s_eInformation,s_pSource,s_Tel
						,s_email,s_education,s_exprience,s_esDate,s_eeDate
						,s_fLanguage,s_fName,s_fRelation,s_dismission,s_idNum);
				st.add(s);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ps, conn);
		}
		
		return st;//注意返回值中部门和岗位只有id和名称信息有效。
	}
}
