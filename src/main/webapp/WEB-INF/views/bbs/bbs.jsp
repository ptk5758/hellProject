<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
	<h1>대충 자유게시판</h1>
	<div class="bbsMain">
		<div onclick="location.href='/bbs/notice'">1.공지사항</div>
		<div>2.운동게시판</div>
		<div onclick="location.href='/bbs/free'">3.자유게시판</div>
		<div>4.질문답변</div>
	</div>
<%@ include file="/WEB-INF/views/include/footer.jsp" %>