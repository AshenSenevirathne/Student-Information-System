/**
 * @Student_ID : IT18180626
 * @Name : H.M.A.N.Welagedara
 */


package com.oop.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.oop.util.DBConnectionUtil;
import com.oop.util.QueryUtil;
import com.sis.model.TimeTableDetails;
import com.sis.model.TimeTableName;
import com.oop.util.CommonConstants;
import com.oop.util.CommonFunctions;

public class TimeTableServices implements ITimeTableServices {
	public static final Logger log = Logger.getLogger(TimeTableServices.class.getName());

	private static Connection connection;

	private static Statement statement;

	private static PreparedStatement ps;

	private static ResultSet rs;

	

	static {
		createTimeTable();
	}

	public static void createTimeTable() {

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_TIMETABLEDETAILS_TABLE));
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_TIMETABLE_TABLE));
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_TIMETABLE_TABLE));
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_TIMETABLEDETAILS_TABLE));

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} 
	}
	
	
	public void addTimeTable(TimeTableName timeTableName) {
		// TODO Auto-generated method stub
		String timetableID = CommonFunctions.generateIDs(getTimetableID(), CommonConstants.TIMETABLE_TABLE);
		timeTableName.setTimeTableID(timetableID);
		try {

			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ADD_TIMETABLE_TABLE));

			ps.setString(CommonConstants.COLUMN_INDEX_ONE, timeTableName.getTimeTableID());
			ps.setString(CommonConstants.COLUMN_INDEX_TWO, timeTableName.getTimeTableName());
			ps.setInt(CommonConstants.COLUMN_INDEX_THREE, timeTableName.getYear());
			
			System.out.println(timeTableName);
			
			ps.execute();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (ps != null) {
					ps.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}

	}
	
	
	private ArrayList<String> getTimetableID() {

		ArrayList<String> arrayList = new ArrayList<String>();

		try {
			connection = DBConnectionUtil.getDBConnection();
			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_SELECT_ALL_FROM_TIMETABLE));
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
			}
		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}  finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (ps != null) {
					ps.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return arrayList;
	}
	
	
	
	
	public void addTimeTableDetails(TimeTableDetails timeTableDetails) {
		// TODO Auto-generated method stub
		String timetableDetailsID = CommonFunctions.generateIDs(getTimetableDetailsID(), CommonConstants.TIMETABLE_DETAILS_TABLE);
		timeTableDetails.setTtDetailsId(timetableDetailsID);
		try {

			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ADD_TIMETABLEDETAILS));

			ps.setString(CommonConstants.COLUMN_INDEX_ONE, timeTableDetails.getTtDetailsId());
			ps.setString(CommonConstants.COLUMN_INDEX_TWO, timeTableDetails.getTimeTableID());
			ps.setString(CommonConstants.COLUMN_INDEX_THREE, timeTableDetails.getSubject());
			ps.setString(CommonConstants.COLUMN_INDEX_FOUR, timeTableDetails.getDate());
			ps.setString(CommonConstants.COLUMN_INDEX_FIVE, timeTableDetails.getStartTime());
			ps.setString(CommonConstants.COLUMN_INDEX_SIX, timeTableDetails.getEndTime());
			ps.execute();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}  finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (ps != null) {
					ps.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}

	}
	
	
	
	
	
	private ArrayList<String> getTimetableDetailsID() {

		ArrayList<String> arrayList = new ArrayList<String>();

		try {
			connection = DBConnectionUtil.getDBConnection();
			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_SELECT_ALL_FROM_TIMETABLEDETAILS));
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
			}
		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}  finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (ps != null) {
					ps.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return arrayList;
	}
	
	public ArrayList<TimeTableName> getTimetableNameList() {
		// TODO Auto-generated method stub
		ArrayList<TimeTableName> list = new ArrayList<TimeTableName>();

		try {
			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_SELECT_ALL_FROM_TIMETABLE));

			rs = ps.executeQuery();

			while (rs.next()) {

				TimeTableName tableName = new TimeTableName();
				tableName.setTimeTableID(rs.getString(CommonConstants.COLUMN_INDEX_ONE));
				tableName.setTimeTableName(rs.getString(CommonConstants.COLUMN_INDEX_TWO));
				tableName.setYear(Integer.parseInt(rs.getString(CommonConstants.COLUMN_INDEX_THREE)));
				list.add(tableName);

			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}  finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (ps != null) {
					ps.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return list;

	}
	
	public ArrayList<TimeTableDetails> getTimetableDetailsList(String timeTableNameID) {
		// TODO Auto-generated method stub
		ArrayList<TimeTableDetails> list = new ArrayList<TimeTableDetails>();

		try {
			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_TIMETABLE_DETAILS_BY_TIMETABLE_ID));
			ps.setString(CommonConstants.COLUMN_INDEX_ONE, timeTableNameID);
			rs = ps.executeQuery();

			while (rs.next()) {

				TimeTableDetails timeTableDetails = new TimeTableDetails();
				timeTableDetails.setTtDetailsId(rs.getString(CommonConstants.COLUMN_INDEX_ONE));
				timeTableDetails.setTimeTableID(rs.getString(CommonConstants.COLUMN_INDEX_TWO));
				timeTableDetails.setSubject(rs.getString(CommonConstants.COLUMN_INDEX_THREE));
				timeTableDetails.setDate(rs.getString(CommonConstants.COLUMN_INDEX_FOUR));
				timeTableDetails.setStartTime(rs.getString(CommonConstants.COLUMN_INDEX_FIVE));
				timeTableDetails.setEndTime(rs.getString(CommonConstants.COLUMN_INDEX_SIX));
				
				
				list.add(timeTableDetails);

			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}  finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (ps != null) {
					ps.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return list;

	}


	@Override
	public void deleteTimeTableDetails(String timetableId) {
		// TODO Auto-generated method stub
		try {

			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_DELETE_TIMETABLE_DETAILS));

			ps.setString(CommonConstants.COLUMN_INDEX_ONE, timetableId);
		
			ps.execute();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}  finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (ps != null) {
					ps.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
	}


	@Override
	public void deleteTimeTable(String timetableId) {
		// TODO Auto-generated method stub
		try {

			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_DELETE_TIMETABLE));

			ps.setString(CommonConstants.COLUMN_INDEX_ONE, timetableId);
		
			ps.execute();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}  finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (ps != null) {
					ps.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
	}


	@Override
	public ArrayList<TimeTableName> getTimetableNameListByYear(int year) {
		// TODO Auto-generated method stub
		

		ArrayList<TimeTableName> list = new ArrayList<TimeTableName>();

		try {
			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_TIMETABLE_BY_YEAR));
			ps.setInt(CommonConstants.COLUMN_INDEX_ONE, year);
			rs = ps.executeQuery();

			while (rs.next()) {

				TimeTableName tableName = new TimeTableName();
				tableName.setTimeTableID(rs.getString(CommonConstants.COLUMN_INDEX_ONE));
				tableName.setTimeTableName(rs.getString(CommonConstants.COLUMN_INDEX_TWO));
				tableName.setYear(Integer.parseInt(rs.getString(CommonConstants.COLUMN_INDEX_THREE)));
				list.add(tableName);

			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}  finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (ps != null) {
					ps.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return list;
	}


	@Override
	public TimeTableName getTimeTableNameById(String timetableID) {
		// TODO Auto-generated method stub
		TimeTableName tableName = new TimeTableName();
		try {
			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_TIMETABLE_BY_ID));
			ps.setString(CommonConstants.COLUMN_INDEX_ONE, timetableID);
			rs = ps.executeQuery();

			while (rs.next()) {

				
				tableName.setTimeTableID(rs.getString(CommonConstants.COLUMN_INDEX_ONE));
				tableName.setTimeTableName(rs.getString(CommonConstants.COLUMN_INDEX_TWO));
				tableName.setYear(Integer.parseInt(rs.getString(CommonConstants.COLUMN_INDEX_THREE)));
				

			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}  finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (ps != null) {
					ps.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return tableName;
		
	}


	@Override
	public void updateTimeTable(TimeTableName timeTableName) {
		// TODO Auto-generated method stub
		try {

			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_UPDATE_TIMETABLE));

			ps.setString(CommonConstants.COLUMN_INDEX_ONE, timeTableName.getTimeTableName());
			ps.setInt(CommonConstants.COLUMN_INDEX_TWO, timeTableName.getYear());
			ps.setString(CommonConstants.COLUMN_INDEX_THREE, timeTableName.getTimeTableID());
			ps.execute();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}  finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (ps != null) {
					ps.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		
		
	}


	@Override
	public void updateTimeTableDetails(TimeTableDetails timeTableDetails) {
		// TODO Auto-generated method stub
		try {

			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_UPDATE_TIMETABLE_DETAILS));

			ps.setString(CommonConstants.COLUMN_INDEX_ONE, timeTableDetails.getDate());
			ps.setString(CommonConstants.COLUMN_INDEX_TWO, timeTableDetails.getStartTime());
			ps.setString(CommonConstants.COLUMN_INDEX_THREE, timeTableDetails.getEndTime());
			ps.setString(CommonConstants.COLUMN_INDEX_FOUR, timeTableDetails.getTtDetailsId());
			
			ps.execute();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}  finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (ps != null) {
					ps.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
	}


}
