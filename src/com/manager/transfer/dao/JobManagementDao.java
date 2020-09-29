package com.manager.transfer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.manager.department.dao.DBUtil;
import com.manager.transfer.domain.Department;
import com.manager.transfer.domain.Job;
import com.manager.transfer.domain.JobTransfer;
import com.manager.transfer.domain.Staff;

public class JobManagementDao implements IJobManagementDao{

	@Override
	public boolean insertJobTransfer(JobTransfer jt) {
		Connection conn = DBUtil.getConnection();
		System.out.println(conn);
		String sql="insert into job_transfer (JT_PRE_JOB,JT_JOB,JT_STAFFID,"
				+ "JT_TYPE,JT_DATE) "
				+"values (?,?,?,?,?)";
		PreparedStatement psp = null;
		try {
			psp = conn.prepareStatement(sql);
			psp.setInt(1, jt.getJt_preJob().getJ_id());
			psp.setInt(2, jt.getJt_job().getJ_id());
			psp.setInt(3, jt.getJt_staffId().getS_id());
			psp.setString(4, jt.getJt_type());
			psp.setString(5, jt.getJt_date());
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
	public boolean updateJobTransfer(JobTransfer jt) {
		Connection conn = DBUtil.getConnection();
		System.out.println(conn);
		String sql="update job_transfer "
				+ " SET JT_PRE_JOB = ? ,JT_JOB = ? ,JT_STAFFID = ? , "
				+ " JT_TYPE = ?,JT_DATE = ? "
				+ " WHERE JT_ID = ? ";
		PreparedStatement psp = null;
		try {
			psp = conn.prepareStatement(sql);
			psp.setInt(6, jt.getJt_id());
			psp.setInt(1, jt.getJt_preJob().getJ_id());
			psp.setInt(2, jt.getJt_job().getJ_id());
			psp.setInt(3, jt.getJt_staffId().getS_id());
			psp.setString(4, jt.getJt_type());
			psp.setString(5, jt.getJt_date());
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
	public boolean deleteJobTransfer(JobTransfer jt) {
		Connection conn = DBUtil.getConnection();
		System.out.println(conn);
		String sql="delete from job_transfer "
				+ " WHERE JT_ID = ? ";
		PreparedStatement psp = null;
		try {
			psp = conn.prepareStatement(sql);
			psp.setInt(1, jt.getJt_id());
			
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
	public ArrayList<JobTransfer> queryjtById(int id) {
		Connection conn = DBUtil.getConnection();
		ArrayList<JobTransfer> alj = new ArrayList<>();
		ResultSet rs = null;
		System.out.println(conn);
		String sql="select JT_ID,JT_PRE_JOB,JT_JOB,JT_STAFFID,JT_TYPE"
				+ ",JT_DATE,jb.J_NAME,j.J_NAME,s.S_NAME"
				+ " from job_transfer jt,job jb,job j,staff s"
				+ " where jb.J_ID=jt.JT_PRE_JOB AND j.J_ID=jt.JT_JOB"
				+ " AND s.S_ID=jt.JT_STAFFID AND "
				+ "jt.JT_ID = ?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			rs = ps.executeQuery();
			while(rs.next()) {			
				int jt_id = rs.getInt(1);	//员工号，主键，自动增长
				int jt_preJob = rs.getInt(2);	//调转前的部门，外键
				int jt_job = rs.getInt(3);	//调转后的部门，外键
				int jt_staffId = rs.getInt(4);	//调转员工，外键
				String jt_type = rs.getString(5);	//调转类型（主动调动，被动调动，数据错误）
				String jt_date= rs.getString(6);	//调动日期
				String jbj_name= rs.getString(7);	
				String jj_name= rs.getString(8);	
				String ss_name= rs.getString(9);	
				
				Job jb = new Job();
				jb.setJ_id(jt_preJob);
				Job j = new Job();
				j.setJ_id(jt_job);
				Staff s = new Staff();
				s.setS_id(jt_staffId);
				
				jb.setJ_name(jbj_name);
				j.setJ_name(jj_name);
				s.setS_name(ss_name);
				
				JobTransfer jt = new JobTransfer(jt_id,jb,j,s,jt_type,jt_date);
				alj.add(jt);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.close(rs, ps, conn);
		}
		return alj;
	}

	@Override
	public ArrayList<JobTransfer> queryjtByPreJobId(int preJobId) {
		Connection conn = DBUtil.getConnection();
		ArrayList<JobTransfer> alj = new ArrayList<>();
		ResultSet rs = null;
		System.out.println(conn);
		String sql="select JT_ID,JT_PRE_JOB,JT_JOB,JT_STAFFID,JT_TYPE"
				+ ",JT_DATE,jb.J_NAME,j.J_NAME,s.S_NAME"
				+ " from job_transfer jt,job jb,job j,staff s"
				+ " where jb.J_ID=jt.JT_PRE_JOB AND j.J_ID=jt.JT_JOB"
				+ " AND s.S_ID=jt.JT_STAFFID AND "
				+ "jt.JT_PRE_JOB = ?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1,preJobId);
			rs = ps.executeQuery();
			while(rs.next()) {			
				int jt_id = rs.getInt(1);	//员工号，主键，自动增长
				int jt_preJob = rs.getInt(2);	//调转前的部门，外键
				int jt_job = rs.getInt(3);	//调转后的部门，外键
				int jt_staffId = rs.getInt(4);	//调转员工，外键
				String jt_type = rs.getString(5);	//调转类型（主动调动，被动调动，数据错误）
				String jt_date= rs.getString(6);	//调动日期
				String jbj_name= rs.getString(7);	
				String jj_name= rs.getString(8);	
				String ss_name= rs.getString(9);	
				
				Job jb = new Job();
				jb.setJ_id(jt_preJob);
				Job j = new Job();
				j.setJ_id(jt_job);
				Staff s = new Staff();
				s.setS_id(jt_staffId);
				
				jb.setJ_name(jbj_name);
				j.setJ_name(jj_name);
				s.setS_name(ss_name);
				
				JobTransfer jt = new JobTransfer(jt_id,jb,j,s,jt_type,jt_date);
				alj.add(jt);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.close(rs, ps, conn);
		}
		return alj;
	}

	@Override
	public ArrayList<JobTransfer> queryjtByJobId(int jobId) {
		Connection conn = DBUtil.getConnection();
		ArrayList<JobTransfer> alj = new ArrayList<>();
		ResultSet rs = null;
		System.out.println(conn);
		String sql="select JT_ID,JT_PRE_JOB,JT_JOB,JT_STAFFID,JT_TYPE"
				+ ",JT_DATE,jb.J_NAME,j.J_NAME,s.S_NAME"
				+ " from job_transfer jt,job jb,job j,staff s"
				+ " where jb.J_ID=jt.JT_PRE_JOB AND j.J_ID=jt.JT_JOB"
				+ " AND s.S_ID=jt.JT_STAFFID AND "
				+ "jt.JT_JOB = ?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1,jobId);
			rs = ps.executeQuery();
			while(rs.next()) {			
				int jt_id = rs.getInt(1);	//员工号，主键，自动增长
				int jt_preJob = rs.getInt(2);	//调转前的部门，外键
				int jt_job = rs.getInt(3);	//调转后的部门，外键
				int jt_staffId = rs.getInt(4);	//调转员工，外键
				String jt_type = rs.getString(5);	//调转类型（主动调动，被动调动，数据错误）
				String jt_date= rs.getString(6);	//调动日期
				String jbj_name= rs.getString(7);	
				String jj_name= rs.getString(8);	
				String ss_name= rs.getString(9);	
				
				Job jb = new Job();
				jb.setJ_id(jt_preJob);
				Job j = new Job();
				j.setJ_id(jt_job);
				Staff s = new Staff();
				s.setS_id(jt_staffId);
				
				jb.setJ_name(jbj_name);
				j.setJ_name(jj_name);
				s.setS_name(ss_name);
				
				JobTransfer jt = new JobTransfer(jt_id,jb,j,s,jt_type,jt_date);
				alj.add(jt);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.close(rs, ps, conn);
		}
		return alj;
	}

	@Override
	public ArrayList<JobTransfer> queryjtByStaffId(int staffId) {
		Connection conn = DBUtil.getConnection();
		ArrayList<JobTransfer> alj = new ArrayList<>();
		ResultSet rs = null;
		System.out.println(conn);
		String sql="select JT_ID,JT_PRE_JOB,JT_JOB,JT_STAFFID,JT_TYPE"
				+ ",JT_DATE,jb.J_NAME,j.J_NAME,s.S_NAME"
				+ " from job_transfer jt,job jb,job j,staff s"
				+ " where jb.J_ID=jt.JT_PRE_JOB AND j.J_ID=jt.JT_JOB"
				+ " AND s.S_ID=jt.JT_STAFFID AND "
				+ "jt.JT_STAFFID = ?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1,staffId);
			rs = ps.executeQuery();
			while(rs.next()) {			
				int jt_id = rs.getInt(1);	//员工号，主键，自动增长
				int jt_preJob = rs.getInt(2);	//调转前的部门，外键
				int jt_job = rs.getInt(3);	//调转后的部门，外键
				int jt_staffId = rs.getInt(4);	//调转员工，外键
				String jt_type = rs.getString(5);	//调转类型（主动调动，被动调动，数据错误）
				String jt_date= rs.getString(6);	//调动日期
				String jbj_name= rs.getString(7);	
				String jj_name= rs.getString(8);	
				String ss_name= rs.getString(9);	
				
				Job jb = new Job();
				jb.setJ_id(jt_preJob);
				Job j = new Job();
				j.setJ_id(jt_job);
				Staff s = new Staff();
				s.setS_id(jt_staffId);
				
				jb.setJ_name(jbj_name);
				j.setJ_name(jj_name);
				s.setS_name(ss_name);
				
				JobTransfer jt = new JobTransfer(jt_id,jb,j,s,jt_type,jt_date);
				alj.add(jt);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.close(rs, ps, conn);
		}
		return alj;
	}

	@Override
	public ArrayList<JobTransfer> queryjtByType(String type) {
		Connection conn = DBUtil.getConnection();
		ArrayList<JobTransfer> alj = new ArrayList<>();
		ResultSet rs = null;
		System.out.println(conn);
		String sql="select JT_ID,JT_PRE_JOB,JT_JOB,JT_STAFFID,JT_TYPE"
				+ ",JT_DATE,jb.J_NAME,j.J_NAME,s.S_NAME"
				+ " from job_transfer jt,job jb,job j,staff s"
				+ " where jb.J_ID=jt.JT_PRE_JOB AND j.J_ID=jt.JT_JOB"
				+ " AND s.S_ID=jt.JT_STAFFID AND "
				+ "jt.JT_TYPE = ?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,type);
			rs = ps.executeQuery();
			while(rs.next()) {			
				int jt_id = rs.getInt(1);	//员工号，主键，自动增长
				int jt_preJob = rs.getInt(2);	//调转前的部门，外键
				int jt_job = rs.getInt(3);	//调转后的部门，外键
				int jt_staffId = rs.getInt(4);	//调转员工，外键
				String jt_type = rs.getString(5);	//调转类型（主动调动，被动调动，数据错误）
				String jt_date= rs.getString(6);	//调动日期
				String jbj_name= rs.getString(7);	
				String jj_name= rs.getString(8);	
				String ss_name= rs.getString(9);	
				
				Job jb = new Job();
				jb.setJ_id(jt_preJob);
				Job j = new Job();
				j.setJ_id(jt_job);
				Staff s = new Staff();
				s.setS_id(jt_staffId);
				
				jb.setJ_name(jbj_name);
				j.setJ_name(jj_name);
				s.setS_name(ss_name);
				
				JobTransfer jt = new JobTransfer(jt_id,jb,j,s,jt_type,jt_date);
				alj.add(jt);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.close(rs, ps, conn);
		}
		return alj;
	}

	@Override
	public ArrayList<JobTransfer> queryjtByDate(String date) {
		Connection conn = DBUtil.getConnection();
		ArrayList<JobTransfer> alj = new ArrayList<>();
		ResultSet rs = null;
		System.out.println(conn);
		String sql="select JT_ID,JT_PRE_JOB,JT_JOB,JT_STAFFID,JT_TYPE"
				+ ",JT_DATE,jb.J_NAME,j.J_NAME,s.S_NAME"
				+ " from job_transfer jt,job jb,job j,staff s"
				+ " where jb.J_ID=jt.JT_PRE_JOB AND j.J_ID=jt.JT_JOB"
				+ " AND s.S_ID=jt.JT_STAFFID AND "
				+ "jt.JT_DATE = ?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,date);
			rs = ps.executeQuery();
			while(rs.next()) {			
				int jt_id = rs.getInt(1);	//员工号，主键，自动增长
				int jt_preJob = rs.getInt(2);	//调转前的部门，外键
				int jt_job = rs.getInt(3);	//调转后的部门，外键
				int jt_staffId = rs.getInt(4);	//调转员工，外键
				String jt_type = rs.getString(5);	//调转类型（主动调动，被动调动，数据错误）
				String jt_date= rs.getString(6);	//调动日期
				String jbj_name= rs.getString(7);	
				String jj_name= rs.getString(8);	
				String ss_name= rs.getString(9);	
				
				Job jb = new Job();
				jb.setJ_id(jt_preJob);
				Job j = new Job();
				j.setJ_id(jt_job);
				Staff s = new Staff();
				s.setS_id(jt_staffId);
				
				jb.setJ_name(jbj_name);
				j.setJ_name(jj_name);
				s.setS_name(ss_name);
				
				JobTransfer jt = new JobTransfer(jt_id,jb,j,s,jt_type,jt_date);
				alj.add(jt);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.close(rs, ps, conn);
		}
		return alj;
	}
//	public static void main(String[] args) {
//		IJobManagementDao jmd = new JobManagementDao();
//		
////		Job jb = new Job();
////		jb.setJ_id(1);
////		Job ja = new Job();
////		ja.setJ_id(2);
////		Staff s = new Staff();
////		s.setS_id(1);
////		JobTransfer jt = new JobTransfer(3,jb,ja,s,"降职","2013-02-03");
////		jmd.deleteJobTransfer(jt);
//		ArrayList<JobTransfer> jts = jmd.queryjtByJobName("主任");
//		for(JobTransfer jt:jts) {
//			System.out.println(jt.toString());			
//		}
//	}

	@Override
	public ArrayList<Staff> queryjtStaffb(String jobName) {
		Connection conn = DBUtil.getConnection();
		ArrayList<Staff> st = new ArrayList<>();
		ResultSet rs = null;
		System.out.println(conn);
		String sql="select S_ID,S_NAME,S_SEX,S_BIRTHDAY,S_DEPARTMENTID,S_JOBID"
				+ ",S_DATE,S_JSDATE,S_EINFORMATION,S_PSOURCE,S_TEL"
				+ ",S_EMAIL,S_EDUCATION,S_EXPERIENCE,S_ESDATE,S_EEDATE"
				+ ",S_FLANGUAGE,S_FNAME,S_FRELATION,S_DISMISSION,S_IDNUM"
				+ ",D_NAME,J_NAME"
				+ " from job_transfer jt,Staff s, department d,job j"
				+ " where jt.JT_STAFFID = s.S_ID AND jt.JT_PRE_JOB = j.J_ID AND s.S_DEPARTMENTID=d.D_ID"
				+ " AND j.J_NAME like ? ";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,"%"+jobName+"%");
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
	public ArrayList<Staff> queryjtStaffa(String jobName) {
		Connection conn = DBUtil.getConnection();
		ArrayList<Staff> st = new ArrayList<>();
		ResultSet rs = null;
		System.out.println(conn);
		String sql="select S_ID,S_NAME,S_SEX,S_BIRTHDAY,S_DEPARTMENTID,S_JOBID"
				+ ",S_DATE,S_JSDATE,S_EINFORMATION,S_PSOURCE,S_TEL"
				+ ",S_EMAIL,S_EDUCATION,S_EXPERIENCE,S_ESDATE,S_EEDATE"
				+ ",S_FLANGUAGE,S_FNAME,S_FRELATION,S_DISMISSION,S_IDNUM"
				+ ",D_NAME,J_NAME"
				+ " from job_transfer jt,Staff s, department d,job j"
				+ " where jt.JT_STAFFID = s.S_ID AND jt.JT_JOB = j.J_ID AND s.S_DEPARTMENTID=d.D_ID"
				+ " AND j.J_NAME like ? ";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,"%"+jobName+"%");
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
	public ArrayList<JobTransfer> queryjtByPreJobName(String preJobName) {
		Connection conn = DBUtil.getConnection();
		ArrayList<JobTransfer> alj = new ArrayList<>();
		ResultSet rs = null;
		System.out.println(conn);
		String sql="select JT_ID,JT_PRE_JOB,JT_JOB,JT_STAFFID,JT_TYPE"
				+ ",JT_DATE,jb.J_NAME,j.J_NAME,s.S_NAME"
				+ " from job_transfer jt,job jb,job j,staff s"
				+ " where jb.J_ID=jt.JT_PRE_JOB AND j.J_ID=jt.JT_JOB"
				+ " AND s.S_ID=jt.JT_STAFFID AND "
				+ "jb.J_NAME LIKE ?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,"%"+preJobName+"%");
			rs = ps.executeQuery();
			while(rs.next()) {			
				int jt_id = rs.getInt(1);	//员工号，主键，自动增长
				int jt_preJob = rs.getInt(2);	//调转前的部门，外键
				int jt_job = rs.getInt(3);	//调转后的部门，外键
				int jt_staffId = rs.getInt(4);	//调转员工，外键
				String jt_type = rs.getString(5);	//调转类型（主动调动，被动调动，数据错误）
				String jt_date= rs.getString(6);	//调动日期
				String jbj_name= rs.getString(7);	
				String jj_name= rs.getString(8);	
				String ss_name= rs.getString(9);	
				
				Job jb = new Job();
				jb.setJ_id(jt_preJob);
				Job j = new Job();
				j.setJ_id(jt_job);
				Staff s = new Staff();
				s.setS_id(jt_staffId);
				
				jb.setJ_name(jbj_name);
				j.setJ_name(jj_name);
				s.setS_name(ss_name);
				
				JobTransfer jt = new JobTransfer(jt_id,jb,j,s,jt_type,jt_date);
				alj.add(jt);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.close(rs, ps, conn);
		}
		return alj;
	}

	@Override
	public ArrayList<JobTransfer> queryjtByJobName(String JobName) {
		Connection conn = DBUtil.getConnection();
		ArrayList<JobTransfer> alj = new ArrayList<>();
		ResultSet rs = null;
		System.out.println(conn);
		String sql="select JT_ID,JT_PRE_JOB,JT_JOB,JT_STAFFID,JT_TYPE"
				+ ",JT_DATE,jb.J_NAME,j.J_NAME,s.S_NAME"
				+ " from job_transfer jt,job jb,job j,staff s"
				+ " where jb.J_ID=jt.JT_PRE_JOB AND j.J_ID=jt.JT_JOB"
				+ " AND s.S_ID=jt.JT_STAFFID AND "
				+ "j.J_NAME LIKE ?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,"%"+JobName+"%");
			rs = ps.executeQuery();
			while(rs.next()) {			
				int jt_id = rs.getInt(1);	//员工号，主键，自动增长
				int jt_preJob = rs.getInt(2);	//调转前的部门，外键
				int jt_job = rs.getInt(3);	//调转后的部门，外键
				int jt_staffId = rs.getInt(4);	//调转员工，外键
				String jt_type = rs.getString(5);	//调转类型（主动调动，被动调动，数据错误）
				String jt_date= rs.getString(6);	//调动日期
				String jbj_name= rs.getString(7);	
				String jj_name= rs.getString(8);	
				String ss_name= rs.getString(9);	
				
				Job jb = new Job();
				jb.setJ_id(jt_preJob);
				Job j = new Job();
				j.setJ_id(jt_job);
				Staff s = new Staff();
				s.setS_id(jt_staffId);
				
				jb.setJ_name(jbj_name);
				j.setJ_name(jj_name);
				s.setS_name(ss_name);
				
				JobTransfer jt = new JobTransfer(jt_id,jb,j,s,jt_type,jt_date);
				alj.add(jt);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.close(rs, ps, conn);
		}
		return alj;
	}

}
