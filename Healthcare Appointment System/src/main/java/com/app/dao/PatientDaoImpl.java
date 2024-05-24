package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.app.utils.DBUtils.*;

public class PatientDaoImpl implements PatientDao{
	Connection cn;
	PreparedStatement pst1;
	public PatientDaoImpl() throws SQLException {
		super();
		cn = openConnection();
		pst1 = cn.prepareStatement(null);
	}
	
	
	
	
	
}
