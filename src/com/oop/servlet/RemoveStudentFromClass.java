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
import com.oop.service.IMarkServices;
import com.oop.service.MarkServices;
import com.sis.model.Clases;
import com.sis.model.Student;


/**
 * Servlet implementation class RemoveStudentFromClass
 */
@WebServlet("/RemoveStudentFromClass")
public class RemoveStudentFromClass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RemoveStudentFromClass() {
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

		Student student1 = new Student();
		student1.setStudentID(request.getParameter("removeStudentID"));
		
		//remove student from class
		IClassServices classesServices = new ClassesServices();
		classesServices.removeStudentsFromClass(student1);
		
		//remove student marks
		IMarkServices iMarkServices = new MarkServices();
		iMarkServices.dropStudentMark(student1.getStudentID());
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/teacher/FinalizeClass.jsp");
		dispatcher.forward(request, response);
	}

}
