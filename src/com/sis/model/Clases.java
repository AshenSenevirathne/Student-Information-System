/**
 * @Student_ID : IT18178678
 * @Name : S.M.A.S.Senevirathne
 */

package com.sis.model;

public class Clases {
	private String classID;
	protected String className;
	private String Teacher;
	private String hall;
	private String noOfStudents;
	private String status;
	protected String year;

	public String getClassID() {
		return classID;
	}

	public void setClassID(String classID) {
		this.classID = classID;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getTeacher() {
		return Teacher;
	}

	public void setTeacher(String teacher) {
		Teacher = teacher;
	}

	public String getHall() {
		return hall;
	}

	public void setHall(String hall) {
		this.hall = hall;

	}

	public String getNoOfStudents() {
		return noOfStudents;
	}

	public void setNoOfStudents(String noOfStudents) {
		this.noOfStudents = noOfStudents;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Clases [classID=" + classID + ", className=" + className + ", Teacher=" + Teacher + ", hall=" + hall
				+ ", noOfStudents=" + noOfStudents + ", status=" + status + ", year=" + year + "]";
	}

	

}
