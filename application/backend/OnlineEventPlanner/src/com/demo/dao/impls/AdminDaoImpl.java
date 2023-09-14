package com.demo.dao.impls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.dao.AdminDao;
import com.demo.dao.util.DBUtil;
import com.demo.models.Admin;
import com.demo.models.User;
import com.demo.models.Vendor;

public class AdminDaoImpl implements AdminDao {
	private static Connection conn;
	private static PreparedStatement pstmt;
	private static String query;
	// connecting the database
	static {
		try {
			conn = DBUtil.getConnection();
		} catch (SQLException e) {
			System.out.println("Cannot connect to Database");
		}
	}

	// add vendor details
	@Override
	public boolean addVendor(Vendor v) throws SQLException {
		query = "insert into Vendor values(?,?,?,?,?,?,?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, v.getVendorid());
		pstmt.setString(2, v.getUsername());
		pstmt.setString(3, v.getPasswd());
		pstmt.setString(4, v.getFirstname());
		pstmt.setString(5, v.getLastname());
		pstmt.setString(6, v.getStreet());
		pstmt.setString(7, v.getCity());
		pstmt.setString(8, v.getState());
		pstmt.setString(9, v.getCountry());
		pstmt.setString(10, v.getPincode());
		pstmt.setString(11, v.getEmail());
		pstmt.setString(12, v.getMobile());
		int cnt = pstmt.executeUpdate();
		if (cnt > 0)
			return true;

		return false;
	}

	// view all vendors
	@Override
	public List<Vendor> viewVendors() throws SQLException {
		List<Vendor> vlist = new ArrayList<>();
		query = "select * from Vendor";
		pstmt = conn.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Vendor vd = new Vendor(rs.getInt("vendorid"), rs.getString("firstname"), rs.getString("lastname"),
					rs.getString("street"), rs.getString("city"), rs.getString("state"), rs.getString("country"),
					rs.getString("pincode"), rs.getString("email"), rs.getString("mobile"), rs.getString("username"),
					rs.getString("passwd"));
			vlist.add(vd);
		}
		return vlist;
	}

	// view all users
	@Override
	public List<User> viewUsers() throws SQLException {
		List<User> ulist = new ArrayList<>();
		query = "select * from User";
		pstmt = conn.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			User u = new User(rs.getInt("userid"), rs.getString("firstname"), rs.getString("lastname"),
					rs.getString("username"), rs.getString("passwd"), rs.getString("doj"), rs.getString("dob"),
					rs.getString("dept"), rs.getString("email"), rs.getString("mobile"), rs.getString("location"),
					rs.getString("userstatus"));
			ulist.add(u);
		}
		return ulist;
	}

	// validating login credentials of Admin
	@Override
	public boolean validateAdmin(Admin a) throws SQLException {
		query = "select firstname from Admin where username=? and passwd=?";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, a.getUsername());
		pstmt.setString(2, a.getPasswd());
		ResultSet rs = pstmt.executeQuery();
		if (rs.next())
			return true;

		return false;
	}

	// update user status
	@Override
	public boolean updateUserStatus(int uid, String status) throws SQLException {
		query = "update User set userstatus=? where userid=?";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, status);
		pstmt.setInt(2, uid);
		int cnt = pstmt.executeUpdate();
		if (cnt > 0)
			return true;

		return false;
	}

	// closing DB Connection
	@Override
	public void closeConnection() throws SQLException {
		DBUtil.closeConnection();
	}

}
