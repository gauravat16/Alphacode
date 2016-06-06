package io.codesalad.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

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
import io.codesalad.model.User;

/**
 * Servlet implementation class ViewCompetition
 */
@WebServlet("/ViewCompetition")
public class ViewCompetition extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCompetition() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String compId = request.getParameter("compId");
		String pid = request.getParameter("pid");
		HttpSession session = request.getSession(false);
		User Loginuser =(User) session.getAttribute("user");
		String msg = request.getParameter("msg");
		String enrolled = request.getParameter("enrolled");
		

		
		

	    Competition newComp= new Competition();
		try {
			newComp = new DatabaseManager().getCompetitionData(compId);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String[] pidArr = newComp.compId.split(",");
		ArrayList<Problem> plist = new ArrayList<>();
		for(String id:pidArr)
		{
			try {
				plist.add(new ProblemProcessor().getProblemData(id));
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//System.out.println(newComp.compAuthor);
		String alreadyEnrolled = "0";
		if(newComp.userList!=null)
		{
		System.out.println("ads");
		
		for(String id:newComp.userList)
		{
			
			if(id.equals(Loginuser.email))
			{
				alreadyEnrolled="1";
			}
		}}
		
		System.out.println(alreadyEnrolled);
		request.setAttribute("comp", newComp);
		request.setAttribute("ulist", newComp.userList);
		request.setAttribute("enrolled", alreadyEnrolled);
		request.setAttribute("msg", msg);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/Web/ViewCompetition.jsp");
		rd.forward(request, response);
		
				
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		
	}

}
