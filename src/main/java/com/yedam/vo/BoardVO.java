package com.yedam.vo;

import java.util.Date;

public class BoardVO { // tbl_board
	private int boardNo; //게시글 board_no
	private String title; // 제목 title
	private String content;// 내용 content
	private String writer;// 작성자 writer
	private Date writeDate; // 작성일자 write_date
	private int viewCnt; // 조회수 view_cnt
	
	public BoardVO() {}
	
	public BoardVO(int boardNo, String boardTitle, String boardContent, String boardWriter, Date boardWriteDate,
			int boardView) {
		super();
		this.boardNo = boardNo;
		this.title = boardTitle;
		this.content = boardContent;
		this.writer = boardWriter;
		this.writeDate = boardWriteDate;
		this.viewCnt = boardView;
	}
	
	public int getBoardNo() {
		return boardNo;
	}
	public String getBoardTitle() {
		return title;
	}
	public String getBoardContent() {
		return content;
	}
	public String getBoardWriter() {
		return writer;
	}
	public Date getBoardWriteDate() {
		return writeDate;
	}
	public int getBoardView() {
		return viewCnt;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public void setBoardTitle(String boardTitle) {
		this.title = boardTitle;
	}
	public void setBoardContent(String boardContent) {
		this.content = boardContent;
	}
	public void setBoardWriter(String boardWriter) {
		this.writer = boardWriter;
	}
	public void setBoardWriteDate(Date boardWriteDate) {
		this.writeDate = boardWriteDate;
	}
	public void setBoardView(int boardView) {
		this.viewCnt = boardView;
	}
	
	
	
}
