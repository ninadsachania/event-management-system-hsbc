package com.demo.dao;

import java.sql.SQLException;
import java.util.List;

import com.demo.models.PlanRequest;
import com.demo.models.Quotation;
import com.demo.models.User;

public interface UserDao {
	boolean validateUser(User u) throws SQLException;

	boolean registerUser(User u) throws SQLException;

	User viewUser(int uid) throws SQLException;

	boolean updatePasswd(int uid, String passwd) throws SQLException;

	boolean addPlanRequest(PlanRequest pl) throws SQLException;

	List<Quotation> viewquotation(int uid) throws SQLException;

	boolean updateQuotationStatus(int quotid, String status) throws SQLException;

	public void closeConnection() throws SQLException;
}
