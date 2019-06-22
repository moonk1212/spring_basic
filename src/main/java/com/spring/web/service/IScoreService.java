package com.spring.web.service;

import java.util.List;

import com.spring.web.model.ScoreVO;

public interface IScoreService {

	//점수 저장 기능.
	void insertScoreProcess(ScoreVO scores);
	//점수 전체 조회 기능
	List<ScoreVO> selectAllScores();
	//점수 수정 기능
	void modifyScore();
	//점수 삭제 기능
	void deleteScore(int stuNo);
	

}
