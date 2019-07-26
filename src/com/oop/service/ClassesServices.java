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
import com.sis.model.Clases;
import com.sis.model.Student;

public class ClassesServices implements IClassServices {

	public static final Logger log = Logger.getLogger(ClassesServices.class.getName());

	private static Connection connection;

	private static Statement statement;

	private static PreparedStatement ps;

	private static ResultSet rs;

	static {
		createClassesTable();

	}

	public static void createClassesTable() {
		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_CLASSES_TABLE));
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_CLASSES_TABLE));

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	@Override
	public void addClass(Clases classes) {
		// TODO Auto-generated method stub
		String classesID = CommonFunctions.generateIDs(getClassesID(), CommonConstants.CLASS_PREFIX);

		try {

			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ADD_CLASSES_TABLE));
			connection.setAutoCommit(false);

			classes.setClassID(classesID);
			ps.setString(CommonConstants.COLUMN_INDEX_ONE, classes.getClassID());
			ps.setString(CommonConstants.COLUMN_INDEX_TWO, classes.getClassName());
			ps.setString(CommonConstants.COLUMN_INDEX_THREE, classes.getYear());
			ps.setString(CommonConstants.COLUMN_INDEX_FOUR, classes.getNoOfStudents());
			ps.setString(CommonConstants.COLUMN_INDEX_FIVE, classes.getTeacher());
			ps.setString(CommonConstants.COLUMN_INDEX_SIX, classes.getHall());
			ps.execute();
			connection.commit();

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

	private ArrayList<String> getClassesID() {

		ArrayList<String> arrayList = new ArrayList<String>();

		try {
			connection = DBConnectionUtil.getDBConnection();
			ps = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_CLASSES_TABLE_ENTRY_COUNT));
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
	public List<Student> getStudentList(String selectedYear) {
		// TODO Auto-generated method stub

		List<Student> list = new ArrayList<Student>();

		try {
			connection = DBConnectionUtil.getDBConnection();

			ps = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_SELECTED_YEAR_STUDENT_LIST));
			ps.setString(CommonConstants.COLUMN_INDEX_ONE, selectedYear);
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

	public List<Student> getInsertedStudentList(String className) {
		// TODO Auto-generated method stub

		List<Student> list = new ArrayList<Student>();

		try {
			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_INSERTED_STUDENT_LIST));
			ps.setString(CommonConstants.COLUMN_INDEX_ONE, className);
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

	public void removeClass(String classID) {
		// TODO Auto-generated method stub

		try {

			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_CLASS));
			ps.setString(CommonConstants.COLUMN_INDEX_ONE, classID);
			ps.executeUpdate();

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

	public Clases getClassDetails(String className) {
		// TODO Auto-generated method stub

		Clases clases = new Clases();

		try {
			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_CLASS_DETAILS));
			ps.setString(CommonConstants.COLUMN_INDEX_ONE, className);
			rs = ps.executeQuery();

			while (rs.next()) {

				clases.setClassID(rs.getString("classesID"));
				clases.setClassName(rs.getString("classesName"));
				clases.setYear(rs.getString("classesYear"));
				clases.setNoOfStudents(rs.getString("classesNoOfStudents"));
				clases.setTeacher(rs.getString("classesTeacher"));
				clases.setHall(rs.getString("classesHall"));

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
		return clases;

	}

	public void removeStudentsFromClass(String className) {
		// TODO Auto-generated method stub

		try {

			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_STUDENTS_FROM_CLASS));
			ps.setString(CommonConstants.COLUMN_INDEX_ONE, className);
			ps.executeUpdate();

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

	public void updateClassDetails(Clases clases) {
		try {

			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_CLASS_DETAILS));

			ps.setString(CommonConstants.COLUMN_INDEX_ONE, clases.getClassName());
			ps.setString(CommonConstants.COLUMN_INDEX_TWO, clases.getNoOfStudents());
			ps.setString(CommonConstants.COLUMN_INDEX_THREE, clases.getTeacher());
			ps.setString(CommonConstants.COLUMN_INDEX_FOUR, clases.getHall());
			ps.setString(CommonConstants.COLUMN_INDEX_FIVE, clases.getClassID());

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

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_STUDENT_BY_ID));
			ps.setString(CommonConstants.COLUMN_INDEX_ONE, studentID);
			rs = ps.executeQuery();
			while (rs.next()) {
				student.setStudentID(rs.getString("studentID"));
				student.setName(rs.getString("studentName"));
				student.setYear(Integer.parseInt(rs.getString("studentYear")));
				student.setClassName(rs.getString("className"));

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

	public void addStudentsToClass(Student student) {
		try {

			connection = DBConnectionUtil.getDBConnection();
			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ADD_STUDENT_TO_CLASS));

			ps.setString(CommonConstants.COLUMN_INDEX_ONE, student.getClassName());
			ps.setString(CommonConstants.COLUMN_INDEX_TWO, student.getStudentID());

			ps.executeUpdate();

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

	public void removeStudentsFromClass(Student student) {
		try {

			connection = DBConnectionUtil.getDBConnection();
			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_STUDENT_TO_CLASS));

			ps.setString(CommonConstants.COLUMN_INDEX_ONE, student.getStudentID());

			ps.executeUpdate();

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

	// when Class name get update
	public void updateStudentClass(String className, String oldClassName) {

		try {

			connection = DBConnectionUtil.getDBConnection();
			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_STUDENT_TO_CLASS));

			ps.setString(CommonConstants.COLUMN_INDEX_ONE, className);
			ps.setString(CommonConstants.COLUMN_INDEX_TWO, oldClassName);
			ps.executeUpdate();

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

	public String getClassName(int userName) {
		String className = "";
		try {

			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_CLASS_NAME));
			ps.setInt(CommonConstants.COLUMN_INDEX_ONE, userName);

			rs = ps.executeQuery();
			while (rs.next()) {

				className = rs.getString("OwnClass");
				
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

		return className;
	}

	public void setClassName(int userName, String className) {
		try {

			connection = DBConnectionUtil.getDBConnection();
			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_SET_CLASS_NAME));

			ps.setString(CommonConstants.COLUMN_INDEX_ONE, className);
			ps.setInt(CommonConstants.COLUMN_INDEX_TWO, userName);
			ps.executeUpdate();

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

}
