/**
 * @Student_ID : IT18178678
 * @Name : S.M.A.S.Senevirathne
 */

package com.sis.model;

public class Assignments {
	private int assignmentID;
	private String assignmentName;
	private String assignmentDescription;
	private String subID;
	private String date;
	public int getAssignmentID() {
		return assignmentID;
	}
	public void setAssignmentID(int assignmentID) {
		this.assignmentID = assignmentID;
	}
	public String getAssignmentName() {
		return assignmentName;
	}
	public void setAssignmentName(String assignmentName) {
		this.assignmentName = assignmentName;
	}
	public String getAssignmentDescription() {
		return assignmentDescription;
	}
	public void setAssignmentDescription(String assignmentDescription) {
		this.assignmentDescription = assignmentDescription;
	}
	public String getSubID() {
		return subID;
	}
	public void setSubID(String subID) {
		this.subID = subID;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Assignments [assignmentID=" + assignmentID + ", assignmentName=" + assignmentName
				+ ", assignmentDescription=" + assignmentDescription + ", subID=" + subID + ", date=" + date + "]";
	}
	
	
}
