package com.blog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.blog.model.BoardVO;
import com.blog.model.PageDTO;
import com.blog.model.PagingInform;
import com.blog.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	 private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	 
	  @Autowired
	    private BoardService bservice;
	  
	  
	  /* 페이징 처리한 게시판 목록 페이지 접속 */
	    @GetMapping("/list")
	    public void boardListGET(Model model, PagingInform pi) {
	        
	        log.info("boardListGET");
	        
	        model.addAttribute("list", bservice.getListPaging(pi));

	        PageDTO pagedto = new PageDTO(pi, bservice.getTotal(pi));
	        
	        model.addAttribute("pagedto", pagedto);
	    }
	    
	  /* 게시판 목록 페이지 */ 
//	 @GetMapping("/list")
//	    // => @RequestMapping(value="list", method=RequestMethod.GET)
//	    public void boardListGET(Model model) {
//	        
//	        log.info("게시판 목록 페이지 진입");
//	        model.addAttribute("list", bservice.getList());
//	    }
	    
	    /* 게시판 등록 페이지 */
	    @GetMapping("/enroll")
	    public void boardEnrollGET() {
	        
	        log.info("게시판 등록 페이지 진입");
	        
	    }
	    
	    /* 게시판 등록 */
	   @PostMapping("/enroll")
	    public String boardEnrollPOST(BoardVO board, RedirectAttributes rttr) {
	        
	        log.info("BoardVO : " + board);
	        
	        bservice.enroll(board);
	        
	        rttr.addFlashAttribute("result", "enrol success"); //일회성 전달
	        
	        return "redirect:/board/list";
	        
	    }
	   
	   /* 게시판 조회 */
	   @GetMapping("/getPage")
	   public void boardGetPageGET(int bno, Model model, PagingInform pi) {
		   
		   model.addAttribute("pageInfo", bservice.getPage(bno));
		   model.addAttribute("pi", pi);
		   
	   }
	 
	   /* 수정 페이지 이동 */
	    @GetMapping("/modify")
	    public void boardModifyGET(int bno, Model model, PagingInform pi) {
	        
	        model.addAttribute("pageInfo", bservice.getPage(bno));
	        model.addAttribute("pi", pi);
	    }
	    
	    /* 페이지 수정 */
	    @PostMapping("/modify")
	    public String boardModifyPOST(BoardVO board, RedirectAttributes rttr, PagingInform pi) {
	        
	        bservice.modify(board);
	        
	        rttr.addFlashAttribute("result", "modify success");
	        rttr.addAttribute("pageNum", pi.getPageNum());
	        rttr.addAttribute("amount", pi.getAmount());
	        rttr.addAttribute("keyword", pi.getKeyword());
	        rttr.addAttribute("type", pi.getType());
	        return "redirect:/board/list";
	        
	    }
	    
	    /* 페이지 삭제 */
	    @PostMapping("/delete")
	    public String boardDeletePOST(int bno, RedirectAttributes rttr,  PagingInform pi) {
	        
	        bservice.delete(bno);
	        
	        rttr.addFlashAttribute("result", "delete success");
	        
	        rttr.addAttribute("pageNum", pi.getPageNum());
	        rttr.addAttribute("amount", pi.getAmount());
	        rttr.addAttribute("keyword", pi.getKeyword());
	        rttr.addAttribute("type", pi.getType());
	        return "redirect:/board/list";
	    }
}
