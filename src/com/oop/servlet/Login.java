
package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sis.model.StaffMember;
import com.sis.model.Teacher;

import com.oop.util.CommonFunctions;

/**
 * Servlet implementation class studentLogin
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
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

		String un = request.getParameter("username");
		String pwd = request.getParameter("password");

		HttpSession session = request.getSession();

		CommonFunctions commonFunctions = new CommonFunctions();

		char TFL = 'T';
		char TSL = 'E';
		char SMFL = 'S';
		char SMSL = 'M';

		if (TFL == un.charAt(0) && TSL == un.charAt(1)) {

			Teacher teacher = commonFunctions.TeacherLogin(un, pwd);

			if (teacher.getOwnClass().equals("None")) {

				response.setContentType("text/html");
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/WEB-INF/views/teacher/CreateClass.jsp");
				session.setAttribute("User", teacher);
				dispatcher.forward(request, response);

			}
			
			if (teacher.getOwnClass().equals("None")) {

				response.setContentType("text/html");
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/WEB-INF/views/teacher/CreateClass.jsp");
				session.setAttribute("User", teacher);
				dispatcher.forward(request, response);

			}
			
			if (!teacher.getOwnClass().equals("None")) {

				response.setContentType("text/html");
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/WEB-INF/views/teacher/ShowClass.jsp");
				session.setAttribute("User", teacher);
				dispatcher.forward(request, response);

			}

			else {
				response.setContentType("text/html");
				request.setAttribute("Error", "E");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
				dispatcher.forward(request, response);
			}

		}
		
		
		else if(SMFL == un.charAt(0) && SMSL == un.charAt(1)) {
			
			StaffMember staffMember = commonFunctions.StaffLogin(un, pwd);
			
			if(staffMember != null) {
				response.setContentType("text/html");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/staff_member/index.jsp");
				dispatcher.forward(request, response);
				session.setAttribute("User", staffMember);
			}
			
			else {
				response.setContentType("text/html");
				request.setAttribute("Error", "E");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
				dispatcher.forward(request, response);
			}
		}
		
		
		
		
	}
}