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
		User other = new User();
		String email = request.getParameter("email");
		String from = request.getParameter("from");

		String isFromOtherUser = request.getParameter("isFromOtherUser");
		DatabaseManager newDbJob = new DatabaseManager();
		HashMap<String, String> userDetails;
		String address="";
		ArrayList<Solution> list = new ArrayList<>();
		
		if(isFromOtherUser.equals("true"))
		{
			
			System.out.println("in this!");

			
			
			userDetails = newDbJob.getUserDetails(email);
			
			//getting problems solved
			list = newDbJob.getProblemsSolved(email);
			
			
			newUser.uname = userDetails.get("userName");
			newUser.email = userDetails.get("email");
			newUser.pic = userDetails.get("pic");
			
			newSession.setAttribute("isFromOtherUser", "true");
			newSession.setAttribute("from",from );
			newSession.setAttribute("probSolved", list);
			newSession.setAttribute("profile", newUser);
			
			userDetails = newDbJob.getUserDetails(from);
			other.uname = userDetails.get("userName");
			other.email = userDetails.get("email");
			other.pic = userDetails.get("pic");
			

			
			
			
			newSession.setAttribute("user", other);


			response.sendRedirect("/CodeSalad/Web/Profile.jsp");
			
			
		}
		else{
		
		
		
		userDetails = newDbJob.getUserDetails(newUser.email);
		
		//getting problems solved
		list = newDbJob.getProblemsSolved(newUser.email);
		System.out.println(newUser.email);
		
		newUser.uname = userDetails.get("userName");
		newUser.email = userDetails.get("email");
		newUser.pic = userDetails.get("pic");
		
		newSession.setAttribute("probSolved", list);
		newSession.setAttribute("profile", newUser);
		response.sendRedirect("/CodeSalad/Web/Profile.jsp");
		
		
		}
		
		
		
	
		
		

		

	

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
