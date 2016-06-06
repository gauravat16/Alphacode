package io.codesalad.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.mysql.jdbc.DatabaseMetaData;
import com.mysql.jdbc.ResultSet;

import io.codesalad.model.DatabaseManager;
import io.codesalad.model.User;

/**
 * Servlet implementation class LoginSignup
 */
// @WebServlet("/LoginSignup")
public class LoginSignup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginSignup() {
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

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Boolean result = false;

		DatabaseManager newTask = new DatabaseManager();

		if (newTask.checkIfPresent(email, password).equals("1")) {
			result = true;
		}

		if (result == true) {
			DatabaseManager newobj = new DatabaseManager();
			HashMap<String, String> userValues = new HashMap<>();
			userValues = newobj.getUserDetails(email);
			User newUser = new User();
			newUser.uname = userValues.get("userName");
			newUser.email = email;
			newUser.pic = userValues.get("pic");

			HttpSession session = request.getSession();
			session.setAttribute("user", newUser);
			response.sendRedirect("/CodeSalad/Web/index.jsp");

		} else {
			
			request.setAttribute("isNotRegistered", "true");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/Web/LoginMain/loginmain.jsp");
			rd.forward(request, response);
			

		}

	}

}
