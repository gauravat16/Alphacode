package io.codesalad.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import io.codesalad.model.DatabaseManager;
import io.codesalad.model.User;



/**
 * Servlet implementation class EditProfile
 */
@WebServlet("/EditProfile")
@MultipartConfig
public class EditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProfile() {
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
		HttpSession newSession = request.getSession(false);
		User newUser = (User) newSession.getAttribute("user");
		Part filePart = request.getPart("pic"); 
		
		String fileName = filePart.getSubmittedFileName();
		System.out.println(fileName);
		String last2 = Character.toString(fileName.charAt(fileName.length() - 2))
				+ Character.toString(fileName.charAt(fileName.length() - 1));
		System.out.println(last2);
		String extension = "";
		switch (last2) {
		case "ng":
			extension = "png";
			break;
		case "eg":
			extension = "jpeg";
			break;
		case "pg":
			extension = "jpeg";
			break;	
		case "NG":
			extension = "png";
			break;
		case "EG":
			extension = "jpeg";
			break;
		case "PG":
			extension = "jpeg";
			break;

		}
		
		
	    InputStream fileContent = filePart.getInputStream();
	    File file = new File("/home/gaurav/CodeSalad/profile/"+newUser.email+"."+extension);

	    try (InputStream input = filePart.getInputStream()) {
	        Files.copy(input, file.toPath(),StandardCopyOption.REPLACE_EXISTING);
	    }
	    
	    DatabaseManager newDbJob = new DatabaseManager();
	    try {

			newDbJob.getDBConnection().execute("UPDATE CodeSalad.Users SET pic = '/profile/"+newUser.email+"."+extension+"' WHERE email = '"+newUser.email+"'");
			newUser.pic="/profile/"+newUser.email+"."+extension;
			newSession.setAttribute("edituser", newUser);
			response.sendRedirect("/CodeSalad/Web/Profile.jsp");
		
	    
	    
	    } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	




}
