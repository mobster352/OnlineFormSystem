package com.cs490;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import java.util.Arrays;
import com.google.gson.Gson;

@Path("ws2")
public class FormsServices {
	
	/*
	Form[] list = new Form[100];
	Form[] list2 = new Form[1];
	Form[] list3 = new Form[1];
	
	@Path("/forms")
	@GET
	@Produces("text/plain")
	
	public String getForms() throws SQLException, ClassNotFoundException {

		int index = 0;
		String connectStr="jdbc:mysql://localhost:3306/formdb";
		String username="root";
		String password="csci330pass";
		String driver="com.mysql.jdbc.Driver";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(connectStr, username, password);
		
		String query = "SELECT * FROM forms";
		PreparedStatement pstmt = con.prepareStatement(query);
		
		ResultSet rs = pstmt.executeQuery();
		Gson theGsonObj = new Gson();
		String result = "";
		while (rs.next()){

			int theId = rs.getInt("id");
			String theName = rs.getString("name");
			String theSemester = rs.getString("semester");
			String theYear = rs.getString("year");
			Form formObject = new Form(theId,theName,theSemester,theYear);
			
			//Object to json object
			String jsonForm = theGsonObj.toJson(formObject);
			list[index] = formObject;
			index++;
		}
		list = Arrays.copyOf(list,index);
		
		//result = Arrays.toString(list);
		result = theGsonObj.toJson(list);
		return result;
	
	}
	@Path("/forms/{id}")
	@GET
	@Produces("text/plain")
	public String getFormById(@PathParam("id") String theId) throws SQLException, ClassNotFoundException {
		int index = 0;
		int intId = 0;
		String theForm = "";
		
		//url patterens are always strings, need to convert to int
		try{
			intId = Integer.parseInt(theId);}
		catch(NumberFormatException ne){
			intId = 1;}

		//Now Retrieve ingredients from database
		String connectStr="jdbc:mysql://localhost:3306/formdb";
		String username="root";
		String password="csci330pass";
		String driver="com.mysql.jdbc.Driver";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(connectStr, username, password);
		
		String query = "SELECT id, name, semester, year FROM forms WHERE id = ?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1,intId);
		
		ResultSet rs = pstmt.executeQuery();
		String result = "";
		Gson theGsonObj = new Gson();
		
		while (rs.next()){

			int theId2 = rs.getInt("id");
			String theName = rs.getString("name");
			String theSemester = rs.getString("semester");
			String theYear = rs.getString("year");
			
			Form formObject = new Form(theId2,theName,theSemester,theYear);
			
			//Object to json object
			String jsonIngredient = theGsonObj.toJson(formObject);
			list2[index] = formObject;
			//index++;
		}
		//result = Arrays.toString(list2);
		result = theGsonObj.toJson(list2);
		return result;
				
	}
	
	@Path("/forms/form")
	@GET
	@Produces("text/plain")
	public String getFormByName(@QueryParam("name") String theName) throws SQLException, ClassNotFoundException {
		String theForm = "";
		int index = 0;
		//retrieve ingredient from db
		String connectStr="jdbc:mysql://localhost:3306/formdb";
		String username="root";
		String password="csci330pass";
		String driver="com.mysql.jdbc.Driver";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(connectStr, username, password);
		
		String query = "SELECT id, name, semester, year FROM forms WHERE name = ?";	
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1,theName);

		ResultSet rs = pstmt.executeQuery();
		
		String result = "";
		Gson theGsonObj = new Gson();
		while (rs.next()){

			int theId3 = rs.getInt("id");
			String theName3 = rs.getString("name");
			String theSemester = rs.getString("semester");
			String theYear = rs.getString("year");
			
			Form formObject = new Form(theId3,theName,theSemester,theYear);
			
			//Object to json object
			String jsonIngredient = theGsonObj.toJson(formObject);
			list3[index] = formObject;
			//index++;
		}
		//result = Arrays.toString(list3);
		result = theGsonObj.toJson(list3);
		return result;
	}

	*/
	
	
}//End class