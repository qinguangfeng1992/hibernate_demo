package com.qinguangfeng.entity;

public class User implements java.io.Serializable{
   private int uId;
   private String userName;
   private String pwd;
public int getuId() {
	return uId;
}
public void setuId(int uId) {
	this.uId = uId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
public User(int uId, String userName, String pwd) {

	this.uId = uId;
	this.userName = userName;
	this.pwd = pwd;
}
public User() {

}
public User(String userName, String pwd) {
	super();
	this.userName = userName;
	this.pwd = pwd;
}
@Override
public String toString() {
	return "User [uId=" + uId + ", userName=" + userName + ", pwd=" + pwd + "]";
}
	
	
	
}
