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

/**
 * Servlet implementation class JspPageManagerServlet
 */
@WebServlet("/JspPageManagerServlet")
public class JspPageManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JspPageManagerServlet() {
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
		
		/**
		 * in here many jsp link to one servlet and send responses to jsp pages
		 */
		
		String action = request.getParameter("action");
		
		if(action.equals("CC")) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/teacher/CreateClass.jsp");
			dispatcher.forward(request, response);
		}
		
		else if(action.equals("VC")) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/teacher/ShowClass.jsp");
			dispatcher.forward(request, response);
		}
		
		else if(action.equals("MR")) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/teacher/ClassStudentList.jsp");
			dispatcher.forward(request, response);
		}
		
		else if(action.equals("VA")) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/teacher/RegisterPersentage.jsp");
			dispatcher.forward(request, response);
		}
		
		else if(action.equals("AM")) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/teacher/AddMarks.jsp");
			dispatcher.forward(request, response);
		}
		
		else if(action.equals("VM")) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/teacher/ShowMarks.jsp");
			dispatcher.forward(request, response);
		}
		
		else if(action.equals("MO")) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/teacher/ShowStudentPlace.jsp");
			dispatcher.forward(request, response);
		}
		
		else if(action.equals("UP")) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/teacher/UpdateProfile.jsp");
			dispatcher.forward(request, response);
		}
		
		else if(action.equals("AS")) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/teacher/FinalizeClass.jsp");
			dispatcher.forward(request, response);
		}
		
		else if(action.equals("SD")) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/teacher/ShowAllStudentSetails.jsp");
			dispatcher.forward(request, response);
		}
		
		else if(action.equals("ES")) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/teacher/EditStudentMarks.jsp");
			dispatcher.forward(request, response);
		}
		
		else if(action.equals("UA")) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/teacher/UploadAssignment.jsp");
			dispatcher.forward(request, response);
		}
	}

}
