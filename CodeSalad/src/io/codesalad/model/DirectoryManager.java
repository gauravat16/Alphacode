package io.codesalad.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;

public class DirectoryManager {

	public DirectoryManager() {
		// TODO Auto-generated constructor stub
	}

	public DirectoryManager(String FolderName, boolean mode) throws IOException {

		// add check for user existing or problem existing

		if (mode) {
			// run fn to create user folder
			UserFoler(FolderName);

		} else {
			// run fn to create Problem folder
			problemFolder(FolderName);
		}

	}

	int UserFoler(String FolderName) throws IOException {
		int status = 0;
		String script = "#!/bin/bash  \n" + "mkdir /home/gaurav/CodeSalad/Users/" + FolderName; // Script
																			// to
																			// make
																			// folder

		Scriptinator newScript = new Scriptinator(script, "UFolder");

		String line = "./Scripts/UFolder.sh "; // run the script
		CommandLine cmdLine = CommandLine.parse(line);
		DefaultExecutor executor = new DefaultExecutor();
		status = executor.execute(cmdLine);

		return status;
	}

	int problemFolder(String FolderName) throws IOException {
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

	public int HtmlToCode(String Rawcode, String uname, int pid, String lang) throws IOException {
		int status = 0;

		File newScript = new File("/home/gaurav/CodeSalad/Users/" + uname + "/" + pid + "." + lang);

		newScript.createNewFile();
		FileWriter Fwriter = new FileWriter(newScript);
		Fwriter.write(Rawcode);
		Fwriter.flush();
		Fwriter.close();

		return status;
	}

	int NewProblem(String ProblemText, String ProblemName, String uname, String DateTime, String[] languages) throws IOException {
		int status = 0;
		int pid=0; // get recent pid from database

		File newProblem = new File("/home/gaurav/CodeSalad/Problems/" + pid + "/" +ProblemName  + ".txt");

		newProblem.createNewFile();
		FileWriter Fwriter = new FileWriter(newProblem);
		Fwriter.write(ProblemText);
		Fwriter.flush();
		Fwriter.close();

		return status;
	}

	public static void main(String[] args) throws IOException {

		DirectoryManager obj = new DirectoryManager();
		//obj.problemFolder("hjfhg");
		obj.HtmlToCode("fgx", "lol", 4, "sf");

	}

}
