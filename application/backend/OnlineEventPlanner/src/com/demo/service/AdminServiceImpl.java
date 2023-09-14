package com.demo.service;

import java.sql.SQLException;
import java.util.List;

import com.demo.dao.AdminDao;
import com.demo.dao.impls.AdminDaoImpl;
import com.demo.models.Admin;
import com.demo.models.User;
import com.demo.models.Vendor;

public class AdminServiceImpl implements AdminService {
	private static AdminDao adminDAO = new AdminDaoImpl();

	@Override
	public boolean addVendor(Vendor v) throws SQLException {
		return adminDAO.addVendor(v);
	}

	@Override
	public List<Vendor> viewVendors() throws SQLException {
		return adminDAO.viewVendors();
	}

	@Override
	public List<User> viewUsers() throws SQLException {
		return adminDAO.viewUsers();
	}

	@Override
	public boolean validateAdmin(Admin a) throws SQLException {
		return adminDAO.validateAdmin(a);
	}

	@Override
	public boolean updateUserStatus(int uid, String status) throws SQLException {
		return adminDAO.updateUserStatus(uid, status);
	}

}
