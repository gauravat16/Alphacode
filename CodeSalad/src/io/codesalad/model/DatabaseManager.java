package io.codesalad.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class DatabaseManager {

	public Connection getDBConnection() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		String URL = "postgres://siscyzfttbwxtu:44b702ffba4b04ab2ea70083eecb24332e8fb42756ffdca3cca608673357a27f@ec2-50-17-217-166.compute-1.amazonaws.com:5432/d686i75644sj3s";
		Connection conn = DriverManager.getConnection("jdbc:postgresql://ec2-50-17-217-166.compute-1.amazonaws.com:5432/d686i75644sj3s", new CodeProcessor().getConfig()[1], new CodeProcessor().getConfig()[2]);
		
		return conn;

	}

	public void addUser(String name, String password, String email, String progslist) {
		// adds user to database
		String query = "insert into \"Users\" values ('" + name + "','" + password + "','" + email
				+ "' , '/CodeSalad/Web/images/nopic.png' )";
		Connection conn = null;
		Statement stm = null;

		try {
			conn = getDBConnection();
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

	}

	public String checkIfPresent(String email, String password) {
		// checks if user is present
		String query = " select exists( select * from \"Users\" where email='" + email + "' and password='"
				+ password + "' ) as result ";

		String val = "";

		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;

		try {
			conn = getDBConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery(query);
			while (rs.next()) {
				val = rs.getString("result");
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

		return val;

	}

	public void addProblem(String probname, String createdby, String CreatedOn, String[] langAllowed, String MaxTime,
			String MaxMemory) {
		// adds a problem to db
	}

	public void removeProblem(String pID) {
		// Remove a problem
	}

	public HashMap<String, String> getUserDetails(String email) {
		HashMap<String, String> userData = new HashMap<>();
		userData.put("email", email);

		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;

		try {
			conn = getDBConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery("select * from \"Users\" where \"Users\".\"email\"='" + email + "'");
			while (rs.next()) {
				userData.put("userName", rs.getString("userName"));
				userData.put("password", rs.getString("password"));
				userData.put("pic", rs.getString("pic"));

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

		return userData;

	}

	public User getUserDetailsObj(String email) throws ClassNotFoundException, SQLException {

		User user = new User();

		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;

		try {
			conn = getDBConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery("select * from \"Users\" where email='" + email + "'");
			while (rs.next()) {

				user.email = rs.getString("userName");
				user.password = rs.getString("password");
				user.pic = rs.getString("pic");

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

		return user;

	}

	public ArrayList<Solution> getProblemsSolved(String email) throws IOException {

		ArrayList<Solution> list = new ArrayList<>();

		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;

		try {
			conn = getDBConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery("Select * from \"Solutions\" where \"Solutions\".\"Uname\"='" + email + "'");
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

		return list;

	}

	public Competition getCompetitionData(String compId) throws ClassNotFoundException, SQLException, IOException {
		Competition newComp = new Competition();
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;

		try {
			conn = getDBConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery("Select * from \"Competitions\" where compId = '" + compId + "'");
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
				System.out.println(newComp.compUsers);

				if (newComp.compUsers != null) {

					String[] user = newComp.compUsers.split(",");

					ArrayList<String> userList = new ArrayList<>();

					for (String u : user) {
						userList.add(u);
						System.out.println(u);

					}

					newComp.userList = userList;

				}
				if (newComp.CompPId != null) {
					String[] prob = newComp.CompPId.split(",");
					ArrayList<String> probList = new ArrayList<>();
					for (String p : prob)

					{
						probList.add(p);
						// newComp.probList.add(p);

					}

					newComp.probList = probList;

				}

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

		File readComp = new File(new CodeProcessor().getConfig()[0]+"/CodeSalad/Competitions/" + compId + "/info.txt");
		
		FileInputStream in = new FileInputStream(readComp);
		BufferedReader bRead = new BufferedReader(new InputStreamReader(in));
		String data = "";
		StringBuffer stringBuffer = new StringBuffer();

		while ((data = bRead.readLine()) != null) {
			stringBuffer.append(data).append("<br>");

		}
		// System.out.println(stringBuffer);

		newComp.compText = stringBuffer.toString();

		return newComp;

	}

	public String getCompetitionText(String compId) throws IOException {
		File readComp = new File(new CodeProcessor().getConfig()[0]+"/CodeSalad/Competitions/" + compId + "/info.txt");
		
		FileInputStream in = new FileInputStream(readComp);
		BufferedReader bRead = new BufferedReader(new InputStreamReader(in));
		String data = "";
		String inp = "";
		while ((inp = bRead.readLine()) != null) {
			data += inp + "<br>";

		}

		return data;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		String query = "insert into \"Problems\" (Pname,CreatedBy,CreatedOn,MaxTime,MaxMemory,Difficulty,FromComp) values ('"
				+ "pname" + "' ,  '" + "user.email" +"' , '" + "time" + "' , ' ' , ' ' , '" + "plevel" + "' , 0"
				+ " )";
		System.out.println( query );

	}

}
