/**
 * @Student_ID : IT18180626
 * @Name : H.M.A.N.Welagedara
 */


package com.sis.model;

public class Student {

	private String studentID;

	private String name;

	private String address;

	private String phoNo;

	private String email;

	private String gender;

	private int year;

	private String className;

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoNo() {
		return phoNo;
	}

	public void setPhoNo(String phoNo) {
		this.phoNo = phoNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Override
	public String toString() {

		return "Student ID = " + studentID + "\n" + "Student Name = " + name + "\n" + "Address = " + address + "\n"
				+ "Phone No = " + phoNo + "\n" + "\n" + "Email = " + email + "\n" + "Gender = " + gender + "\n"
				+ "Year = " + year + "\n" + "Class = " + className;
	}

}
