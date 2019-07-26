/**
 * @Student_ID : IT18180626
 * @Name : H.M.A.N.Welagedara
 */


package com.sis.model;

public class Subjects {

	private String subID;
	private String subCode;
	private String subName;
	private int year;

	public String getSubID() {
		return subID;
	}

	public void setSubID(String subID) {
		this.subID = subID;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getSubCode() {
		return subCode;
	}

	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}

	@Override
	public String toString() {
		return "Subjects [subID=" + subID + ", subCode=" + subCode + ", subName=" + subName + ", year=" + year + "]";
	}

	
}
