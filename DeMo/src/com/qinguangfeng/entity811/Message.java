package com.qinguangfeng.entity811;

import java.io.Serializable;

/**
 * 用来封装  账号 和密码 属性 的类
 * @author Administrator
 *
 */
public class Message  implements Serializable{
private String uuid;
private String password;

//==写个构造方法，让其他人 传两个参数进去
public Message(String uuid,String password){
	this.uuid=uuid;
	this.password=password;
	
	
}


public String getUuid() {
	return uuid;
}
public void setUuid(String uuid) {
	this.uuid = uuid;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}


	
	
	
}
