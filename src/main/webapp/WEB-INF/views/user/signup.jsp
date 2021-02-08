<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
<link rel="stylesheet" type="text/css" href="/css/user.css?ver=1">
	<div class="signupBoard">
		<div class="signup_item">
			<div class="boardTitle">사이트 이용정보</div>
			<div class="idpw_item">
				<div class="idpw_min_box">
					<div class="idpw_item_text">아이디</div>
					<div class="idpw_item_input"><input name="id" placeholder="아이디"></div>
				</div>
				<div class="idpw_min_box">
					<span class="idpw_item_text">아이디 중복확인</span>
					<span class="idpw_item_input"><button>중복확인</button></span>
				</div>
			</div>
			<div class="idpw_item">			
				<div class="idpw_min_box">
					<div class="idpw_item_text">비밀번호</div>
					<div class="idpw_item_input"><input name="password" placeholder="비밀번호"></div>
				</div>
				<div class="idpw_min_box">
					<span class="idpw_item_text">비밀번호 확인</span>
					<span class="idpw_item_input"><input name="passwordcheck"  placeholder="비밀번호 확인"></span>
				</div>
			</div>
		</div>		
		<div class="signup_item">
			<div class="boardTitle">회원정보</div>
			<div class="idpw_item">
				<div class="idpw_min_box">
					<div class="idpw_item_text">이름</div>
					<div class="idpw_item_input"><input name="name"  placeholder="이름"></div>
				</div>
				<div class="idpw_min_box">
					<div class="idpw_item_text">나이</div>
					<div class="idpw_item_input"><input name="age" type="number" min="0"  placeholder="나이"></div>
				</div>
			</div>
			<div class="idpw_item">			
				<div class="idpw_min_box">
					<div class="idpw_item_text">닉네임</div>
					<div class="idpw_item_input"><input name="nickname"  placeholder="닉네임"></div>
				</div>
				<div class="idpw_min_box">
					<div class="idpw_item_text">성별</div>
					<div class="idpw_item_input">
						<span>남<input type="radio" name="gender" checked="checked" value="남자"></span>
						<span style="padding-left: 30px;">여<input type="radio" name="gender" value="여자"></span>
					</div>
				</div>	
			</div>
			<div class="idpw_item">
				<div class="idpw_min_box">
					<div class="idpw_item_text">이메일</div>
					<div class="idpw_item_input"><input id="email1" name="email"  placeholder="이메일"></div>
				</div>
				<div class="idpw_min_box">
					<div class="idpw_item_text">선택</div>
					<div class="idpw_item_input">
						<select id="email2" name="email">
							<option value="write">직접입력</option>
							<option value="naver.com">네이버</option>							
							<option value="gmail.com">구글</option>
							<option value="hanmail.net">다음</option>
						</select>
					</div>
				</div>
			</div>
		</div>
		<div class="signupsubmit">
			<button onclick="signupdo()">회원가입</button>
		</div>
	</div>
	<script src="/js/user/UserSignup.js?ver=1"></script>
<%@ include file="/WEB-INF/views/include/footer.jsp" %>