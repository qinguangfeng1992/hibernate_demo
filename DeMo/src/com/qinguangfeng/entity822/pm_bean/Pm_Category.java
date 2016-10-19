package com.qinguangfeng.entity822.pm_bean;
/**
 * 这个是对应  套图管理 的图片分类 表
 * @author Administrator
 *
 */
public class Pm_Category {
private String ID;
private String PM_CG_SYSUUID;
private String PM_NAME;
private String PM_MCH_ID;
private String PM_PIC_BIG_URL;
private String PM_PIC_SMALL_URL;
private String PM_FLAG;
private String PM_CREATE_USER_ID;
private String PM_CREATE_TIME;
private String PM_UPDATE_USER_ID;
private String PM_UPDATE_TIME;
private String PM_DEL;


@Override
public String toString() {
	return "ID=" + ID + ", PM_CG_SYSUUID=" + PM_CG_SYSUUID + ", PM_NAME=" + PM_NAME + ", PM_MCH_ID="
			+ PM_MCH_ID + ", PM_PIC_BIG_URL=" + PM_PIC_BIG_URL + ", PM_PIC_SMALL_URL=" + PM_PIC_SMALL_URL + ", PM_FLAG="
			+ PM_FLAG + ", PM_CREATE_USER_ID=" + PM_CREATE_USER_ID + ", PM_CREATE_TIME=" + PM_CREATE_TIME
			+ ", PM_UPDATE_USER_ID=" + PM_UPDATE_USER_ID + ", PM_UPDATE_TIME=" + PM_UPDATE_TIME + ", PM_DEL=" + PM_DEL
			;
}
public String getID() {
	return ID;
}
public void setID(String iD) {
	ID = iD;
}
public String getPM_CG_SYSUUID() {
	return PM_CG_SYSUUID;
}
public void setPM_CG_SYSUUID(String pM_CG_SYSUUID) {
	PM_CG_SYSUUID = pM_CG_SYSUUID;
}
public String getPM_NAME() {
	return PM_NAME;
}
public void setPM_NAME(String pM_NAME) {
	PM_NAME = pM_NAME;
}
public String getPM_MCH_ID() {
	return PM_MCH_ID;
}
public void setPM_MCH_ID(String pM_MCH_ID) {
	PM_MCH_ID = pM_MCH_ID;
}
public String getPM_PIC_BIG_URL() {
	return PM_PIC_BIG_URL;
}
public void setPM_PIC_BIG_URL(String pM_PIC_BIG_URL) {
	PM_PIC_BIG_URL = pM_PIC_BIG_URL;
}
public String getPM_PIC_SMALL_URL() {
	return PM_PIC_SMALL_URL;
}
public void setPM_PIC_SMALL_URL(String pM_PIC_SMALL_URL) {
	PM_PIC_SMALL_URL = pM_PIC_SMALL_URL;
}
public String getPM_FLAG() {
	return PM_FLAG;
}
public void setPM_FLAG(String pM_FLAG) {
	PM_FLAG = pM_FLAG;
}
public String getPM_CREATE_USER_ID() {
	return PM_CREATE_USER_ID;
}
public void setPM_CREATE_USER_ID(String pM_CREATE_USER_ID) {
	PM_CREATE_USER_ID = pM_CREATE_USER_ID;
}
public String getPM_CREATE_TIME() {
	return PM_CREATE_TIME;
}
public void setPM_CREATE_TIME(String pM_CREATE_TIME) {
	PM_CREATE_TIME = pM_CREATE_TIME;
}
public String getPM_UPDATE_USER_ID() {
	return PM_UPDATE_USER_ID;
}
public void setPM_UPDATE_USER_ID(String pM_UPDATE_USER_ID) {
	PM_UPDATE_USER_ID = pM_UPDATE_USER_ID;
}
public String getPM_UPDATE_TIME() {
	return PM_UPDATE_TIME;
}
public void setPM_UPDATE_TIME(String pM_UPDATE_TIME) {
	PM_UPDATE_TIME = pM_UPDATE_TIME;
}
public String getPM_DEL() {
	return PM_DEL;
}
public void setPM_DEL(String pM_DEL) {
	PM_DEL = pM_DEL;
}


	
	
	
	
	
	
	
	
	
	
	
	
}
