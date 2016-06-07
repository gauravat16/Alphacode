package io.codesalad.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;

public class Scriptinator {

	public Scriptinator() {

	}

	Scriptinator(String script ,String ScriptName) throws IOException {
		
			ScriptMaker(script, ScriptName);
	}
	
	int ScriptMaker(String script, String  ScriptName) throws IOException
	{
		int status =0;
		
		File newScript = new File("/home/"+new CodeProcessor().getConfig()[0]+"/CodeSalad/Scripts/"+ScriptName+".sh"); // Script file created
		newScript.createNewFile();
		FileWriter Fwriter = new FileWriter(newScript);
		Fwriter.write(script);
		Fwriter.flush();
		Fwriter.close();

		String line = "chmod -R u+x /home/"+new CodeProcessor().getConfig()[0]+"/CodeSalad/Scripts"; // Changing executable permissions
		CommandLine cmdLine = CommandLine.parse(line);
		DefaultExecutor executor = new DefaultExecutor();
		status = executor.execute(cmdLine);

		
		return status;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
