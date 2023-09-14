package com.demo.dao;

import java.sql.SQLException;
import java.util.List;

import com.demo.models.Packages;
import com.demo.models.PlanRequest;
import com.demo.models.Quotation;
import com.demo.models.Vendor;

public interface VendorDao {
	boolean validateVendor(Vendor v) throws SQLException;

	boolean addPackage(Packages p) throws SQLException;

	List<PlanRequest> viewUserRequest() throws SQLException;

	boolean createQuotation(Quotation q) throws SQLException;

	void closeConnection() throws SQLException;

}
