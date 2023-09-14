package com.demo.models;

public class Packages {
	private int packageId;
	private String packagetype;
	private double amoun;
	private int vendorid;

	// parametrized constructotr
	public Packages(int packageId, String packagetype, double amoun, int vendorid) {
		this.packageId = packageId;
		this.packagetype = packagetype;
		this.amoun = amoun;
		this.vendorid = vendorid;
	}

	// getters and setters
	public int getPackageId() {
		return packageId;
	}

	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}

	public String getPackagetype() {
		return packagetype;
	}

	public void setPackagetype(String packagetype) {
		this.packagetype = packagetype;
	}

	public double getAmoun() {
		return amoun;
	}

	public void setAmoun(double amoun) {
		this.amoun = amoun;
	}

	public int getVendorid() {
		return vendorid;
	}

	public void setVendorid(int vendorid) {
		this.vendorid = vendorid;
	}

	@Override
	public String toString() {
		return "Packages [packageId=" + packageId + ", packagetype=" + packagetype + ", amoun=" + amoun + ", vendorid="
				+ vendorid + "]";
	}

}
