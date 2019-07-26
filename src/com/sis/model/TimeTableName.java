/**
 * @Student_ID : IT18180626
 * @Name : H.M.A.N.Welagedara
 */


package com.sis.model;

public class TimeTableName extends TimeTable {
	
	private String timeTableName;
	private int year;

	public String getTimeTableName() {
		return timeTableName;
	}

	public void setTimeTableName(String timeTableName) {
		this.timeTableName = timeTableName;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "TimeTableName [timeTableName=" + timeTableName + ", year=" + year + ", timeTableID=" + timeTableID
				+ "]";
	}

	

	
	
	
}
