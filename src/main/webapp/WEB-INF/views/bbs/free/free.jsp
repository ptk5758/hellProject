<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
<link rel="stylesheet" type="text/css" href="/css/bbs.css">	
	<div class="freeMain">
		<h1>대충 자유게시판</h1>
		<div class="freeBoard">
			<div class="freeBoardList listtop">
				<div class="freeBoardList_Num">No</div>
				<div class="freeBoardList_Subject">제목</div>
				<div class="freeBoardList_User">유저</div>
				<div class="freeBoardList_Date">날짜</div>				
				<div class="freeBoardList_Ref">조회수</div>
				<div class="freeBoardList_Like">추천</div>
			</div>
			<div class="freeBoardList">
				<div class="freeBoardList_Num">1</div>
				<div class="freeBoardList_Subject">니하는플레이보이</div>				
				<div class="freeBoardList_User">유저</div>
				<div class="freeBoardList_Date">2021-02-10</div>
				<div class="freeBoardList_Ref">23</div>
				<div class="freeBoardList_Like">2</div>
			</div>
		</div>
	</div>
	<!-- <h1 onclick="location.href='/bbs/free/posting'">글쓰기</h1> -->
	<script src="/js/free/freelist.js?ver=1"></script>
<%@ include file="/WEB-INF/views/include/footer.jsp" %>
