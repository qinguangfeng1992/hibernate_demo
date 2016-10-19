package com.qinguangfeng.entity820;

/**
 * 这是封装类，是我的数据库studb里的 年级表 的封装类
 * 
 * @author Administrator
 *
 */
public class Grade_JavaBean {
	private int gradeId;
	private String gradeName;

	public Grade_JavaBean() {

	}

	public Grade_JavaBean(int gradeId, String gradeName) {

		this.gradeId = gradeId;
		this.gradeName = gradeName;
	}

	public int getGradeId() {
		return gradeId;
	}

	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	@Override
	public String toString() {
	
		return gradeId +"\t"+ gradeName ;
	}
	

}
