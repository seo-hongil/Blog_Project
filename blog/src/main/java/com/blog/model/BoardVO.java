package com.blog.model;

import java.util.Date;

public class BoardVO {

	    private int bno; 					//게시판 번호 
	    private String title; 				//게시판 제목
	    private String content; 		//게시판 내용
	    private String writer;			//게시판 작성자
	    private Date regdate; 			//등록일
	    private Date updateDate;  //수정일
	 

		public int getBno() {
			return bno;
		}

		public void setBno(int bno) {
			this.bno = bno;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public String getWriter() {
			return writer;
		}

		public void setWriter(String writer) {
			this.writer = writer;
		}

		public Date getRegdate() {
			return regdate;
		}

		public void setRegdate(Date regdate) {
			this.regdate = regdate;
		}

		public Date getUpdateDate() {
			return updateDate;
		}

		public void setUpdateDate(Date updateDate) {
			this.updateDate = updateDate;
		}
		
		 
	    @Override
		public String toString() {
			return  "BoardVO [bno=" + bno + ", title=" + title + ", content=" + content + ", writer=" + writer
					+ ", regdate=" + regdate + ", updateDate=" + updateDate + "]";
		}
		
	}

