package com.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.web.model.ScoreVO;
import com.spring.web.repository.IScoreDAO;

//서비스 클래스를 스프링 컨테이너에 빈으로 등록
@Service
public class ScoreService implements IScoreService {
	
	@Autowired
	private IScoreDAO dao;
	
	@Override
	public void insertScoreProcess(ScoreVO scores) {
		scores.calcData();
		dao.insertScore(scores);
	}

	@Override
	public List<ScoreVO> selectAllScores() {
		return dao.selectAllScores();
	}

	@Override
	public void modifyScore() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteScore(int stuNo) {
		int idx = stuNo - 1;
		dao.deleteScore(idx);
	}

}





