package com.demo.service;

import java.sql.SQLException;
import java.util.List;

import com.demo.dao.UserDao;
import com.demo.dao.impls.UserDaoImpl;
import com.demo.models.PlanRequest;
import com.demo.models.Quotation;
import com.demo.models.User;

public class UserServiceImpl implements UserService {
	private static UserDao userDAO = new UserDaoImpl();

	@Override
	public void updatePassword(User user, String newPassword) throws SQLException {
		userDAO.updatePasswd(user.getUserid(), newPassword);
	}

	@Override
	public User findById(int userId) throws SQLException {
		return userDAO.viewUser(userId);
	}

	@Override
	public boolean registerUser(User u) throws SQLException {
		return userDAO.registerUser(u);
	}

	@Override
	public boolean addPlanRequest(PlanRequest pl) throws SQLException {
		return userDAO.addPlanRequest(pl);
	}

	@Override
	public List<Quotation> viewQuotation(int uid) throws SQLException {
		return userDAO.viewquotation(uid);
	}
}
