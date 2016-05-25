package io.codesalad.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import io.codesalad.model.DatabaseManager;
import io.codesalad.model.Problem;
import io.codesalad.model.ProblemProcessor;
import io.codesalad.model.User;

/**
 * Servlet implementation class NewProblem
 */
@WebServlet("/NewProblem")
public class NewProblem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewProblem() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String testCases = "";
		DatabaseManager newDb = new DatabaseManager();
		
		String pid = "";
		String plevel = "";
		String isfromComp = request.getParameter("isfromComp");
		String compId = request.getParameter("compId");
		try {
			Statement  stm1 = newDb.getDBConnection();
			ResultSet rs = stm1.executeQuery("SELECT max(ProbId) as id  FROM CodeSalad.Problems");
			while (rs.next()) {
				pid = rs.getString("id");
				
			}
			
			stm1.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int id = Integer.parseInt(pid);
		id++;
		pid = Integer.toString(id);
		// System.out.println(pid);

		for (int i = 1; i <= 14; i = i + 2) {
			if (request.getParameter(Integer.toString(i)) == null) {
				break;
			} else {
				testCases += request.getParameter(Integer.toString(i)) + "|"
						+ request.getParameter(Integer.toString(i + 1)) + "\n";
			}
		}

		String code = request.getParameter("code");
		String pname = request.getParameter("Pname");
		plevel = request.getParameter("level");
		User user = null;
		HttpSession session = request.getSession(false);
		user = (User) session.getAttribute("user");

		ProblemProcessor newProcessor = new ProblemProcessor();

		newProcessor.saveProblem(code, pid, testCases);

		DatabaseManager newDbjob = new DatabaseManager();
		

		String time = LocalDate.now().toString();
		Statement stm2;

		switch (isfromComp) {
		
		
		case "true":
			String query = "insert into CodeSalad.Problems (`Pname`,`CreatedBy`,`CreatedOn`,`MaxTime`,`MaxMemory`,`Difficulty`,`FromComp`) values ('"
					+ pname + "' ,  '" + user.email + " ' '" + "' , '" + time + "' , ' ' , ' ' , '" + plevel + "' , 1"
					+ " )";
			String query2 = "update CodeSalad.Competitions set CompPId=CONCAT(CompPId,'"+pid+",') where compId='"+compId+"'";

			try {
				
				stm2 = newDbjob.getDBConnection();
				stm2.execute(query);
				stm2.execute(query2);

				stm2.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;

		default:
			query = "insert into CodeSalad.Problems (`Pname`,`CreatedBy`,`CreatedOn`,`MaxTime`,`MaxMemory`,`Difficulty`,`FromComp`) values ('"
					+ pname + "' ,  '" + user.email + " ' '" + "' , '" + time + "' , ' ' , ' ' , '" + plevel + "' , 0"
					+ " )";

			try {
				stm2 = newDbjob.getDBConnection();
				stm2.execute(query);
				stm2.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		}

		// Sending a new page to view the problem
		ProblemProcessor newProbProc = new ProblemProcessor();
		Problem newProb = new Problem();
		try {
			newProb = newProbProc.getProblemData(pid);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (isfromComp.equals("true")) {


			response.sendRedirect("/CodeSalad/ViewCompetition?pid=" + pid + "&compId=" + compId);

		} else {
			response.sendRedirect("/CodeSalad/ViewProblem?pid=" + pid);
		}

	}

}
