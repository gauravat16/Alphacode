package io.codesalad.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
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

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String newComp = request.getParameter("newComp");
		Boolean isfromProb = (Boolean) request.getAttribute("isfromProb");
		String addProb = request.getParameter("addProb");
		String cid = request.getParameter("id");

		if (addProb.equals("true") && addProb != null) {
			request.setAttribute("isfromComp", "true");
			request.setAttribute("compId", cid);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/Web/NewProblem.jsp");
			rd.forward(request, response);

		}

		if (newComp.equals("true")) {
			HttpSession newSession = request.getSession(false);
			User newUser = (User) newSession.getAttribute("user");
			String compname = request.getParameter("compName");
			String info = request.getParameter("compInfo");
			String compOn = request.getParameter("compOn");
			String compDuration = request.getParameter("compDuration");

			DatabaseManager newDbjob = new DatabaseManager();
			Statement stm;
			String time = LocalDate.now().toString();
			String compId = null;

			try {
				stm = newDbjob.getDBConnection();
				ResultSet rs = stm.executeQuery("SELECT max(compId) as id  FROM CodeSalad.Competitions");
				while (rs.next()) {
					compId = rs.getString("id");
				}

				stm.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			int id = Integer.parseInt(compId);
			id++;
			compId = Integer.toString(id);
			new DirectoryManager().CompetitionFolder(compId); // create
																// competiton
																// folder
			String address = new DirectoryManager().saveProblem(compId, info);

			String query = "insert into CodeSalad.Competitions (`compName`,`compDate`,`compAuthor`,`CompFileLocation`,`CompCreation` , `CompDuration`) values ('"
					+ compname + "' ,  '" + compOn + " ' '" + "' , '" + newUser.email + "' , '" + address + "' ,'"
					+ time + "' , '" + compDuration + "')";

			try {

				stm = newDbjob.getDBConnection();
				newDbjob.getDBConnection().execute(query);
				stm.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			response.sendRedirect("/CodeSalad/ViewCompetition?compId=" + compId);

		}

	}

}
