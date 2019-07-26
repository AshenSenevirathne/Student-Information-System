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
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.oop.util.CommonConstants;
import com.oop.util.DBConnectionUtil;
import com.oop.util.QueryUtil;
import com.sis.model.Assignments;

public class AssignmentServices implements IAssignmentServices {
	
	public static final Logger log = Logger.getLogger(ClassesServices.class.getName());

	private static Connection connection;

	private static Statement statement;

	private static PreparedStatement ps;

	private static ResultSet rs;
	
	static {
		createAssignmentTable();

	}
	
	
	public static void createAssignmentTable() {
		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_ASSIGNMENT_TABLE));
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_ASSIGNMENT_TABLE));

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}
	
	@Override
	public void addAssignment(Assignments assignments) {
		// TODO Auto-generated method stub
		try {

			connection = DBConnectionUtil.getDBConnection();

			ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ADD_ASSIGNMENT_TABLE));
			connection.setAutoCommit(false);

			
			ps.setString(CommonConstants.COLUMN_INDEX_ONE, assignments.getAssignmentName());
			ps.setString(CommonConstants.COLUMN_INDEX_TWO, assignments.getAssignmentDescription());
			ps.setString(CommonConstants.COLUMN_INDEX_THREE, assignments.getSubID());
			ps.setString(CommonConstants.COLUMN_INDEX_FOUR, assignments.getDate());
			ps.executeUpdate();
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

}
