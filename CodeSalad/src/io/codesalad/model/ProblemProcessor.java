package io.codesalad.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProblemProcessor {

	public ProblemProcessor() {
		// TODO Auto-generated constructor stub
	}

	public ProblemProcessor(String ProblemText, int pid) {

	}

	public void saveProblem(String ProblemText, String pid, String Testcases) throws IOException {
		File probFolder = new File("/home/"+new CodeProcessor().getConfig()[0]+"/CodeSalad/Problems/" + pid + "/");
		probFolder.mkdirs();
		File newProblem = new File("/home/"+new CodeProcessor().getConfig()[0]+"/CodeSalad/Problems/" + pid + "/problem.txt");
		newProblem.createNewFile();
		FileWriter fWriter = new FileWriter(newProblem);
		fWriter.write(ProblemText);
		fWriter.flush();

		newProblem = new File("/home/"+new CodeProcessor().getConfig()[0]+"/CodeSalad/Problems/" + pid + "/testcases.txt");
		newProblem.createNewFile();
		fWriter = new FileWriter(newProblem);
		fWriter.write(Testcases);
		fWriter.flush();

		fWriter.close();

	}

	public Problem getProblemData(String pid) throws ClassNotFoundException, SQLException, IOException {
		Problem newProb = new Problem();
		DatabaseManager newDbJob = new DatabaseManager();
	
		
		
		
		

		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;

		try {
			conn = new DatabaseManager().getDBConnection();
			stm = conn.createStatement();
			
			
			String query = "Select * from CodeSalad.Problems where ProbId = '"+pid+"'";
			 rs = stm.executeQuery(query);
			while(rs.next())
			{
				newProb.pid=rs.getString("ProbId");
				newProb.problemName=rs.getString("Pname");
				newProb.author=rs.getString("CreatedBy");
				newProb.createdOn=rs.getString("CreatedOn");
				newProb.difficulty=rs.getString("Difficulty");
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				rs.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

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
		
		
		
		
		
		
		
		
		File readProb = new File("/home/"+new CodeProcessor().getConfig()[0]+"/CodeSalad/Problems/" + pid + "/problem.txt");
		//System.out.println("/home/gaurav/CodeSalad/Problems/" + pid + "/problem.txt");
		FileInputStream in = new FileInputStream(readProb);
		BufferedReader bRead = new BufferedReader(new InputStreamReader(in));
		String data ="";
		  StringBuffer stringBuffer = new StringBuffer();
		
		while((data =bRead.readLine())!=null)
		{
			stringBuffer.append(data).append("<br>");
			
		}
		//System.out.println(stringBuffer);
		
		newProb.problemText=stringBuffer.toString();

		return newProb;

	}

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		

	}

}
