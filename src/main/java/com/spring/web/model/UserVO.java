package com.spring.web.model;

import java.util.List;

//자바빈 객체를 통한 파라미터 처리 클래스
public class UserVO {
	
	private String userId;
	private String userPw;
	private String userName;
	private List<String> hobby;	
	
	
	//커맨드 객체는 반드시 기본생성자와 setter/getter가 필수!
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<String> getHobby() {
		return hobby;
	}
	public void setHobby(List<String> hobby) {
		this.hobby = hobby;
	}
	
	
	
	

}





