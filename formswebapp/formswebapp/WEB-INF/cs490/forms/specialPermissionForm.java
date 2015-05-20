package com.cs490.forms;
import java.util.HashMap;
import java.util.Map;

public class specialPermissionForm extends form{
	private int formId = 0;
	private String schoolYear ="";
	private String semester = "";
	private Map<String, String> enrollmentList = new HashMap<String,String>();

	public specialPermissionForm(){
		this.formId = super.getFormId();
		this.schoolYear = "None Yet";
		this.semester = "None Yet";
	}
	
	public specialPermissionForm(String aYear, String aSemester){
		this.formId = super.getFormId();
		this.schoolYear = aYear;
		this.semester = aSemester;
	}
	
	//Gets
	public String getSchoolYear(){
		return this.schoolYear;
	}
	public String getSemester(){
		return this.semester;
	}
	
	//Sets
	public void setSchoolYear(String aYear){
		this.schoolYear = aYear;
	}
	public void setSemester(String aSemester){
		this.semester = aSemester;
	}
	
	public String toString(){
		String text = "";
		text += "form Id: "+this.formId+" "+this.schoolYear+" "+this.semester;
		return text;
	}
}//End Class