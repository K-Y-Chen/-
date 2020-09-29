package com.manager.department.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

import com.manager.department.domain.Department;
import com.manager.department.domain.Staff;

public class DepartmentDao implements IDepartmentDao{

	@Override
	public ArrayList<Department> queryDepartments() {
		Connection conn = DBUtil.getConnection();
		String sql = "select * from department";
		PreparedStatement ps = null;
		ResultSet rs  = null;
		ArrayList<Department> departments = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				int d_id = rs.getInt(1);
				String d_name = rs.getString(2);
				String d_type = rs.getString(3);
				String d_tel = rs.getString(4);
				String d_date= rs.getString(5);
//				System.out.println(d_id+d_name+d_type+d_tel+d_date);
				Department d =new Department(d_id, d_name, d_type, d_tel, d_date);
				departments.add(d);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
					}
		finally {
			DBUtil.close(ps, conn);
		}
		return departments;		
	}

	@Override
	public ArrayList<Department> queryDepartmentsById(int id) {
		Connection conn = DBUtil.getConnection();
		String sql = "select * from department where d_id=?";
		PreparedStatement ps = null;
		ResultSet rs  = null;
		ArrayList<Department> departments = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				int d_id = rs.getInt(1);				
				String d_name = rs.getString(2);
				String d_type = rs.getString(3);
				String d_tel = rs.getString(4);
				String d_date= rs.getString(5);
//				System.out.println(d_id+d_name+d_type+d_tel+d_date);
				Department d =new Department(d_id, d_name, d_type, d_tel, d_date);
				departments.add(d);								
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
					}
		finally {
			DBUtil.close(ps, conn);
		}
		return departments;		
	}

	@Override
	public ArrayList<Department> queryDepartmentsByName(String name) {
		Connection conn = DBUtil.getConnection();
		String sql = "select * from department where d_name=?";
		PreparedStatement ps = null;
		ResultSet rs  = null;
		ArrayList<Department> departments = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while(rs.next()) {							
				int d_id = rs.getInt(1);
				String d_name = rs.getString(2);
				String d_type = rs.getString(3);
				String d_tel = rs.getString(4);
				String d_date= rs.getString(5);
//				System.out.println(d_id+d_name+d_type+d_tel+d_date);
				Department d =new Department(d_id, d_name, d_type, d_tel, d_date);
				departments.add(d);								
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
					}
		finally {
			DBUtil.close(ps, conn);
		}
		return departments;	
	}

	@Override
	public ArrayList<Department> queryDepartmentsByType(String type) {
		Connection conn = DBUtil.getConnection();
		String sql = "select * from department where d_type=?";
		PreparedStatement ps = null;
		ResultSet rs  = null;
		ArrayList<Department> departments = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, type);
			rs = ps.executeQuery();
			while(rs.next()) {							
				int d_id = rs.getInt(1);
				String d_name = rs.getString(2);
				String d_type = rs.getString(3);
				String d_tel = rs.getString(4);
				String d_date= rs.getString(5);
//				System.out.println(d_id+d_name+d_type+d_tel+d_date);
				Department d =new Department(d_id, d_name, d_type, d_tel, d_date);
				departments.add(d);								
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
					}
		finally {
			DBUtil.close(ps, conn);
		}
		return departments;	
	}

	@Override
	public ArrayList<Staff> queryStaffsInDep(String departmentname) {

		Connection conn = DBUtil.getConnection();
		String sql = "select s_id,s_name,s_sex,j_name from "
				+ "staff,department,job where d_id=s_departmentid and s_jobid=j_id and d_name=? and s_dismission = 0";
		PreparedStatement ps = null;
		ResultSet rs  = null;
		ArrayList<Staff> staffs = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, departmentname);
			rs = ps.executeQuery();
			while(rs.next()) {						
				int s_id = rs.getInt(1);
				String s_name = rs.getString(2);
				String s_sex = rs.getString(3);
				String j_name = rs.getString(4);
//				System.out.println(s_id+s_name+s_sex+departmentname+j_name);
				Staff s = new Staff(s_id,s_name,s_sex,departmentname,j_name);
	//			System.out.println(s.getS_id()+s.getS_name()+s.getS_sex()+s.getS_departmentname()+s.getS_jobname());
				staffs.add(s);								
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
					}
		finally {
			DBUtil.close(ps, conn);
		}
		return staffs;
	}

	@Override
	public boolean insertDepartment(Department d) {
		Connection conn = DBUtil.getConnection();
//		String sql = "insert into department (d_name,d_type,d_tel,d_date)"+
//		" values(?,?,?,to_date(?,'yyyy-mm-dd'))";

		String sql = "insert into department (d_name,d_type,d_tel,d_date)"+
		" values(?,?,?,?)";
//		System.out.println(d.getD_date());
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, d.getD_name());
			ps.setString(2, d.getD_type());
			ps.setString(3, d.getD_tel());
			ps.setString(4, d.getD_date());
//			System.out.println(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		finally {
			DBUtil.close(ps, conn);
		}
		return true;
	}

	@Override
	public boolean updateDepartment(Department d) {
		Connection conn = DBUtil.getConnection();
		String sql = "update department set d_name=?,d_type=?,d_tel=?,d_date=? where d_id=?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(5,d.getD_id());
			ps.setString(1, d.getD_name());
			ps.setString(2, d.getD_type());
			ps.setString(3, d.getD_tel());
			ps.setString(4, d.getD_date());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		finally {
			DBUtil.close(ps, conn);
		}
		return true;
	}

	@Override
	public boolean deleteDepartmentByName(Department d) {
		Connection conn = DBUtil.getConnection();
		String sql = "delete from department where d_name=?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, d.getD_name());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
			DBUtil.close(ps, conn);
		return true;
	}
	
	
}
