package com.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.web.model.BirthVO;

@Controller
@RequestMapping("/quiz")
public class QuizController {

	@RequestMapping("/birth")
	public String birthForm() {
		return "quiz/birth-form";
	}

	//1st	
	@RequestMapping("/sendBirth") //폼전송 맵핑	
	public String sendBirth(BirthVO birth, Model model) {

		String birthDay = birth.getYear() + birth.getMonth() + birth.getDay();
		System.out.println(birthDay);

		model.addAttribute("birth", birth);

		return "quiz/birth-result";
	}

}







