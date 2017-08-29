package io.codesalad.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.codesalad.model.Competition;
import io.codesalad.model.DatabaseManager;

/**
 * Servlet implementation class Enroll
 */
@WebServlet("/Enroll")
public class Enroll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Enroll() {
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
		
		String CompId = request.getParameter("compid");
		String uemail = request.getParameter("email");
		DatabaseManager newDBmanager = new DatabaseManager();
		
		
		Connection conn = null;
		Statement stm = null;
	

		try {
			conn = new DatabaseManager().getDBConnection();
			stm = conn.createStatement();
			
			stm.execute("update \"Competitions\" set compUsers=CONCAT(ifnull(compUsers,''),'"+uemail+",') where compId='"+CompId+"'");

			

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			

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
		
		
		
		
		request.setAttribute("msg", "See you at the finish line!");
		request.setAttribute("email", uemail);
		request.setAttribute("enrolled", "1");

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/ViewCompetition?compId="+CompId+"&email="+uemail);
		rd.forward(request, response);
		
		
		
		
		
		
	}

}
