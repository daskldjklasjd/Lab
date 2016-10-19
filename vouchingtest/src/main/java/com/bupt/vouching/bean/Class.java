package com.bupt.vouching.bean;

/**
 * 班级实体
 * 
 * @author Hogan
 * 
 */
public class Class {

	private String classId;
	private String name;
	private Integer isActive;

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

}
