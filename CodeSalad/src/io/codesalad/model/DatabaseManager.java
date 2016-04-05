package io.codesalad.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
	
	public Statement getDBConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/CodeSalad", "root", "raceison10");
		Statement stm = conn.createStatement();
		return stm;
		
	}
	
	public void addUser(String uname, String fname,String lname,String password,String email )
	{
		//adds user to database
		
	}
		
	public boolean checkIfPresent(String uname,String email,String password) throws ClassNotFoundException, SQLException
	{
		//checks if user is present
		String query = " select exists( select * from CodeSalad.Users where email='"+email+"'and password='"+password +" ' )";
		ResultSet result = this.getDBConnection().executeQuery(query);
		Boolean val = result.next();
		System.out.println(val);
		return val;
		
	}
	
	public void addProblem(String probname,String createdby, String CreatedOn,String[] langAllowed,String MaxTime ,String MaxMemory)
	{
		//adds a problem to db
	}
	
	public void removeProblem(String pID)
	{
		//Remove a problem
	}
	
	
	

	
	

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		//DatabaseManager obj = new DatabaseManager();
		//obj.checkIfPresent("fddf", "gauravsati19@gmail.com","raceison");

	}

}
