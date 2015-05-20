package com.cs490.forms;

public class courseSubForm extends form{
	private int formId = 0;
	private String catalogYear = "";
	private String substituteFor = "";
	private Boolean isMajor = false;

	public courseSubForm(){
		formId = super.getFormId();
		this.catalogYear = "None Yet";
		this.substituteFor = "None Yet";
		this.isMajor = false;
		
	}
	
	public courseSubForm(String aCatalog, String aSub, Boolean aMajor){
		formId = super.getFormId();
		this.catalogYear = aCatalog;
		this.substituteFor = aSub;
		this.isMajor = aMajor;
	}
	
	//Gets
	public String getCatalogYear(){
		return this.catalogYear;
	}
	public String getSubstituteFor(){
		return this.substituteFor;
	}
	public Boolean getIsMajorFor(){
		return this.isMajor;
	}
	
	//Sets
	public void setCatalogYear(String aCatalog){
		this.catalogYear = aCatalog;
	}
	public void setSubstituteFor(String aSub){
		this.substituteFor = aSub;
	}
	public void setIsMajor(Boolean aMajor){
		this.isMajor = aMajor;
	}
	
	//Also include a toString that creates a String representation
	public String toString(){
		String text = "";
		text += "form Id: "+this.formId+" "+this.catalogYear+" "+this.substituteFor+" "+this.isMajor;
		return text;
	}

}//End Class