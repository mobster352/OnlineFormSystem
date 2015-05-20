package com.cs490;
import java.util.HashMap;
import java.util.Map;

public class RegistrationForm extends Form{
	private int formId = 0;
	private int schoolYear = 0;
	private String semester = "";
	private Map<String,String> courseList = new HashMap<String,String>();

	//Default Constructor
	public RegistrationForm(){
		formId = super.getFormId();
		this.schoolYear = 0;
		this.semester = "None Yet";
	}
	
	public RegistrationForm(int aSchoolYear, String aSemester){
		formId = super.getFormId();
		this.schoolYear = aSchoolYear;
		this.semester = aSemester;
	}
	
	//Gets
	public int getSchoolYear(){
		return this.schoolYear;
	}
	public String getSemester(){
		return this.semester;
	}
	
	//Sets
	public void setSchoolYearear(int aSchoolYear){
		this.schoolYear = aSchoolYear;
	}
	public void setSemester(String aSemester){
		this.semester = aSemester;
	}
	
	
	//Also include a toString that creates a String representation
	public String toString(){
		String text = "";
		text += "form Id: "+this.getFormId()+" "+this.schoolYear+" "+this.semester;
		return text;
	}

}//End Class