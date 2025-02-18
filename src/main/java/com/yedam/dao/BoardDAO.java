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
		
		return false;		
	}
	//수정
	public boolean updateBoard(BoardVO board) {
		
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
