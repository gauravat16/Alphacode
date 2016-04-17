package io.codesalad.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.codesalad.model.Problem;
import io.codesalad.model.ProblemProcessor;

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
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String pid = (String) request.getAttribute("pid");
		
		
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
				request.setAttribute("problem", newProb);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/Web/problem.jsp");
				rd.forward(request, response);
		
	}

}
