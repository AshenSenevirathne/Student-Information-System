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
import com.sis.model.Student;
import com.sun.org.apache.xalan.internal.xsltc.trax.OutputSettings;


/**
 * Servlet implementation class AddStudentsToClassServlet
 */
@WebServlet("/AddStudentsToClassServlet")
public class AddStudentsToClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1871871796669342804L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudentsToClassServlet() {
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
		
		response.setContentType("text/html");
		String className = request.getParameter("className");
		String studentId[] = request.getParameterValues("studentId");
		
		//add selected year students to created class
		for (String id : studentId) {
			Student student = new Student();
			student.setStudentID(id);
			student.setClassName(className);
			IClassServices classesServices = new ClassesServices();
			classesServices.addStudentsToClass(student);
			
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/teacher/FinalizeClass.jsp");
		dispatcher.forward(request, response);
		
	}

}
