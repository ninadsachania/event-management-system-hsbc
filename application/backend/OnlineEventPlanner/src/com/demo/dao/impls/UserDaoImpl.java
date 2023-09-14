package com.demo.dao.impls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.dao.UserDao;
import com.demo.dao.util.DBUtil;
import com.demo.models.PlanRequest;
import com.demo.models.Quotation;
import com.demo.models.User;

public class UserDaoImpl implements UserDao {
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

	// validating login credentials of the User
	@Override
	public boolean validateUser(User u) throws SQLException {
		query = "select firstname from User where username=? and passwd=?";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, u.getUsername());
		pstmt.setString(2, u.getPasswd());
		ResultSet rs = pstmt.executeQuery();
		if (rs.next())
			return true;
		return false;
	}

	// view user details
	@Override
	public User viewUser(int uid) throws SQLException {
		User u = null;
		query = "select * from User where userid=?";
		pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, uid);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			u = new User(rs.getInt("userid"), rs.getString("firstname"), rs.getString("lastname"),
					rs.getString("username"), rs.getString("passwd"), rs.getString("doj"), rs.getString("dob"),
					rs.getString("dept"), rs.getString("email"), rs.getString("mobile"), rs.getString("location"),
					rs.getString("userstatus"));
		}
		return u;
	}

	// change user password
	@Override
	public boolean updatePasswd(int uid, String passwd) throws SQLException {
		query = "update User set passwd=? where userid=?";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, passwd);
		pstmt.setInt(2, uid);
		int cnt = pstmt.executeUpdate();
		if (cnt > 0)
			return true;

		return false;
	}

	// creating plan request
	@Override
	public boolean addPlanRequest(PlanRequest pl) throws SQLException {
		query = "insert into Planrequest values(?,?,?,?,?)";
		pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, pl.getRequestId());
		pstmt.setString(2, pl.getFromdate());
		pstmt.setString(3, pl.getTodate());
		pstmt.setInt(4, pl.getNoOfPeopleAttending());
		pstmt.setInt(5, pl.getUserId());
		int cnt = pstmt.executeUpdate();
		if (cnt > 0)
			return true;

		return false;
	}

	// view quotation details
	@Override
	public List<Quotation> viewquotation(int uid) throws SQLException {
		List<Quotation> qlist = new ArrayList<>();
		query = "select * from Quotation where userid=?";
		pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, uid);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Quotation q = new Quotation(rs.getInt("quotid"), rs.getInt("vendorid"), rs.getInt("userid"),
					rs.getInt("requestid"), rs.getString("packagetype"), rs.getString("quotstatus"),
					rs.getDouble("estimatedamt"));
			qlist.add(q);
		}
		return qlist;
	}

	// user registration
	@Override
	public boolean registerUser(User u) throws SQLException {
		query = "insert into User(userid,firstname,lastname,username,passwd,doj,dob,dept,email,mobile,location) values(?,?,?,?,?,?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, u.getUserid());
		pstmt.setString(2, u.getFirstname());
		pstmt.setString(3, u.getLastname());
		pstmt.setString(4, u.getUsername());
		pstmt.setString(5, u.getPasswd());
		pstmt.setString(6, u.getDoj());
		pstmt.setString(7, u.getDob());
		pstmt.setString(8, u.getDept());
		pstmt.setString(9, u.getEmail());
		pstmt.setString(10, u.getMobile());
		pstmt.setString(11, u.getLocation());
		int cnt = pstmt.executeUpdate();
		if (cnt > 0)
			return true;
		return false;
	}

	// update the status of Quotation
	@Override
	public boolean updateQuotationStatus(int quotid, String status) throws SQLException {
		query = "update Quotation set quotstatus=? where quotid=?";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, status);
		pstmt.setInt(2, quotid);
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
