<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
	<h1>대충 자유게시판 업로드</h1>
	<div>
		<div><input placeholder="재목" name="subject"></div>	
		<div><textarea placeholder="내용" name="content"></textarea></div>
		<div><input type="file" name="img" id="myimg" accept="image/*"></div>		
	</div>
	<div><button onclick="postingdo()">전송Ajax</button></div>
	<script src="/js/free/freeposting.js?ver=1"></script>
<%@ include file="/WEB-INF/views/include/footer.jsp" %>
