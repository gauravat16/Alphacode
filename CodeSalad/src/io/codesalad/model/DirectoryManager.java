package io.codesalad.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;

public class DirectoryManager {
	
	private String user = new CodeProcessor().getConfig()[0];

	public DirectoryManager() {
		// TODO Auto-generated constructor stub
	}

	public DirectoryManager(String FolderName, boolean mode) throws IOException {

		// add check for user existing or problem existing

		if (mode) {
			// run fn to create user folder
			UserFolder(FolderName);

		} else {
			// run fn to create Problem folder
			problemFolder(FolderName);
		}

	}

	public String UserFolder(String FolderName) throws IOException {

		
		String script = "#!/bin/bash  \n" + "mkdir /home/" + user + "/CodeSalad/Users/" + FolderName;

		File newFolder = new File( user + "/CodeSalad/Users/" + FolderName);
		File newProglist = new File( user + "/CodeSalad/Users/" + FolderName + "/proglist.txt");
		newFolder.mkdirs();
		newProglist.createNewFile();

		return  user + "/CodeSalad/Users/" + FolderName + "/proglist.txt";
	}
	
	public String CompetitionFolder(String compId) throws IOException {

		
		String script = "#!/bin/bash  \n" + "mkdir /home/" + user + "/CodeSalad/Competitions/" + compId;

		File newFolder = new File( user + "/CodeSalad/Competitions/" + compId);
		newFolder.mkdirs();
		

		return newFolder.getAbsolutePath();
	}

	public int problemFolder(String FolderName) throws IOException {
		int status = 0;
		String script = "#!/bin/bash  \n" + "mkdir Problems/" + FolderName; // Script
																			// to
																			// make
		Scriptinator newScript = new Scriptinator(script, "ProbFolder"); // folder

		String line = "./Scripts/ProbFolder.sh "; // run the script
		CommandLine cmdLine = CommandLine.parse(line);
		DefaultExecutor executor = new DefaultExecutor();
		status = executor.execute(cmdLine);

		return status;
	}

	public int HtmlToCode(String Rawcode, String uname, String pid, String lang) throws IOException {
		int status = 0;

		File newScript = new File(new CodeProcessor().getConfig()[0]+"/CodeSalad/Users/" + uname + "/" + pid + "." + lang);

		newScript.createNewFile();
		FileWriter Fwriter = new FileWriter(newScript);
		Fwriter.write(Rawcode);
		Fwriter.flush();
		Fwriter.close();

		return status;
	}
	
	public String saveProblem(String CompId, String info) throws IOException {

		File newScript = new File(new CodeProcessor().getConfig()[0]+"/CodeSalad/Competitions/" + CompId + "/" + "info.txt");

		newScript.createNewFile();
		FileWriter Fwriter = new FileWriter(newScript);
		Fwriter.write(info);
		Fwriter.flush();
		Fwriter.close();

		return newScript.getAbsolutePath();
	}

	int NewProblem(String ProblemText, String ProblemName, String uname, String DateTime, String[] languages)
			throws IOException {
		int status = 0;
		int pid = 0; // get recent pid from database

		File newProblem = new File(new CodeProcessor().getConfig()[0]+"/CodeSalad/Problems/" + pid + "/" + ProblemName + ".txt");

		newProblem.createNewFile();
		FileWriter Fwriter = new FileWriter(newProblem);
		Fwriter.write(ProblemText);
		Fwriter.flush();
		Fwriter.close();

		return status;
	}

	public static String getProfilePic(String uname, String picAddress) throws ExecuteException, IOException {
		// gets last 2 of the picture extension
		String last2 = Character.toString(picAddress.charAt(picAddress.length() - 2))
				+ Character.toString(picAddress.charAt(picAddress.length() - 1));
	
		String extension = "";
		switch (last2) {
		case "ng":
			extension = "png";
			break;
		case "eg":
			extension = "jpeg";
			break;

		}

		String line = "pwd";
		System.out.println(line);// run
																								// script
		CommandLine command = CommandLine.parse(line);
		DefaultExecutor executor = new DefaultExecutor();
		executor.execute(command);
		String sRootPath = new File("").getAbsolutePath();

		return "WebContent/Web/images/" + uname + "." + extension;
	}

	public void delete(String address) throws ExecuteException, IOException {
		String line = "rm"+address ; // run
		// script
		CommandLine command = CommandLine.parse(line);
		DefaultExecutor executor = new DefaultExecutor();
		executor.execute(command);
	}
	
	
	
	public static void main(String[] args) throws ExecuteException, IOException
	{
	}

}
