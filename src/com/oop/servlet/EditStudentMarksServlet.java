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
 * Servlet implementation class EditStudentMarksServlet
 */
@WebServlet("/EditStudentMarksServlet")
public class EditStudentMarksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditStudentMarksServlet() {
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
		
		String markID[] =request.getParameterValues("markID");
		String marks[] = request.getParameterValues("subjectMark");
		IMarkServices markServices	= new MarkServices();
		
		//edit student mark
		for(int i = 0; i < markID.length; i++) {
			Marks mark = new Marks();
			mark.setMarkID(markID[i]);
			mark.setMark(Float.parseFloat(marks[i]));
			markServices.updateStudentMark(mark);
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/teacher/ShowMarks.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
