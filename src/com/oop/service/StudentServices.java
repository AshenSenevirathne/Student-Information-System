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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.sis.model.Student;
import com.oop.util.DBConnectionUtil;
import com.oop.util.QueryUtil;
import com.oop.util.CommonConstants;
import com.oop.util.CommonFunctions;



public class StudentServices implements IStudentServices {
	public static final Logger log = Logger.getLogger(StudentServices.class.getName());

	private static Connection connection;

	private static Statement statement;

	private static PreparedStatement ps;

	private static ResultSet rs;


	static {
		createStudentTable();

	}

	public static void createStudentTable() {

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DELETE_STUDENT_TABLE));
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_STUDENT_TABLE));
		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}
	
	@Override
	public void addStudents(Student student) {
		// TODO Auto-generated method stub
		String studentId = CommonFunctions.generateIDs(getStudentID(), CommonConstants.STUDENT_TABLE);
		student.setStudentID(studentId);
		try {

			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ADD_STUDENT_TABLE));

			ps.setString(CommonConstants.COLUMN_INDEX_ONE, student.getStudentID());
			ps.setString(CommonConstants.COLUMN_INDEX_TWO, student.getName());
			ps.setInt(CommonConstants.COLUMN_INDEX_THREE, student.getYear());
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

	private ArrayList<String> getStudentID() {

		ArrayList<String> arrayList = new ArrayList<String>();

		try {
			connection = DBConnectionUtil.getDBConnection();
			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_SELECT_ALL_FROM_STUDENT));
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
			}
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
		return arrayList;
	}

	@Override
	public ArrayList<Student> getStudentList() {

		ArrayList<Student> list = new ArrayList<Student>();

		try {
			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_SELECT_ALL_FROM_STUDENT));

			rs = ps.executeQuery();

			while (rs.next()) {

				Student student = new Student();
				student.setStudentID(rs.getString("studentID"));
				student.setName(rs.getString("studentName"));
				student.setYear(Integer.parseInt(rs.getString("studentYear")));
				
				list.add(student);

			}

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
		return list;

	}

	@Override
	public void removeStudent(String studentID) {
		// TODO Auto-generated method stub

		try {

			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_DELETE_FROM_STUDENT));

			ps.setString(CommonConstants.COLUMN_INDEX_ONE, studentID);

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

	public Student getStudentByID(String studentID) {

		Student student = new Student();
		try {

			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_STUDENT_DETAILS));
			ps.setString(CommonConstants.COLUMN_INDEX_ONE, studentID);
			rs = ps.executeQuery();
			while (rs.next()) {
				student.setStudentID(rs.getString("studentID"));
				student.setName(rs.getString("studentName"));
				student.setYear(Integer.parseInt(rs.getString("studentYear")));
				

			}

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

		return student;

	}

	@Override
	public void updateStudentDetails(Student student, String studentID) {
		// TODO Auto-generated method stub
		try {

			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_STUDENT_DETAILS));

			ps.setString(CommonConstants.COLUMN_INDEX_ONE, student.getName());
			ps.setInt(CommonConstants.COLUMN_INDEX_TWO, student.getYear());
			ps.setString(CommonConstants.COLUMN_INDEX_THREE, studentID);
			System.out.println("fvdfvf" + student);
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

	@Override
	public void deleteAllStudents() {
		// TODO Auto-generated method stub
		try {

			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_DELETE_ALL_STUDENT));

			

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

	@Override
	public ArrayList<Student> getStudentByYear(int year) {
		// TODO Auto-generated method stub
		ArrayList<Student> list = new ArrayList<Student>();

		try {
			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_STUDENTS_BY_YEAR));
			ps.setInt(CommonConstants.COLUMN_INDEX_ONE, year);
			rs = ps.executeQuery();

			while (rs.next()) {

				Student student = new Student();
				student.setStudentID(rs.getString("studentID"));
				student.setName(rs.getString("studentName"));
				student.setYear(Integer.parseInt(rs.getString("studentYear")));
				
				list.add(student);

			}

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
		return list;

	}

}
