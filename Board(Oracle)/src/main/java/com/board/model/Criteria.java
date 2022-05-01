package com.board.model;

public class Criteria {
	// 이클래스는 페이징처리시에 쿼리문에 있는 where 조건부분을 처리해주는 클래스이다 
	// 당연히 PageMakerDTO 이전에 만드는것임 
	
	//현재 페이지번호 [1] [2] [3] 들을 말하는것 
	private int pageNum;
	
	//한 페이지에 보여질 글의 개수
	private int amount;
	
	// 기본 생성자를 이용해 초기 값을 지정해줌 
	public Criteria() {
		this(1,10);
	} //바로 아래에있는  다른 생성자에  this를 대입하는식으로 초기값 설정
	
	public Criteria(int pageNum, int amount) {
		this.pageNum =pageNum;
		this.amount = amount;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override 
	public String toString() { 
		return "Criteria [pageNum=" + pageNum + ", amount=" + amount + "]";
	}
	
	
	

}
