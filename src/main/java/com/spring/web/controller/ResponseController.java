package com.spring.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.web.model.UserVO;

@Controller
@RequestMapping("/response")
public class ResponseController {

	@RequestMapping("/res")
	public String showEx01() {
		return "response/res-ex01";
	}

	//Model객체를 사용하여 화면에 데이터 전송하기
	@RequestMapping("/page01")
	public void page01(HttpServletRequest req, Model model) {
		System.out.println("/response/page01 요청이 들어옴!");
		model.addAttribute("nickname", "뽀삐");
		model.addAttribute("age", req.getParameter("age"));
	}


	//ModelAndView객체를 사용하여 화면에 데이터 전송하기
	@RequestMapping("/page02")
	public ModelAndView page02() {
		System.out.println("/response/page02 요청이 들어옴!");
		ModelAndView mv = new ModelAndView();
		mv.addObject("userName", "최영희");
		mv.setViewName("/response/page02");
		return mv;
	}

	//@ModelAttribute 사용하기 - view에서 전달받은 값을
	// 다른 view에서 사용할 경우
	@RequestMapping("/page03")
	public String page03(@ModelAttribute("page") String pageNum) {
		System.out.println("/response/page03 요청이 들어옴!");
		System.out.println("전달된 페이지 번호: " + pageNum + "번");
		return "response/page03";
	}

	///////////////////////////////////////////////////

	//퀴즈
	//퀴즈화면처리
	@RequestMapping(value="/res-quiz")
	public void res_quiz01() {
//		return "response/res-quiz";
	}

	//커맨드객체와  Model을 사용한 방식
	/*@RequestMapping("/res-login")
	public String res_param(UserVO vo, Model model) {
		String id = vo.getUserId();
		String pw = vo.getUserPw();

		model.addAttribute("userId", id); //아이디를 모델에 추가
		if(id.equals("kim123") && pw.equals("kkk1234")) {
			return "response/res-quiz-success";
		} else {
			return "response/res-quiz-fail";
		}
	}*/
	
	//@ModelAttribute를 사용한 방식
	@RequestMapping("/res-login")
	public String res_param(@ModelAttribute("userId") String id
							, @RequestParam("userPw") String pw) {
		
				
		if(id.equals("kim123") && pw.equals("kkk1234")) {
			return "response/res-quiz-success";
		} else {
			return "response/res-quiz-fail";
		}
	}
	
	/////////////////////////////////////
	
	//Redirect 처리
	//로그인 화면 처리
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		
		return "response/res-redirect-form";
	}
	
	//로그인 검증 처리
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@ModelAttribute("userId") String id
			, @RequestParam("userPw") String pw
			, @RequestParam("userPwChk") String pwChk
			, RedirectAttributes ra) {
		
		System.out.println("id정보: " + id);
		System.out.println("pw정보: " + pw);
		System.out.println("pwChk정보: " + pwChk);
		
		if(id.equals("")) {
			//ra.addFlashAttribute("msg", "아이디를 입력하세요!");
			ra.addFlashAttribute("msg", "idEmpty");
			return "redirect:/response/login";
		} else if(!pw.equals(pwChk)) {
			//ra.addFlashAttribute("msg", "비밀번호 확인란을 체크하세요!");
			ra.addFlashAttribute("msg", "pwFail");
			return "redirect:/response/login";
		} else if(id.equals("abc123") && pw.equals("1234")) {
			return "response/res-quiz-success";
		} else {
			return null;
		}
	}

}










