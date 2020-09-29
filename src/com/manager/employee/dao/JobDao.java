package com.manager.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.manager.department.dao.*;
import com.manager.employee.domain.Job;

public class JobDao implements  IJobDao{

	@Override
	public ArrayList<Job> getAllJNames() {
		ArrayList<Job> job = new ArrayList<>();
		Connection conn = DBUtil.getConnection();
		String sql = "select J_ID, J_NAME from JOB";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				Job je = new Job(id, name);
				job.add(je);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ps, conn);
		}
		
		return job;
	}
}
