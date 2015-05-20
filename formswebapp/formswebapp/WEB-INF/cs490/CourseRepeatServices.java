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



@Path("/courseRepeatForm")
public class CourseRepeatServices {

	@Path("/{repeatForm}")
	@GET
	@Produces("text/plain")
	public Response getCourseRepeatFormById(@PathParam("repeatForm") String theId) throws SQLException, ClassNotFoundException, NamingException {
		FormFacade formFacade = FormFacade.getInstance();
		
		int intId = 0;
		
		//URL patterns are always strings, need to convert to int
		try{
			intId = Integer.parseInt(theId);
			}
		catch(NumberFormatException ne){
			intId = 1;
		}
	
		CourseRepeatForm[] resultArray = formFacade.getTermRepeatFormById(intId);
		
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
	public Response createCourseRepeatForm(MultivaluedMap<String,String> formFields) throws SQLException, ClassNotFoundException, NamingException {
		FormFacade formFacade = FormFacade.getInstance();
		
		String repeat = formFields.getFirst("repeat");
		String termtaken = formFields.getFirst("termTaken");
		String grade = formFields.getFirst("grade");
		String termrepeat = formFields.getFirst("termRepeat");
		String studId = formFields.getFirst("studid");
		String status = formFields.getFirst("status");
		String formId = formFields.getFirst("formId");
		
		
		
		CourseRepeatForm termToRepeatCreate = new CourseRepeatForm(repeat,termtaken,grade,termrepeat,status,formId);
		String result = formFacade.createTermToRepeatForm(termToRepeatCreate, studId);
		
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
	
	@Path("/courseRepeatTeacher")
	@POST
	@Produces("text/plain")
	public Response getCourseRepeatFormTeacher(MultivaluedMap<String,String> formFields) throws SQLException, ClassNotFoundException, NamingException {
		
		String studId = formFields.getFirst("studid");
		
		FormFacade formFacade = FormFacade.getInstance();
		CourseRepeatForm[] resultArray = formFacade.getRepeatFormTeacher(studId);
		
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
	
	@Path("/courseRepeat")
	@POST
	@Produces("text/plain")
	public Response getCourseRepeatForms(MultivaluedMap<String,String> formFields) throws SQLException, ClassNotFoundException, NamingException {
		
		String studId = formFields.getFirst("studid");
		
		FormFacade formFacade = FormFacade.getInstance();
		CourseRepeatForm[] resultArray = formFacade.getRepeatForms(studId);
		
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