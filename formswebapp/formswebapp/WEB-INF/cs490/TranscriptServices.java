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

@Path("/transcriptForm")
public class TranscriptServices {

	@Path("/{transForm}")
	@GET
	@Produces("text/plain")
	public Response getTranscriptFormById(@PathParam("studentForm") String theId) throws SQLException, ClassNotFoundException, NamingException {
		FormFacade formFacade = FormFacade.getInstance();
		
		int intId = 0;
		
		//URL patterns are always strings, need to convert to int
		try{
			intId = Integer.parseInt(theId);
			}
		catch(NumberFormatException ne){
			intId = 1;
		}
	
		TranscriptForm[] resultArray = formFacade.getTranscriptFormById(intId);
		
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
	public Response createTranscriptForm(MultivaluedMap<String,String> formFields) throws SQLException, ClassNotFoundException, NamingException {
		FormFacade formFacade = FormFacade.getInstance();
		
		String firstTermAttended = formFields.getFirst("firstTermAttended");
		String lastTermAttended = formFields.getFirst("lastTermAttended");
		String toBeCompleted = formFields.getFirst("toBeCompleted");
		
		String firstYearAttended = formFields.getFirst("firstYearAttended");
		String lastYearAttended = formFields.getFirst("lastYearAttended");
		
		
		String numTrans1 = formFields.getFirst("numtrans1");
		String name1 = formFields.getFirst("name1");
		
		String numTrans2 = formFields.getFirst("numtrans2");
		String name2 = formFields.getFirst("name2");
		
		String numTrans3 = formFields.getFirst("numtrans3"); 
		String name3 = formFields.getFirst("name3");
		
		String studId = formFields.getFirst("studid");
		
		String status = formFields.getFirst("status");
		String formId = formFields.getFirst("formId");
	
		TranscriptForm transcriptCreate = new TranscriptForm(firstTermAttended,lastTermAttended,toBeCompleted,firstYearAttended,lastYearAttended,numTrans1,name1,numTrans2,name2,numTrans3,name3,formId,status);
		String result = formFacade.createTranscriptForm(transcriptCreate, studId);
		
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
	
	@Path("/transFormTeacher")
	@POST
	@Produces("text/plain")
	public Response getTranscriptFormTeacher(MultivaluedMap<String,String> formFields) throws SQLException, ClassNotFoundException, NamingException {
		
		String studId = formFields.getFirst("studid");
		
		FormFacade formFacade = FormFacade.getInstance();
		TranscriptForm[] resultArray = formFacade.getTranscriptFormTeacher(studId);
		
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
	
	
	@Path("/transForm")
	@POST
	@Produces("text/plain")
	public Response getTranscriptForms(MultivaluedMap<String,String> formFields) throws SQLException, ClassNotFoundException, NamingException {
		
		String studId = formFields.getFirst("studid");
		
		FormFacade formFacade = FormFacade.getInstance();
		TranscriptForm[] resultArray = formFacade.getTranscriptForms(studId);
		
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