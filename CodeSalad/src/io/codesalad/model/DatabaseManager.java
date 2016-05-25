package io.codesalad.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
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
		String query = "insert into CodeSalad.Users values ('" + name + "','" + password + "','" + email
				+ "' , '/CodeSalad/Web/images/nopic.png' )";
		System.out.println(query);
		Statement stm = getDBConnection();
		stm.execute(query);
		stm.close();

	}

	public String checkIfPresent(String email, String password) throws ClassNotFoundException, SQLException {
		// checks if user is present
		String query = " select exists( select * from CodeSalad.Users where email='" + email + "' and password='"
				+ password + "' ) as result ";

		Statement stm = this.getDBConnection();
		ResultSet result = stm.executeQuery(query);
		
		String val = "";
		while (result.next()) {
			val = result.getString("result");
		}
		stm.close();
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
		 
			Statement stm =	this.getDBConnection();
					ResultSet rs =	stm.executeQuery("select * from CodeSalad.Users where email='" + email + "'");
		while (rs.next()) {
			userData.put("userName", rs.getString("userName"));
			userData.put("password", rs.getString("password"));
			userData.put("pic", rs.getString("pic"));

		}
		stm.close();


		return userData;

	}

	public ArrayList<Solution> getProblemsSolved(String email)
			throws ClassNotFoundException, SQLException, IOException {
		String Query = "Select * from CodeSalad.Solutions where uname='" + email + "'";
		ArrayList<Solution> list = new ArrayList<>();
		
			Statement stm =	new DatabaseManager().getDBConnection();
			ResultSet rs =	stm.executeQuery(Query);
		while (rs.next()) {
			Problem newProb = new Problem();
			ProblemProcessor newPProc = new ProblemProcessor();

			Solution newSol = new Solution();
			newSol.probid = rs.getString("ProbId");
			newProb = newPProc.getProblemData(newSol.probid);
			newSol.problemName = newProb.problemName;
			newSol.status = rs.getString("Status");
			newSol.execTime = rs.getString("ExecTime");
			newSol.execMem = rs.getString("ExecMem");
			newSol.submittedOn = rs.getString("SubmittedOn");
			newSol.lang = rs.getString("LangUsed");
			newSol.uname = rs.getString("Uname");

			list.add(newSol);
		}
		stm.close();

		return list;

	}

	public Competition getCompetitionData(String compId) throws ClassNotFoundException, SQLException, IOException {
		Competition newComp = new Competition();
		DatabaseManager newDbJob = new DatabaseManager();

		String query = "Select * from CodeSalad.Competitions where compId = '" + compId + "'";
		 Statement stm = newDbJob.getDBConnection();
		 ResultSet rs =	stm.executeQuery(query);
		while (rs.next()) {
			newComp.CompPId = rs.getString("CompPId");
			newComp.compName = rs.getString("compName");
			newComp.compAuthor = rs.getString("compAuthor");
			newComp.CompCreation = rs.getString("CompCreation");
			newComp.compDate = rs.getString("compDate");
			newComp.CompFileLocation = rs.getString("CompFileLocation");
			newComp.compUsers = rs.getString("compUsers");
			newComp.CompDuration = rs.getString("CompDuration");
			newComp.compId = rs.getString("compId");

			if (newComp.compUsers != null && newComp.CompPId != null) {
				newComp.probList = (ArrayList<String>) Arrays.asList(newComp.CompPId.split(","));
				newComp.userList = (ArrayList<String>) Arrays.asList(newComp.compUsers.split(","));
			}

		}

		File readComp = new File("/home/gaurav/CodeSalad/Competitions/" + compId + "/info.txt");
		// System.out.println("/home/gaurav/CodeSalad/Problems/" + pid +
		// "/problem.txt");
		FileInputStream in = new FileInputStream(readComp);
		BufferedReader bRead = new BufferedReader(new InputStreamReader(in));
		String data = "";
		StringBuffer stringBuffer = new StringBuffer();

		while ((data = bRead.readLine()) != null) {
			stringBuffer.append(data).append("<br>");

		}
		// System.out.println(stringBuffer);

		newComp.compText = stringBuffer.toString();
		stm.close();

		return newComp;

	}
	
	public String getCompetitionText(String compId) throws IOException
	{
		File readComp = new File("/home/gaurav/CodeSalad/Competitions/" + compId + "/info.txt");
		// System.out.println("/home/gaurav/CodeSalad/Problems/" + pid +
		// "/problem.txt");
		FileInputStream in = new FileInputStream(readComp);
		BufferedReader bRead = new BufferedReader(new InputStreamReader(in));
		String data = "";
		String inp ="";
		StringBuffer stringBuffer = new StringBuffer();

		while ((inp= bRead.readLine()) != null) {
			data+=inp+"<br>";

		}
		
		return data;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub
	

		DatabaseManager obj = new DatabaseManager();
		
	}

}
