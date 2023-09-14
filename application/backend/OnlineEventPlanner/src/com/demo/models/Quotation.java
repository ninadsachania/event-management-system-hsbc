package com.demo.models;

public class Quotation {
	private int quotid, vendorid, userid, requestid;
	private String packagetype, quotstatus;
	private double estimatedAmt;

	// parameterized constructor
	public Quotation(int quotid, int vendorid, int userid, int requestid, String packagetype, String quotstatus,
			double estimatedAmt) {
		this.quotid = quotid;
		this.vendorid = vendorid;
		this.userid = userid;
		this.requestid = requestid;
		this.packagetype = packagetype;
		this.quotstatus = quotstatus;
		this.estimatedAmt = estimatedAmt;
	}

	// getters and setters
	public int getQuotid() {
		return quotid;
	}

	public void setQuotid(int quotid) {
		this.quotid = quotid;
	}

	public int getVendorid() {
		return vendorid;
	}

	public void setVendorid(int vendorid) {
		this.vendorid = vendorid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getRequestid() {
		return requestid;
	}

	public void setRequestid(int requestid) {
		this.requestid = requestid;
	}

	public String getPackagetype() {
		return packagetype;
	}

	public void setPackagetype(String packagetype) {
		this.packagetype = packagetype;
	}

	public String getQuotstatus() {
		return quotstatus;
	}

	public void setQuotstatus(String quotstatus) {
		this.quotstatus = quotstatus;
	}

	public double getEstimatedAmt() {
		return estimatedAmt;
	}

	public void setEstimatedAmt(double estimatedAmt) {
		this.estimatedAmt = estimatedAmt;
	}

	@Override
	public String toString() {
		return "Quotation [quotid=" + quotid + ", vendorid=" + vendorid + ", userid=" + userid + ", requestid="
				+ requestid + ", packagetype=" + packagetype + ", quotstatus=" + quotstatus + ", estimatedAmt="
				+ estimatedAmt + "]";
	}

}
