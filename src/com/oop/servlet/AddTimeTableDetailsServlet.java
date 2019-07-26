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



/**
 * Servlet implementation class AddTimeTableDetailsServlet
 */
@WebServlet("/AddTimeTableDetailsServlet")
public class AddTimeTableDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTimeTableDetailsServlet() {
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
		
		String timeTableID = request.getParameter("timeTableID");
		String subjects[] = request.getParameterValues("subject");
		String day[] = request.getParameterValues("day");
		String startTime[] = request.getParameterValues("startTime");
		String endTime[] = request.getParameterValues("endTime");
		
		//add time table details
		for(int i = 0; i < subjects.length; i++ ) {
			TimeTableDetails timeTableDetails = new TimeTableDetails();
			timeTableDetails.setTimeTableID(timeTableID);
			timeTableDetails.setDate(day[i]);
			timeTableDetails.setSubject(subjects[i]);
			timeTableDetails.setStartTime(startTime[i]);
			timeTableDetails.setEndTime(endTime[i]);
			ITimeTableServices iTimeTableServices = new TimeTableServices();
			iTimeTableServices.addTimeTableDetails(timeTableDetails);
			
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/staff_member/AllTimeTables.jsp");
		dispatcher.forward(request, response);
	}

}
