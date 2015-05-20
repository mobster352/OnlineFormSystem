package com.cs490;
import java.sql.Connection;
import javax.naming.NamingException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class UserFacade{
	//attributes
	private static UserFacade singleton;
	private UserDataAccess dao;
	
	//constructor
	private UserFacade() throws NamingException, SQLException{
		this.dao = UserDataAccess.getInstance();
	}

	public static UserFacade getInstance()throws NamingException, SQLException{
		if(singleton == null)
			singleton = new UserFacade();
		
		return singleton;
	}
	
	public String courseSubApproved(String id)throws SQLException, ClassNotFoundException, NamingException{
		Connection con = dao.getConnection();
		String result = "";
		
		PreparedStatement pstmt = con.prepareStatement("UPDATE coursesub SET status='Approved' WHERE formid = ?");
		pstmt.setString(1,id);
		int res = pstmt.executeUpdate();
		if(res == 1){
			result = "passed";
			return result;
		}
		else{
		return result;
		}
		
		
	}
	
	public String courseRepeatApproved(String id)throws SQLException, ClassNotFoundException, NamingException{
		Connection con = dao.getConnection();
		String result = "";
		
		PreparedStatement pstmt = con.prepareStatement("UPDATE courserepeat SET status='Approved' WHERE formid = ?");
		pstmt.setString(1,id);
		int res = pstmt.executeUpdate();
		if(res == 1){
			result = "passed";
			return result;
		}
		else{
		return result;
		}
		
		
	}
	
	public String transcriptApproved(String id)throws SQLException, ClassNotFoundException, NamingException{
		Connection con = dao.getConnection();
		String result = "";
		
		PreparedStatement pstmt = con.prepareStatement("UPDATE transcriptform SET status='Approved' WHERE formid = ?");
		pstmt.setString(1,id);
		int res = pstmt.executeUpdate();
		if(res == 1){
			result = "passed";
			return result;
		}
		else{
		return result;
		}
		
		
	}
	
	public String changePassword(String oldPassword, String newPassword, String id)throws SQLException, ClassNotFoundException, NamingException{
	
	Connection con = dao.getConnection();
	String result = "failed";
	PreparedStatement pstmt = con.prepareStatement("select * from user where userPassword = ? AND id = ?");
	pstmt.setString(1,oldPassword);
	pstmt.setString(2,id);
	ResultSet rset = pstmt.executeQuery();
	while(rset.next()){
	PreparedStatement pstm = con.prepareStatement("UPDATE user SET userPassword=? WHERE id = ?");
	pstm.setString(1,newPassword);
	pstm.setString(2,id);
	int res1 = pstm.executeUpdate();
	result = "passed";
	return result;
	}
	
	return result;
	
	}
	
	public String specialPermissionApproved(String id)throws SQLException, ClassNotFoundException, NamingException{
		Connection con = dao.getConnection();
		String result = "";
		
		PreparedStatement pstmt = con.prepareStatement("UPDATE specialform SET status='Approved' WHERE formid = ?");
		pstmt.setString(1,id);
		int res = pstmt.executeUpdate();
		if(res == 1){
			result = "passed";
			return result;
		}
		else{
		return result;
		}
		
		
	}
	

	public int deleteUser(int theId)throws SQLException, ClassNotFoundException, NamingException{
		Connection con = dao.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement("DELETE from user where id=?");
		pstmt.setInt(1,theId);
		int res = pstmt.executeUpdate();
		if(res != 1){
			return 0;
		}
		else{
			return res;
		}
	}
	
	public String deleteSession(String uId)throws SQLException, ClassNotFoundException, NamingException{
		Connection con = dao.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement("DELETE from authsession where sessionId=?");
		pstmt.setString(1,uId);
		int res = pstmt.executeUpdate();
		if(res != 1){
		String success = "success";
		
			return success;
		}
		else{
		String failure = "failure";
			return failure;
		}
	}
	
	
	
	public int checkSession(String token)throws SQLException, ClassNotFoundException, NamingException{
	
	Connection con = dao.getConnection();
	
	PreparedStatement pstmt = con.prepareStatement("SELECT id FROM authsession WHERE sessionId=?");
		pstmt.setString(1,token);
		ResultSet rset = pstmt.executeQuery();
		 
		int index = 0;

		System.out.println(index);
		System.out.println(token);
		
		
			while(rset.next()){
			index++;
			}
			if(index > 0){
			return 1;
			}
			else {
			return 0;
			}
		
	
	}

	public String createSession(Session sessionToAdd)throws SQLException, ClassNotFoundException, NamingException{
	Connection con = dao.getConnection();
	String sessionName = sessionToAdd.getSessionName();
	String sessionPassword = sessionToAdd.getSessionPassword();
	
	String toEncrypt=null;
	
	PreparedStatement stm = con.prepareStatement("SELECT userName, userPassword FROM user WHERE userName = ? AND userPassword = ?");
	stm.setString(1,sessionName);
	stm.setString(2,sessionPassword);
	
	ResultSet rs = stm.executeQuery();
	while(rs.next()){
	
	String name = rs.getString("userName");
	String password = rs.getString("userPassword");
	
	toEncrypt = name.concat(password);
	
	PreparedStatement pstm = con.prepareStatement("INSERT INTO authsession (userName, userPassword, sessionId) VALUES (?,?,?)");
	pstm.setString(1,name);
	pstm.setString(2,password);
	pstm.setString(3,toEncrypt);
	int res = pstm.executeUpdate();
	
	
	
	}
	
	return toEncrypt;
	
	}
	
	
	

	public User[] getUserByName(String theToken)throws SQLException, ClassNotFoundException, NamingException{
		Connection con = dao.getConnection();
		
		
		PreparedStatement psss = con.prepareStatement("SELECT userName FROM authsession WHERE sessionId = ?");
		psss.setString(1, theToken);
		ResultSet rsss = psss.executeQuery();
		String theName = "";
		while(rsss.next()){
		theName = rsss.getString("userName");
		}
		
		System.out.println(theName);
		
		PreparedStatement pstmt = con.prepareStatement("SELECT * FROM user WHERE userName=?");
		pstmt.setString(1, theName);
		ResultSet rs = pstmt.executeQuery();
		
		User[] userArray = new User[100];
		int index = 0;
	
		while(rs.next()){
			int studid = rs.getInt("id");
			String userName = rs.getString("userName");
			String firstName = rs.getString("firstName");
			String lastName = rs.getString("lastName");
			String middleName = rs.getString("middleName");
			String streetAddress = rs.getString("streetAddress");
			String city = rs.getString("city");
			String state = rs.getString("state");
			String zip = rs.getString("zip");
			String dob = rs.getString("dob");
			String major = rs.getString("major");
			String minor = rs.getString("minor");
			String telephone = rs.getString("telephone");
			String catalogYear = rs.getString("catalogYear");
			
			
			User userObject = new User(studid,userName,firstName,lastName,middleName,streetAddress,city,state,zip,dob,major,minor,telephone,catalogYear);
			userArray[index] = userObject;
			index++;
			System.out.println(index);
		}
		if(index > 0){
			userArray = Arrays.copyOf(userArray,index);
			return userArray;
		}
		else{
			return null;
		}
	}//End Method
	
}