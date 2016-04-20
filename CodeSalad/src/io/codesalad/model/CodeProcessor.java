package io.codesalad.model;

import java.util.ArrayList;
import java.io.*;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;

public class CodeProcessor {

	public CodeProcessor() {
		// TODO Auto-generated constructor stub
	}

	

public	int runCodeJava(String Rawcode, String uname, String pid, String lang) throws ExecuteException, IOException {

		int status=1;
		String fileAddress = "/home/gaurav/CodeSalad/Users/" + uname + "/" + pid + "." + lang;

		String script = "#!/bin/bash  \n" + "javac -Xstdout " +"/home/gaurav/CodeSalad/Users/"+uname+"/"+pid+"error.txt "+ fileAddress  ;
		
		Scriptinator newScript = new Scriptinator(script, "RunjavaCode"); // new
																			// script
																			// name-RunJavaCode
																			// created

		String line = "/home/gaurav/CodeSalad/Scripts/RunjavaCode.sh "; // run script
		CommandLine command = CommandLine.parse(line);
		DefaultExecutor executor = new DefaultExecutor();
		try {
			status = executor.execute(command);
		} catch (Exception e) {
			
			return status;
		}
	

		return status;
	}

	public int RunAndCompare(String pid, String uname) throws ExecuteException, IOException {
		int status = 0;
		ArrayList<String> list = new ArrayList<>();

		File testcases = new File("/home/gaurav/CodeSalad/Problems/" + pid + "/testcases.txt");
		FileInputStream fIn = new FileInputStream(testcases);
		BufferedReader bRead = new BufferedReader(new InputStreamReader(fIn));
		String values;
		String temp1 = "";
		String temp2 = "";
		int track = 0;
		while ((values = bRead.readLine()) != null) {
			for (int i = 0; i < values.length(); i++) {
				if (values.charAt(i) != '|') {
					temp1 += values.charAt(i);

				}
				if (values.charAt(i) == '|') {
					track = i;
					break;
				}

			}
			for (int j = track + 1; j < values.length(); j++) {
				temp2 += values.charAt(j);
			}

		}

		File testoutputs = new File("/home/gaurav/CodeSalad/Problems/" + pid + "/testoutputs.txt");
		testoutputs.createNewFile();
		FileWriter fWriter = new FileWriter(testoutputs);
		fWriter.write(temp2);
		fWriter.flush();
		fWriter.close();
		
		

		String address1 = "/home/gaurav/CodeSalad/Users/" + uname + "/output.txt";
		String address2 = "/home/gaurav/CodeSalad/Problems/" + pid + "/testoutputs.txt";

		String script = "#!/bin/bash \n echo " + temp1 + " | java -classpath /home/gaurav/CodeSalad/Users/" + uname + " Main  > /home/gaurav/CodeSalad/Users/" + uname
				+ "/output.txt";
		
		Scriptinator newScript = new Scriptinator(script, "Compare");
		String line = "/home/gaurav/CodeSalad/Scripts/Compare.sh "; // run the script
		CommandLine cmdLine = CommandLine.parse(line);
		DefaultExecutor executor = new DefaultExecutor();
		status = executor.execute(cmdLine);

		File f1 = new File(address1);
		File f2 = new File(address2);
		FileInputStream fIn1 = new FileInputStream(f1);
		BufferedReader bRead1 = new BufferedReader(new InputStreamReader(fIn1));
		String in;
		String F1 = "";
		String F2 = "";
		while ((in = bRead1.readLine()) != null) {
			F1 += in;
		}

		fIn = new FileInputStream(f2);
		bRead = new BufferedReader(new InputStreamReader(fIn));
		in = "";
		while ((in = bRead.readLine()) != null) {
			F2 += in;

		}

		if (F1.equals(F2)) {
			status = 1;
		}

		return status;

	}

	
}
