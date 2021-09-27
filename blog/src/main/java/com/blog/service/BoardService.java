package com.blog.service;

import java.util.List;

import com.blog.model.BoardVO;

public interface BoardService {
	
    public void enroll(BoardVO board); //게시판 등록
    public List<BoardVO> getList();      // 게시판 목록 
    public BoardVO getPage(int bno);  //게시판 조회
}
