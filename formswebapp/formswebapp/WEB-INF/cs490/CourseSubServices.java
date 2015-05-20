package com.cs490;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;

import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import java.util.Arrays;
import com.google.gson.Gson;

@Path("/courseSubForm")
public class CourseSubServices {

	


	@Path("/{courseForm}")
	@GET
	@Produces("text/plain")
	public Response getSubFormById(@PathParam("courseForm") String theId) throws SQLException, ClassNotFoundException, NamingException {
		FormFacade formFacade = FormFacade.getInstance();
		
		int intId = 0;
		
		//URL patterns are always strings, need to convert to int
		try{
			intId = Integer.parseInt(theId);
			}
		catch(NumberFormatException ne){
			intId = 1;
		}
	
		CourseSubForm[] resultArray = formFacade.getSubFormById(intId);
		
		if(resultArray != null){
			Gson theGsonObject = new Gson();
			String result = theGsonObject.toJson(resultArray);
			ResponseBuilder rb = Response.ok(result,MediaType.TEXT_PLAIN);
			rb.status(200);
			return rb.build();
		}
		else{
			return Response.status(404).build();
		}
		
	}
	
	@POST
	@Produces("text/plain")
	@Consumes("application/x-www-form-urlencoded") //web service expected from data
	public Response createSubForm(MultivaluedMap<String,String> formFields) throws SQLException, ClassNotFoundException, NamingException {
		FormFacade formFacade = FormFacade.getInstance();
		
		String substituteFor1 = formFields.getFirst("sourceCourse1");
		String requirement1 = formFields.getFirst("replacementCourse1");
		
		String substituteFor2 = formFields.getFirst("sourceCourse2");
		String requirement2 = formFields.getFirst("replacementCourse2");
		
		String substituteFor3 = formFields.getFirst("sourceCourse3");
		String requirement3 = formFields.getFirst("replacementCourse3");
		
		String studId = formFields.getFirst("studid");
		
		String status = formFields.getFirst("status");
		String formId = formFields.getFirst("formId");
		
		
		String teacher = "1";
		
		CourseSubForm subCreate = new CourseSubForm(substituteFor1,requirement1,substituteFor2,requirement2,substituteFor3,requirement3,status,formId,teacher);
		String result = formFacade.createSubForm(subCreate, studId);
		
		if(result == "passed"){
			System.out.println("In Pass");
			Gson theGsonObject = new Gson();
			String result1 = theGsonObject.toJson(result);
		 	ResponseBuilder rb = Response.ok(result1,MediaType.TEXT_PLAIN);
			rb.status(201);
			return rb.build();
		}
		else{
			return Response.status(404).build();	
		}//end else
	}//End method
	
	@Path("/subFormTeacher")
	@POST
	@Produces("text/plain")
	public Response getSubFormTeacher(MultivaluedMap<String,String> formFields) throws SQLException, ClassNotFoundException, NamingException {
		
		String studId = formFields.getFirst("studid");
			
		FormFacade formFacade = FormFacade.getInstance();
		
		CourseSubForm[] resultArray = formFacade.getSubFormTeacher(studId);
		
		
		
		if(resultArray != null){
			Gson theGsonObject = new Gson();
			String result = theGsonObject.toJson(resultArray);
			ResponseBuilder rb = Response.ok(result,MediaType.TEXT_PLAIN);
			rb.status(200);
			return rb.build();
		}
		else{
			return Response.status(700).build();
		}
	}
	
	
	
	
	
	@Path("/subForm")
	@POST
	@Produces("text/plain")
	public Response getSubForms(MultivaluedMap<String,String> formFields) throws SQLException, ClassNotFoundException, NamingException {
		
		String studId = formFields.getFirst("studid");
		
		
		
		FormFacade formFacade = FormFacade.getInstance();
		
		
		
		
		
		CourseSubForm[] resultArray = formFacade.getSubForms(studId);
		
		
		
		if(resultArray != null){
			Gson theGsonObject = new Gson();
			String result = theGsonObject.toJson(resultArray);
			ResponseBuilder rb = Response.ok(result,MediaType.TEXT_PLAIN);
			rb.status(200);
			return rb.build();
		}
		else{
			return Response.status(700).build();
		}
	}
	
}//End class