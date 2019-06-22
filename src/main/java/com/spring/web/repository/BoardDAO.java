package com.spring.web.repository;

import java.util.*;
import org.springframework.stereotype.Repository;

import com.spring.web.model.BoardVO;

@Repository
public class BoardDAO implements IBoardDAO {

	private List<BoardVO> articles = new ArrayList<>();

	@Override
	public List<BoardVO> getArticles() {		
		return articles;
	}

	@Override
	public void insertArticle(BoardVO article) {
		articles.add(article);
		System.out.println(article);
		System.out.println("게시글 저장 완료!!");		
	}

	@Override
	public void deleteArticle(int index) {
		articles.remove(index);
		System.out.println((index+1)+"번 게시글 삭제 완료!!");
	}

	@Override
	public BoardVO getContent(int index) {
		return articles.get(index);
	}

	@Override
	public void modifyArticle(BoardVO article, int index) {
		articles.set(index, article);
		System.out.println((index+1)+"번 게시글 수정 완료!!");
	}
	
}




