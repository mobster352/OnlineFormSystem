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

@Path("/specialpermission")
public class specialPermissionServices {

	@Path("/{specialPerm}")
	@GET
	@Produces("text/plain")
	public Response getSpecialFormById(@PathParam("studentForm") String theId) throws SQLException, ClassNotFoundException, NamingException {
		FormFacade formFacade = FormFacade.getInstance();
		
		int intId = 0;
		
		//URL patterns are always strings, need to convert to int
		try{
			intId = Integer.parseInt(theId);
			}
		catch(NumberFormatException ne){
			intId = 1;
		}
	
		specialPermissionForm[] resultArray = formFacade.getSpecialFormById(intId);
		
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
	public Response createSpecialForm(MultivaluedMap<String,String> formFields) throws SQLException, ClassNotFoundException, NamingException {
		FormFacade formFacade = FormFacade.getInstance();
		
		String year = formFields.getFirst("year");
		String term = formFields.getFirst("term");
		String dept1 = formFields.getFirst("dept1");
		String dept2 = formFields.getFirst("dept2");
		String dept3 = formFields.getFirst("dept3");
		String dept4 = formFields.getFirst("dept4");
		String course1 = formFields.getFirst("course1");
		String course2 = formFields.getFirst("course2");
		String course3 = formFields.getFirst("course3");
		String course4 = formFields.getFirst("course4");
		String section1 = formFields.getFirst("section1");
		String section2 = formFields.getFirst("section2");
		String section3 = formFields.getFirst("section3");
		String section4 = formFields.getFirst("section4");
		String credit1 = formFields.getFirst("credit1");
		String credit2 = formFields.getFirst("credit2");
		String credit3 = formFields.getFirst("credit3");
		String credit4 = formFields.getFirst("credit4");
		String permission1 = formFields.getFirst("permission1");
		String permission2 = formFields.getFirst("permission2");
		String permission3 = formFields.getFirst("permission3");
		String permission4 = formFields.getFirst("permission4");
		String studId = formFields.getFirst("studId");
		String status = "In Progress";
	
		specialPermissionForm specialCreate = new specialPermissionForm(year,term,dept1,dept2,dept3,dept4,course1,course2,course3,course4,section1,section2,section3,section4,credit1,credit2,credit3,credit4,permission1,permission2,permission3,permission4,studId,status);
		String result = formFacade.createSpecialForm(specialCreate, studId);
		
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
	
	@Path("/specFormTeacher")
	@POST
	@Produces("text/plain")
	public Response getSpecialFormTeacher(MultivaluedMap<String,String> formFields) throws SQLException, ClassNotFoundException, NamingException {
		
		String studId = formFields.getFirst("studid");
		
		FormFacade formFacade = FormFacade.getInstance();
		specialPermissionForm[] resultArray = formFacade.getSpecialFormTeacher(studId);
		
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
	
	
	@Path("/specForm")
	@POST
	@Produces("text/plain")
	public Response getSpecialForms(MultivaluedMap<String,String> formFields) throws SQLException, ClassNotFoundException, NamingException {
		
		String studId = formFields.getFirst("studid");
		
		FormFacade formFacade = FormFacade.getInstance();
		specialPermissionForm[] resultArray = formFacade.getSpecialForms(studId);
		
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