package com.manager.job.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.manager.department.dao.DBUtil;
import com.manager.department.domain.Staff;
import com.manager.job.domain.Job;

public class JobDao implements IJobDao{

	@Override
	public ArrayList<Job> queryJobs() {
		Connection conn = DBUtil.getConnection();
		String sql = "select * from job";
		PreparedStatement ps = null;
		ResultSet rs  = null;
		ArrayList<Job> jobs = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				int j_id = rs.getInt(1);
				String j_name = rs.getString(2);
				String j_type = rs.getString(3);
				int j_size = rs.getInt(4);
//				System.out.println(j_id+j_name+j_type+j_size);
				Job j =new Job(j_id, j_name, j_type, j_size);
				jobs.add(j);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
					}
		finally {
			DBUtil.close(ps, conn);
		}
		return jobs;		
	}

	@Override
	public ArrayList<Job> queryJobsById(int id) {
		Connection conn = DBUtil.getConnection();
		String sql = "select * from job where j_id=?";
		PreparedStatement ps = null;
		ResultSet rs  = null;
		ArrayList<Job> jobs = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				int j_id = rs.getInt(1);
				String j_name = rs.getString(2);
				String j_type = rs.getString(3);
				int j_size = rs.getInt(4);
//				System.out.println(j_id+j_name+j_type+j_size);
				Job j =new Job(j_id, j_name, j_type, j_size);
				jobs.add(j);						
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
					}
		finally {
			DBUtil.close(ps, conn);
		}
		return jobs;		
	}

	@Override
	public ArrayList<Job> queryJobsByName(String name) {
		Connection conn = DBUtil.getConnection();
		String sql = "select * from job where j_name=?";
		PreparedStatement ps = null;
		ResultSet rs  = null;
		ArrayList<Job> jobs = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while(rs.next()) {
				int j_id = rs.getInt(1);
				String j_name = rs.getString(2);
				String j_type = rs.getString(3);
				int j_size = rs.getInt(4);
//				System.out.println(j_id+j_name+j_type+j_size);
				Job j =new Job(j_id, j_name, j_type, j_size);
				jobs.add(j);						
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
					}
		finally {
			DBUtil.close(ps, conn);
		}
		return jobs;	
	}

	@Override
	public ArrayList<Job> queryJobsByType(String type) {
		Connection conn = DBUtil.getConnection();
		String sql = "select * from job where j_type=?";
		PreparedStatement ps = null;
		ResultSet rs  = null;
		ArrayList<Job> jobs = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, type);
			rs = ps.executeQuery();
			while(rs.next()) {
				int j_id = rs.getInt(1);
				String j_name = rs.getString(2);
				String j_type = rs.getString(3);
				int j_size = rs.getInt(4);
//				System.out.println(j_id+j_name+j_type+j_size);
				Job j =new Job(j_id, j_name, j_type, j_size);
				jobs.add(j);						
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
					}
		finally {
			DBUtil.close(ps, conn);
		}
		return jobs;	
	}

	@Override
	public ArrayList<Staff> queryStaffsInJob(String jobname) {
		Connection conn = DBUtil.getConnection();
		String sql = "select s_id,s_name,s_sex,d_name from "
				+ "staff,department,job where d_id=s_departmentid and s_jobid=j_id and j_name=? and s_dismission = 0";
		PreparedStatement ps = null;
		ResultSet rs  = null;
		ArrayList<Staff> staffs = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, jobname);
//			System.out.println(jobname);
			rs = ps.executeQuery();
			while(rs.next()) {						
				int s_id = rs.getInt(1);
				String s_name = rs.getString(2);
				String s_sex = rs.getString(3);
				String d_name = rs.getString(4);
//				System.out.println(s_id+s_name+s_sex+d_name+jobname);
				Staff s = new Staff(s_id,s_name,s_sex,d_name,jobname);
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
	public boolean insertJob(Job j) {
		Connection conn = DBUtil.getConnection();
		String sql = "insert into job (j_name,j_type,j_size)"+
		" values(?,?,?)";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, j.getJ_name());
			ps.setString(2, j.getJ_type());
			ps.setInt(3, j.getJ_size());
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
	public boolean updateJob(Job j) {
		Connection conn = DBUtil.getConnection();
		String sql = "update job set j_name=?,j_type=?,j_size=? where j_id=?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(4,j.getJ_id());
			ps.setString(1, j.getJ_name());
			ps.setString(2, j.getJ_type());
			ps.setInt(3, j.getJ_size());
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
	public boolean deleteJobByName(Job j) {
		Connection conn = DBUtil.getConnection();
		String sql = "delete from job where j_name=?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, j.getJ_name());
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
