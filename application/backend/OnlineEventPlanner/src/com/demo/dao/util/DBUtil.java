package com.demo.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.demo.dao.configs.DaoConfigs;

//singleton pattern
public class DBUtil {
	static Connection con;

	// connecting to database
	public static Connection getConnection() throws SQLException {
		if (con == null) {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			con = DriverManager.getConnection(DaoConfigs.CONURL, DaoConfigs.USERNAME, DaoConfigs.PASSWORD);
			if (con != null) {
				System.out.println("Connected");
				return con;
			} else {
				System.out.println("not connected");
			}
		}
		return con;
	}

	// closing the connection
	public static void closeConnection() throws SQLException {
		if (con != null) {
			con.close();
			con = null;
		}

	}

}
