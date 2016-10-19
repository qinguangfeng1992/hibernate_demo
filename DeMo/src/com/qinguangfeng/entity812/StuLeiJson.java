package com.qinguangfeng.entity812;

import java.io.Serializable;

/**
 * ������� ��ɾ��ģ��������� ��������
 *  ������һ��javaBeans���װ�����ȽϷ���
 *  ���й��췽�� ��get/set���������л�һ����������
 *  �����������Ķ�������õ�ʱ��Ҳ�Ƚ�
 * @author Administrator
 *
 */
public class StuLeiJson implements Serializable{

private String id;
private String name1;
private String clas;
private String score;



public StuLeiJson() {
	super();
}
public StuLeiJson( String id, String name1, String clas, String score) {
	super();

	this.id = id;
	this.name1 = name1;
	this.clas = clas;
	this.score = score;
}


public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName1() {
	return name1;
}
public void score(String name1) {
	this.name1 = name1;
}
public String getClas() {
	return clas;
}
public void setClas(String clas) {
	this.clas = clas;
}
public String getScore() {
	return score;
}
public void setScore(String score) {
	this.score = score;
}
	
	public void  show(){
		
		System.out.println("==================");
		System.out.println("名字："+getName1());
		System.out.println("分数："+getScore());
		System.out.println("班级："+getClas());
		System.out.println("编号："+getId());
	}
	
	
	
}
