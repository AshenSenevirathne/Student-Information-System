/**
 * @Student_ID : IT18178678
 * @Name : S.M.A.S.Senevirathne
 */

package com.oop.servlet;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.service.ClassesServices;
import com.oop.service.RegisterServices;
import com.oop.service.IClassServices;
import com.oop.service.IMarkServices;
import com.oop.service.IRegisterServices;
import com.oop.service.MarkServices;
import com.sis.model.Clases;
import com.sis.model.Student;
import java.util.List;


/**
 * Servlet implementation class RemoveClassServlet
 */
@WebServlet("/RemoveClassServlet")
public class RemoveClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveClassServlet() {
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
		Clases clases = new Clases();
		clases.setClassID(request.getParameter("classID"));
		int userName = Integer.parseInt(request.getParameter("userName"));
		
		IClassServices services = new ClassesServices();
		//remove class
		services.removeClass(clases.getClassID());
		String className = request.getParameter("className");
		
		//remove all register records in the class
		IRegisterServices registerServices = new RegisterServices();
		registerServices.removeClassesRegisterRecords(className);
		
		//update teacher class Name to None
		services.setClassName(userName, "None");
		
		IMarkServices iMarkServices = new MarkServices();
		
		//remove all students marks in the class
		List<Student> list1 = services.getInsertedStudentList(className);
		Iterator<Student> it_list1 = list1.iterator();
		while (it_list1.hasNext()) {
			Student student= new Student();
			student = it_list1.next();
			iMarkServices.dropStudentMark(student.getStudentID());
			
		}
	
		//remove students from the class
		services.removeStudentsFromClass(className);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/teacher/CreateClass.jsp");
		dispatcher.forward(request, response);
	}

}
