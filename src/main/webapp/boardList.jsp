<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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
 <table border="2">
 	<tbody>
 <%
 for(BoardVO board : list) {
 %>
	<tr>
		<td><%=board.getBoardNo() %></td>
		<td><%=board.getBoardTitle() %></td>
		<td><%=board.getBoardWriter() %></td>
		<td><%=board.getBoardWriteDate() %></td>
		<td><%=board.getBoardView() %></td>
	</tr>
 <%
 } // for 종료
 %>
	</tbody> 	
  </table>
</body>
</html>