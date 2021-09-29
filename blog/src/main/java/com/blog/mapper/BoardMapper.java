package com.blog.mapper;

import java.util.List;

import com.blog.model.BoardVO;
import com.blog.model.PagingInform;

public interface BoardMapper {
	
	public void enroll(BoardVO board); //게시판 등록
    public List<BoardVO> getList();      //게시판 목록 
    public BoardVO getPage(int bno);  //게시판 조회
    public int modify(BoardVO board); //게시판 수정
    public int delete(int bno); 				  //게시판 삭제
    public List<BoardVO> getListPaging(PagingInform pi);// 페이징처리한 게시판 목록 
    public int getTotal(PagingInform pi);						 // 게시판 게시물의 총 개수
}
