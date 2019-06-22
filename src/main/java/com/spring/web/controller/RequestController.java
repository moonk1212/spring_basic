package com.spring.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.web.model.UserVO;

//자동으로 스프링 설정파일에 해당 클래스의 빈을 등록.
@Controller
@RequestMapping("/request")
public class RequestController {

	//RequestMapping은 어떤 Url로 이 메서드를 동작시킬 것인가에 대한 설정입니다.
	@RequestMapping("/test")
	public String callTest() {
		System.out.println("/request/test 요청이 들어옴!");
		return "test";
	}

	//만약 /request/req 요청이 들어왔을 때
	//view폴더 아래에 있는 request폴더 아래에 
	//req-ex01.jsp파일을 열도록 메서드를 구성해보세요
	@RequestMapping("/req")
	public String req() {
		System.out.println("/request/req 요청이 들어옴!");
		return "request/req-ex01";
	}

	@RequestMapping(value="/basic01", method=RequestMethod.GET)
	public String basic01Get() {
		System.out.println("/request/basic01 GET요청이 들어옴!");
		return "request/req-ex01";
	}

	@RequestMapping(value="/basic01", method=RequestMethod.POST)
	public String basic01Post() {
		System.out.println("/request/basic01 POST요청이 들어옴!");
		return "request/req-ex01";
	}

	///////////////////////////////////////////////

	/*
	  url : /request/join -> GET방식
	  view: /request/req-ex02.jsp
	  methodName: join()
	 */
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		System.out.println("/request/join GET요청이 들어옴!");
		return "request/req-ex02";
	}


	/*
	 # 1. 전통적인 방식의 파라미터 처리(request객체 이용)
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(HttpServletRequest request) throws Exception {
		System.out.println("/request/join POST요청이 들어옴!");
		System.out.println("ID: " + request.getParameter("userId"));
		System.out.println("PW: " + request.getParameter("userPw"));
		return "request/req-ex02";
	}*/

	/*
	 # 2. @RequestParam 아노테이션을 이용한 요청 파라미터 처리.

	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(@RequestParam("userId") String id, 
			@RequestParam("userPw") String pw, 
			@RequestParam(value="hobby", required=false, defaultValue="취미도 없는 사람") List<String> hobby) throws Exception {
		System.out.println("/request/join POST요청이 들어옴!");

		System.out.println("ID: " + id);
		System.out.println("PW: " + pw);
		System.out.println("HOBBYS: " + hobby);

		return "request/req-ex02";

	}*/

	//3. 커맨드 객체를 활용한 파라미터 처리.
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(UserVO user) throws Exception {
		System.out.println("/request/join POST요청이 들어옴!");

		System.out.println("ID: " + user.getUserId());
		System.out.println("PW: " + user.getUserPw());
		System.out.println("NAME: " + user.getUserName());
		System.out.println("HOBBYS: " + user.getHobby());

		return "request/req-ex02";

	}

	///////////////////////////////////////////

	//req-quiz 정답
	@RequestMapping(value="/quiz", method=RequestMethod.GET)
	public String quiz() {
		return "/request/req-quiz";
	}

	/*@RequestMapping(value="/quiz", method=RequestMethod.POST)
	public String quiz(@RequestParam("userId") String id,
			@RequestParam("userPw") String pw) {

		if(id.equals("abc1234") && pw.equals("xxx4321"))
			return "request/login-success";
		else
			return "request/login-fail";
	}*/
	
	@RequestMapping(value="/quiz", method=RequestMethod.POST)
	public String quiz(UserVO user) {

		if(user.getUserId().equals("abc1234") 
				&& user.getUserPw().equals("xxx4321"))
			return "request/login-success";
		else
			return "request/login-fail";
	}

}







