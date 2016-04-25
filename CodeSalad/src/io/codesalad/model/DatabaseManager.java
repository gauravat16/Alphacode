package io.codesalad.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class DatabaseManager {

	public Statement getDBConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CodeSalad", "root", "raceison10");
		Statement stm = conn.createStatement();
		return stm;

	}

	public void addUser(String name, String password, String email, String progslist)
			throws ClassNotFoundException, SQLException {
		// adds user to database
		String query = "insert into CodeSalad.Users values ('" + name + "','" + password + "','" + email + "' )";
		System.out.println(query);
		this.getDBConnection().execute(query);

	}

	public String checkIfPresent(String email, String password) throws ClassNotFoundException, SQLException {
		// checks if user is present
		String query = " select exists( select * from CodeSalad.Users where email='" + email + "' and password='"
				+ password + "' ) as result ";
		ResultSet result = this.getDBConnection().executeQuery(query);
		String val = "";
		while (result.next()) {
			val = result.getString("result");
		}
		System.out.println(val);
		return val;

	}

	public void addProblem(String probname, String createdby, String CreatedOn, String[] langAllowed, String MaxTime,
			String MaxMemory) {
		// adds a problem to db
	}

	public void removeProblem(String pID) {
		// Remove a problem
	}

	public HashMap<String, String> getUserDetails(String email) throws ClassNotFoundException, SQLException {
		HashMap<String, String> userData = new HashMap<>();
		userData.put("email", email);
		ResultSet rs = this.getDBConnection().executeQuery("select * from CodeSalad.Users where email='" + email + "'");
		while (rs.next()) {
			userData.put("userName", rs.getString("userName"));
			userData.put("password", rs.getString("password"));
			userData.put("pic", rs.getString("pic"));

		}

		return userData;

	}

	public ArrayList<Solution> getProblemsSolved(String email) throws ClassNotFoundException, SQLException {
		String Query = "Select * from CodeSalad.Solutions where uname='" + email + "'";
		ArrayList<Solution> list = new ArrayList<>();
		ResultSet rs = new DatabaseManager().getDBConnection().executeQuery(Query);
		while (rs.next()) {
			Solution newSol = new Solution();
			newSol.probid = rs.getString("ProbId");
			newSol.status = rs.getString("Status");
			newSol.execTime = rs.getString("ExecTime");
			newSol.execMem = rs.getString("ExecMem");
			newSol.submittedOn = rs.getString("SubmittedOn");
			newSol.lang = rs.getString("LangUsed");
			newSol.uname = rs.getString("Uname");
			list.add(newSol);
		}

		return list;

	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String query = " select exists( select * from CodeSalad.Users where email='' and password='' )";
		System.out.println(query);

		// DatabaseManager obj = new DatabaseManager();
		// obj.checkIfPresent("fddf", "gauravsati19@gmail.com","raceison");

	}

}
