package com.ptk.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WeightVO {
	
	private int height;
	private int weight;
	private int age;
	private double bmi;
	private String bmi_status;
	private String gender;
	private String ip;
	private Date uploadDate;
	private String stringdate;
	private String user;
	
	@Override
	public String toString() {
		String result;
		
		result = "{";
		result += "\"height\":\""+this.height+"\",";
		result += "\"weight\":\""+this.weight+"\",";
		result += "\"age\":\""+this.age+"\",";
		result += "\"bmi\":\""+this.bmi+"\",";
		result += "\"bmi_status\":\""+this.bmi_status+"\",";
		result += "\"gender\":\""+this.gender+"\",";
		result += "\"uploadDate\":\""+this.uploadDate+"\",";
		result += "\"user\":\""+this.user+"\",";
		result += "\"ip\":\""+this.ip+"\"";
		result += "}";
		
		return result;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public double getBmi() {
		return bmi;
	}

	public void setBmi(double bmi) {
		this.bmi = bmi;
	}

	public String getBmi_status() {
		return bmi_status;
	}

	public void setBmi_status(String bmi_status) {
		this.bmi_status = bmi_status;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getStringdate() {
		return stringdate;
	}

	public void setStringdate(String stringdate) {
		this.stringdate = stringdate;
	}
	
	

}
