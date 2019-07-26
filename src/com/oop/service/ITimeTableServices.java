/**
 * @Student_ID : IT18180626
 * @Name : H.M.A.N.Welagedara
 */


package com.oop.service;

import java.util.ArrayList;

import com.sis.model.TimeTableDetails;
import com.sis.model.TimeTableName;

public interface ITimeTableServices {
	
	/**
	 * add TimeTable
	 * @param timeTableName
	 */
	public void addTimeTable(TimeTableName timeTableName);
	
	/**
	 * add TimeTable Details
	 * @param timeTableDetails
	 */
	public void addTimeTableDetails(TimeTableDetails timeTableDetails);
	
	/**
	 *get TimetableName List
	 */
	public ArrayList<TimeTableName> getTimetableNameList();
	
	
	/**
	 * get Timetable Details List
	 * @param timeTableNameID
	 */
	public ArrayList<TimeTableDetails> getTimetableDetailsList(String timeTableNameID);
	
	
	/**
	 * delete TimeTable Details
	 * @param timetableId
	 */
	public void deleteTimeTableDetails(String timetableId);
	
	
	/**
	 * delete TimeTable
	 * @param timetableId
	 */
	public void deleteTimeTable(String timetableId);
	
	
	/**
	 * get Timetable NameList By Year
	 * @param year
	 */
	public ArrayList<TimeTableName> getTimetableNameListByYear(int year);
	
	
	/**
	 * get TimeTable Name ById
	 * @param timetableID
	 */
	public TimeTableName getTimeTableNameById(String timetableID);
	
	
	/**
	 * update TimeTable
	 * @param timeTableName
	 */
	public void updateTimeTable(TimeTableName timeTableName);
	
	
	/**
	 * update TimeTable Details
	 * @param timeTableDetails
	 */
	public void updateTimeTableDetails(TimeTableDetails timeTableDetails);
}
