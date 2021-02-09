package com.ptk.domain;

public class NoticeVO implements Community{
	
	private int uid;
	private String user;
	private String subject;
	private String content;
	private String img;
	private String uploadDate;
	private String ip;
	private int ref;
	
	@Override
	public String toString() {
		String result;
		result = "{";
		result += "\"uid\":\""+this.uid+"\",";
		result += "\"subject\":\""+this.subject+"\",";
		result += "\"content\":\""+this.content+"\",";
		result += "\"img\":\""+this.img+"\",";
		result += "\"uploadDate\":\""+this.uploadDate+"\",";
		result += "\"ip\":\""+this.ip+"\",";		
		result += "\"ref\":\""+this.ref+"\"";
		result += "}";		
		return result;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}	
	
	

}
