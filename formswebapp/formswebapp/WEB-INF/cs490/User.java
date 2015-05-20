package com.cs490;

public class User {
 
private int id=0;
private String userName;
private String firstName;
private String lastName;
private String middleName;
private String streetAddress;
private String city;
private String state;
private String zip;
private String dob;
private String major;
private String minor;
private String telephone;
private String catalogYear;
public int getId() {
return id;
}
public void setId(int id) {
this.id = id;
}
public String getUserName() {
return userName;
}
public void setUserName(String userName) {
this.userName = userName;
}
public String getFirstName() {
return firstName;
}
public void setFirstName(String firstName) {
this.firstName = firstName;
}
public String getLastName() {
return lastName;
}
public void setLastName(String lastName) {
this.lastName = lastName;
}
public String getMiddleName() {
return middleName;
}
public void setMiddleName(String middleName) {
this.middleName = middleName;
}
public String getStreetAddress() {
return streetAddress;
}
public void setStreetAddress(String streetAddress) {
this.streetAddress = streetAddress;
}
public String getCity() {
return city;
}
public void setCity(String city) {
this.city = city;
}
public String getState() {
return state;
}
public void setState(String state) {
this.state = state;
}
public String getZip() {
return zip;
}
public void setZip(String zip) {
this.zip = zip;
}
public String getDob() {
return dob;
}
public void setDob(String dob) {
this.dob = dob;
}
public String getMajor() {
return major;
}
public void setMajor(String major) {
this.major = major;
}
public String getMinor() {
return minor;
}
public void setMinor(String minor) {
this.minor = minor;
}
public String getTelephone() {
return telephone;
}
public void setTelephone(String telephone) {
this.telephone = telephone;
}
public String getCatalogYear() {
return catalogYear;
}
public void setCatalogYear(String catalogYear) {
this.catalogYear = catalogYear;
}
public User(int id, String userName, String firstName, String lastName,
String middleName, String streetAddress, String city, String state,
String zip, String dob, String major, String minor,
String telephone, String catalogYear) {
super();
this.id = id;
this.userName = userName;
this.firstName = firstName;
this.lastName = lastName;
this.middleName = middleName;
this.streetAddress = streetAddress;
this.city = city;
this.state = state;
this.zip = zip;
this.dob = dob;
this.major = major;
this.minor = minor;
this.telephone = telephone;
this.catalogYear = catalogYear;
}
 
 
 
 
 
 
}