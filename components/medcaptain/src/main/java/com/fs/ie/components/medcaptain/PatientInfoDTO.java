package com.fs.ie.components.medcaptain;

import java.io.Serializable;

public class PatientInfoDTO implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -523482513027639181L;
	
	private String inpatientNo;
	
	private String name;
	
	private int gender;
	
	private String genderType;
	
	private int age;
	
	private float height;
	
	private float weight;
	
	private int type;
	
	private String patientType;
	
	private String department;
	
	private String room;
	
	private String bed;

	private String order;
	
	public String getInpatientNo() {
		return inpatientNo;
	}
	
	public void setInpatientNo(String inpatientNo) {
		this.inpatientNo = inpatientNo;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getGender() {
		return gender;
	}
	
	public void setGender(int gender) {
		this.gender = gender;
	}
	
	public String getGenderType() {
		return genderType;
	}
	
	public void setGenderType(String genderType) {
		this.genderType = genderType;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public float getHeight() {
		return height;
	}
	
	public void setHeight(float height) {
		this.height = height;
	}
	
	public float getWeight() {
		return weight;
	}
	
	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	public int getType() {
		return type;
	}
	
	public void setType(int type) {
		this.type = type;
	}
	
	public String getPatientType() {
		return patientType;
	}
	
	public void setPatientType(String patientType) {
		this.patientType = patientType;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String getRoom() {
		return room;
	}
	
	public void setRoom(String room) {
		this.room = room;
	}
	
	public String getBed() {
		return bed;
	}
	
	public void setBed(String bed) {
		this.bed = bed;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}
}
