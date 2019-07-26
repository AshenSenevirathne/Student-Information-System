/**
 * @Student_ID : IT18178678
 * @Name : S.M.A.S.Senevirathne
 */

package com.oop.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.oop.util.CommonConstants;
import com.oop.util.CommonFunctions;
import com.oop.util.DBConnectionUtil;
import com.oop.util.QueryUtil;
import com.sis.model.ClassAttendance;
import com.sis.model.Student;

public class RegisterServices implements IRegisterServices {

	public static final Logger log = Logger.getLogger(RegisterServices.class.getName());

	private static Connection connection;

	private static Statement statement;

	private static PreparedStatement ps;

	private static ResultSet rs;

	static {
		createRegiterTable();

	}

	public static void createRegiterTable() {

		try {
			
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_REGISTER_TABLE));
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_REGISTER_TABLE));

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	public List<Student> getRegister(String className) {
		// TODO Auto-generated method stub

		List<Student> list = new ArrayList<Student>();

		try {
			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_CLASS_STUDENT_LIST));
			ps.setString(CommonConstants.COLUMN_INDEX_ONE, className);

			rs = ps.executeQuery();

			while (rs.next()) {

				Student student = new Student();
				student.setStudentID(rs.getString("studentID"));
				student.setName(rs.getString("studentName"));
				student.setYear(Integer.parseInt(rs.getString("studentYear")));

				list.add(student);
				
			}

		}  catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}finally {
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

	public void markRegister(ClassAttendance classAttendance) {
		// TODO Auto-generated method stub

		
		String id = CommonFunctions.generateIDs(getdayId(), CommonConstants.REGISTER_PREFIX);
		try {
			connection = DBConnectionUtil.getDBConnection();
			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ADD_REGISTER_TABLE));
			ps.setString(CommonConstants.COLUMN_INDEX_ONE, id);
			ps.setString(CommonConstants.COLUMN_INDEX_TWO, classAttendance.getStudentId());
			ps.setString(CommonConstants.COLUMN_INDEX_THREE, classAttendance.getClassName());
			ps.executeUpdate();

		}  catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
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

	// get created primary keys
	private ArrayList<String> getdayId() {

		ArrayList<String> arrayList = new ArrayList<String>();

		try {
			connection = DBConnectionUtil.getDBConnection();
			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_SELECT_ALL_FROM_REGISTER));
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
			}
		}  catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
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
		return arrayList;
	}

	public int getTotalDays(String className) {

		int totalDays = 0;
		try {
			connection = DBConnectionUtil.getDBConnection();
			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_TOTAL_DAYS));
			ps.setString(CommonConstants.COLUMN_INDEX_ONE, className);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				totalDays = rs.getInt("TPD");
				
			}
			
		}  catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
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
		return totalDays;
	}

	public int getTotalPrasentDays(String studentID) {

		int totalPrasentDays = 0;
		try {
			connection = DBConnectionUtil.getDBConnection();
			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_TOTAL_PRASENT_DAYS));

			ps.setString(CommonConstants.COLUMN_INDEX_ONE, studentID);
			ResultSet rs = ps.executeQuery();
			
			
			while (rs.next()) {
				totalPrasentDays = rs.getInt(CommonConstants.COLUMN_INDEX_ONE);
				
			}

		}  catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}finally {
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
		return totalPrasentDays;
	}
	
	public void removeClassesRegisterRecords(String className) {
		// TODO Auto-generated method stub

		
		try {
			connection = DBConnectionUtil.getDBConnection();
			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_DELETE_REGISTER_ENTRY));
			ps.setString(CommonConstants.COLUMN_INDEX_ONE, className);

			ps.executeUpdate();

		}  catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}finally {
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
