<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
<link rel="stylesheet" type="text/css" href="/css/bbs/freebbs.css?ver=1">
	<div class="freePosting" ondrop="dragdrop(event)" ondragover="dragover(event)">
		<div class="freePosting_title">자유게시판</div>
		<div class="freePostingBorder">
			<div class="freePosting_Item">
				<div class="freePosting_text">제목</div>
				<div class="freePosting_value"><input placeholder="제목" name="subject"></div>
			</div>
			<div class="freePosting_Item">
				<div class="freePosting_text">상태</div>
				<div class="freePosting_value">
					<div class="freePosting_status">
						<span><label for="status1">공개</label><input id="status1" type="radio" name="status" checked="checked"></span>
						<span><label for="status2">비밀</label><input id="status2" type="radio" name="status"></span>
					</div>
				</div>
			</div>
			<div class="freePosting_Item">
				<div class="freePosting_text">내용</div>
				<div class="freePosting_value">
					<textarea id="freePosting_content" name="content"></textarea>
				</div>
			</div>
			<div class="freePosting_Item">
				<div class="freePosting_text">첨부파일</div>
				<div class="freePosting_value">
					<input name="img" type="file" id="myfile" onchange="showimg(event)" accept="image/*">
					<div class="freePosting_fileupload">
						<div id="filetextresult"><label for="myfile" id="fileupbutton">파일첨부</label></div>
						<div><img src="/img/카메라_001.png" id="showimg"></div>						
					</div>
				</div>
			</div>
			<div class="freePosting_Item">
				<div class="freePosting_text"></div>
				<div class="freePosting_value">
					<button onclick="postingdo()" id="freePosting_submitButton">전송</button>
				</div>
			</div>
		</div>
	</div>
	
	
	
	
	
	<!-- <h1>대충 자유게시판 업로드</h1>
	<div>
		<div><input placeholder="재목" name="subject"></div>	
		<div><textarea placeholder="내용" name="content"></textarea></div>
		<div><input type="file" name="img" id="myimg" accept="image/*"></div>		
	</div>
	<div><button onclick="postingdo()">전송Ajax</button></div> -->
	<script src="/js/free/freeposting.js?ver=1"></script>
<%@ include file="/WEB-INF/views/include/footer.jsp" %>

