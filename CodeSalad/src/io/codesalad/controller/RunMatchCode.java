package io.codesalad.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import io.codesalad.model.CodeProcessor;
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
		
		//create files
		
		DirectoryManager newDirJob = new DirectoryManager();
		newDirJob.HtmlToCode(Rawcode, newUser.email, pid, lang);
		
		//Run and match the code
		
		CodeProcessor newJob = new CodeProcessor();
		//System.out.println(newUser.email);
		int status = newJob.runCodeJava(Rawcode, newUser.email, pid, lang);
		if(status==1)
		{
			System.out.println("error");
		}
	    newJob.RunAndCompare(pid, newUser.email);
		//System.out.println(status);
		
		
	}

}
