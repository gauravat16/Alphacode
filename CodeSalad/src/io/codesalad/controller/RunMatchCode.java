package io.codesalad.controller;

import java.io.IOException;
import java.sql.SQLException;
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
		
		
		//int status = newJob.runCodeJava(Rawcode, newUser.email, pid, lang);
		try{
		if(status==1)
		{
			query  ="insert into CodeSalad.Solutions values ('"+newUser.email+"','"+pid+"','CE','','','"+time+"','"+lang+"')";
			newDbJob.getDBConnection().execute(query);

			String error = newJob.errGen(pid, newUser.email);
			session.setAttribute("msg", error);
			
			response.sendRedirect("/CodeSalad/Web/Result.jsp");
		}
		
		else
		{
			status =newJob.RunAndCompare(pid, newUser.email,lang);
			if(status==1)
			{
				query  ="insert into CodeSalad.Solutions values ('"+newUser.email+"','"+pid+"','WA','','','"+time+"','"+lang+"')";
				newDbJob.getDBConnection().execute(query);
				
				String error = "Wrong Answer";
				session.setAttribute("msg", error);
				response.sendRedirect("/CodeSalad/Web/Result.jsp");
			}
			else
			{
				query  ="insert into CodeSalad.Solutions values ('"+newUser.email+"','"+pid+"','CA','','','"+time+"','"+lang+"')";
				newDbJob.getDBConnection().execute(query);
				
				session.setAttribute("msg", "Correct answer!");
				response.sendRedirect("/CodeSalad/Web/Result.jsp");
			}
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
	}

}
