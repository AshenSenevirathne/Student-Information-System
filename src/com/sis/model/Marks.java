/**
 * @Student_ID : IT18178678
 * @Name : S.M.A.S.Senevirathne
 */

package com.sis.model;

public class Marks {

	private String markID;
	private String studentID;
	private float mark;
	private String subjectName;

	public String getMarkID() {
		return markID;
	}

	public void setMarkID(String markID) {
		this.markID = markID;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public float getMark() {
		return mark;
	}

	public void setMark(float mark) {
		this.mark = mark;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	@Override
	public String toString() {
		return "Marks [markID=" + markID + ", studentID=" + studentID + ", mark=" + mark + ", subjectName="
				+ subjectName + "]";
	}

}
