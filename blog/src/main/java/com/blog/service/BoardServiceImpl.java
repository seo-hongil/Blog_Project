package com.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.mapper.BoardMapper;
import com.blog.model.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

		@Autowired
		private BoardMapper mapper;
		
		@Override
		public void enroll(BoardVO board) {
			
			mapper.enroll(board);
			
		}

}