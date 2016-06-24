package io.codesalad.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import io.codesalad.model.CodeProcessor;
import io.codesalad.model.DatabaseManager;
import io.codesalad.model.DirectoryManager;
import io.codesalad.model.Problem;
import io.codesalad.model.User;

/**
 * Servlet implementation class RunMatchCode
 */
@WebServlet("/RunMatchCode")
public class RunMatchCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RunMatchCode() {
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
		
		HttpSession session = request.getSession(false);
		User newUser = (User) session.getAttribute("user");
		Problem newProblem = (Problem) session.getAttribute("problem");
		String pid = newProblem.pid;
		String Rawcode = request.getParameter("code");
		String lang = request.getParameter("lang");
		System.out.println("lang");
		//create files
		
		DirectoryManager newDirJob = new DirectoryManager();
		newDirJob.HtmlToCode(Rawcode, newUser.email, pid, lang);
		
		//Run and match the code
		DatabaseManager newDbJob = new DatabaseManager();
		String time = LocalDate.now().toString();
		String query;
		
		CodeProcessor newJob = new CodeProcessor();
		//System.out.println(newUser.email);
		int status=1;
		switch(lang)
		{
		case "java":
			
		{
			status = newJob.runCodeJava(Rawcode, newUser.email, pid, lang);
			
			break;
		}
		
		case "c":
		{
			status = newJob.runCodeC(Rawcode, newUser.email, pid, lang);
			break;
		}
		
		case "cpp":
		{
			status = newJob.runCodeCpp(Rawcode, newUser.email, pid, lang);
			break;
		}
		
		
		}
		try{
		
		if(status==101)
		{
			query  ="insert into CodeSalad.Solutions values ('"+newUser.email+"','"+pid+"','CE','','','"+time+"','"+lang+"')";
			
			
			
			Connection conn = null;
			Statement stm = null;
			ResultSet rs = null;

			try {
				conn = new DatabaseManager().getDBConnection();
				stm = conn.createStatement();
				stm.execute(query);

				

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
			
			
			

			String error = newJob.errGen(pid, newUser.email);
			session.setAttribute("msg", error);
			session.setAttribute("status", status);

			response.sendRedirect("/CodeSalad/Web/Result.jsp");
		}
		else {
			status =newJob.RunAndCompare(pid, newUser.email,lang);

		}
		System.out.println(status);
		
		switch(status)
		{
		case 102:
		{
			query  ="insert into CodeSalad.Solutions values ('"+newUser.email+"','"+pid+"','RE','','','"+time+"','"+lang+"')";
			
			
			
			
			Connection conn = null;
			Statement stm = null;
			ResultSet rs = null;

			try {
				conn = new DatabaseManager().getDBConnection();
				stm = conn.createStatement();
				stm.execute(query);

				

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
			
			
			
			
			String error = "Runtime Error";
			session.setAttribute("status", status);

			session.setAttribute("msg", error);
			response.sendRedirect("/CodeSalad/Web/Result.jsp");
			break;
		}
		case 103:
			
		{
			query  ="insert into CodeSalad.Solutions values ('"+newUser.email+"','"+pid+"','CA','','','"+time+"','"+lang+"')";
		
			
			Connection conn = null;
			Statement stm = null;
			ResultSet rs = null;

			try {
				conn = new DatabaseManager().getDBConnection();
				stm = conn.createStatement();
				stm.execute(query);

				

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
			
			
			
			
			
			session.setAttribute("status", status);

			session.setAttribute("msg", "Correct answer!");
			response.sendRedirect("/CodeSalad/Web/Result.jsp");
			break;
		}
		
		case 104:
		{
			query  ="insert into CodeSalad.Solutions values ('"+newUser.email+"','"+pid+"','WA','','','"+time+"','"+lang+"')";
			
			Connection conn = null;
			Statement stm = null;
			ResultSet rs = null;

			try {
				conn = new DatabaseManager().getDBConnection();
				stm = conn.createStatement();
				stm.execute(query);

				

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
			
			
			
			
			session.setAttribute("msg", "Wrong answer!");
			session.setAttribute("status", status);

			response.sendRedirect("/CodeSalad/Web/Result.jsp");
			break;
		}
	
		
		
		
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		
	
		
		
	}

}
