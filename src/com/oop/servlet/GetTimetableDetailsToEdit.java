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

import com.sis.model.TimeTableName;

/**
 * Servlet implementation class getTimetableDetailsToEdit
 */
@WebServlet("/GetTimetableDetailsToEdit")
public class GetTimetableDetailsToEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetTimetableDetailsToEdit() {
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
		String ttId = request.getParameter("ttID");
		System.out.println(ttId);
		
		//get time details
		TimeTableName tableName = new TimeTableName();
		tableName.setTimeTableID(ttId);
		
		request.setAttribute("tableName", tableName);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/staff_member/EditTimetableDetails.jsp");
		dispatcher.forward(request, response);
	}

}
