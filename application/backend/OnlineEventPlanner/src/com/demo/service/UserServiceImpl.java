package com.demo.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.demo.dao.UserDao;
import com.demo.dao.impls.UserDaoImpl;
import com.demo.exceptions.InvalidNumberOfPeopleException;
import com.demo.exceptions.PlannedDateException;
import com.demo.models.PlanRequest;
import com.demo.models.Quotation;
import com.demo.models.User;

public class UserServiceImpl implements UserService {
	private static UserDao userDAO = new UserDaoImpl();

	@Override
	public boolean updatePassword(int userid, String newPassword) throws SQLException {
		return userDAO.updatePasswd(userid, newPassword);
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
	public boolean addPlanRequest(PlanRequest pl)
			throws SQLException, InvalidNumberOfPeopleException, PlannedDateException {
		if (pl.getNoOfPeopleAttending() > 30) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate plannedDate = LocalDate.parse(pl.getFromdate(), formatter);
			LocalDate toDate = LocalDate.parse(pl.getTodate(), formatter);

			if (plannedDate.isAfter(LocalDate.now()) && plannedDate.isBefore(toDate)) {
				return userDAO.addPlanRequest(pl);
			} else {
				throw new PlannedDateException("Planned date should be greater than current date and less than toDate");
			}
		}
		throw new InvalidNumberOfPeopleException("number of people attending should be greater than 30");

	}

	@Override
	public List<Quotation> viewQuotation(int uid) throws SQLException {
		return userDAO.viewquotation(uid);
	}

	@Override
	public boolean validateUser(User u) throws SQLException {
		return userDAO.validateUser(u);
	}

	@Override
	public boolean updateQuotationStatus(int quotid, String status) throws SQLException {
		return userDAO.updateQuotationStatus(quotid, status);
	}

	@Override
	public void closeConnection() throws SQLException {
		userDAO.closeConnection();

	}
}
