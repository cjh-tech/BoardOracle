package com.board.mapper;

import java.util.List;

import com.board.model.BoardVO;
import com.board.model.Criteria;
	
	// BoardMapper 가 BoardMapper.xml과 연동됨 마이바티스로 연동 메서드 이름
public interface BoardMapper {
	/* 게시판 등록 */
    public void enroll(BoardVO board);
    
    // 게시판 목록   게시판은 list로 주는듯함 
    public List<BoardVO> getList();
    
    /* 게시판 목록 페이징 적용 pagenum, amount    criteria부분*/
    public List<BoardVO> getListPaging(Criteria cri);
        
    // 게시판글 총 갯수
    public int getTotal();
    
    
    // 게시판 조회
    public BoardVO getPage(int bno); 
    
    // 게시판 수정
    public int modify(BoardVO board);
    
    // 게시판 삭제
    public int delete(int bno);
        
    
}
