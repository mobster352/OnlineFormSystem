package com.cs490;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("ws1")
public class CSCI490WSTest {

	@Path("/test1")
	@GET
	@Produces("text/plain")
	public String getMessage1() {
		return "490 WebService by Richard Roman";
	}
	
	@Path("/test2")
	@GET
	@Produces("text/plain")
	public String getMessage2() {
		return "CSCI 490 OO Software Engineering";
	}
}//end class