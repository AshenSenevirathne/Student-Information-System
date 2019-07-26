/**
 * @Student_ID : IT18180626
 * @Name : H.M.A.N.Welagedara
 */


package com.oop.service;

import java.util.ArrayList;

import com.sis.model.Student;



public interface IStudentServices {
	
	/**
	 * add students
	 * @param student
	 */
	public void addStudents(Student student);
	
	
	/**
	 * get Student List
	 */
	public ArrayList<Student> getStudentList();
	
	
	/**
	 * remove students from class
	 * @param studentID
	 */
	public void removeStudent(String studentID);
	
	
	/**
	 * get Student By ID
	 * @param studentID
	 */
	public Student getStudentByID(String studentID);
	
	
	/**
	 * update Student Details
	 * @param student , studentID
	 */
	public void updateStudentDetails(Student student, String studentID);
	
	/**
	 * delete All Students
	 */
	public void deleteAllStudents();
	
	
	/**
	 * get Student By Year
	 * @param year
	 */
	public ArrayList<Student> getStudentByYear(int year);
	
}
