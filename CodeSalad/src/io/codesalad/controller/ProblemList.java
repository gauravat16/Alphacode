package io.codesalad.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.codesalad.model.DatabaseManager;
import io.codesalad.model.Problem;
import io.codesalad.model.User;

/**
 * Servlet implementation class Problems
 */
@WebServlet("/ProblemList")
public class ProblemList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProblemList() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String userMail = request.getParameter("userMail");
		String difficulty = request.getParameter("difficulty");
		String totitle = "";
		String isFromUser = request.getParameter("isFromUser");
		Problem newProblem = new Problem();
		ArrayList<Problem> ProblemObjs = new ArrayList<>();
		HashMap<String, String> uDetails = new HashMap<>();

		if (isFromUser.equals("true")) {
			
				

			Connection conn = null;
			Statement stm = null;
			ResultSet rs = null;

			try {
				conn = new DatabaseManager().getDBConnection();
				stm = conn.createStatement();

				rs = stm.executeQuery("Select * from CodeSalad.Problems where CreatedBy = '" + userMail + "'");
				while (rs.next()) {
					newProblem = new Problem();

					newProblem.difficulty = "Beginner";
					newProblem.pid = rs.getString("ProbId");
					newProblem.problemName = rs.getString("Pname");
					newProblem.author = rs.getString("CreatedBy");
					newProblem.createdOn = rs.getString("CreatedOn");
					ProblemObjs.add(newProblem);
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
			

		} else {
			try {

				switch (difficulty) {
				case "B":
					totitle = "Beginner";

					Connection conn = null;
					Statement stm = null;
					ResultSet rs = null;

					try {
						conn = new DatabaseManager().getDBConnection();
						stm = conn.createStatement();
						rs = stm.executeQuery("Select * from CodeSalad.Problems where Difficulty = 'B'");
						while (rs.next()) {
							newProblem = new Problem();

							newProblem.difficulty = "Beginner";
							newProblem.pid = rs.getString("ProbId");
							newProblem.problemName = rs.getString("Pname");
							newProblem.authEmail = rs.getString("CreatedBy");
							uDetails = new DatabaseManager().getUserDetails(newProblem.authEmail);
							newProblem.author = uDetails.get("userName");

							newProblem.createdOn = rs.getString("CreatedOn");
							ProblemObjs.add(newProblem);

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

					break;

				case "E":
					totitle = "Easy";

					
					
					
					Connection conn1 = null;
					Statement stm1 = null;
					ResultSet rs1 = null;

					try {
						conn1 = new DatabaseManager().getDBConnection();
						stm1 = conn1.createStatement();
						
						rs =stm1.executeQuery("Select * from CodeSalad.Problems where Difficulty = 'E'");
						while (rs.next()) {
							newProblem = new Problem();
							newProblem.difficulty = "Easy";
							newProblem.pid = rs.getString("ProbId");
							newProblem.problemName = rs.getString("Pname");
							newProblem.authEmail = rs.getString("CreatedBy");
							uDetails = new DatabaseManager().getUserDetails(newProblem.authEmail);
							newProblem.author = uDetails.get("userName");
							newProblem.createdOn = rs.getString("CreatedOn");

							ProblemObjs.add(newProblem);

						}
						

						

					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {

						try {
							rs1.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						try {
							stm1.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							conn1.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
					

					break;

				case "M":
					totitle = "Medium";

					
					
					Connection conn11 = null;
					Statement stm11 = null;
					ResultSet rs11 = null;

					try {
						conn11 = new DatabaseManager().getDBConnection();
						stm11 = conn11.createStatement();
						rs11 = stm11.executeQuery("Select * from CodeSalad.Problems where Difficulty = 'M'");
						while (rs11.next()) {
							newProblem = new Problem();
							newProblem.difficulty = "Medium";
							newProblem.pid = rs11.getString("ProbId");
							newProblem.problemName = rs11.getString("Pname");
							newProblem.authEmail = rs11.getString("CreatedBy");
							uDetails = new DatabaseManager().getUserDetails(newProblem.authEmail);
							newProblem.author = uDetails.get("userName");
							newProblem.createdOn = rs11.getString("CreatedOn");

							ProblemObjs.add(newProblem);

						}

						

					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {

						try {
							rs11.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						try {
							stm11.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							conn11.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
					
								
					
					
					
					break;

				case "H":

					totitle = "Hard";
					
					
					
					
					
					
					Connection conn111 = null;
					Statement stm111 = null;
					ResultSet rs111 = null;

					try {
						conn111 = new DatabaseManager().getDBConnection();
						stm111 = conn111.createStatement();
						rs = stm111.executeQuery("Select * from CodeSalad.Problems where Difficulty = 'H'");
						while (rs.next()) {
							newProblem = new Problem();
							newProblem.difficulty = "Hard";
							newProblem.pid = rs.getString("ProbId");
							newProblem.problemName = rs.getString("Pname");
							newProblem.authEmail = rs.getString("CreatedBy");
							uDetails = new DatabaseManager().getUserDetails(newProblem.authEmail);
							newProblem.author = uDetails.get("userName");
							newProblem.createdOn = rs.getString("CreatedOn");
							ProblemObjs.add(newProblem);

						}

						

					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {

						try {
							rs111.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						try {
							stm111.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							conn111.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
					
					
					
					
					
					
					break;

				default:
					break;
				}
			}

			catch (Exception e) {
				// TODO: handle exception
			}
		}

		request.setAttribute("PObjs", ProblemObjs);
		request.setAttribute("title", totitle);

		RequestDispatcher newDispatcher = getServletContext().getRequestDispatcher("/Web/Questions.jsp");
		newDispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

}
