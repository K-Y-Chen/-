package com.manager.transfer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.manager.department.dao.DBUtil;
import com.manager.transfer.domain.Staff;
import com.manager.transfer.domain.StaffTrail;
public class StaffTrailDao implements IStaffTrailDao {

	@Override
	public boolean insertStaffTrail(StaffTrail st) {
		Connection conn = DBUtil.getConnection();
		System.out.println(conn);
		String sql="insert into staff_trail (ST_STAFFID,ST_TSDATE,"
				+ "ST_TEDATE) "
				+" values (?,?,?)";
		PreparedStatement psp = null;
		try {
			psp = conn.prepareStatement(sql);
			psp.setInt(1, st.getSt_staffId().getS_id());
			psp.setString(2, st.getSt_tsDate());
			psp.setString(3, st.getSt_teDate());
			
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
	public boolean updateStaffTrail(StaffTrail st) {
		Connection conn = DBUtil.getConnection();
		System.out.println(conn);
		String sql="update staff_trail "
				+ " SET ST_STAFFID = ?,ST_TSDATE = ? ,ST_TEDATE= ? "
				+" WHERE ST_ID = ? ";
		PreparedStatement psp = null;
		try {
			psp = conn.prepareStatement(sql);
			psp.setInt(4, st.getSt_id());
			psp.setInt(1, st.getSt_staffId().getS_id());
			psp.setString(2, st.getSt_tsDate());
			psp.setString(3, st.getSt_teDate());
			
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
	public boolean deleteStaffTrail(StaffTrail st) {
		Connection conn = DBUtil.getConnection();
		System.out.println(conn);
		String sql="delete from staff_trail "
				+" WHERE ST_ID = ? ";
		PreparedStatement psp = null;
		try {
			psp = conn.prepareStatement(sql);
			psp.setInt(1, st.getSt_id());
			
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
	public ArrayList<StaffTrail> queryStaffTrailById(int id) {
		Connection conn = DBUtil.getConnection();
		ArrayList<StaffTrail> alst = new ArrayList<>();
		ResultSet rs = null;
		System.out.println(conn);
		String sql="select ST_ID,ST_STAFFID,ST_TSDATE,ST_TEDATE"
				+ ",s.S_NAME"
				+ " from staff_trail st,staff s"
				+ " where s.S_ID=st.ST_STAFFID AND "
				+ " st.ST_ID = ?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			rs = ps.executeQuery();
			while(rs.next()) {			
				int st_id = rs.getInt(1);	//员工号，主键，自动增长
				int st_staffId = rs.getInt(2);	//离职员工，外键
				String st_tsDate= rs.getString(3);	//离职日期
				String st_teDate = rs.getString(4);	//调转类型（主动调动，被动调动，数据错误）
				
				String st_name= rs.getString(5);	
				
				Staff s = new Staff();
				s.setS_id(st_staffId);
				s.setS_name(st_name);
				
				StaffTrail st = new StaffTrail(st_id,s,st_tsDate,st_teDate);
				alst.add(st);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.close(rs, ps, conn);
		}
		return alst;
	}

	@Override
	public ArrayList<StaffTrail> queryStaffTrailByStaffId(int StaffId) {
		Connection conn = DBUtil.getConnection();
		ArrayList<StaffTrail> alst = new ArrayList<>();
		ResultSet rs = null;
		System.out.println(conn);
		String sql="select ST_ID,ST_STAFFID,ST_TSDATE,ST_TEDATE"
				+ ",s.S_NAME"
				+ " from staff_trail st,staff s"
				+ " where s.S_ID=st.ST_STAFFID AND "
				+ " st.ST_STAFFID = ?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1,StaffId);
			rs = ps.executeQuery();
			while(rs.next()) {			
				int st_id = rs.getInt(1);	//员工号，主键，自动增长
				int st_staffId = rs.getInt(2);	//离职员工，外键
				String st_tsDate= rs.getString(3);	//离职日期
				String st_teDate = rs.getString(4);	//调转类型（主动调动，被动调动，数据错误）
				
				String st_name= rs.getString(5);	
				
				Staff s = new Staff();
				s.setS_id(st_staffId);
				s.setS_name(st_name);
				
				StaffTrail st = new StaffTrail(st_id,s,st_tsDate,st_teDate);
				alst.add(st);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.close(rs, ps, conn);
		}
		return alst;
	}

	@Override
	public ArrayList<StaffTrail> queryStaffTrailBysDate(String sDate) {
		Connection conn = DBUtil.getConnection();
		ArrayList<StaffTrail> alst = new ArrayList<>();
		ResultSet rs = null;
		System.out.println(conn);
		String sql="select ST_ID,ST_STAFFID,ST_TSDATE,ST_TEDATE"
				+ ",s.S_NAME"
				+ " from staff_trail st,staff s"
				+ " where s.S_ID=st.ST_STAFFID AND "
				+ " st.ST_TSDATE = ?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,sDate);
			rs = ps.executeQuery();
			while(rs.next()) {			
				int st_id = rs.getInt(1);	//员工号，主键，自动增长
				int st_staffId = rs.getInt(2);	//离职员工，外键
				String st_tsDate= rs.getString(3);	//离职日期
				String st_teDate = rs.getString(4);	//调转类型（主动调动，被动调动，数据错误）
				
				String st_name= rs.getString(5);	
				
				Staff s = new Staff();
				s.setS_id(st_staffId);
				s.setS_name(st_name);
				
				StaffTrail st = new StaffTrail(st_id,s,st_tsDate,st_teDate);
				alst.add(st);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.close(rs, ps, conn);
		}
		return alst;
	}

	@Override
	public ArrayList<StaffTrail> queryStaffTrailByeDate(String eDate) {
		Connection conn = DBUtil.getConnection();
		ArrayList<StaffTrail> alst = new ArrayList<>();
		ResultSet rs = null;
		System.out.println(conn);
		String sql="select ST_ID,ST_STAFFID,ST_TSDATE,ST_TEDATE"
				+ ",s.S_NAME"
				+ " from staff_trail st,staff s"
				+ " where s.S_ID=st.ST_STAFFID AND "
				+ " st.ST_TEDATE = ?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,eDate);
			rs = ps.executeQuery();
			while(rs.next()) {			
				int st_id = rs.getInt(1);	//员工号，主键，自动增长
				int st_staffId = rs.getInt(2);	//离职员工，外键
				String st_tsDate= rs.getString(3);	//离职日期
				String st_teDate = rs.getString(4);	//调转类型（主动调动，被动调动，数据错误）
				
				String st_name= rs.getString(5);	
				
				Staff s = new Staff();
				s.setS_id(st_staffId);
				s.setS_name(st_name);
				
				StaffTrail st = new StaffTrail(st_id,s,st_tsDate,st_teDate);
				alst.add(st);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.close(rs, ps, conn);
		}
		return alst;
	}


//	public static void main(String[] args) {
//		IStaffTrailDao istd = new StaffTrailDao();
//
//		Staff s = new Staff();
//		s.setS_id(3);
//		StaffTrail st = new StaffTrail(s,"2008-04-01","2008-08-01");
//		istd.insertStaffTrail(st);
//		
////		ArrayList<StaffTrail> sts = istd.queryStaffTrailById(1);
////		for(StaffTrail st:sts) {
////			System.out.println(st.toString());			
////			System.out.println(st.getSt_staffId().getS_name());
////		}
//	}
}
