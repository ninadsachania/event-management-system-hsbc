package com.demo.service;

import java.sql.SQLException;
import java.util.List;

import com.demo.dao.VendorDao;
import com.demo.dao.impls.VendorDaoImpl;
import com.demo.models.Packages;
import com.demo.models.PlanRequest;
import com.demo.models.Quotation;
import com.demo.models.Vendor;

public class VendorServiceImpl implements VendorService {
	private static VendorDao vendorDAO = new VendorDaoImpl();

	@Override
	public boolean validateVendor(Vendor v) throws SQLException {
		return vendorDAO.validateVendor(v);
	}

	@Override
	public boolean addPackage(Packages p) throws SQLException {
		return vendorDAO.addPackage(p);
	}

	@Override
	public List<PlanRequest> viewUserRequest() throws SQLException {
		return vendorDAO.viewUserRequest();
	}

	@Override
	public boolean createQuotation(Quotation q) throws SQLException {
		return vendorDAO.createQuotation(q);
	}
}
