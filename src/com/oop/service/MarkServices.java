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
import com.sis.model.ClassPlaceList;
import com.sis.model.Marks;
import com.sis.model.Student;
import com.sis.model.Subjects;

public class MarkServices implements IMarkServices {

	public static final Logger log = Logger.getLogger(MarkServices.class.getName());

	private static Connection connection;

	private static Statement statement;

	private static PreparedStatement ps;

	private static ResultSet rs;

	

	static {
		createMarkTable();
	}

	public static void createMarkTable() {
		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_MARKS_TABLE));
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_MARKS_TABLE));
		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	public void addMarks(Marks marks) {
		// TODO Auto-generated method stub
		String markID = CommonFunctions.generateIDs(getClassesID(), CommonConstants.MARK_PREFIX);

		try {

			connection = DBConnectionUtil.getDBConnection();
			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ADD_MARKS_TABLE));
			connection.setAutoCommit(false);

			marks.setMarkID(markID);
			ps.setString(1, marks.getMarkID());
			ps.setString(2, marks.getStudentID());
			ps.setString(3, marks.getSubjectName());
			ps.setFloat(4, marks.getMark());

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
			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_SELECT_ALL_MARKS_TABLE));
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

	public List<Subjects> getSubjectList(String selectedYear) {
		// TODO Auto-generated method stub

		List<Subjects> list = new ArrayList<Subjects>();

		try {
			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_SUBJECT_LIST));
			ps.setString(CommonConstants.COLUMN_INDEX_ONE, selectedYear);
			rs = ps.executeQuery();

			while (rs.next()) {

				Subjects subjects = new Subjects();
				subjects.setSubID(rs.getString("subID"));
				subjects.setSubName(rs.getString("subName"));

				list.add(subjects);
				System.out.println(subjects);

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

	public List<Marks> getStudentMArk(String studentID) {
		// TODO Auto-generated method stub

		List<Marks> list = new ArrayList<Marks>();

		try {
			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_STUDENT_MARK));
			ps.setString(CommonConstants.COLUMN_INDEX_ONE, studentID);
			rs = ps.executeQuery();

			while (rs.next()) {

				Marks marks = new Marks();
				marks.setMarkID(rs.getString("markID"));
				marks.setStudentID(rs.getString("studentID"));
				marks.setSubjectName(rs.getString("subName"));
				marks.setMark(Float.parseFloat(rs.getString("marks")));

				list.add(marks);

				System.out.println(marks);

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

	public List<Student> getClassStudentList(String className) {
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

				list.add(student);
				System.out.println(student);

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

	public void updateStudentMark(Marks mark) {
		try {

			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_STUDENT_MARKS));

			ps.setFloat(CommonConstants.COLUMN_INDEX_ONE, mark.getMark());
			ps.setString(CommonConstants.COLUMN_INDEX_TWO, mark.getMarkID());

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

	public void dropStudentMark(String studentID) {
		try {

			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_DELETE_STUDENT_MARKS));

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

	public List<ClassPlaceList> getStudentPlaceList(String className) {
		// TODO Auto-generated method stub

		List<ClassPlaceList> list = new ArrayList<ClassPlaceList>();

		try {
			connection = DBConnectionUtil.getDBConnection();
			
			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_STUDENT_PLACE_LIST));
			ps.setString(CommonConstants.COLUMN_INDEX_ONE, className);
			rs = ps.executeQuery();

			while (rs.next()) {

				ClassPlaceList classPlaceList = new ClassPlaceList();
				classPlaceList.setStudentID(rs.getString(CommonConstants.COLUMN_INDEX_ONE));
				classPlaceList.setName(rs.getString(CommonConstants.COLUMN_INDEX_TWO));
				classPlaceList.setSum(Float.parseFloat(rs.getString(CommonConstants.COLUMN_INDEX_THREE)));
				classPlaceList.setAvg(Float.parseFloat(rs.getString(CommonConstants.COLUMN_INDEX_FOUR)));
				classPlaceList.setTotalSubject(Integer.parseInt(rs.getString(CommonConstants.COLUMN_INDEX_FIVE)));

				list.add(classPlaceList);
				System.out.println(classPlaceList);

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

	public ClassPlaceList getSelectedStudentPlaceList(String StudetID) {
		// TODO Auto-generated method stub

		ClassPlaceList classPlaceList = new ClassPlaceList();

		try {
			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_SELECTED_STUDENT_PLACE_LIST));
			ps.setString(CommonConstants.COLUMN_INDEX_ONE, StudetID);
			rs = ps.executeQuery();

			while (rs.next()) {

				classPlaceList.setStudentID(rs.getString(CommonConstants.COLUMN_INDEX_ONE));
				classPlaceList.setName(rs.getString(CommonConstants.COLUMN_INDEX_TWO));
				classPlaceList.setSum(Float.parseFloat(rs.getString(CommonConstants.COLUMN_INDEX_THREE)));
				classPlaceList.setAvg(Float.parseFloat(rs.getString(CommonConstants.COLUMN_INDEX_FOUR)));
				classPlaceList.setTotalSubject(Integer.parseInt(rs.getString(CommonConstants.COLUMN_INDEX_FIVE)));

				System.out.println(classPlaceList);

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

		return classPlaceList;

	}

}
