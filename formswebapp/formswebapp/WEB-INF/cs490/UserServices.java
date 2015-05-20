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


@Path("/user")
public class UserServices{
	
	@Path("/password")
	@POST
	@Produces("text/plain")
	public Response passwordChange(MultivaluedMap<String,String> formFields) throws SQLException, ClassNotFoundException, NamingException {
	
		String result = "failed";
	
		UserFacade userFacade = UserFacade.getInstance();
		String oldPassword = formFields.getFirst("oldPassword");
		String newPassword = formFields.getFirst("newPassword");
		String id = formFields.getFirst("id");
		
		result = userFacade.changePassword(oldPassword,newPassword,id);
		
		if(result == "passed"){
			Gson theGsonObject = new Gson();
			String result1 = theGsonObject.toJson(result);
			ResponseBuilder rb = Response.ok(result1,MediaType.TEXT_PLAIN);
			rb.status(200);
			return rb.build();
		}
		else{
			return Response.status(404).build();
		}
		
		
		
	}
	
	@Path("/approve")
	@POST
	@Produces("text/plain")
	public Response formApprove(MultivaluedMap<String,String> formFields) throws SQLException, ClassNotFoundException, NamingException { 
	
		UserFacade userFacade = UserFacade.getInstance();
		String result ="failed";
		String formType = formFields.getFirst("formType");
		String id = formFields.getFirst("id");
		if(formType.equals("courseSub")){
			result = userFacade.courseSubApproved(id);
		}
		
		if(formType.equals("courseRepeat")){
			result = userFacade.courseRepeatApproved(id);
		}
		if(formType.equals("transcript")){
			result = userFacade.transcriptApproved(id);
		}
		if(formType.equals("specialPermission")){
			result = userFacade.specialPermissionApproved(id);
		}
	
		if(result == "passed"){
			Gson theGsonObject = new Gson();
			String result1 = theGsonObject.toJson(result);
			ResponseBuilder rb = Response.ok(result1,MediaType.TEXT_PLAIN);
			rb.status(200);
			return rb.build();
		}
		else{
			return Response.status(404).build();
		}
	
	}
	

	@Path("/{token}")
	@GET
	@Produces("text/plain") 
	public Response getUser(@PathParam("token")String token) throws SQLException, ClassNotFoundException, NamingException { 
	
		UserFacade userFacade = UserFacade.getInstance();	
		
		String[] split = token.split("=");
		String newToken = split[1];
	
		
		
		int check = userFacade.checkSession(newToken);
		if(check == 1){
		
		
		
		User[] resultArray = userFacade.getUserByName(newToken);
		
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
		}else{
		return Response.status(401).build();
		}
		
	}
}