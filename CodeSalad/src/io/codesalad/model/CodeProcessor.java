package io.codesalad.model;

import java.util.ArrayList;


import java.io.*;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.ExecuteWatchdog;

public class CodeProcessor {
	
	public String uAccName;
	

	

	public CodeProcessor() {
		// TODO Auto-generated constructor stub
	}
	
	public String[] getConfig()
	{
		String[] data = new String[20];
		try {
			
			BufferedReader bRead = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("Configuration.txt")));
			String in;
			int counter = 0;
			while ((in = bRead.readLine()) != null) {
				
				data[counter] += in;
				counter++;
				

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return data;
	}

	public int runCodeJava(String Rawcode, String uname, String pid, String lang) throws ExecuteException, IOException {

		int status = 1;
		String fileAddress = "/home/gaurav/CodeSalad/Users/" + uname + "/" + pid + "." + lang;

		String script = "#!/bin/bash  \n" + "javac -Xstdout " + "/home/gaurav/CodeSalad/Users/" + uname + "/" + pid
				+ "error.txt " + fileAddress;

		Scriptinator newScript = new Scriptinator(script, uname+"RunjavaCode"); // new
																			// script
																			// name-RunJavaCode
																			// created

		String line = "/home/gaurav/CodeSalad/Scripts/"+uname+"RunjavaCode.sh "; // run
																		// script
		CommandLine command = CommandLine.parse(line);
		DefaultExecutor executor = new DefaultExecutor();
		ExecuteWatchdog watchdog = new ExecuteWatchdog(5000);
		executor.setWatchdog(watchdog);
		try {
			status = executor.execute(command);
		} catch (Exception e) {
			status =101; //Compiling error

			return status;
		}

		return status;
	}
	
	
	public  int runCodeC(String Rawcode, String uname, String pid, String lang) throws ExecuteException, IOException {

		int status = 1;
		String fileAddress = "/home/gaurav/CodeSalad/Users/" + uname + "/" + pid + "." + lang;

		String script = "#!/bin/bash  \n" + "(cd /home/gaurav/CodeSalad/Users/" + uname + "/ && gcc " + fileAddress+" 2> /home/gaurav/CodeSalad/Users/"+uname+"/"+pid+"error.txt )";
		

		Scriptinator newScript = new Scriptinator(script, uname+"RunCCode"); // new
																			// script
																			// name-RunJavaCode
																			// created

		String line = "/home/gaurav/CodeSalad/Scripts/"+uname+"RunCCode.sh "; // run
																		// script
		CommandLine command = CommandLine.parse(line);
		DefaultExecutor executor = new DefaultExecutor();
		ExecuteWatchdog watchdog = new ExecuteWatchdog(5000);
		executor.setWatchdog(watchdog);
		try {
			status = executor.execute(command);
		} catch (Exception e) {
			
			status =101; //Compiling error
			return status;
		}

		return status;
	}
	
	public  int runCodeCpp(String Rawcode, String uname, String pid, String lang) throws ExecuteException, IOException {

		int status = 1;
		String fileAddress = "/home/gaurav/CodeSalad/Users/" + uname + "/" + pid + "." + lang;

		String script = "#!/bin/bash  \n" + "(cd /home/gaurav/CodeSalad/Users/" + uname + "/ && g++ " + fileAddress+" 2> /home/gaurav/CodeSalad/Users/"+uname+"/"+pid+"error.txt )";
	

		Scriptinator newScript = new Scriptinator(script, uname+"RunCCode"); // new
																			// script
																			// name-RunJavaCode
																			// created

		String line = "/home/gaurav/CodeSalad/Scripts/"+uname+"RunCCode.sh "; // run
																		// script
		CommandLine command = CommandLine.parse(line);
		DefaultExecutor executor = new DefaultExecutor();
		ExecuteWatchdog watchdog = new ExecuteWatchdog(5000);
		executor.setWatchdog(watchdog);
		try {
			status = executor.execute(command);
		} catch (Exception e) {
			status =101; //Compiling error

			return status;
		}

		return status;
	}
	

	public int RunAndCompare(String pid, String uname, String lang) throws ExecuteException, IOException {
		int status = 1;
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
					temp1 += " ";
					track = i;
					break;
				}

			}
			for (int j = track + 1; j < values.length(); j++) {
				temp2 += values.charAt(j);
			}
			temp2 += "\n";

		}

		File testoutputs = new File("/home/gaurav/CodeSalad/Problems/" + pid + "/testoutputs.txt");
		testoutputs.createNewFile();
		FileWriter fWriter = new FileWriter(testoutputs);
		fWriter.write(temp2);
		fWriter.flush();
		fWriter.close();

		String address1 = "/home/gaurav/CodeSalad/Users/" + uname + "/output.txt";
		String address2 = "/home/gaurav/CodeSalad/Problems/" + pid + "/testoutputs.txt";
		String script="";

		switch (lang) {
		case "java":
		{
			 script = "#!/bin/bash \n echo " + temp1 + " | java -classpath /home/gaurav/CodeSalad/Users/" + uname
					+ " Main  > /home/gaurav/CodeSalad/Users/" + uname + "/output.txt";
			break;
		}
		
		case "c":
		{
			 script = "#!/bin/bash \n echo " + temp1 + " | (cd /home/gaurav/CodeSalad/Users/" + uname+" && exec /home/gaurav/CodeSalad/Users/"+uname+"/a.out > /home/gaurav/CodeSalad/Users/"+uname+"/output.txt)";
			
			break;
		}
		
		case "cpp":
			 script = "#!/bin/bash \n echo " + temp1 + " | (cd /home/gaurav/CodeSalad/Users/" + uname+" && exec /home/gaurav/CodeSalad/Users/"+uname+"/a.out > /home/gaurav/CodeSalad/Users/"+uname+"/output.txt)";

			break;

		}



		Scriptinator newScript = new Scriptinator(script, uname+"Compare");
		String line = "/home/gaurav/CodeSalad/Scripts/"+uname+"Compare.sh "; // run the
																	// script
		CommandLine cmdLine = CommandLine.parse(line);
		DefaultExecutor executor = new DefaultExecutor();
		ExecuteWatchdog watchdog = new ExecuteWatchdog(5000);
		executor.setWatchdog(watchdog);
		try {
			status = executor.execute(cmdLine);
		} catch (Exception e) {
			status =102; //Runtime error
			return status;
			
		}

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
			status = 103;  //Right Answer
		} else {
			status = 104; //Wrong Ans
		}

		return status;

	}

	public String errGen(String pid, String uname) throws IOException {
		File errorLog = new File("/home/gaurav/CodeSalad/Users/" + uname + "/" + pid + "error.txt");
		FileInputStream fIn = new FileInputStream(errorLog);
		BufferedReader bRead = new BufferedReader(new InputStreamReader(fIn));
		String values;
		String temp = "";
		while ((values = bRead.readLine()) != null) {
			temp = errParser(temp);
			temp += values + " <br>";

		}

		return temp;
	}
	
	public String errParser(String line)
	{
		
		int index =line.indexOf(":");
		if(index != -1)
		{
		
		line =line.substring(index+1);
		}

		return line;
		
	}
	
	
	
	
	public String getCode(String email,String pid, String lang) throws IOException
	{
		String code="";
		String address="/home/gaurav/CodeSalad/Users/" + email + "/" + pid + "."+lang;
		File f1 = new File(address);
		FileInputStream fIn1 = new FileInputStream(f1);
		BufferedReader bRead1 = new BufferedReader(new InputStreamReader(fIn1));
		String in;
		
		while ((in = bRead1.readLine()) != null) {
			code += in+"\n";
		}
		
		return code;
	}

	public static void main(String[] args) throws IOException {
		
		
		new CodeProcessor().getConfig();

	}
}
