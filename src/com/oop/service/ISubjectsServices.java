/**
 * @Student_ID : IT18180626
 * @Name : H.M.A.N.Welagedara
 */


package com.oop.service;

import java.util.ArrayList;

import com.sis.model.Subjects;

public interface ISubjectsServices {
	
	/**
	 * add Subject
	 * @param subjects
	 */
	public void addSubject(Subjects subjects);

	
	/**
	 * get Subject List 
	 */
	public ArrayList<Subjects> getSubjectList();

	
	/**
	 * remove Subject
	 * @param 	public
	 */
	public void removeSubject(String subjectID);

	
	/**
	 * get Subject By ID
	 * @param getSubjectByID
	 */
	public Subjects getSubjectByID(String subjectID);

	
	/**
	 * update Subject Details
	 * @param subjects, subjectID
	 */
	public void updateSubjectDetails(Subjects subjects, String subjectID);

	
	/**
	 * delete All Subjects
	 */
	public void deleteAllSubjects();

	
	/**
	 * get SubjectList
	 * @param year
	 */
	public ArrayList<Subjects> getSubjectList(int year);
	
	
	/**
	 * get Subjects By Year
	 * @param year
	 */
	public ArrayList<Subjects> getSubjectsByYear(int year);
}
