package com.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.board.model.BoardVO;
import com.board.model.Criteria;
import com.board.model.PageMakerDTO;
import com.board.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService bservice;
	/* 게시판 목록 페이지 접속  페이징 되면 남겨두면 안됨
	@GetMapping("/list")
	public void boardListGET(Model model) {
		log.info("게시판 목록 진입");
		model.addAttribute("list", bservice.getList());
	}*/
	
	// 일부 페이징처리된 부분임 위와 바뀐부분은 getListPaging(cri) 의 cri도 있지만 쿼리자체가 달라짐
	/*@GetMapping("/list")
	public void boardListGET(Model model, Criteria cri, HttpServletRequest request) {
		log.info("boarList페이징");
		log.info(request.getParameter("pageNum"));
		log.info(request.getParameter("amount")); // get방식으로 받는것은 다 확인함 
		
		// 내가 중간에 cri의 set을 써서 받아준 파라미터가 없지만 자동처리가 됨		
		System.out.println(cri.getPageNum());
		System.out.println(cri.getAmount());
		model.addAttribute("list", bservice.getListPaging(cri));
	}*/
	
	 /* 게시판 목록 페이지 접속(페이징 적용) */
    @GetMapping("/list")
    public void boardListGET(Model model, Criteria cri) {
        
        log.info("boardListGET");
        
        // 게시판 목록임 get방식으로 온 값들 처리해줌
        model.addAttribute("list", bservice.getListPaging(cri));
        
        int total = bservice.getTotal(); // 게시글 총갯수 가져옴 
        
        //페이징 메이커에  cri total 보내줌
        PageMakerDTO pageMake = new PageMakerDTO(cri, total);
        
        //pageMake에 담긴 값들있음  필요한 pageMaker줌
        model.addAttribute("pageMaker", pageMake);
        
    }    
	
	@GetMapping("/enroll")
	public void boardEnrollGET() {
		log.info("게시판 등록 페이지 진입");
	}
		
	// 게시판 등록 
	@PostMapping("/enroll")      // BoardVO board에 enroll에서 넘어온 값들이 자동으로 들어가짐 
	public String boardEnrollPOST(BoardVO board,RedirectAttributes rttr) {
		
		log.info("BoardVO :" + board );
		
		bservice.enroll(board);
		
		rttr.addFlashAttribute("result", "enroll success");
		
		return "redirect:/board/list";
	}
	
	// 게시판 조회
	@GetMapping("/get")
	public void boardGetPageGET(Integer bno, Model model) {
		
		model.addAttribute("pageInfo", bservice.getPage(bno));
	}
	
	/*수정 페이지 이동 */
	@GetMapping("/modify")
	public void boardModifyGET(int bno, Model model) {
		model.addAttribute("pageInfo", bservice.getPage(bno));
	}
	
	@PostMapping("/modify")
	public String boardModifyPost(BoardVO board, RedirectAttributes rttr) {
		
		bservice.modify(board);
		
		rttr.addFlashAttribute("result", "modify success");
		
		return "redirect:/board/list";
	}
	
	/*게시글 삭제*/
	@PostMapping("/delete")
	public String boardDeletePOST(int bno, RedirectAttributes rttr) {
		bservice.delete(bno);
		
		rttr.addFlashAttribute("result", "delete success");
		
		return "redirect:/board/list";
	}
	
}
