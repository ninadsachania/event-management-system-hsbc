package com.demo.service;

import java.sql.SQLException;
import java.util.List;

import com.demo.models.PlanRequest;
import com.demo.models.Quotation;
import com.demo.models.User;

public interface UserService {
    User findById(int userId) throws SQLException;
	boolean registerUser(User u) throws SQLException;
    void updatePassword(User user, String newPassword) throws SQLException;
    boolean addPlanRequest(PlanRequest pl) throws SQLException;
    List<Quotation> viewQuotation(int uid) throws SQLException;

}
