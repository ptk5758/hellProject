<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
	<h1>대충 자유게시판</h1>
	<div class="bbsMain">
		<div>1.글</div>
		<div>2.게시물</div>
		<div>3.내용</div>
		<div>4.응응변</div>
	</div>
	<h1 onclick="location.href='/bbs/free/posting'">글쓰기</h1>
<%@ include file="/WEB-INF/views/include/footer.jsp" %>
