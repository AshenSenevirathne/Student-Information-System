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
import com.sis.model.Subjects;
import com.oop.util.CommonConstants;
import com.oop.util.CommonFunctions;

public class SubjectServices implements ISubjectsServices {
	public static final Logger log = Logger.getLogger(SubjectServices.class.getName());

	private static Connection connection;

	private static Statement statement;

	private static PreparedStatement ps;

	private static ResultSet rs;

	
	
	static {
		createSubjectTable();

	}
	
	public static void createSubjectTable() {

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DELETE_SUBJECT_TABLE));
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_SUBJECT_TABLE));
		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	
	
	@Override
	public void addSubject(Subjects subjects) {
		// TODO Auto-generated method stub
		String subjectId = CommonFunctions.generateIDs(getSubjectID(), CommonConstants.SUBJECT_TABLE);
		subjects.setSubID(subjectId);
		try {

			connection = DBConnectionUtil.getDBConnection();
			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ADD_SUBJECT_TABLE));

			ps.setString(CommonConstants.COLUMN_INDEX_ONE, subjects.getSubID());
			ps.setString(CommonConstants.COLUMN_INDEX_TWO, subjects.getSubCode());
			ps.setString(CommonConstants.COLUMN_INDEX_THREE, subjects.getSubName());
			ps.setInt(CommonConstants.COLUMN_INDEX_FOUR, subjects.getYear());
			System.out.println(subjects);
			
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
	
	private ArrayList<String> getSubjectID() {

		ArrayList<String> arrayList = new ArrayList<String>();

		try {
			connection = DBConnectionUtil.getDBConnection();
			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_SELECT_ALL_FROM_SUBJECTS));
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
	public ArrayList<Subjects> getSubjectList() {
		// TODO Auto-generated method stub
		ArrayList<Subjects> list = new ArrayList<Subjects>();

		try {
			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_SELECT_ALL_FROM_SUBJECTS));

			rs = ps.executeQuery();

			while (rs.next()) {

				Subjects subjects = new Subjects();
				subjects.setSubID(rs.getString(CommonConstants.COLUMN_INDEX_ONE));
				subjects.setSubCode(rs.getString(CommonConstants.COLUMN_INDEX_TWO));
				subjects.setSubName(rs.getString(CommonConstants.COLUMN_INDEX_THREE));
				subjects.setYear(Integer.parseInt(rs.getString(CommonConstants.COLUMN_INDEX_FOUR)));
				list.add(subjects);

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
	public void removeSubject(String subjectID) {
		// TODO Auto-generated method stub
		try {

			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_DELETE_SUBJECTS));

			ps.setString(CommonConstants.COLUMN_INDEX_ONE, subjectID);

			ps.execute();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
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

	@Override
	public Subjects getSubjectByID(String subjectID) {
		// TODO Auto-generated method stub
		Subjects subjects = new Subjects();
		try {

			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_SUBJECT_BY_ID));
			ps.setString(CommonConstants.COLUMN_INDEX_ONE, subjectID);
			rs = ps.executeQuery();
			while (rs.next()) {
				subjects.setSubID(rs.getString(CommonConstants.COLUMN_INDEX_ONE));
				subjects.setSubCode(rs.getString(CommonConstants.COLUMN_INDEX_TWO));
				subjects.setSubName(rs.getString(CommonConstants.COLUMN_INDEX_THREE));
				subjects.setYear(Integer.parseInt(rs.getString(CommonConstants.COLUMN_INDEX_FOUR)));

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

		return subjects;

	}

	@Override
	public void updateSubjectDetails(Subjects subjects, String subjectID) {
		// TODO Auto-generated method stub
		try {

			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_SUBJECT_DETAILS));

			ps.setString(CommonConstants.COLUMN_INDEX_ONE, subjects.getSubCode());
			ps.setString(CommonConstants.COLUMN_INDEX_TWO, subjects.getSubName());
			ps.setInt(CommonConstants.COLUMN_INDEX_THREE, subjects.getYear());
			ps.setString(CommonConstants.COLUMN_INDEX_FOUR, subjects.getSubID());

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
	public void deleteAllSubjects() {
		// TODO Auto-generated method stub
		try {

			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_DELETE_ALL_SUBJECTS));

			

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

	public ArrayList<Subjects> getSubjectList(int year) {
		// TODO Auto-generated method stub
		ArrayList<Subjects> list = new ArrayList<Subjects>();

		try {
			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_SUBJECT_BY_YEAR));
			ps.setInt(CommonConstants.COLUMN_INDEX_ONE, year);
			rs = ps.executeQuery();

			while (rs.next()) {

				Subjects subjects = new Subjects();
				subjects.setSubID(rs.getString(CommonConstants.COLUMN_INDEX_ONE));
				subjects.setSubCode(rs.getString(CommonConstants.COLUMN_INDEX_TWO));
				subjects.setSubName(rs.getString(CommonConstants.COLUMN_INDEX_THREE));
				subjects.setYear(Integer.parseInt(rs.getString(CommonConstants.COLUMN_INDEX_FOUR)));
				list.add(subjects);

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
	public ArrayList<Subjects> getSubjectsByYear(int year) {
		// TODO Auto-generated method stub
		ArrayList<Subjects> list = new ArrayList<Subjects>();

		try {
			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_SUBJECTS_BY_YEAR));
			ps.setInt(CommonConstants.COLUMN_INDEX_ONE, year);
			rs = ps.executeQuery();

			while (rs.next()) {

				Subjects subjects = new Subjects();
				subjects.setSubID(rs.getString(CommonConstants.COLUMN_INDEX_ONE));
				subjects.setSubCode(rs.getString(CommonConstants.COLUMN_INDEX_TWO));
				subjects.setSubName(rs.getString(CommonConstants.COLUMN_INDEX_THREE));
				subjects.setYear(Integer.parseInt(rs.getString(CommonConstants.COLUMN_INDEX_FOUR)));
				list.add(subjects);

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
