package com.sis.model;

public class Teacher{
	private int teacherId;
	private String name;
	private String section;
	private String NIC;
	private String OwnClass;
	private String email;
	private String password;
	
	
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getNIC() {
		return NIC;
	}
	public void setNIC(String nIC) {
		NIC = nIC;
	}
	public String getOwnClass() {
		return OwnClass;
	}
	public void setOwnClass(String ownClass) {
		OwnClass = ownClass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", name=" + name + ", section=" + section + ", NIC=" + NIC
				+ ", OwnClass=" + OwnClass + ", email=" + email + ", password=" + password + "]";
	}
	
	
}
