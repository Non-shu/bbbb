<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <jsp:include page="includes/header.jsp"></jsp:include>
 
 <!--  html 주석문. -->
 
 <%  // <%안에는 자바코드 입력가능
 String msg = "Hello";
 System.out.println(msg);
 // boardList.do -> request -> boardList.jsp
 String result = (String) request.getAttribute("msg");
 List<BoardVO> list = (List<BoardVO>) request.getAttribute("list");
 %>
 <p>msg의 값은 <%=result %></p>
 <h3>게시글 목록</h3>
 <table class = "table table-active" >
 <thead>
 <tr>
 <th>글번호</th><th>제목</th><th>작성자</th><th>작성일시</th><th>조회수</th>
 </tr>
 </thead>
 	<tbody>
 <%
 for(BoardVO board : list) {
 %>
	<tr>
		<td><%=board.getBoardNo() %></td>
		<td><a href="board.do?bno=<%=board.getBoardNo() %>"><%=board.getBoardTitle() %></a></td>
		<td><%=board.getBoardWriter() %></td>
		<td><%=board.getBoardWriteDate() %></td>
		<td><%=board.getBoardView() %></td>
	</tr>
 <%
 } // for 종료
 %>
	</tbody> 	
  </table>
 <jsp:include page="includes/footer.jsp"></jsp:include>
