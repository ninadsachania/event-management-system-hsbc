package com.demo.models;

public class PlanRequest {
	private int requestId, noOfPeopleAttending, userId;
	private String fromdate, todate;

	// parameterized constructor
	public PlanRequest(int requestId, int noOfPeopleAttending, int userId, String fromdate, String todate) {
		this.requestId = requestId;
		this.noOfPeopleAttending = noOfPeopleAttending;
		this.userId = userId;
		this.fromdate = fromdate;
		this.todate = todate;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public int getNoOfPeopleAttending() {
		return noOfPeopleAttending;
	}

	public void setNoOfPeopleAttending(int noOfPeopleAttending) {
		this.noOfPeopleAttending = noOfPeopleAttending;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFromdate() {
		return fromdate;
	}

	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}

	public String getTodate() {
		return todate;
	}

	public void setTodate(String todate) {
		this.todate = todate;
	}

	@Override
	public String toString() {
		return "PlanRequest [requestId=" + requestId + ", noOfPeopleAttending=" + noOfPeopleAttending + ", userId="
				+ userId + ", fromdate=" + fromdate + ", todate=" + todate + "]";
	}

}
