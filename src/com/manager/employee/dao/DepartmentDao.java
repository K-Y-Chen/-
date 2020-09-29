package com.manager.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.manager.employee.domain.Department;
import com.manager.department.dao.*;

public class DepartmentDao implements IDepartmentDao {

	@Override
	public ArrayList<Department> getAllDNames() {
		ArrayList<Department> department = new ArrayList<>();
		Connection conn = DBUtil.getConnection();
		String sql = "select D_ID, D_NAME from DEPARTMENT";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				Department de = new Department(id, name);
				department.add(de);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ps, conn);
		}
		
		return department;
	}

}
