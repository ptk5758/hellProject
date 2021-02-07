package com.ptk.domain;

public class PageVO {
	
	private int pagecut; // 페이지 리미트
	private int nowpage; // 현재 페이지
	private int limitstart; // 보여줄 게시물 0,5 10,5
	private int totallist; // 총 게시물수
	private int totalpage; // 총 페이지수 
	
	public PageVO() {
		this.pagecut = 5;
		this.nowpage = 1;
	}

	public int getPagecut() {
		return pagecut;
	}

	public void setPagecut(int pagecut) {
		this.pagecut = pagecut;
	}

	public int getNowpage() {
		return nowpage;
	}

	public void setNowpage(int nowpage) {
		this.nowpage = nowpage;
	}

	public int getLimitstart() {
		return limitstart;
	}

	public void setLimitstart(int limitstart) {
		this.limitstart = limitstart;
	}

	public int getTotallist() {
		return totallist;
	}

	public void setTotallist(int totallist) {
		this.totallist = totallist;
	}

	public int getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	
	@Override
	public String toString() {
		String result;
		result = "{";
		result += "\"pagecut\":\""+this.pagecut+"\",";
		result += "\"nowpage\":\""+this.nowpage+"\",";
		result += "\"limitstart\":\""+this.limitstart+"\",";
		result += "\"totallist\":\""+this.totallist+"\",";
		result += "\"totalpage\":\""+this.totalpage+"\"";
		result += "}";
		return result;
	}
}
