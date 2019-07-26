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
import com.sis.model.TimeTableName;



/**
 * Servlet implementation class AddTimeTableServlet
 */
@WebServlet("/AddTimeTableServlet")
public class AddTimeTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTimeTableServlet() {
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
		timeTableName.setTimeTableName(request.getParameter("examName"));
		timeTableName.setYear(Integer.parseInt(request.getParameter("year")));
		
		//add time table
		ITimeTableServices iTimeTableServices = new TimeTableServices();
		iTimeTableServices.addTimeTable(timeTableName);
		
		request.setAttribute("timeTableName", timeTableName);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/staff_member/AddTimeTableDetails.jsp");
		dispatcher.forward(request, response);
		
	}

}
