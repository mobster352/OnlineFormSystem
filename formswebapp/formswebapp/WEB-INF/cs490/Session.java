package com.cs490;
public class Session{
	//Attributes 
	private int id= 0;
	private String SessionName = "";
	private String SessionPassword = "";

	//default constructor
	public Session(){
		id = 0;
		SessionName = "No name yet";
		SessionPassword = "No password yet";
	}
	
	public Session(int aId){
		this.id = aId;
	}
	
	public Session(int aId, String aName, String aPassword){
		id = aId;
		SessionName = aName;
		SessionPassword = aPassword;
	}

	public Session(String aName, String aPassword){
		this.id = 0;
		this.SessionName = aName;		
		this.SessionPassword = aPassword;
	}
	public int getId(){
		return id;
	}
	public String getSessionName(){
		return SessionName;
	}
	public String getSessionPassword(){
		return SessionPassword;
	}	
	public void setId(int aId){
		this.id = aId;

	}	
	public void setSessionName(String aName){
		this.SessionName = aName;
	}
	public void setSessionPassword(String aPassword){
		this.SessionPassword = aPassword;
	}
	
	//Also include a toString that creates a String representation	in the form id: name (category)	
	public String toString(){
		String text = "";
		text += "id: "+this.id+" "+this.SessionName+" , "+this.SessionPassword+" ";
		return text;
	}
}//end class