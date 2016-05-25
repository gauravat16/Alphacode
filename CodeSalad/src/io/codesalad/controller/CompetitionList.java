package io.codesalad.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.codesalad.model.Competition;
import io.codesalad.model.DatabaseManager;
import io.codesalad.model.DirectoryManager;

/**
 * Servlet implementation class CompetitionList
 */
@WebServlet("/CompetitionList")
public class CompetitionList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompetitionList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String email = request.getParameter("email");
		ArrayList<Competition> complist = new ArrayList<>();
		try{
		switch (email) {
		case "header":
			DatabaseManager newDbjob = new DatabaseManager();
			Statement stm = newDbjob.getDBConnection();
			ResultSet competions = stm.executeQuery("select * from CodeSalad.Competitions"); 
			while(competions.next())
			{
				Competition newComp = new Competition();

				System.out.println("in header");
				newComp.CompPId = competions.getString("CompPId");
				System.out.println(newComp.CompPId);
				newComp.compId = competions.getString("compId"); 
				newComp.compName = competions.getString("compName");
				newComp.compDate=competions.getString("compDate");
				newComp.compAuthor=competions.getString("compAuthor");
				newComp.CompCreation=competions.getString("CompCreation");
				newComp.CompDuration=competions.getString("CompDuration");
				newComp.compText = newDbjob.getCompetitionText(newComp.compId);
				System.out.println(newComp.compName);
				complist.add(newComp);
						


				
			}
			stm.close();
			
			break;

		default:
			
			DatabaseManager newDbjob1 = new DatabaseManager();
			Statement stm1 = newDbjob1.getDBConnection();
			ResultSet competions1 = stm1.executeQuery("select * from CodeSalad.Competitions where CompAuthor='"+email+"'"); 
			while(competions1.next())
			{
				Competition newComp = new Competition();
				newComp.CompPId = competions1.getString("CompPId");
				newComp.compId = competions1.getString("compId");
				newComp.compName = competions1.getString("compName");
				newComp.compDate=competions1.getString("compDate");
				newComp.compAuthor=competions1.getString("compAuthor");
				newComp.CompCreation=competions1.getString("CompCreation");
				newComp.CompDuration=competions1.getString("CompDuration");
				newComp.compText = newDbjob1.getCompetitionText(newComp.compId);
				complist.add(newComp);




				
			}
			stm1.close();
			
			
			
			break;
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	for(Competition e: complist)
	{
		System.out.println(e.compAuthor);
	}
	request.setAttribute("competition", complist);
	request.setAttribute("title", "Competitions");
	RequestDispatcher rd = getServletContext().getRequestDispatcher("/Web/competitions.jsp");
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
