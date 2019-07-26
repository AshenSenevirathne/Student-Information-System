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

import com.oop.service.IMarkServices;
import com.oop.service.MarkServices;
import com.sis.model.Marks;

/**
 * Servlet implementation class AddMarksServlet
 */
@WebServlet("/AddMarksServlet")
public class AddMarksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMarksServlet() {
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
		
		String studentId = request.getParameter("studentID");
		String subjectName[] =request.getParameterValues("subjectName");
		String marks[] = request.getParameterValues("subjectMark");
		IMarkServices markServices	= new MarkServices();
		
		//add marks
		for(int i = 0; i < subjectName.length; i++) {
			Marks mark = new Marks();
			mark.setSubjectName(subjectName[i]);
			mark.setMark(Float.parseFloat(marks[i]));
			mark.setStudentID(studentId);
			markServices.addMarks(mark);
			
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/teacher/AddMarks.jsp");
		dispatcher.forward(request, response);
 	}

}
