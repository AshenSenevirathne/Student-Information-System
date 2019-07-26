/**
 * @Student_ID : IT18180626
 * @Name : H.M.A.N.Welagedara
 */


package com.sis.model;

public class TimeTableDetails extends TimeTable {
	private String ttDetailsId;
	private String Subject;
	private String date;
	private String startTime;
	private String endTime;

	public String getTtDetailsId() {
		return ttDetailsId;
	}

	public void setTtDetailsId(String ttDetailsId) {
		this.ttDetailsId = ttDetailsId;
	}

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "TimeTableDetails [ttDetailsId=" + ttDetailsId + ", Subject=" + Subject + ", date=" + date
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", timeTableID=" + timeTableID + "]";
	}

}
