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

import com.oop.service.ISubjectsServices;
import com.oop.service.SubjectServices;
import com.sis.model.Subjects;



/**
 * Servlet implementation class EditSubjectServlet
 */
@WebServlet("/EditSubjectServlet")
public class EditSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditSubjectServlet() {
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
		Subjects subjects = new Subjects();
		String subjectID = request.getParameter("subID");
		subjects.setSubID(subjectID);
		subjects.setSubCode(request.getParameter("subCode"));
		subjects.setSubName(request.getParameter("subName"));
		subjects.setYear(Integer.parseInt(request.getParameter("year")));
		
		//edit subject details
		ISubjectsServices iSubjectsServices = new SubjectServices();
		iSubjectsServices.updateSubjectDetails(subjects, subjectID);
		
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/staff_member/SubjectList.jsp");
		dispatcher.forward(request, response);

	}

}
