package com.manager.transfer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.manager.department.dao.DBUtil;
import com.manager.transfer.domain.Job;

public class JobDao implements IJobDao {

	@Override
	public Job queryIdJobsByName(String name) {
		Connection conn = DBUtil.getConnection();
		String sql = "select J_ID from job where j_name=?";
		PreparedStatement ps = null;
		ResultSet rs  = null;
		Job j =new Job();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while(rs.next()) {							
				int j_id = rs.getInt(1);
				
				j.setJ_id(j_id);					
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		finally {
			DBUtil.close(ps, conn);
		}
		return j;	
	}
	
//	public static void main(String [] args) {
//		IJobDao idd =new JobDao();
//		Job ds = idd.queryIdJobsByName("财务主管");
//		System.out.print(ds.getJ_id());
//	}
}
