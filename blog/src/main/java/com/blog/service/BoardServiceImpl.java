package com.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.mapper.BoardMapper;
import com.blog.model.BoardVO;
import com.blog.model.PagingInform;

@Service
public class BoardServiceImpl implements BoardService {

		@Autowired
		private BoardMapper mapper;
		
		@Override
		public void enroll(BoardVO board) {
			
			mapper.enroll(board);
			
		}
		
		  @Override
		    public List<BoardVO> getList() {
		        
		        return mapper.getList();
		    }

		@Override
		public BoardVO getPage(int bno) {
			
			return mapper.getPage(bno);
		}
		
		@Override
	    public int modify(BoardVO board) {
	        
	        return mapper.modify(board);
	    }
		
		 @Override
		    public int delete(int bno) {
		        
		        return mapper.delete(bno);
		    }    
		
		 /* 페이징처리한 게시판 목록 */
		    @Override
		    public List<BoardVO> getListPaging(PagingInform pi) {
		        
		        return mapper.getListPaging(pi);
		    }    
		    
		    /* 게시물 총 갯수 */
		    @Override
		    public int getTotal(PagingInform pi) {
		        
		        return mapper.getTotal(pi);
		    }    
}
