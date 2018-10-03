package com.fdmgroup.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.print("inside the get method");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String uname= request.getParameter("username");
		String password= request.getParameter("password");
		
		if(uname.isEmpty() || password.isEmpty()){
			request.setAttribute("errorMsg","Userame and password is empty");
			RequestDispatcher rd= request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			
		}
		
		if(uname.equals("jdoe") || password.equals("1234")){
			request.setAttribute("errorMsg","Userame and password correct");
			RequestDispatcher rd= request.getRequestDispatcher("pages/dashboard.jsp");
			rd.forward(request, response);
			
		}
		
		else{
			request.setAttribute("errorMsg","Userame and password is wrong");
			RequestDispatcher rd= request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
