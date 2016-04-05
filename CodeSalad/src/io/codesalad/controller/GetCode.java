package io.codesalad.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.codesalad.model.CodeProcessor;
import io.codesalad.model.DirectoryManager;

/**
 * Servlet implementation class GetCode
 */
@WebServlet("/GetCode")
public class GetCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCode() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String code = request.getParameter("code");
		String lang = request.getParameter("lang");
		//System.out.println(code);
		System.out.println(lang);
		//CodeProcessor newJob = new CodeProcessor(code,"lol",4,lang);
		DirectoryManager obj = new DirectoryManager();
		obj.HtmlToCode(code, "lol", 4, lang);
		
		
		
		
	}

}
