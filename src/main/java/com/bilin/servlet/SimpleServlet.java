package com.bilin.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SimpleServlet
 */
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SimpleServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("userName", null);
		response.getWriter().append("<html><head></head><body>")
		.append("You are now logged out. <br/>")
		.append("<hr/>")
		.append("<a href=\"/webapp\">Home</a>")
		.append("</body>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userName =  request.getParameter("txtname");
		String password =  request.getParameter("txtpass");
		if(authenticate(userName, password)){
		    session.setAttribute("userName", userName);
		    request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
		    request.setAttribute("errMsg", "Invalid Credentials!");
		    request.getRequestDispatcher("start.jsp").forward(request, response);
		}
		
	}

    private boolean authenticate(String userName, String password) {
        return !userName.isEmpty() && new StringBuffer(userName.toLowerCase()).reverse().toString().equals(password);
    }

}
