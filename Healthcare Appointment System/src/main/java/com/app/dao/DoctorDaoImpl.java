package com.app.dao;

import static com.app.utils.DBUtils.openConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;;

public class DoctorDaoImpl implements DoctorDao {
	Connection cn;
	PreparedStatement pst1;

	public DoctorDaoImpl() throws SQLException {
		cn = openConnection();
		pst1 = cn.prepareStatement("");
	}

}
