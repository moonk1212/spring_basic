package com.spring.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.web.model.BoardVO;
import com.spring.web.service.IBoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private IBoardService service;
	
	//글 작성 화면 요청
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write() {
		System.out.println("/board/write : GET요청 발생!");
		return "board/board-write";
	}
	
	//글 작성 처리 요청
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(BoardVO article) {
		System.out.println("/board/write : POST요청 발생!");
		service.insertArticle(article);
		return "redirect:/board/list";
	}
	
	//글 목록 화면 요청
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(Model model) {
		System.out.println("/board/list : GET요청 발생!");
		model.addAttribute("articles", service.getArticles());
		return "board/board-list2";
	}
	
	//글 삭제 요청
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(@RequestParam("boardNo") int boardNo) {
		System.out.println("/board/delete?boardNo="+boardNo+" : GET요청 발생!");
		service.deleteArticle(boardNo);
		return "redirect:/board/list";
	}
	
	//글 내용보기 요청
	@RequestMapping(value="/content", method=RequestMethod.GET)
	public String content(@ModelAttribute("boardNo") int boardNo
			, Model model) {
		System.out.println("/board/content?boardNo="+boardNo+" : GET요청 발생!");
		
		model.addAttribute("content", service.getContent(boardNo));
		return "board/board-content";
	}
	
	//글 수정하기 화면요청
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public String modify(@ModelAttribute("boardNo") int boardNo
			, Model model) {
		System.out.println("/board/modify?boardNo="+boardNo+" : GET요청 발생!");
		
		model.addAttribute("content", service.getContent(boardNo));
		return "board/board-modify";
	}
	
	//글 수정 처리요청
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(BoardVO article, 
			@RequestParam("boardNo") int boardNo) {
		System.out.println("/board/modify?boardNo="+boardNo+" : POST요청 발생!");
		service.modifyArticle(article, boardNo);
		return "redirect:/board/list";
	}

}






