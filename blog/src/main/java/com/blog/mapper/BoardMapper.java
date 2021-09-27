package com.blog.mapper;

import java.util.List;

import com.blog.model.BoardVO;

public interface BoardMapper {
	
	public void enroll(BoardVO board); //게시판 등록
    public List<BoardVO> getList();     //게시판 목록 
}
