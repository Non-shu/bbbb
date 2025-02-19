<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="includes/header.jsp"></jsp:include>
<h3>수정페이지(modifyBoard.jsp)</h3>
<%
BoardVO board = (BoardVO) request.getAttribute("board");
%>
<form action="modifyBoard.do">
<input type = "hidden" name ="bno" value="<%=board.getBoardNo()%>">
<table class="table">
	<tr>
		<th>글 번호</th>
		<td><%=board.getBoardNo()%></td>
		<th>조회수</th>
		<td><%=board.getBoardView()%></td>
	</tr>
	<tr>
		<th>제 목</th>
		<td colspan="3"><input type="text" class="form-control"
			value="<%=board.getBoardTitle()%> "></td>
	</tr>
	<tr>
		<th>내 용</th>
		<td colspan="3">
		<textarea cols="45" rows="3" class="form-control"><%=board.getContent()%></textarea>
		</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td><%=board.getBoardWriter()%></td>
		<th>작성일시</th>
		<td><%=board.getBoardWriteDate()%></td>
	</tr>
	<tr>
	<td colspan="3" align ="center">
 	<button class = "btn btn-success" type = "submit">수정하기</button>
 	<button class = "btn btn-dark" type = "button">돌아가기</button>
</td>
</tr>
</table>
</form>
<jsp:include page="includes/footer.jsp"></jsp:include>