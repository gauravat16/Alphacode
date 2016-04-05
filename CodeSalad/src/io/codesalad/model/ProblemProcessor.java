package io.codesalad.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ProblemProcessor {

	public ProblemProcessor() {
		// TODO Auto-generated constructor stub
	}

	public ProblemProcessor(String ProblemText, int pid) {

	}

	static void saveProblem(String ProblemText, int pid, String Testcases) throws IOException {
		File newProblem = new File("/home/gaurav/CodeSalad/Problems/" + pid + "/problem.txt");
		newProblem.createNewFile();
		FileWriter fWriter = new FileWriter(newProblem);
		fWriter.write(ProblemText);
		fWriter.flush();

		newProblem = new File("/home/gaurav/CodeSalad/Problems/" + pid + "/testcases.txt");
		newProblem.createNewFile();
		fWriter = new FileWriter(newProblem);
		fWriter.write(Testcases);
		fWriter.flush();
		

		fWriter.close();

	}

	public static void main(String[] args) throws IOException {
		saveProblem("dfdsfsdfsdf", 44, "fyrfhtgh");

	}

}
