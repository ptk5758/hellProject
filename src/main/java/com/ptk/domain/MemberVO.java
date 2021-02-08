package com.ptk.domain;

public class MemberVO implements User{
	
	private int uid;
	private String id;
	private String password;
	private String name;
	private String nickname;
	private int age;
	private String gender;
	private String email;
	private int level;
	
	@Override
	public String toString() {
		String result;
		result = "{";
		result += "\"uid\":\""+this.uid+"\",";
		result += "\"id\":\""+this.id+"\",";
		result += "\"password\":\""+this.password+"\",";
		result += "\"name\":\""+this.name+"\",";
		result += "\"nickname\":\""+this.nickname+"\",";
		result += "\"age\":\""+this.age+"\",";
		result += "\"gender\":\""+this.gender+"\",";
		result += "\"level\":\""+this.level+"\",";
		result += "\"email\":\""+this.email+"\"";
		result += "}";		
		return result;
	}	
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
