package com.blog.model;

public class PagingInform {
	private int pageNum; //현재 페이지
	private int amount;    // 각 페이지 마다 보여줄 게시물 개수
	
	//기본 생성자
	public PagingInform() {
		this(1,10); //기본값 : 1페이지당 10개의 게시물씩
		
	}
	
	public PagingInform(int pageNum, int amount) {
		super();
		this.pageNum = pageNum;
		this.amount = amount;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "PageInform [pageNum=" + pageNum + ", amount=" + amount + "]";
	}
	
}
