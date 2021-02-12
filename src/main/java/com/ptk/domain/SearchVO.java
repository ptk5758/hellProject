package com.ptk.domain;

public class SearchVO extends PageVO{
	
	private String selecttitle;
	private String inputvalue;
	
	
	
	public String getSelecttitle() {
		return selecttitle;
	}
	public void setSelecttitle(String selecttitle) {
		this.selecttitle = selecttitle;
	}
	
	public String getInputvalue() {
		return inputvalue;
	}
	public void setInputvalue(String inputvalue) {
		this.inputvalue = inputvalue;
	}
	
	public String getJSONString() {
		String result;
		result = "{\"page\":"+super.toString()+",";
		result += "\"search\":{";
		result += "\"selecttitle\":\""+this.selecttitle+"\",";
		result += "\"inputvalue\":\""+this.inputvalue+"\"";
		result += "}}";
		return result;
	}

}
