/**
 * @Student_ID : IT18178678
 * @Name : S.M.A.S.Senevirathne
 */

package com.oop.service;

import java.util.List;

import com.sis.model.ClassPlaceList;
import com.sis.model.Marks;
import com.sis.model.Student;
import com.sis.model.Subjects;

public interface IMarkServices {
	
	/**
	 * add Marks
	 * @param marks
	 */
	public void addMarks(Marks marks);
	
	
	/**
	 * get Subject List
	 * @param selectedYear
	 */
	public List<Subjects> getSubjectList(String selectedYear);
	
	
	/**
	 * get Student MArk
	 * @param studentID
	 */
	public List<Marks> getStudentMArk(String studentID);
	
	
	/**
	 * get Class Student List
	 * @param className
	 */
	public List<Student> getClassStudentList(String className);
	
	
	/**
	 * update Student Mark
	 * @param mark
	 */
	public void updateStudentMark(Marks mark);
	
	
	/**
	 * drop Student Mark
	 * @param studentID
	 */
	public void dropStudentMark(String studentID);
	
	
	/**
	 * get Student PlaceList
	 * @param className
	 */
	public List<ClassPlaceList> getStudentPlaceList(String className);
}
