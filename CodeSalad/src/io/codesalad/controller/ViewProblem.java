package io.codesalad.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import io.codesalad.model.Competition;
import io.codesalad.model.DatabaseManager;
import io.codesalad.model.Problem;
import io.codesalad.model.ProblemProcessor;
import io.codesalad.model.Solution;

/**
 * Servlet implementation class ViewProblem
 */
@WebServlet("/ViewProblem")

public class ViewProblem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewProblem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
String pid = (String) request.getParameter("pid");
		
		
		//Sending a new page to view the problem
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
	//gets all the people who attempted that problem
				DatabaseManager newDbJob = new DatabaseManager();
				Solution newSol ;
				ArrayList<Solution> solList = new ArrayList<>();
				HashMap<String, String> userDetails;
				

				Connection conn = null;
				Statement stm = null;
				ResultSet rs = null;

				try {
					conn = new DatabaseManager().getDBConnection();
					stm = conn.createStatement();
					rs = stm.executeQuery("select * from \"Solutions\" where \"Solutions\".\"ProbId\" = '"+pid+"'");
					while(rs.next())
					{	
						newSol= new Solution();
						newSol.execMem = rs.getString("ExecMem");
						newSol.execTime = rs.getString("ExecTime");  
						newSol.lang = rs.getString("LangUsed");
						newSol.probid = rs.getString("ProbId");
						newSol.status = rs.getString("Status");
						newSol.submittedOn = rs.getString("SubmittedOn");
						newSol.email = rs.getString("Uname");
						userDetails=newDbJob.getUserDetails(rs.getString("Uname"));
						newSol.uname=userDetails.get("userName") ;
						solList.add(newSol);
					
					}

					

				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {

					try {
						rs.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					try {
						stm.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
				
				
				
				
				HttpSession newSession =request.getSession(false);
				newSession.setAttribute("problem", newProb);
				newSession.setAttribute("pCoders", solList);
				
				
				response.sendRedirect("/Web/problem.jsp");
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
