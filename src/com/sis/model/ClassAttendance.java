/**
 * @Student_ID : IT18178678
 * @Name : S.M.A.S.Senevirathne
 */

package com.sis.model;

public class ClassAttendance extends Clases{
	private String studentId;
	private float totalDay;
	private float prasentDays;
	private float absentDays;
	private float persentage;
	private static final float PERSENTAGE_MARK = 80;

	

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public float getTotalDay() {
		return totalDay;
	}

	public void setTotalDay(float totalDay) {
		this.totalDay = totalDay;
	}

	public float getPrasentDays() {
		return prasentDays;
	}

	public void setPrasentDays(float prasentDays) {
		this.prasentDays = prasentDays;
	}

	public float getAbsentDays() {
		return absentDays;
	}

	public void setAbsentDays(float absentDays) {
		this.absentDays = absentDays;
	}

	public float getPersentage() {
		return persentage;
	}

	public void setPersentage(float persentage) {
		this.persentage = persentage;
	}

	public static float getPersentageMark() {
		return PERSENTAGE_MARK;
	}

	@Override
	public String toString() {
		return "ClassAttendance [studentId=" + studentId + ", totalDay=" + totalDay + ", prasentDays=" + prasentDays
				+ ", absentDays=" + absentDays + ", persentage=" + persentage + ", className=" + className + ", year="
				+ year + "]";
	}

	
}
