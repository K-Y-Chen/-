package com.manager.transfer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.manager.department.dao.DBUtil;
import com.manager.transfer.domain.Dismission;
import com.manager.transfer.domain.Staff;

public class DismissionDao implements IDismissionDao{

	@Override
	public boolean insertDismission(Dismission dismission) {
		Connection conn = DBUtil.getConnection();
		System.out.println(conn);
		String sql="insert into dismission (D_STAFFID,D_DATE,D_TYPE,"
				+ "D_POOL) "
				+" values (?,?,?,?)";
		PreparedStatement psp = null;
		try {
			psp = conn.prepareStatement(sql);
			psp.setInt(1, dismission.getD_staffId().getS_id());
			psp.setString(2, dismission.getD_date());
			psp.setString(3, dismission.getD_type());
			psp.setBoolean(4, dismission.isD_pool());
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
	public boolean updateDismission(Dismission dismission) {
		Connection conn = DBUtil.getConnection();
		System.out.println(conn);
		String sql="update dismission "
				+ " SET D_STAFFID = ?,D_DATE = ?,D_TYPE = ?,"
				+ " D_POOL = ? "
				+ " WHERE D_ID = ? ";
		PreparedStatement psp = null;
		try {
			psp = conn.prepareStatement(sql);
			psp.setInt(5, dismission.getD_id());
			psp.setInt(1, dismission.getD_staffId().getS_id());
			psp.setString(2, dismission.getD_date());
			psp.setString(3, dismission.getD_type());
			psp.setBoolean(4, dismission.isD_pool());
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
	public boolean deleteDismission(Dismission dismission) {
		Connection conn = DBUtil.getConnection();
		System.out.println(conn);
		String sql="delete FROM dismission "
				+ " WHERE D_ID = ? ";
		PreparedStatement psp = null;
		try {
			psp = conn.prepareStatement(sql);
			psp.setInt(1, dismission.getD_id());
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
	public ArrayList<Dismission> querydById(int id) {
		Connection conn = DBUtil.getConnection();
		ArrayList<Dismission> ald = new ArrayList<>();
		ResultSet rs = null;
		System.out.println(conn);
		String sql="select D_ID,D_STAFFID,D_DATE,D_TYPE,D_POOL"
				+ ",s.S_NAME"
				+ " from dismission dis,staff s"
				+ " where s.S_ID=dis.D_STAFFID AND "
				+ "dis.D_ID = ?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			rs = ps.executeQuery();
			while(rs.next()) {			
				int d_id = rs.getInt(1);	//员工号，主键，自动增长
				int d_staffId = rs.getInt(2);	//离职员工，外键
				String d_date= rs.getString(3);	//离职日期
				String d_type = rs.getString(4);	//调转类型（主动调动，被动调动，数据错误）
				boolean d_pool= rs.getBoolean(5);	//进入人才库
				
				String d_name= rs.getString(6);	
				
				Staff s = new Staff();
				s.setS_id(d_staffId);
				s.setS_name(d_name);
				Dismission dis = new Dismission(d_id,s,d_date,d_type,d_pool);
				ald.add(dis);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.close(rs, ps, conn);
		}
		return ald;
	}

	@Override
	public ArrayList<Dismission> querydByStaffId(int staffId) {
		Connection conn = DBUtil.getConnection();
		ArrayList<Dismission> ald = new ArrayList<>();
		ResultSet rs = null;
		System.out.println(conn);
		String sql="select D_ID,D_STAFFID,D_DATE,D_TYPE,D_POOL"
				+ ",s.S_NAME"
				+ " from dismission dis,staff s"
				+ " where s.S_ID=dis.D_STAFFID AND "
				+ "dis.D_STAFFID = ?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1,staffId);
			rs = ps.executeQuery();
			while(rs.next()) {			
				int d_id = rs.getInt(1);	//员工号，主键，自动增长
				int d_staffId = rs.getInt(2);	//离职员工，外键
				String d_date= rs.getString(3);	//离职日期
				String d_type = rs.getString(4);	//调转类型（主动调动，被动调动，数据错误）
				boolean d_pool= rs.getBoolean(5);	//进入人才库
				
				String d_name= rs.getString(6);	
				
				Staff s = new Staff();
				s.setS_id(d_staffId);
				s.setS_name(d_name);
				Dismission dis = new Dismission(d_id,s,d_date,d_type,d_pool);
				ald.add(dis);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.close(rs, ps, conn);
		}
		return ald;
	}

	@Override
	public ArrayList<Dismission> querydByDate(String date) {
		Connection conn = DBUtil.getConnection();
		ArrayList<Dismission> ald = new ArrayList<>();
		ResultSet rs = null;
		System.out.println(conn);
		String sql="select D_ID,D_STAFFID,D_DATE,D_TYPE,D_POOL"
				+ ",s.S_NAME"
				+ " from dismission dis,staff s"
				+ " where s.S_ID=dis.D_STAFFID AND "
				+ "dis.D_DATE = ?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,date);
			rs = ps.executeQuery();
			while(rs.next()) {			
				int d_id = rs.getInt(1);	//员工号，主键，自动增长
				int d_staffId = rs.getInt(2);	//离职员工，外键
				String d_date= rs.getString(3);	//离职日期
				String d_type = rs.getString(4);	//调转类型（主动调动，被动调动，数据错误）
				boolean d_pool= rs.getBoolean(5);	//进入人才库
				
				String d_name= rs.getString(6);	
				
				Staff s = new Staff();
				s.setS_id(d_staffId);
				s.setS_name(d_name);
				Dismission dis = new Dismission(d_id,s,d_date,d_type,d_pool);
				ald.add(dis);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.close(rs, ps, conn);
		}
		return ald;
	}

	@Override
	public ArrayList<Dismission> querydByType(String type) {
		Connection conn = DBUtil.getConnection();
		ArrayList<Dismission> ald = new ArrayList<>();
		ResultSet rs = null;
		System.out.println(conn);
		String sql="select D_ID,D_STAFFID,D_DATE,D_TYPE,D_POOL"
				+ ",s.S_NAME"
				+ " from dismission dis,staff s"
				+ " where s.S_ID=dis.D_STAFFID AND "
				+ "dis.D_TYPE like ?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,"%" + type + "%");
			rs = ps.executeQuery();
			while(rs.next()) {			
				int d_id = rs.getInt(1);	//员工号，主键，自动增长
				int d_staffId = rs.getInt(2);	//离职员工，外键
				String d_date= rs.getString(3);	//离职日期
				String d_type = rs.getString(4);	//调转类型（主动调动，被动调动，数据错误）
				boolean d_pool= rs.getBoolean(5);	//进入人才库
				
				String d_name= rs.getString(6);	
				
				Staff s = new Staff();
				s.setS_id(d_staffId);
				s.setS_name(d_name);
				Dismission dis = new Dismission(d_id,s,d_date,d_type,d_pool);
				ald.add(dis);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.close(rs, ps, conn);
		}
		return ald;
	}

	@Override
	public ArrayList<Dismission> querydByPool(boolean pool) {
		Connection conn = DBUtil.getConnection();
		ArrayList<Dismission> ald = new ArrayList<>();
		ResultSet rs = null;
		System.out.println(conn);
		String sql="select D_ID,D_STAFFID,D_DATE,D_TYPE,D_POOL"
				+ ",s.S_NAME"
				+ " from dismission dis,staff s"
				+ " where s.S_ID=dis.D_STAFFID AND "
				+ "dis.D_POOL = ?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setBoolean(1,pool);
			rs = ps.executeQuery();
			while(rs.next()) {			
				int d_id = rs.getInt(1);	//员工号，主键，自动增长
				int d_staffId = rs.getInt(2);	//离职员工，外键
				String d_date= rs.getString(3);	//离职日期
				String d_type = rs.getString(4);	//调转类型（主动调动，被动调动，数据错误）
				boolean d_pool= rs.getBoolean(5);	//进入人才库
				
				String d_name= rs.getString(6);	
				
				Staff s = new Staff();
				s.setS_id(d_staffId);
				s.setS_name(d_name);
				Dismission dis = new Dismission(d_id,s,d_date,d_type,d_pool);
				ald.add(dis);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.close(rs, ps, conn);
		}
		return ald;
	}
//	public static void main(String[] args) {
//		IDismissionDao disd = new DismissionDao();
//		
//		Staff s = new Staff();
//		s.setS_id(1);
//		Dismission dismission = new Dismission(3,s,"2020-04-03","退休",false);
//		disd.deleteDismission(dismission);
////		ArrayList<Dismission> diss = disd.querydByPool(false);
////		for(Dismission dis:diss) {
////			System.out.println(dis.toString());			
////			System.out.println(dis.getD_staffId().getS_name());
////		}
//	}

}
