/**
 * @Student_ID : IT18178678
 * @Name : S.M.A.S.Senevirathne
 */

package com.oop.service;

import java.util.ArrayList;
import java.util.List;

import com.sis.model.Clases;
import com.sis.model.Student;

public interface IClassServices {
	
	/**
	 * Add class to Classes table
	 * @param classes
	 */
	public void addClass(Clases classes);
	
	
	/**
	 * remove class from Classes table
	 * @param classID
	 */
	public void removeClass(String classID);
	
	
	/**
	 * get all Students in selected year
	 * @param selectedYear
	 */
	public List<Student> getStudentList(String selectedYear);
	
	
	/**
	 * remove Students From Class
	 * @param className
	 */
	public void removeStudentsFromClass(String className);
	
	
	/**
	 * update class details
	 * @param clases
	 */
	public void updateClassDetails(Clases clases);
	
	
	/**
	 * get class name
	 * @param userName
	 */
	public String getClassName(int userName);
	
	
	/**
	 * set class name
	 * @param userName, className
	 */
	public void setClassName(int userName, String className);
	
	
	/**
	 * get inserted students to class
	 * @param className
	 */
	public List<Student> getInsertedStudentList(String className);
	
	
	/**
	 * get class details
	 * @param className
	 */
	public Clases getClassDetails(String className);
	
	
	/**
	 * update student class
	 * @param className, oldClassName
	 */
	public void updateStudentClass(String className, String oldClassName);
	
	
	/**
	 * remove students from class
	 * @param student
	 */
	public void removeStudentsFromClass(Student student);
	
	
	/**
	 * add students to class
	 * @param student
	 */
	public void addStudentsToClass(Student student);
	
}
