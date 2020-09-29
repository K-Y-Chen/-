package com.manager.employee.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.manager.department.dao.*;
import com.manager.employee.domain.*;


public class EmployeeDao implements IEmployeeDao {

	@Override
	public ArrayList<Employee> queryEmployee(String employeename) {
		ArrayList<Employee> employees = new ArrayList<>();
		//String ppname = "%"+productname+"%";
		Connection conn = DBUtil.getConnection();
		String sql = "select e.S_ID,e.S_NAME,e.S_SEX,e.S_TEL,e.S_DEPARTMENTID,e.S_JOBID,d.D_NAME,j.J_NAME"
				+ " from STAFF e,DEPARTMENT d,JOB j "
				+ " where s_dismission=0 and e.S_DEPARTMENTID=d.D_ID and e.S_JOBID=J.J_ID and S_NAME like ? ";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+employeename+"%");
			rs = ps.executeQuery();
			while(rs.next()) {
				int eid = rs.getInt(1);
				String ename = rs.getString(2);
				String esex = rs.getString(3);
				String etel = rs.getString(4);
				int edepartmentid = rs.getInt(5);
				int ejobid = rs.getInt(6);
				String dname = rs.getString(7);
				String jname = rs.getString(8);
				Department di = new Department(edepartmentid, dname);
				Job ji = new Job(ejobid,jname);
;				Employee e = new Employee(eid,ename,esex,etel,di,ji);
				employees.add(e);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ps, conn);
		}
		
		return employees;
	}

	@Override
	public Employee queryEmployee(int id) {
		Employee ee=null;
		Connection conn = DBUtil.getConnection();
		String sql = "select e.S_ID,e.S_NAME,e.S_SEX,e.S_TEL,e.S_DEPARTMENTID,e.S_JOBID,d.D_NAME,j.J_NAME,"
				+"e.S_BIRTHDAY,e.S_DATE,e.S_JSDATE,e.S_EINFORMATION,e.S_PSOURCE,e.S_EMAIL,e.S_EDUCATION,"
				+"e.S_EXPERIENCE,e.S_ESDATE,e.S_EEDATE,e.S_FLANGUAGE,e.S_FNAME,e.S_FRELATION,e.S_DISMISSION,e.S_IDNUM"
				+ " from STAFF e,DEPARTMENT d,JOB j "
				+ " where s_dismission=0 and e.S_DEPARTMENTID=d.D_ID and e.S_JOBID=J.J_ID and S_ID=? ";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			rs = ps.executeQuery();
			while(rs.next()) {
				int eid = rs.getInt(1);
				String ename = rs.getString(2);
				String esex = rs.getString(3);
				String etel = rs.getString(4);
				int edepartmentid = rs.getInt(5);
				int ejobid = rs.getInt(6);
				String dname = rs.getString(7);
				String jname = rs.getString(8);
				String birthday=rs.getString(9);
				String indate=rs.getString(10);
				String jsdate=rs.getString(11);
				String information = rs.getString(12);
				String source = rs.getString(13);
				String email = rs.getString(14);
				String education = rs.getString(15);
				String experience = rs.getString(16);
				String esdate=rs.getString(17);
				String eedate=rs.getString(18);	
				String flanguage = rs.getString(19);
				String fname = rs.getString(20);
				String frelation = rs.getString(21);
				int dismission=rs.getInt(22);
				String idnum=rs.getString(23);
				Department di = new Department(edepartmentid, dname);
				Job ji = new Job(ejobid,jname);
				ee = new Employee(eid,ename,esex,birthday,di,
						ji,indate,jsdate,information,source,etel,email,education,experience,
						esdate,eedate,flanguage,fname,frelation,dismission,idnum);

				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ps, conn);
		}
		return ee;
	}

	@Override
	public boolean updateEmployee(Employee es) {
		Connection conn = DBUtil.getConnection();
//		String sql = "update product set productname = ?,productprice=?,productnum=?,producttype=? where productid = ?";
		
		String sql = "update STAFF set S_NAME=?,S_SEX=?,S_BIRTHDAY=date_format(?,'%Y-%c-%d'),S_DEPARTMENTID=?,S_JOBID=?,S_DATE=date_format(?,'%Y-%c-%d'),S_JSDATE=date_format(?,'%Y-%c-%d'),S_EINFORMATION=?,"
				+"S_PSOURCE=?,S_TEL=?,S_EMAIL=?,S_EDUCATION=?,S_EXPERIENCE=?,S_ESDATE=date_format(?,'%Y-%c-%d'),S_EEDATE=date_format(?,'%Y-%c-%d'),S_FLANGUAGE=?,S_FNAME=?,S_FRELATION=?,"
				+"S_DISMISSION=?,S_IDNUM=? where S_ID = ?";
		
		PreparedStatement ps = null;
	
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, es.getEmployeename());
			ps.setString(2, es.getEmployeesex());
			ps.setString(3, es.getEmployeebirthday());
			ps.setInt(4, es.getEmployeedepartment().getDepartmentid());
			ps.setInt(5, es.getEmployeejob().getJobid());
			ps.setString(6,es.getEmployeedate() );
			ps.setString(7, es.getEnployeejsdate());
			ps.setString(8, es.getEmployeeinformation());
			ps.setString(9,es.getEmployeesource());
			ps.setString(10,es.getEmployeetel());
			ps.setString(11,es.getEmployeemali());
			ps.setString(12, es.getEmployeeeducation());
			ps.setString(13, es.getEmployeeexperience());
			ps.setString(14, es.getEmployeeesdate());
			ps.setString(15, es.getEmployeeeedate());
			ps.setString(16, es.getEmployeeflanguage());
			ps.setString(17, es.getEmployeefname());
			ps.setString(18, es.getEmployeefrelation());
			ps.setInt(19, es.getEmployeedismission());
			ps.setString(20, es.getEmployeeidnum());
			
			ps.setInt(21,es.getEmployeeid());
	
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			DBUtil.close(ps, conn);
		}
		
		
		return true;
	}

	@Override
	public boolean deleteEmployee(int eid) {
		// TODO Auto-generated method stub
		return false;
	}

}
