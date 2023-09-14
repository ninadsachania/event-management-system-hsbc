package com.demo.dao.impls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.dao.VendorDao;
import com.demo.dao.util.DBUtil;
import com.demo.models.Packages;
import com.demo.models.PlanRequest;
import com.demo.models.Quotation;
import com.demo.models.Vendor;

public class VendorDaoImpl implements VendorDao {
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

	// validating login credentials of the Vendor
	@Override
	public boolean validateVendor(Vendor v) throws SQLException {
		query = "select firstname from Vendor where username=? and passwd=?";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, v.getUsername());
		pstmt.setString(2, v.getPasswd());
		ResultSet rs = pstmt.executeQuery();
		if (rs.next())
			return true;

		return false;
	}

	// adding package details
	@Override
	public boolean addPackage(Packages p) throws SQLException {
		query = "insert into Package values(?,?,?,?)";
		pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, p.getPackageId());
		pstmt.setString(2, p.getPackagetype());
		pstmt.setDouble(3, p.getAmoun());
		pstmt.setInt(4, p.getVendorid());
		int cnt = pstmt.executeUpdate();
		if (cnt > 0)
			return true;

		return false;
	}

	// view user plan request
	@Override
	public List<PlanRequest> viewUserRequest() throws SQLException {
		List<PlanRequest> prlist = new ArrayList<>();
		query = "select * from Planrequest";
		pstmt = conn.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			PlanRequest pr = new PlanRequest(rs.getInt("requestid"), rs.getInt("nopeopleattending"),
					rs.getInt("userid"), rs.getString("fromdate"), rs.getString("todate"));
			prlist.add(pr);
		}
		return prlist;
	}

	// add quotation details
	@Override
	public boolean createQuotation(Quotation q) throws SQLException {
		query = "inert into Quotation(quotid,packagetype,estimatedamt,vendorid,userid,requestid) values(?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, q.getQuotid());
		pstmt.setString(2, q.getPackagetype());
		pstmt.setDouble(3, q.getEstimatedAmt());
		pstmt.setInt(4, q.getVendorid());
		pstmt.setInt(5, q.getUserid());
		pstmt.setInt(6, q.getRequestid());
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
