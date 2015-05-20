package com.cs490;
public class specialPermissionForm {

	private String year;
	private String term;
	private String dept1;
	private String dept2;
	private String dept3;
	private String dept4;
	private String course1;
	private String course2;
	private String course3;
	private String course4;
	private String section1;
	private String section2;
	private String section3;
	private String section4;
	private String credit1;
	private String credit2;
	private String credit3;
	private String credit4;
	private String permission1;
	private String permission2;
	private String permission3;
	private String permission4;
	private String formId;
	private String status;
	private String studId;
	
	
	
	public specialPermissionForm() {
		
		this.year = "none";
		this.term = "none";
		this.dept1 = "none";
		this.dept2 = "none";
		this.dept3 = "none";
		this.dept4 = "none";
		this.course1 = "none";
		this.course2 = "none";
		this.course3 = "none";
		this.course4 = "none";
		this.section1 = "none";
		this.section2 = "none";
		this.section3 = "none";
		this.section4 = "none";
		this.credit1 = "none";
		this.credit2 = "none";
		this.credit3 = "none";
		this.credit4 = "none";
		this.permission1 = "none";
		this.permission2 = "none";
		this.permission3 = "none";
		this.permission4 = "none";
		
	}

	
	public specialPermissionForm(String year, String term, String dept1,
			String dept2, String dept3, String dept4, String course1,
			String course2, String course3, String course4, String section1,
			String section2, String section3, String section4, String credit1,
			String credit2, String credit3, String credit4, String permission1,
			String permission2, String permission3, String permission4, String studId, String status) {
		super();
		this.year = year;
		this.term = term;
		this.dept1 = dept1;
		this.dept2 = dept2;
		this.dept3 = dept3;
		this.dept4 = dept4;
		this.course1 = course1;
		this.course2 = course2;
		this.course3 = course3;
		this.course4 = course4;
		this.section1 = section1;
		this.section2 = section2;
		this.section3 = section3;
		this.section4 = section4;
		this.credit1 = credit1;
		this.credit2 = credit2;
		this.credit3 = credit3;
		this.credit4 = credit4;
		this.permission1 = permission1;
		this.permission2 = permission2;
		this.permission3 = permission3;
		this.permission4 = permission4;
		this.studId = studId;
		this.status = status;
	}



	public String getYear() {
		return year;
	}



	public void setYear(String year) {
		this.year = year;
	}



	public String getTerm() {
		return term;
	}



	public void setTerm(String term) {
		this.term = term;
	}



	public String getDept1() {
		return dept1;
	}



	public void setDept1(String dept1) {
		this.dept1 = dept1;
	}



	public String getDept2() {
		return dept2;
	}



	public void setDept2(String dept2) {
		this.dept2 = dept2;
	}



	public String getDept3() {
		return dept3;
	}



	public void setDept3(String dept3) {
		this.dept3 = dept3;
	}



	public String getDept4() {
		return dept4;
	}



	public void setDept4(String dept4) {
		this.dept4 = dept4;
	}



	public String getCourse1() {
		return course1;
	}



	public void setCourse1(String course1) {
		this.course1 = course1;
	}



	public String getCourse2() {
		return course2;
	}



	public void setCourse2(String course2) {
		this.course2 = course2;
	}



	public String getCourse3() {
		return course3;
	}



	public void setCourse3(String course3) {
		this.course3 = course3;
	}



	public String getCourse4() {
		return course4;
	}



	public void setCourse4(String course4) {
		this.course4 = course4;
	}



	public String getSection1() {
		return section1;
	}



	public void setSection1(String section1) {
		this.section1 = section1;
	}



	public String getSection2() {
		return section2;
	}



	public void setSection2(String section2) {
		this.section2 = section2;
	}



	public String getSection3() {
		return section3;
	}



	public void setSection3(String section3) {
		this.section3 = section3;
	}



	public String getSection4() {
		return section4;
	}



	public void setSection4(String section4) {
		this.section4 = section4;
	}



	public String getCredit1() {
		return credit1;
	}



	public void setCredit1(String credit1) {
		this.credit1 = credit1;
	}



	public String getCredit2() {
		return credit2;
	}



	public void setCredit2(String credit2) {
		this.credit2 = credit2;
	}



	public String getCredit3() {
		return credit3;
	}



	public void setCredit3(String credit3) {
		this.credit3 = credit3;
	}



	public String getCredit4() {
		return credit4;
	}



	public void setCredit4(String credit4) {
		this.credit4 = credit4;
	}



	public String getPermission1() {
		return permission1;
	}



	public void setPermission1(String permission1) {
		this.permission1 = permission1;
	}



	public String getPermission2() {
		return permission2;
	}



	public void setPermission2(String permission2) {
		this.permission2 = permission2;
	}



	public String getPermission3() {
		return permission3;
	}



	public void setPermission3(String permission3) {
		this.permission3 = permission3;
	}



	public String getPermission4() {
		return permission4;
	}



	public void setPermission4(String permission4) {
		this.permission4 = permission4;
	}



	@Override
	public String toString() {
		return "specialpermission [year=" + year + ", term=" + term
				+ ", dept1=" + dept1 + ", dept2=" + dept2 + ", dept3=" + dept3
				+ ", dept4=" + dept4 + ", course1=" + course1 + ", course2="
				+ course2 + ", course3=" + course3 + ", course4=" + course4
				+ ", section1=" + section1 + ", section2=" + section2
				+ ", section3=" + section3 + ", section4=" + section4
				+ ", credit1=" + credit1 + ", credit2=" + credit2
				+ ", credit3=" + credit3 + ", credit4=" + credit4
				+ ", permission1=" + permission1 + ", permission2="
				+ permission2 + ", permission3=" + permission3
				+ ", permission4=" + permission4 + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}