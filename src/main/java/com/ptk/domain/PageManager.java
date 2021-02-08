package com.ptk.domain;

public class PageManager {
	
	private PageVO page;
	
	public PageManager(PageVO page) {
		this.page = page;
		init();
	}
	
	private void init() {
		//page.setTotallist(20);//임시 총 게시물수
		page.setTotalpage((int)Math.ceil(page.getTotallist()/page.getPagecut()));
		
		if(page.getNowpage() <= 0) {
			page.setNowpage(1);
		}
		
		if(page.getNowpage() > page.getTotalpage()) {
			page.setNowpage(page.getTotalpage());
		}
		//(object.getNowPage()*object.getPageCut())-object.getPageCut()
		page.setLimitstart((page.getNowpage()*page.getPagecut())-page.getPagecut());
	}
	
	public PageVO getPage() {
		return this.page;
	}

}
