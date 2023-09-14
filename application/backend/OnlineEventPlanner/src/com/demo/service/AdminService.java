package com.demo.service;

import java.sql.SQLException;
import java.util.List;

import com.demo.models.Admin;
import com.demo.models.User;
import com.demo.models.Vendor;

public interface AdminService {
	
	boolean addVendor(Vendor v) throws SQLException;

	List<Vendor> viewVendors() throws SQLException;

	List<User> viewUsers() throws SQLException;

	boolean validateAdmin(Admin a) throws SQLException;

	boolean updateUserStatus(int uid, String status) throws SQLException;
}