package com.cs490;

public class CourseRepeatForm{
	
	private String courseToRepeat = "";
	private String termTaken = "";
	private String gradeEarned = "";
	private String termToRepeat = "";
	private String formId ="";
	private String status ="";
	
	//Default Constructor
	public CourseRepeatForm(){
		
		courseToRepeat = "None Yet";
		termTaken = "None Yet";
		gradeEarned = "None Yet";
		termToRepeat = "None Yet";
		formId = "None Yet";
		status = "None yet";
	}
	
	public CourseRepeatForm(String aCourseToRepeat, String aTermTaken, String aGradeEarned, String aTermToRepeat, String aFormId, String aStatus){
		
		courseToRepeat = aCourseToRepeat;
		termTaken = aTermTaken;
		gradeEarned = aGradeEarned;
		termToRepeat = aTermToRepeat;	
		formId = aFormId;
		status = aStatus;
	}
	
	//Gets
	public String getCourseToRepeat(){
		return this.courseToRepeat;
	}
	public String getTermTaken(){
		return this.termTaken;
	}
	public String getGradeEarned(){
		return this.gradeEarned;
	}
	public String getTermToRepeat(){
		return this.termToRepeat;
	}
	public String getFormId(){
		return this.formId;
	}
	public String getStatus(){
		return this.status;
	}
	
	//Sets
	public void setCourseToRepeat(String aCourseToRepeat){
		this.courseToRepeat = aCourseToRepeat;
	}
	public void setTermTaken(String aTermTaken){
		this.termTaken = aTermTaken;
	}
	public void setGradeEarned(String aGradeEarned){
		this.gradeEarned = aGradeEarned;
	}
	public void setTermToRepeat(String aTermToRepeat){
		this.termToRepeat = aTermToRepeat;
	}
	public void setFormId(String aFormId){
		this.formId = aFormId;
	}
	public void setStatus(String aStatus){
		this.status = aStatus;
	}
	
	//Also include a toString that creates a String representation
	public String toString(){
		String text = "";
		text +=  this.courseToRepeat+" "+this.termTaken+" "+this.gradeEarned+" "+this.termToRepeat + " " + this.status + " " + this.formId;
		return text;
	}
}//End Class	
	