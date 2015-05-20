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
import javax.ws.rs.core.NewCookie;

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

import javax.servlet.http.Cookie;

@Path("/authsession")
public class AuthSession{
@POST
	@Produces("text/plain")
	@Consumes("application/x-www-form-urlencoded") //web service expected from data
	public Response createSession(MultivaluedMap<String,String> formFields) throws SQLException, ClassNotFoundException, NamingException {
		UserFacade userFacade = UserFacade.getInstance();
	
		String userName = formFields.getFirst("loginName");
		String userPassword = formFields.getFirst("loginPass");	
		
		System.out.println(userName);
		System.out.println(userPassword);
		
		Session sessionToAdd = new Session(userName,userPassword);
		String result1 = userFacade.createSession(sessionToAdd);
		
		if(result1 != null){
				Gson theGsonObject = new Gson();
				String result = theGsonObject.toJson(result1);
				ResponseBuilder rb = Response.ok(result,MediaType.TEXT_PLAIN);
				rb.status(201);
				NewCookie token = new NewCookie("token", result);
				
				return rb.cookie(token).build();
			}
			else{
				return Response.status(401).build();	
}
}

@Path("/{token}")
	@DELETE
	@Produces("text/plain")
	@Consumes("application/x-www-form-urlencoded") 
	public Response deleteSession(@PathParam("token") String id) throws SQLException, ClassNotFoundException,NamingException
	{
		System.out.println(id);
		
		UserFacade userFacade = UserFacade.getInstance();
		
		System.out.println(id);
		
		String result1 = userFacade.deleteSession(id);
		
		
		
		
		if(result1 != null){
				Gson theGsonObject = new Gson();
				String result = theGsonObject.toJson(result1);
				ResponseBuilder rb = Response.ok(result,MediaType.TEXT_PLAIN);
				rb.status(201);
				return rb.build();
			}
			else{
				return Response.status(404).build();	
			}//end else
	}//End method	





}