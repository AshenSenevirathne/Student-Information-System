/**
 * @Student_ID : IT18178678
 * @Name : S.M.A.S.Senevirathne
 */

package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sis.model.Clases;

/**
 * Servlet implementation class FinalizedClassServlet
 */
@WebServlet("/FinalizedClassServlet")
public class FinalizedClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinalizedClassServlet() {
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
		Clases classes = new Clases();
		classes.setClassID(request.getParameter("classID"));
		classes.setClassName(request.getParameter("className"));
		classes.setYear(request.getParameter("year"));
		classes.setNoOfStudents(request.getParameter("numberOfStudents"));
		classes.setTeacher(request.getParameter("teacherName"));
		classes.setHall(request.getParameter("hall"));
		
		
		request.setAttribute("classes", classes);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/teacher/ShowClass.jsp");
		dispatcher.forward(request, response);
	}

}
