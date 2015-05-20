package com.cs490.forms;

public class transcriptForm extends form{
	
	private int formId = 0;
	private int theSSN = 0;
	private String maidenName = "";
	private String whenToMail = "";
	private String firstTermAttended = "";
	private String lastTermAttended = "";
	private String mailToInfo = "";

	//Default Constructor
	public transcriptForm(){
		this.formId = super.getFormId();
		this.theSSN = 0;
		this.maidenName = "None Yet";
		this.whenToMail = "None Yet";
		this.firstTermAttended = "None Yet";
		this.lastTermAttended = "None yet";
		this.mailToInfo = "None Yet";
	}
	
	//Overloaded Constructor
	public transcriptForm(int aSSN, String aMaidenName, String aWhenToMail,String aFirst, String aLast, String aMailToInfo){
		this.formId = super.getFormId();
		this.theSSN = aSSN;
		this.maidenName = aMaidenName;
		this.whenToMail = aWhenToMail;
		this.firstTermAttended = aFirst;
		this.lastTermAttended = aLast;
		this.mailToInfo = aMailToInfo;
	}	
	
	//Gets
	public int getSSN(){
		return this.theSSN;
	}
	public String getMaidenName(){
		return this.maidenName;
	}
	public String getWhenToMail(){
		return this.whenToMail;
	}
	public String getFirstTermAttended(){
		return this.firstTermAttended;
	}
	public String getLastTermAttended(){
		return this.lastTermAttended;
	}
	public String getMailToInfo(){
		return this.mailToInfo;
	}
	
	//sets
	public void setSSN(int aSSN){
		this.theSSN = aSSN;
	}
	public void getMaidenName(String aMaiden){
		this.maidenName = aMaiden;
	}
	public void getWhenToMail(String aWhenToMail){
		this.whenToMail = aWhenToMail;
	}
	public void getFirstTermAttended(String aFirst){
		this.firstTermAttended = aFirst;
	}
	public void getLastTermAttended(String aLast){
		this.lastTermAttended = aLast;
	}
	public void getMailToInfo(String aMailToInfo){
		this.mailToInfo = aMailToInfo;
	}
	
	//Also include a toString that creates a String representation
	public String toString(){
		String text = "";
		text += "form Id: "+this.formId+" "+this.theSSN+" "+this.maidenName+" "+this.whenToMail+" "+this.firstTermAttended+" "+this.lastTermAttended+" "+this.mailToInfo;
		return text;
	}
	
	
	
}