package com.blog.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.blog.model.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardMapperTest {
	  private static final Logger log = LoggerFactory.getLogger(BoardMapperTest.class);
	     
	     @Autowired
	     private BoardMapper mapper;
	     
	     /* 게시판 조회 테스트 */ 
	     @Test
	     public void testGetPage() {
	        
	         int bno = 8;
	         
	         log.info("" + mapper.getPage(bno));
	         
	     }
	     
	     /* 목록 출력 테스트 */
//	     @Test
//	     public void testGetList() {
//	    	 List list = mapper.getList();
//	    	 
//	    	 for(Object a : list) {
//	             log.info("" + a);
//	         }
//	     }
	     
	     /* 등록 테스트 */
//	     @Test
//	     public void testEnroll() {
//	         
//	         BoardVO vo = new BoardVO();
//	         
//	         vo.setTitle("mapper test");
//	         vo.setContent("mapper test");
//	         vo.setWriter("mapper test");
//	         
//	         mapper.enroll(vo);
//	         
//	     }
}
