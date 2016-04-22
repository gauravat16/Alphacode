package io.codesalad.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import io.codesalad.model.DatabaseManager;
import io.codesalad.model.DirectoryManager;
import io.codesalad.model.Solution;
import io.codesalad.model.User;

/**
 * Servlet implementation class UserProfile
 */
@WebServlet("/UserProfile")
public class UserProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserProfile() {
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
		
		HttpSession newSession = request.getSession(false);
		User newUser = (User) newSession.getAttribute("user");
		DatabaseManager newDbJob = new DatabaseManager();
		HashMap<String, String> userDetails;
		String address="";
		ArrayList<Solution> list = new ArrayList<>();
		try {
			userDetails = newDbJob.getUserDetails(newUser.email);
			
			//getting problems solved
			list = newDbJob.getProblemsSolved(newUser.email);
			
			
			newUser.uname = userDetails.get("userName");
			newUser.email = userDetails.get("email");
			newUser.pic = userDetails.get("pic");
			System.out.println(newUser.pic);
			
			newSession.setAttribute("probSolved", list);
			newSession.setAttribute("user", newUser);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			
		
		
		
	
		
		

		response.sendRedirect("/CodeSalad/Web/Profile.jsp");

	

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		doGet(request, response);
		
		


	}
	}
