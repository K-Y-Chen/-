package com.manager.transfer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.manager.department.dao.DBUtil;
import com.manager.transfer.domain.Staff;
import com.manager.transfer.domain.StaffCheck;
import com.manager.transfer.domain.StaffTrail;

public class StaffCheckDao implements IStaffCheckDao {

	@Override
	public boolean insertStaffCheck(StaffCheck sc) {
		Connection conn = DBUtil.getConnection();
		System.out.println(conn);
		String sql="insert into staff_check (SC_NUM,SC_COMMENT,SC_RESULT,SC_DATE) "
				+" values (?,?,?,?)";
		PreparedStatement psp = null;
		try {
			psp = conn.prepareStatement(sql);
			psp.setInt(1, sc.getSc_num().getSt_id());
			psp.setString(2, sc.getSc_comment());
			psp.setString(3, sc.getSc_result());
			psp.setString(4, sc.getSc_date());
			
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
	public boolean updateStaffCheck(StaffCheck sc) {
		Connection conn = DBUtil.getConnection();
		System.out.println(conn);
		String sql="update staff_check "
				+" SET SC_NUM = ?,SC_COMMENT = ?,SC_RESULT = ?,SC_DATE = ? "
				+" WHERE SC_ID = ? ";
		PreparedStatement psp = null;
		try {
			psp = conn.prepareStatement(sql);
			psp.setInt(5, sc.getSc_id());
			psp.setInt(1, sc.getSc_num().getSt_id());
			psp.setString(2, sc.getSc_comment());
			psp.setString(3, sc.getSc_result());
			psp.setString(4, sc.getSc_date());
			
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
	public boolean deleteStaffCheck(StaffCheck sc) {
		Connection conn = DBUtil.getConnection();
		System.out.println(conn);
		String sql="delete from staff_check "
				+" WHERE SC_ID = ? ";
		PreparedStatement psp = null;
		try {
			psp = conn.prepareStatement(sql);
			psp.setInt(1, sc.getSc_id());
			
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
	public ArrayList<StaffCheck> queryStaffCheckById(int id) {
		Connection conn = DBUtil.getConnection();
		ArrayList<StaffCheck> alsc = new ArrayList<>();
		ResultSet rs = null;
		System.out.println(conn);
		String sql="select SC_ID,SC_NUM,SC_COMMENT,SC_RESULT,SC_DATE "
				+ ",s.S_NAME "
				+ " from staff_check sc,staff_trail st,staff s"
				+ " where s.S_ID=st.ST_STAFFID AND st.ST_ID=sc.SC_NUM AND "
				+ " sc.SC_ID = ?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			rs = ps.executeQuery();
			while(rs.next()) {			
				int sc_id = rs.getInt(1);	
				int sc_num = rs.getInt(2);	
				String sc_comment= rs.getString(3);	
				String sc_result = rs.getString(4);	
				String sc_date = rs.getString(5);	
				
				String sc_name= rs.getString(6);	
				
				Staff s = new Staff();
				s.setS_id(sc_num);
				s.setS_name(sc_name);
				
				StaffTrail st = new StaffTrail();
				st.setSt_staffId(s);
				
				StaffCheck sc = new StaffCheck(sc_id,st,sc_comment,sc_result,sc_date);
				alsc.add(sc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.close(rs, ps, conn);
		}
		return alsc;
	}

	@Override
	public ArrayList<StaffCheck> queryStaffCheckByNum(int scNum) {
		Connection conn = DBUtil.getConnection();
		ArrayList<StaffCheck> alsc = new ArrayList<>();
		ResultSet rs = null;
		System.out.println(conn);
		String sql="select SC_ID,SC_NUM,SC_COMMENT,SC_RESULT,SC_DATE "
				+ ",s.S_NAME "
				+ " from staff_check sc,staff_trail st,staff s"
				+ " where s.S_ID=st.ST_STAFFID AND st.ST_ID=sc.SC_NUM AND "
				+ " sc.SC_NUM = ?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1,scNum);
			rs = ps.executeQuery();
			while(rs.next()) {			
				int sc_id = rs.getInt(1);	
				int sc_num = rs.getInt(2);	
				String sc_comment= rs.getString(3);	
				String sc_result = rs.getString(4);	
				String sc_date = rs.getString(5);	
				
				String sc_name= rs.getString(6);	
				
				Staff s = new Staff();
				s.setS_id(sc_num);
				s.setS_name(sc_name);
				
				StaffTrail st = new StaffTrail();
				st.setSt_staffId(s);
				
				StaffCheck sc = new StaffCheck(sc_id,st,sc_comment,sc_result,sc_date);
				alsc.add(sc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.close(rs, ps, conn);
		}
		return alsc;
	}

	@Override
	public ArrayList<StaffCheck> queryStaffCheckByResult(String result) {
		Connection conn = DBUtil.getConnection();
		ArrayList<StaffCheck> alsc = new ArrayList<>();
		ResultSet rs = null;
		System.out.println(conn);
		String sql="select SC_ID,SC_NUM,SC_COMMENT,SC_RESULT,SC_DATE "
				+ ",s.S_NAME "
				+ " from staff_check sc,staff_trail st,staff s"
				+ " where s.S_ID=st.ST_STAFFID AND st.ST_ID=sc.SC_NUM AND "
				+ " sc.SC_RESULT = ?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,result);
			rs = ps.executeQuery();
			while(rs.next()) {			
				int sc_id = rs.getInt(1);	
				int sc_num = rs.getInt(2);	
				String sc_comment= rs.getString(3);	
				String sc_result = rs.getString(4);	
				String sc_date = rs.getString(5);	
				
				String sc_name= rs.getString(6);	
				
				Staff s = new Staff();
				s.setS_id(sc_num);
				s.setS_name(sc_name);
				
				StaffTrail st = new StaffTrail();
				st.setSt_staffId(s);
				
				StaffCheck sc = new StaffCheck(sc_id,st,sc_comment,sc_result,sc_date);
				alsc.add(sc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.close(rs, ps, conn);
		}
		return alsc;
	}

	@Override
	public ArrayList<StaffCheck> queryStaffCheckByDate(String date) {
		Connection conn = DBUtil.getConnection();
		ArrayList<StaffCheck> alsc = new ArrayList<>();
		ResultSet rs = null;
		System.out.println(conn);
		String sql="select SC_ID,SC_NUM,SC_COMMENT,SC_RESULT,SC_DATE "
				+ ",s.S_NAME "
				+ " from staff_check sc,staff_trail st,staff s"
				+ " where s.S_ID=st.ST_STAFFID AND st.ST_ID=sc.SC_NUM AND "
				+ " sc.SC_DATE = ?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,date);
			rs = ps.executeQuery();
			while(rs.next()) {			
				int sc_id = rs.getInt(1);	
				int sc_num = rs.getInt(2);	
				String sc_comment= rs.getString(3);	
				String sc_result = rs.getString(4);	
				String sc_date = rs.getString(5);	
				
				String sc_name= rs.getString(6);	
				
				Staff s = new Staff();
				s.setS_id(sc_num);
				s.setS_name(sc_name);
				
				StaffTrail st = new StaffTrail();
				st.setSt_staffId(s);
				
				StaffCheck sc = new StaffCheck(sc_id,st,sc_comment,sc_result,sc_date);
				alsc.add(sc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.close(rs, ps, conn);
		}
		return alsc;
	}
//	public static void main(String[] args) {
//		IStaffCheckDao iscd = new StaffCheckDao();
//
////		StaffTrail st = new StaffTrail();
////		st.setSt_id(3);
////		StaffCheck sc = new StaffCheck(3,st,"²»´í","×ªÕý","2012-04-01");
////		iscd.deleteStaffCheck(sc);
//		
//		ArrayList<StaffCheck> scs = iscd.queryStaffCheckByDate("2013-04-01");
//		for(StaffCheck sc:scs) {
//			System.out.println(sc.toString());			
//			System.out.println(sc.getSc_num().getSt_staffId().getS_name());
//		}
//	}
}
