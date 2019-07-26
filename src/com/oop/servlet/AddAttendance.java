/**
 * @Student_ID : IT18178678
 * @Name : S.M.A.S.Senevirathne
 */

package com.oop.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.service.IRegisterServices;
import com.oop.service.RegisterServices;
import com.sis.model.ClassAttendance;
import com.sis.model.Student;


/**
 * Servlet implementation class AddAttendance
 */
@WebServlet("/AddAttendance")
public class AddAttendance extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddAttendance() {
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

		String studentId[] = request.getParameterValues("studentId");
		String className = request.getParameter("className");
		
		//mark register
		for (String id : studentId) {
			ClassAttendance classAttendance = new ClassAttendance();
			classAttendance.setStudentId(id);
			classAttendance.setClassName(className);
			
			IRegisterServices register = new RegisterServices();
			register.markRegister(classAttendance);
			
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/teacher/RegisterPersentage.jsp");
		dispatcher.forward(request, response);
	}

}
