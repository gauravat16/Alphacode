package io.codesalad.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import io.codesalad.model.DatabaseManager;
import io.codesalad.model.DirectoryManager;
import io.codesalad.model.User;

/**
 * Servlet implementation class Competition
 */
@WebServlet("/Competition")
public class Competition extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Competition() {
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
		// TODO Auto-generated method stub
		doGet(request, response);
		HttpSession newSession = request.getSession(false);
		User newUser = (User) newSession.getAttribute("user");
		String compname = request.getParameter("compName");
		String info = request.getParameter("compInfo");

		DatabaseManager newDbjob = new DatabaseManager();
		String time = LocalDate.now().toString();
		String compId=null ;
		
		try {
			ResultSet rs = newDbjob.getDBConnection().executeQuery("SELECT max(compId) as id  FROM CodeSalad.Competitions");
			while (rs.next()) {
				compId = rs.getString("id");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int id = Integer.parseInt(compId);
		id++;
		compId=Integer.toString(id);
		new DirectoryManager().CompetitionFolder(compId); //create competiton folder
		String address = new DirectoryManager().saveProblem(compId, info);
		

		String query = "insert into CodeSalad.Competitions (`compName`,`compDate`,`compAuthor`,`CompFileLocation`) values ('"
				+ compname + "' ,  '" + time + " ' '" + "' , '" + newUser.email + "' , '"+address+"')";

		try {
			newDbjob.getDBConnection().execute(query);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

	}

}
