package com.cs490.forms;

public class form{
	protected int formId = 0;
	
	public form(){
		this.formId = 0;
	}
	//Get
	public int getFormId(){
		return this.formId;
	}
	//Set
	public void setFormId(int aId){
		this.formId = aId;
	}
	
	public String toString(){
		String text = "";
		text += "form Id: "+this.formId;
		return text;
	}
}//End Class