package com.yedam.control;

import java.io.IOException;

import com.yedam.dao.BoardDAO;
import com.yedam.vo.BoardVO;

public class RemoveBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int bno = req.getParameter("board_no");
		
		BoardVO bvo = new BoardVO();
		bvo.setBoardNo(bno);
		
		BoardDAO bdao = new BoardDAO();
		if(bdao.insertBoard(bvo)) {
			bvo = null;			
			System.out.println("성공");			
		}else{
			System.out.println("실패.");
		}
		
	}

}
