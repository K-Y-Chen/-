package com.manager.transfer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.manager.department.dao.DBUtil;
import com.manager.transfer.domain.Base;
import com.manager.transfer.domain.Staff;


public class BaseDao implements IBaseDao {

	@Override
	public boolean insertBase(Base base) {
		Connection conn = DBUtil.getConnection();
		System.out.println(conn);
		String sql=" insert into base (B_STAFFID) "
				+ " values (?)";
		PreparedStatement psp = null;
		try {
			psp = conn.prepareStatement(sql);
			psp.setInt(1, base.getB_staffId().getS_id());

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
	public boolean updateBase(Base base) {
		Connection conn = DBUtil.getConnection();
		System.out.println(conn);
		String sql="update base "
				+ " SET B_STAFFID = ? "
				+ " WHERE B_ID = ?";
		PreparedStatement psp = null;
		try {
			psp = conn.prepareStatement(sql);
			psp.setInt(2, base.getB_id());
			psp.setInt(1, base.getB_staffId().getS_id());

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
	public boolean deleteBase(Base base) {
		Connection conn = DBUtil.getConnection();
		System.out.println(conn);
		String sql="delete from base "
				+ " WHERE B_STAFFID = ?";
		PreparedStatement psp = null;
		try {
			psp = conn.prepareStatement(sql);
			psp.setInt(1, base.getB_staffId().getS_id());

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
	public ArrayList<Base> queryById(int id) {
		Connection conn = DBUtil.getConnection();
		ArrayList<Base> albs = new ArrayList<>();
		ResultSet rs = null;
		System.out.println(conn);
		String sql="select B_ID,B_STAFFID "
				+ ",s.S_NAME "
				+ " from base b,staff s"
				+ " where s.S_ID = b.B_STAFFID AND "
				+ " b.B_ID = ?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			rs = ps.executeQuery();
			while(rs.next()) {			
				int b_id = rs.getInt(1);	
				int b_staffId = rs.getInt(2);		
				
				String b_name= rs.getString(3);	
				
				Staff s = new Staff();
				s.setS_id(b_staffId);
				s.setS_name(b_name);
				Base base = new Base(b_id,s);
				albs.add(base);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.close(rs, ps, conn);
		}
		return albs;
	}

	@Override
	public ArrayList<Base> queryByStaffId(int staffId) {
		Connection conn = DBUtil.getConnection();
		ArrayList<Base> albs = new ArrayList<>();
		ResultSet rs = null;
		System.out.println(conn);
		String sql="select B_ID,B_STAFFID "
				+ ",s.S_NAME "
				+ " from base b,staff s"
				+ " where s.S_ID = b.B_STAFFID AND "
				+ " b.B_STAFFID = ?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1,staffId);
			rs = ps.executeQuery();
			while(rs.next()) {			
				int b_id = rs.getInt(1);	
				int b_staffId = rs.getInt(2);		
				
				String b_name= rs.getString(3);	
				
				Staff s = new Staff();
				s.setS_id(b_staffId);
				s.setS_name(b_name);
				Base base = new Base(b_id,s);
				albs.add(base);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.close(rs, ps, conn);
		}
		return albs;
	}
//	public static void main(String[] args) {
//		IBaseDao ibd = new BaseDao();	
//		Staff s = new Staff();
//		s.setS_id(5);
//		Base base = new Base(s);
//		ibd.deleteBase(base);
//		
////		ArrayList<Base> bases = ibd.queryByStaffId(1);
////		for(Base base:bases) {
////			System.out.println(base.toString());			
////			System.out.println(base.getB_staffId().getS_name());
////		}
//	}
}
