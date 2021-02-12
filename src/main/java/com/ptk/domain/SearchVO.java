package com.ptk.domain;

public class SearchVO extends PageVO{
	
	private String title;
	private String value;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getJSONString() {
		String result;
		result = "{\"page\":"+super.toString()+",";
		result += "{";
		result += "\"title\":\""+this.title+"\",";
		result += "\"value\":\""+this.value+"\"";
		result += "}";
		return result;
	}

}
