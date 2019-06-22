package com.spring.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.web.model.ScoreVO;
import com.spring.web.service.IScoreService;

@Controller
@RequestMapping("/score")
public class ScoreController {

	@Autowired
	private IScoreService service;

	//점수 등록화면을 열어주는 요청
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String register() {
		System.out.println("/score/register GET요청 발생!");
		return "score/score-form";
	}

	//실제로 점수데이터를 등록해주는 요청
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(ScoreVO scores, RedirectAttributes ra) {
		System.out.println("/score/register POST요청 발생!");

		service.insertScoreProcess(scores);
		ra.addFlashAttribute("msg", "insertSuccess");
		return "redirect:/score/list";
	}

	//점수데이터 목록보기 요청
	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("scores", service.selectAllScores());
		return "score/score-list";
	}

	//점수 삭제 요청
	@RequestMapping("/delete")
	public String deleteScore(
			@RequestParam("stuNo") int stuNo) {
		service.deleteScore(stuNo);
		return "redirect:/score/list";
	}

}








