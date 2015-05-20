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

public class FormFacade{

	private static FormFacade singleton;
	private FormDataAccess dao;
	
	//Data Access
	private FormFacade() throws NamingException, SQLException{
		this.dao = FormDataAccess.getInstance();
	}
	public static FormFacade getInstance()throws NamingException, SQLException{
		if(singleton == null)
			singleton = new FormFacade();
		
		return singleton;
	}
	
	

	
	
	

	/**Start Course Repeat**/
	public CourseRepeatForm[] getRepeatForms(String studId) throws SQLException, ClassNotFoundException, NamingException{
		Connection con = dao.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement("SELECT * FROM courserepeat WHERE studId = ?");
		pstmt.setString(1,studId);
		ResultSet rs = pstmt.executeQuery();
		
		CourseRepeatForm[] formArray = new CourseRepeatForm[100];
		int index=0;
		while(rs.next()){	
			String repeat = rs.getString("courseToRepeat");
			String termtaken = rs.getString("termTaken");
			String grade = rs.getString("gradeEarned");
			String termrepeat = rs.getString("termToRepeat");
			String formId = rs.getString("formId");
			String status = rs.getString("status");
			
			CourseRepeatForm formObject = new CourseRepeatForm(repeat,termtaken,grade,termrepeat,formId,status);
			
			formArray[index] = formObject;
			index++;
		}
		if(index > 0){
			formArray = Arrays.copyOf(formArray,index);
			return formArray;
		}
		else{
			return null;
		}
	}
	public CourseRepeatForm[] getRepeatFormTeacher(String studId) throws SQLException, ClassNotFoundException, NamingException{
		Connection con = dao.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement("SELECT * FROM courserepeat WHERE teacher = ?");
		pstmt.setString(1,studId);
		ResultSet rs = pstmt.executeQuery();
		
		CourseRepeatForm[] formArray = new CourseRepeatForm[100];
		int index=0;
		while(rs.next()){	
			String repeat = rs.getString("courseToRepeat");
			String termtaken = rs.getString("termTaken");
			String grade = rs.getString("gradeEarned");
			String termrepeat = rs.getString("termToRepeat");
			String formId = rs.getString("formId");
			String status = rs.getString("status");
			
			CourseRepeatForm formObject = new CourseRepeatForm(repeat,termtaken,grade,termrepeat,formId,status);
			
			formArray[index] = formObject;
			index++;
		}
		if(index > 0){
			formArray = Arrays.copyOf(formArray,index);
			return formArray;
		}
		else{
			return null;
		}
	}
	
	
	public CourseRepeatForm[] getTermRepeatFormById(int theId)throws SQLException, ClassNotFoundException{
		Connection con = dao.getConnection();
		
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM courserepeat WHERE formId = ?");
		stmt.setInt(1,theId);
		ResultSet rs = stmt.executeQuery();
		
		CourseRepeatForm[] formArray = new CourseRepeatForm[100];
		int index = 0;
		
		while(rs.next()){
			String repeat = rs.getString("courseToRepeat");
			String termtaken = rs.getString("termTaken");
			String grade = rs.getString("gradeEarned");
			String termrepeat = rs.getString("termToRepeat");
			String formId = rs.getString("formId");
			String status = rs.getString("status");
			
			CourseRepeatForm formObject = new CourseRepeatForm(repeat,termtaken,grade,termrepeat,formId,status);
			
			formArray[index] = formObject;
			index++;
		}
		if( index > 0){
			formArray = Arrays.copyOf(formArray,index);
			return formArray;
		}
		else{
			return formArray;
		}
	}
	
	public String createTermToRepeatForm(CourseRepeatForm theFormToCreate, String studId) throws SQLException, ClassNotFoundException, NamingException{
		Connection con = dao.getConnection();
	
		String courseToRepeat = theFormToCreate.getCourseToRepeat();
		String termTaken = theFormToCreate.getTermTaken();
		String gradeEarned = theFormToCreate.getGradeEarned();
		String termToRepeat = theFormToCreate.getTermToRepeat();
		
		PreparedStatement pstmt = con.prepareStatement("INSERT INTO courserepeat(courseToRepeat,termTaken,gradeEarned,termToRepeat, studId) VALUES (?,?,?,?,?)");
		
		pstmt.setString(1,courseToRepeat);
		pstmt.setString(2,termTaken);
		pstmt.setString(3,gradeEarned);
		pstmt.setString(4,termToRepeat);
		pstmt.setString(5,studId);
		int res = pstmt.executeUpdate();
		String answer = "failed";
		
		CourseRepeatForm[] userArray = new CourseRepeatForm[100];
		int index = 0;
					
		if(res == 1){
			answer = "passed";
			return answer;
		}
		else{
			return answer;
		}
	}
	/**End Course Repeat **/
	
	/**Start Course Sub**/
	public CourseSubForm[] getSubForms(String studId) throws SQLException, ClassNotFoundException, NamingException{
		Connection con = dao.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement("SELECT * FROM coursesub WHERE studId = ?");
		pstmt.setString(1,studId);
		ResultSet rs = pstmt.executeQuery();
		
		CourseSubForm[] formArray = new CourseSubForm[100];
		int index=0;
		while(rs.next()){	
			String sourceCourse1 = rs.getString("sourceCourse1");
			String replacementCourse1 = rs.getString("replacementCourse1"); 
			String sourceCourse2 = rs.getString("sourceCourse2");
			String replacementCourse2 = rs.getString("replacementCourse2"); 
			String sourceCourse3 = rs.getString("sourceCourse3");
			String replacementCourse3 = rs.getString("replacementCourse3"); 
			String status = rs.getString("status");
			String formId = rs.getString("formId");
			String teacher = rs.getString("teacher");
			
			CourseSubForm formObject = new CourseSubForm(sourceCourse1,replacementCourse1,sourceCourse2,replacementCourse2,sourceCourse3,replacementCourse3,formId,status,teacher);
			
			formArray[index] = formObject;
			index++;
		}
		if(index > 0){
			formArray = Arrays.copyOf(formArray,index);
			return formArray;
		}
		else{
			return null;
		}
	}
	
	public CourseSubForm[] getSubFormTeacher(String studId) throws SQLException, ClassNotFoundException, NamingException{
		Connection con = dao.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement("SELECT * FROM coursesub WHERE teacher = ?");
		pstmt.setString(1,studId);
		ResultSet rs = pstmt.executeQuery();
		
		CourseSubForm[] formArray = new CourseSubForm[100];
		int index=0;
		while(rs.next()){	
			String sourceCourse1 = rs.getString("sourceCourse1");
			String replacementCourse1 = rs.getString("replacementCourse1"); 
			String sourceCourse2 = rs.getString("sourceCourse2");
			String replacementCourse2 = rs.getString("replacementCourse2"); 
			String sourceCourse3 = rs.getString("sourceCourse3");
			String replacementCourse3 = rs.getString("replacementCourse3"); 
			String status = rs.getString("status");
			String formId = rs.getString("formId");
			String teacher = rs.getString("teacher");
			
			CourseSubForm formObject = new CourseSubForm(sourceCourse1,replacementCourse1,sourceCourse2,replacementCourse2,sourceCourse3,replacementCourse3,formId,status,teacher);
			
			formArray[index] = formObject;
			index++;
		}
		if(index > 0){
			formArray = Arrays.copyOf(formArray,index);
			return formArray;
		}
		else{
			return null;
		}
	}
	
	
	public CourseSubForm[] getSubFormById(int theId)throws SQLException, ClassNotFoundException{
		Connection con = dao.getConnection();
		
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM coursesub WHERE formId = ?");
		stmt.setInt(1,theId);
		ResultSet rs = stmt.executeQuery();
		
		CourseSubForm[] formArray = new CourseSubForm[100];
		int index = 0;
		
		while(rs.next()){
			String sourceCourse1 = rs.getString("sourceCourse1");
			String replacementCourse1 = rs.getString("replacementCourse1"); 
			String sourceCourse2 = rs.getString("sourceCourse2");
			String replacementCourse2 = rs.getString("replacementCourse2"); 
			String sourceCourse3 = rs.getString("sourceCourse3");
			String replacementCourse3 = rs.getString("replacementCourse3"); 
			String formId = rs.getString("formId");	
			String status = rs.getString("status");
			String teacher = rs.getString("teacher");
			
			CourseSubForm formObject = new CourseSubForm(sourceCourse1,replacementCourse1,sourceCourse2,replacementCourse2,sourceCourse3,replacementCourse3,formId,status,teacher);
			
			formArray[index] = formObject;
			index++;
		}
		if( index > 0){
			formArray = Arrays.copyOf(formArray,index);
			return formArray;
		}
		else{
			return formArray;
		}
	}
	
	public String createSubForm(CourseSubForm theFormToCreate, String studId) throws SQLException, ClassNotFoundException, NamingException{
		Connection con = dao.getConnection();
	
		String sourceCourse1 = theFormToCreate.getSubstituteFor1();
		String replacementCourse1 = theFormToCreate.getRequirement1(); 
		String sourceCourse2 = theFormToCreate.getSubstituteFor2();
		String replacementCourse2 = theFormToCreate.getRequirement2(); 
		String sourceCourse3 = theFormToCreate.getSubstituteFor3();
		String replacementCourse3 = theFormToCreate.getRequirement3(); 
		
		
		
		PreparedStatement pstmt = con.prepareStatement("INSERT INTO coursesub(sourceCourse1,replacementCourse1,sourceCourse2,replacementCourse2,sourceCourse3,replacementCourse3, studId) VALUES (?,?,?,?,?,?,?)");
		
		pstmt.setString(1,sourceCourse1);
		pstmt.setString(2,replacementCourse1);
		pstmt.setString(3,sourceCourse2);
		pstmt.setString(4,replacementCourse2);
		pstmt.setString(5,sourceCourse3);
		pstmt.setString(6,replacementCourse3);
		pstmt.setString(7,studId);
		
		int res = pstmt.executeUpdate();
		String answer = "failed";
		
		CourseSubForm[] userArray = new CourseSubForm[100];
		int index = 0;
					
		if(res == 1){
			answer = "passed";
			return answer;
		}
		else{
			return answer;
		}
	}
	/**End Sub Form**/
	
	/**Start Transcript**/
	public TranscriptForm[] getTranscriptForms(String studId) throws SQLException, ClassNotFoundException, NamingException{
		Connection con = dao.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement("SELECT * FROM transcriptform WHERE studId = ?");
		pstmt.setString(1,studId);
		ResultSet rs = pstmt.executeQuery();
		
		TranscriptForm[] formArray = new TranscriptForm[100];
		int index=0;
		while(rs.next()){	
			
			String firstTermAttended = rs.getString("firstTermAttended");
			String firstYearAttended = rs.getString("firstYearAttended"); 
			String lastTermAttended = rs.getString("lastTermAttended");
			String lastYearAttended = rs.getString("lastYearAttended");
			String toBeCompleted = rs.getString("toBeCompleted");
			
			String numTrans1 = rs.getString("numTrans1");
			String name1 = rs.getString("name1");
			
			String numTrans2 = rs.getString("numTrans2");
			String name2 = rs.getString("name2");
			
			String numTrans3 = rs.getString("numTrans3");
			String name3 = rs.getString("name3");	
			
			String formId = rs.getString("formId");
			String status = rs.getString("status");
			
	
			TranscriptForm formObject = new TranscriptForm(firstTermAttended,lastTermAttended,toBeCompleted,firstYearAttended,lastYearAttended,numTrans1,name1,numTrans2,name2,numTrans3,name3,formId,status);
			
			formArray[index] = formObject;
			index++;
		}
		if(index > 0){
			formArray = Arrays.copyOf(formArray,index);
			return formArray;
		}
		else{
			return null;
		}
	}
	
	public TranscriptForm[] getTranscriptFormTeacher(String studId) throws SQLException, ClassNotFoundException, NamingException{
		Connection con = dao.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement("SELECT * FROM transcriptform WHERE teacher = ?");
		pstmt.setString(1,studId);
		ResultSet rs = pstmt.executeQuery();
		
		TranscriptForm[] formArray = new TranscriptForm[100];
		int index=0;
		while(rs.next()){	
			
			String firstTermAttended = rs.getString("firstTermAttended");
			String firstYearAttended = rs.getString("firstYearAttended"); 
			String lastTermAttended = rs.getString("lastTermAttended");
			String lastYearAttended = rs.getString("lastYearAttended");
			String toBeCompleted = rs.getString("toBeCompleted");
			
			String numTrans1 = rs.getString("numTrans1");
			String name1 = rs.getString("name1");
			
			String numTrans2 = rs.getString("numTrans2");
			String name2 = rs.getString("name2");
			
			String numTrans3 = rs.getString("numTrans3");
			String name3 = rs.getString("name3");	
			
			String formId = rs.getString("formId");
			String status = rs.getString("status");
			
	
			TranscriptForm formObject = new TranscriptForm(firstTermAttended,lastTermAttended,toBeCompleted,firstYearAttended,lastYearAttended,numTrans1,name1,numTrans2,name2,numTrans3,name3,formId,status);
			
			formArray[index] = formObject;
			index++;
		}
		if(index > 0){
			formArray = Arrays.copyOf(formArray,index);
			return formArray;
		}
		else{
			return null;
		}
	}
	
	public TranscriptForm[] getTranscriptFormById(int theId)throws SQLException, ClassNotFoundException{
		Connection con = dao.getConnection();
		
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM transcriptform WHERE id = ?");
		stmt.setInt(1,theId);
		ResultSet rs = stmt.executeQuery();
		
		TranscriptForm[] formArray = new TranscriptForm[100];
		int index = 0;
		
		while(rs.next()){
			
			String firstTermAttended = rs.getString("firstTermAttended");
			String firstYearAttended = rs.getString("firstYearAttended"); 
			String lastTermAttended = rs.getString("lastTermAttended");
			String lastYearAttended = rs.getString("lastYearAttended");
			String toBeCompleted = rs.getString("toBeCompleted");
			
			String numTrans1 = rs.getString("numTrans1");
			String name1 = rs.getString("name1");
			
			String numTrans2 = rs.getString("numTrans2");
			String name2 = rs.getString("name2");
			
			String numTrans3 = rs.getString("numTrans3");
			String name3 = rs.getString("name3");
			
			String formId = rs.getString("formId");
			String status = rs.getString("status");
			
			TranscriptForm formObject = new TranscriptForm(firstTermAttended,lastTermAttended,toBeCompleted,firstYearAttended,lastYearAttended,numTrans1,name1,numTrans2,name2,numTrans3,name3,formId,status);
			
			formArray[index] = formObject;
			index++;
			
		}
		if( index > 0){
			formArray = Arrays.copyOf(formArray,index);
			return formArray;
		}
		else{
			return formArray;
		}
	}
	
	public String createTranscriptForm(TranscriptForm theFormToCreate, String studId) throws SQLException, ClassNotFoundException, NamingException{
		Connection con = dao.getConnection();
	
		
			String firstTermAttended = theFormToCreate.getFirstTerm();
			String firstYearAttended = theFormToCreate.getYearFirst(); 
			String lastTermAttended = theFormToCreate.getLastTerm();
			String lastYearAttended = theFormToCreate.getYearLast();
			String toBeCompleted = theFormToCreate.getToBeCompleted();
			
			String numTrans1 = theFormToCreate.getNumTrans1();
			String name1 = theFormToCreate.getName1();
			
			String numTrans2 = theFormToCreate.getNumTrans2();
			String name2 = theFormToCreate.getName2();
			
			String numTrans3 = theFormToCreate.getNumTrans3();
			String name3 = theFormToCreate.getName3();
			
			
	
			
		PreparedStatement pstmt = con.prepareStatement("INSERT INTO transcriptform(firstTermAttended,lastTermAttended,toBeCompleted,firstYearAttended,lastYearAttended,numTrans1,name1,numTrans2,name2,numTrans3,name3,studId) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
		
		pstmt.setString(1,firstTermAttended);
		pstmt.setString(2,lastTermAttended);
		pstmt.setString(3,toBeCompleted);
		pstmt.setString(4,firstYearAttended);
		pstmt.setString(5,lastYearAttended);
		pstmt.setString(6,numTrans1);
		pstmt.setString(7,name1);
		pstmt.setString(8,numTrans2);
		pstmt.setString(9,name2);
		pstmt.setString(10,numTrans3);
		pstmt.setString(11,name3);
		pstmt.setString(12,studId);
		
		
		
		
		
		int res = pstmt.executeUpdate();
		String answer = "failed";
		
		TranscriptForm[] userArray = new TranscriptForm[100];
		int index = 0;
					
		if(res == 1){
			answer = "passed";
			return answer;
		}
		else{
			return answer;
		}
	}
	/**End Transcript **/
	
	
	
	public specialPermissionForm[] getSpecialForms(String studId) throws SQLException, ClassNotFoundException, NamingException{
		Connection con = dao.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement("SELECT * FROM specialform WHERE studId = ?");
		pstmt.setString(1,studId);
		ResultSet rs = pstmt.executeQuery();
		
		specialPermissionForm[] formArray = new specialPermissionForm[100];
		int index=0;
		while(rs.next()){	
			
			String year = rs.getString("year");
			String term = rs.getString("term");
			String dept1 = rs.getString("dept1");
			String dept2  = rs.getString("dept2");
			String dept3  = rs.getString("dept3");
			String dept4 = rs.getString("dept4");
			String course1 = rs.getString("course1");
			String course2  = rs.getString("course2");
			String course3  = rs.getString("course3");
			String course4  = rs.getString("course4");
			String section1  = rs.getString("section1");
			String section2 = rs.getString("section2");
			String section3  = rs.getString("section3");
			String section4  = rs.getString("section4");
			String credit1  = rs.getString("credit1");
			String credit2  = rs.getString("credit2");
			String credit3 = rs.getString("credit3");
			String credit4 = rs.getString("credit4");
			String permission1 = rs.getString("permission1");
			String permission2 = rs.getString("permission2");
			String permission3 = rs.getString("permission3");
			String permission4 = rs.getString("permission4");
			
			
			String formId = rs.getString("formId");
			String status = rs.getString("status");
			
	
			specialPermissionForm formObject = new specialPermissionForm(year,term,dept1,dept2,dept3,dept4,course1,course2,course3,course4,section1,section2,section3,section4,credit1,credit2,credit3,credit4,permission1,permission2,permission3,permission4,formId,status);
			
			formArray[index] = formObject;
			index++;
		}
		if(index > 0){
			formArray = Arrays.copyOf(formArray,index);
			return formArray;
		}
		else{
			return null;
		}
	}
	
	
	public specialPermissionForm[] getSpecialFormTeacher(String studId) throws SQLException, ClassNotFoundException, NamingException{
		Connection con = dao.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement("SELECT * FROM specialform WHERE teacher = ?");
		pstmt.setString(1,studId);
		ResultSet rs = pstmt.executeQuery();
		
		specialPermissionForm[] formArray = new specialPermissionForm[100];
		int index=0;
		while(rs.next()){	
			
			String year = rs.getString("year");
			String term = rs.getString("term");
			String dept1 = rs.getString("dept1");
			String dept2  = rs.getString("dept2");
			String dept3  = rs.getString("dept3");
			String dept4 = rs.getString("dept4");
			String course1 = rs.getString("course1");
			String course2  = rs.getString("course2");
			String course3  = rs.getString("course3");
			String course4  = rs.getString("course4");
			String section1  = rs.getString("section1");
			String section2 = rs.getString("section2");
			String section3  = rs.getString("section3");
			String section4  = rs.getString("section4");
			String credit1  = rs.getString("credit1");
			String credit2  = rs.getString("credit2");
			String credit3 = rs.getString("credit3");
			String credit4 = rs.getString("credit4");
			String permission1 = rs.getString("permission1");
			String permission2 = rs.getString("permission2");
			String permission3 = rs.getString("permission3");
			String permission4 = rs.getString("permission4");
			
			
			String formId = rs.getString("formId");
			String status = rs.getString("status");
			
	
			specialPermissionForm formObject = new specialPermissionForm(year,term,dept1,dept2,dept3,dept4,course1,course2,course3,course4,section1,section2,section3,section4,credit1,credit2,credit3,credit4,permission1,permission2,permission3,permission4,formId,status);
			
			formArray[index] = formObject;
			index++;
		}
		if(index > 0){
			formArray = Arrays.copyOf(formArray,index);
			return formArray;
		}
		else{
			return null;
		}
	}
	
	
	public specialPermissionForm[] getSpecialFormById(int theId)throws SQLException, ClassNotFoundException{
		Connection con = dao.getConnection();
		
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM specialform WHERE formId = ?");
		stmt.setInt(1,theId);
		ResultSet rs = stmt.executeQuery();
		
		specialPermissionForm[] formArray = new specialPermissionForm[100];
		int index = 0;
		
		while(rs.next()){
			
			String year = rs.getString("year");
			String term = rs.getString("term");
			String dept1 = rs.getString("dept1");
			String dept2  = rs.getString("dept2");
			String dept3  = rs.getString("dept3");
			String dept4 = rs.getString("dept4");
			String course1 = rs.getString("course1");
			String course2  = rs.getString("course2");
			String course3  = rs.getString("course3");
			String course4  = rs.getString("course4");
			String section1  = rs.getString("section1");
			String section2 = rs.getString("section2");
			String section3  = rs.getString("section3");
			String section4  = rs.getString("section4");
			String credit1  = rs.getString("credit1");
			String credit2  = rs.getString("credit2");
			String credit3 = rs.getString("credit3");
			String credit4 = rs.getString("credit4");
			String permission1 = rs.getString("permission1");
			String permission2 = rs.getString("permission2");
			String permission3 = rs.getString("permission3");
			String permission4 = rs.getString("permission4");
			
			
			String formId = rs.getString("formId");
			String status = rs.getString("status");
			
			specialPermissionForm formObject = new specialPermissionForm(year,term,dept1,dept2,dept3,dept4,course1,course2,course3,course4,section1,section2,section3,section4,credit1,credit2,credit3,credit4,permission1,permission2,permission3,permission4,formId,status);
			
			formArray[index] = formObject;
			index++;
			
		}
		if( index > 0){
			formArray = Arrays.copyOf(formArray,index);
			return formArray;
		}
		else{
			return formArray;
		}
	}
	
	public String createSpecialForm(specialPermissionForm rs, String studId) throws SQLException, ClassNotFoundException, NamingException{
		Connection con = dao.getConnection();
	
		
		
	
			String year = rs.getYear();
			String term = rs.getTerm();
			String dept1 = rs.getDept1();
			String dept2  = rs.getDept2();
			String dept3  = rs.getDept3();
			String dept4 = rs.getDept4();
			String course1 = rs.getCourse1();
			String course2  = rs.getCourse2();
			String course3  = rs.getCourse3();
			String course4  = rs.getCourse4();
			String section1  = rs.getSection1();
			String section2 = rs.getSection2();
			String section3  = rs.getSection3();
			String section4  = rs.getSection4();
			String credit1  = rs.getCredit1();
			String credit2  = rs.getCredit2();
			String credit3 = rs.getCredit3();
			String credit4 = rs.getCredit4();
			String permission1 = rs.getPermission1();
			String permission2 = rs.getPermission2();
			String permission3 = rs.getPermission3();
			String permission4 = rs.getPermission4();
			String status = "In Progress";
			
		PreparedStatement pstmt = con.prepareStatement("INSERT INTO specialform(year,term,dept1,dept2,dept3,dept4,course1,course2,course3,course4,section1,section2,section3,section4,credit1,credit2,credit3,credit4,permission1,permission2,permission3,permission4,status,studId) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		
		pstmt.setString(1,year);
		pstmt.setString(2,term);
		pstmt.setString(3,dept1);
		pstmt.setString(4,dept2);
		pstmt.setString(5,dept3);
		pstmt.setString(6,dept4);
		pstmt.setString(7,course1);
		pstmt.setString(8,course2);
		pstmt.setString(9,course3);
		pstmt.setString(10,course4);
		pstmt.setString(11,section1);
		pstmt.setString(12,section2);
		pstmt.setString(13,section3);
		pstmt.setString(14,section4);
		pstmt.setString(15,credit1);
		pstmt.setString(16,credit2);
		pstmt.setString(17,credit3);
		pstmt.setString(18,credit4);
		pstmt.setString(19,permission1);
		pstmt.setString(20,permission2);
		pstmt.setString(21,permission3);
		pstmt.setString(22,permission4);
		pstmt.setString(23,status);
		pstmt.setString(24,studId);
		
		
		
		
		
		int res = pstmt.executeUpdate();
		String answer = "failed";
		
		specialPermissionForm[] specialArray = new specialPermissionForm[100];
		int index = 0;
					
		if(res == 1){
			answer = "passed";
			return answer;
		}
		else{
			return answer;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}