package com.cs490.forms;

public class courseRepeatForm extends form{
	private int formId = 0;
	private String courseToRepeat = "";
	private String termTaken = "";
	private String gradeEarned = "";
	private String termToRepeat = "";
	
	//Default Constructor
	public courseRepeatForm(){
		formId = super.getFormId();
		courseToRepeat = "None Yet";
		termTaken = "None Yet";
		gradeEarned = "None Yet";
		termToRepeat = "None Yet";
	}
	
	public courseRepeatForm(String aCourseToRepeat, String aTermTaken, String aGradeEarned, String aTermToRepeat){
		formId = super.getFormId();
		courseToRepeat = aCourseToRepeat;
		termTaken = aTermTaken;
		gradeEarned = aGradeEarned;
		termToRepeat = aTermToRepeat;	
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
	
	//Also include a toString that creates a String representation
	public String toString(){
		String text = "";
		text += "form Id: "+this.formId+" "+this.courseToRepeat+" "+this.termTaken+" "+this.gradeEarned+" "+this.termToRepeat;
		return text;
	}
}//End Class	
	