package com.blog.model;

import java.util.Arrays;

public class PagingInform {
	private int pageNum;    		   //현재 페이지
	private int amount;    	   		   // 각 페이지 마다 보여줄 게시물 개수
	private String keyword; 		   // 검색 키워드
	private String type; 	   		   // 검색 타입
	private String[] typeArr; 	   // 검색 타입 배열
	
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
	
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
		this.typeArr = type.split("");
	}

	public String[] getTypeArr() {
		return typeArr;
	}

	public void setTypeArr(String[] typeArr) {
		this.typeArr = typeArr;
	}

	@Override
	public String toString() {
		return "PagingInform [pageNum=" + pageNum + ", amount=" + amount + ", keyword=" + keyword + ", type=" + type
				+ ", typeArr=" + Arrays.toString(typeArr) + "]";
	}

}
