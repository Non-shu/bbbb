package com.yedam.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.vo.BoardVO;

/*
 * 추가, 수정, 삭제, 조회
 * Create,Read,Update,Delete - CRUD  
 */
public class BoardDAO extends DAO {
	
	//글 조회 수 증가.
	public void updateCount(int boardNo) {
		String sql = "update tbl_board set view_cnt = view_cnt + 1 where board_no = ?";
		try {
			psmt = getConnect().prepareStatement(sql);
			psmt.setInt(1, boardNo);
			psmt.executeUpdate(); //쿼리실행
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	// 상세조회. 글번호 => 전체정보 반환.
	public BoardVO getBoard(int boardNo) {
		String sql = "select * from tbl_board where board_no = ? ";
		try {
			psmt = getConnect().prepareStatement(sql);
			psmt.setInt(1, boardNo);
			rs = psmt.executeQuery();
			// 조회결과가 존재할 경우 
			if(rs.next()) {
				BoardVO board = new BoardVO();
				board.setBoardNo(rs.getInt("board_no"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWriter(rs.getString("writer"));
				board.setWriteDate(rs.getDate("write_date"));
				board.setViewCnt(rs.getInt("view_cnt"));
				//결과 변환
				return board;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return null; //조회결과 없음
	}// end of getBoard

	// 조회
	public List<BoardVO> selectBoard(){
		List<BoardVO> boardList = new ArrayList<>();
		String qry = "select * from tbl_board " //				
				+ "order by board_no";

		try {
			 psmt = getConnect().prepareStatement(qry);			
			 rs = psmt.executeQuery();
			// 조회결과.
			while (rs.next()) {
				BoardVO boar = new BoardVO();
				boar.setBoardNo(rs.getInt("board_no"));
				boar.setBoardContent(rs.getString("content"));
				boar.setBoardTitle(rs.getString("title"));
				boar.setBoardView(rs.getInt("view_Cnt"));
				boar.setBoardWriteDate(rs.getDate("write_Date"));
				boar.setBoardWriter(rs.getString("writer"));

				boardList.add(boar);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardList;		
	}// end of selectBoard
	//추가
	public boolean insertBoard(BoardVO board) {
		String sql = "insert into tbl_board (board_no, title, content, writer) values(board_seq.nextval, ?, ?, ?)";
		try {
			psmt = getConnect().prepareStatement(sql);
			psmt.setString(1, board.getTitle());
			psmt.setString(2, board.getContent());
			psmt.setString(3, board.getWriter());
			
			int r = psmt.executeUpdate(); //insert 실행.
			if(r>0) {
				return true; //정상등록
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false; //처리실패.		
	}
	//수정
	public boolean updateBoard(BoardVO board) {
		System.out.print(board.toString());
		String sql = "update tbl_board set title = ?, content = ? where = board_no = ? ";		
		try {
			psmt= getConnect().prepareStatement(sql);
			psmt.setString(1, board.getBoardTitle());
			psmt.setString(2, board.getBoardContent());
			psmt.setInt(3, board.getBoardNo());						
			
			int r = psmt.executeUpdate();
			if(r>0) {
				return true; //정상수정
			}			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;		
	}
	//삭제
	public boolean deleteBoard(int boardNo) {
		String query = "delete from tbl_board where board_no = ?";
		try {
			psmt = getConnect().prepareStatement(query);
			psmt.setInt(1, boardNo);
			
			int r = stmt.executeUpdate(query);
			if(r>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;		
	}
}
