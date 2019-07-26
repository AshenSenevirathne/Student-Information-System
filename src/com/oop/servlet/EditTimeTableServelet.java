/**
 * @Student_ID : IT18180626
 * @Name : H.M.A.N.Welagedara
 */


package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.service.ITimeTableServices;
import com.oop.service.TimeTableServices;
import com.sis.model.TimeTableDetails;
import com.sis.model.TimeTableName;

/**
 * Servlet implementation class EditTimeTableServelet
 */
@WebServlet("/EditTimeTableServelet")
public class EditTimeTableServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditTimeTableServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		TimeTableName timeTableName = new TimeTableName();
		timeTableName.setTimeTableID(request.getParameter("ttID"));
		timeTableName.setTimeTableName(request.getParameter("examName"));
		timeTableName.setYear(Integer.parseInt(request.getParameter("year")));
		
		//edit time table name
		ITimeTableServices iTimeTableServices = new TimeTableServices();
		iTimeTableServices.updateTimeTable(timeTableName);
		
		String ttDataID[] = request.getParameterValues("ttDID");
		String date[] = request.getParameterValues("day");
		String startTime[] = request.getParameterValues("startTime");
		String endTime[] = request.getParameterValues("endTime");
		
		
		//edit time table details
		for(int i = 0; i < ttDataID.length; i++ ) {
			TimeTableDetails details = new TimeTableDetails();
			
			details.setDate(date[i]);
			details.setStartTime(startTime[i]);
			details.setEndTime(endTime[i]);
			details.setTtDetailsId(ttDataID[i]);
			System.out.println(details);
			iTimeTableServices.updateTimeTableDetails(details);
			
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/staff_member/AllTimeTables.jsp");
		dispatcher.forward(request, response);
	}

}
