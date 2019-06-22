package com.spring.web.repository;

import java.util.*;

import org.springframework.stereotype.Repository;

import com.spring.web.model.ScoreVO;

//ScoreDAO클래스를 스프링 컨테이너에 빈으로 등록
@Repository
public class ScoreDAO implements IScoreDAO {
	
	//학생들의 점수정보를 저장할 리스트 생성
	private List<ScoreVO> scoreList = new ArrayList<>();

	@Override
	public void insertScore(ScoreVO scores) {
		System.out.println("DAO의 insert명령이 수행됨!");
		scoreList.add(scores);
		System.out.println("점수 데이터 저장 성공!");
	}

	@Override
	public List<ScoreVO> selectAllScores() {
		return scoreList;
	}

	@Override
	public void modifyScore() {
		
	}

	@Override
	public void deleteScore(int index) {
		scoreList.remove(index);
	}

}




