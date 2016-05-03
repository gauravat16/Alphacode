package io.codesalad.model;

import java.util.ArrayList;

public class Competition {
	
	
	String compName, compUsers, compDate, compAuthor, CompFileLocation, CompPId , compText,CompCreation,CompDuration,compId;
	ArrayList<String> userList , probList;

	public String getCompName()
	{
		return compName;
	}
	
	public String getCompUsers()
	{
		return compUsers;
	}
	
	public String getCompDate()
	{
		return compDate;
	}
	
	public String getCompAuthor()
	{
		return compAuthor;
	}
	
	public String getCompFileLocation()
	{
		return CompFileLocation;
	}
	
	public String getCompPId()
	{
		return CompPId;
	}
	
	public String getCompText()
	{
		return compText;
	}

	public String getCompCreation()
	{
		return CompCreation;
	}
	
	public ArrayList<String> getUserList()
	{
		return userList ;
	}
	
	public ArrayList<String> getProbList()
	{
		return probList ;
	}
	
	public String getCompDuration()
	{
		return CompDuration;
	}
	
	public String getCompId()
	{
		return compId;
	}
	
}
