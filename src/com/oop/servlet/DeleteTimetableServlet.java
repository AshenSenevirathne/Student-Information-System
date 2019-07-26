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

/**
 * Servlet implementation class DeleteTimetableServlet
 */
@WebServlet("/DeleteTimetableServlet")
public class DeleteTimetableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTimetableServlet() {
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
		
		String timeTableId = request.getParameter("ttID");
		
		
		ITimeTableServices iTimeTableServices = new TimeTableServices();
		//delete timetable details
		iTimeTableServices.deleteTimeTableDetails(timeTableId);
		//delete timetable
		iTimeTableServices.deleteTimeTable(timeTableId);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/staff_member/AllTimeTables.jsp");
		dispatcher.forward(request, response);
	}

}
