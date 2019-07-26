package com.oop.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import com.sis.model.StaffMember;
import com.sis.model.Teacher;

public class CommonFunctions {

	private static Connection connection;
	private PreparedStatement preparedStatement;
	
	public static String generateIDs(ArrayList<String> arrayList, String prefix) {

		String id;
		int next = arrayList.size();
		next++;
		id = prefix + next;
		if (arrayList.contains(id)) {
			next++;
			id = prefix + next;
		}
		return id;
	}
	
	public Teacher TeacherLogin(String un , String pwd) {
		
		Teacher result =  null;
		
		try {
			
			connection = DBConnectionUtil.getDBConnection(); 
			
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_TEACHER_LOGIN));
			
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, un);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, pwd);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Teacher teacher = new Teacher();
				teacher.setTeacherId(resultSet.getInt("teacherId"));
				teacher.setName(resultSet.getString("name"));
				teacher.setSection(resultSet.getString("section"));
				teacher.setNIC(resultSet.getString("NIC"));
				teacher.setOwnClass(resultSet.getString("OwnClass"));
				teacher.setEmail(resultSet.getString("Email"));
				
				result = teacher;
				
				
			}
			
		} catch (SQLException | IOException | ParserConfigurationException | ClassNotFoundException | org.xml.sax.SAXException e) {
			System.out.println(e);

		}
		return result;
		
	}
	
public StaffMember StaffLogin(String un , String pwd) {
		
		StaffMember result = null;
		
		try {
			
			connection = DBConnectionUtil.getDBConnection(); 
			
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_STAFF_LOGIN));
			
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, un);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, pwd);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				StaffMember sm = new StaffMember();
				sm.setId(resultSet.getInt("staffMemberId"));
				sm.setName(resultSet.getString("name"));
				sm.setEmail(resultSet.getString("email"));
				sm.setNIC(resultSet.getString("NIC"));
				System.out.println(sm);
				result = sm;
			}
			
		} catch (SQLException | IOException | ParserConfigurationException | ClassNotFoundException | org.xml.sax.SAXException e) {
			System.out.println(e);
		}
		
		return result;
	}

}
