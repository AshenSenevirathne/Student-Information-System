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

import com.oop.service.AssignmentServices;
import com.oop.service.IAssignmentServices;
import com.sis.model.Assignments;

/**
 * Servlet implementation class AddAssignmentServlet
 */
@WebServlet("/AddAssignmentServlet")
public class AddAssignmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAssignmentServlet() {
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
		
		Assignments assignments = new Assignments();
		assignments.setAssignmentName(request.getParameter("assignmentName"));
		assignments.setSubID(request.getParameter("subID"));
		assignments.setDate(request.getParameter("deadline"));
		assignments.setAssignmentDescription(request.getParameter("description"));
		
		//add Assignments
		IAssignmentServices iAssignmentServices = new AssignmentServices();
		iAssignmentServices.addAssignment(assignments);
		System.out.println(assignments);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/teacher/ShowClass.jsp");
		dispatcher.forward(request, response);
	}

}
