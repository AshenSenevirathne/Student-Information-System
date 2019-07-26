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

import com.oop.service.ClassesServices;
import com.oop.service.IClassServices;
import com.sis.model.Clases;

/**
 * Servlet implementation class AddClassServlet
 */
@WebServlet("/AddClassServlet")
public class AddClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddClassServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		response.setContentType("text/html");

		// take inserted values by client
		Clases classes = new Clases();
		classes.setClassName(request.getParameter("className"));
		classes.setYear(request.getParameter("year"));
		classes.setNoOfStudents(request.getParameter("studentNo"));
		classes.setTeacher(request.getParameter("teacherName"));
		classes.setHall(request.getParameter("hall"));
		int userName = Integer.parseInt(request.getParameter("userName"));
		
		// use the interface
		IClassServices service = new ClassesServices();
		//add class
		service.addClass(classes);
		//set class name of employee
		service.setClassName(userName, request.getParameter("className"));

		request.setAttribute("classes", classes);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/teacher/FinalizeClass.jsp");
		dispatcher.forward(request, response);

	}

}
