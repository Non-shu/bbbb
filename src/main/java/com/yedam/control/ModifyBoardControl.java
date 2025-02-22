package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.BoardDAO;
import com.yedam.vo.BoardVO;

public class ModifyBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		int bno = req.getParameter("board_no");
		
		//매개값으로 활용.
		BoardVO bvo = new BoardVO();
		bvo.setBoardTitle(title);
		bvo.setBoardContent(content);
		bvo.setBoardNo(bno);
		
		BoardDAO bdao = new BoardDAO();
		if(bdao.insertBoard(bvo)) {
			//forward (매개값 활용) & redirect (매개값을 전달못함)
			resp.sendredirect("boardList.do");
			System.out.println("성공");			
		}else{
			System.out.println("실패.");
		}
		
	} 
	
}
