package com.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.mapper.BoardMapper;
import com.board.model.BoardVO;
import com.board.model.Criteria;
@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper mapper;
	
	@Override
	public void enroll(BoardVO board) {
		
		mapper.enroll(board);
		
	}
    //게시판 목록
	@Override
	public List<BoardVO> getList() {
		
		return mapper.getList();
	}
	
	// 게시판 목록(페이징 적용)
	@Override
	public List<BoardVO> getListPaging(Criteria cri){
		return mapper.getListPaging(cri);
	}
	
	//게시판 총갯수
	@Override
	public int getTotal() {
		return mapper.getTotal();
	}
	
	
	@Override
	public BoardVO getPage(Integer bno) {
				
		return mapper.getPage(bno);
	
	}
	
	@Override
	public int modify(BoardVO board) {
		return mapper.modify(board);
	}
	
	@Override
	public int delete(int bno) {
		return mapper.delete(bno);
	}
}
