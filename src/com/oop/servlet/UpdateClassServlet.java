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
import com.sis.model.ClassAttendance;


/**
 * Servlet implementation class UpdateClassServlet
 */
@WebServlet("/UpdateClassServlet")
public class UpdateClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateClassServlet() {
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
		String className = request.getParameter("className");
		int userName = Integer.parseInt(request.getParameter("userName"));
		String previousClassName = request.getParameter("previousClassName");
		classes.setClassID(request.getParameter("classID"));
		classes.setClassName(className);
		classes.setYear(request.getParameter("year"));
		classes.setNoOfStudents(request.getParameter("studentNo"));
		classes.setTeacher(request.getParameter("teacherName"));
		classes.setHall(request.getParameter("hall"));
		
		//update class details
		IClassServices services = new ClassesServices();
		services.updateClassDetails(classes);
		//update class name of students
		services.updateStudentClass(className, previousClassName);
		//update employee created class name
		services.setClassName(userName, className);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/teacher/ShowClass.jsp");
		dispatcher.forward(request, response);
	}

}
