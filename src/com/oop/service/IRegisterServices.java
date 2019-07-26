/**
 * @Student_ID : IT18178678
 * @Name : S.M.A.S.Senevirathne
 */

package com.oop.service;

import java.util.List;

import com.sis.model.ClassAttendance;
import com.sis.model.Student;

public interface IRegisterServices {
	/**
	 * get Register
	 * @param className
	 */
	public List<Student> getRegister(String className);
	
	
	/**
	 * mark Register
	 * @param classAttendance
	 */
	public void markRegister(ClassAttendance classAttendance);

	
	/**
	 * get Total Days
	 * @param className
	 */
	public int getTotalDays(String className);

	
	/**
	 * get Total Prasent Days
	 * @param studentID
	 */
	public int getTotalPrasentDays(String studentID);

	
	/**
	 * remove Classes Register Records
	 * @param className
	 */
	public void removeClassesRegisterRecords(String className);
}
