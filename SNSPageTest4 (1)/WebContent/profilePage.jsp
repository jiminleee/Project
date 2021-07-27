<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>육각정 : 내 프로필</title>

<link rel="stylesheet" href="css/home.css">
  <!--아이콘 불러오는 스크립트-->
  	<script src="https://kit.fontawesome.com/e9529a8bd6.js" crossorigin="anonymous"></script>
  <!--웹폰트 불러오는 스크립트-->
  	<link rel="preconnect" href="https://fonts.gstatic.com">
  	<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Gugi&family=Nanum+Gothic&family=Nanum+Myeongjo:wght@800&family=Song+Myung&display=swap" rel="stylesheet">
  <!-- js 연결 -->
	<script type="text/javascript" src="js/Delprofile.js"></script>
	
</head>
<body>
<div class="contentPage"> 
          <div class="pageTitle">프로필</div>
          <div class="myProfile">
            <div class="myProfileBox">
     
	              <div class="profileSpan">
	              	<p class="titleSpan">이미지</p>
	               	<p class="mySpan"><img src="img/${sessionScope.a.a_img }" width="200px"></p>
	              </div>
	              <div class="profileSpan">
	              	<p class="titleSpan">아이디</p>
	              	<p class="mySpan">${sessionScope.a.a_id }</p>
	              </div>
	              <div class="profileSpan">
	              	<p class="titleSpan">비밀번호</p>
	              	<p class="mySpan">${sessionScope.a.a_pw }</p>
	              </div>
	              <div class="profileSpan">
	              	<p class="titleSpan">이름</p>
	              	<p class="mySpan">${sessionScope.a.a_name }</p>
	              </div>
	              <div class="profileSpan">
	              	<p class="titleSpan">생일</p>
	              	<p class="mySpan">${sessionScope.a.a_birth }</p>
	              </div>
	              <div class="profileSpan">
	              	<p class="titleSpan">성별</p>
	              	<p class="mySpan">${sessionScope.a.a_gender }</p>
	              </div>
	              <div class="profileSpan">
	              	<p class="titleSpan">자기소개</p>
	              	<p class="mySpan">${sessionScope.a.a_intro }</p>
	              </div>
	              
	              <button onclick="location.href='UpdateProfile?id=${sessionScope.a.a_id }'" class="updateBtn">수정</button>
              	  <button onclick="DelProfile('${sessionScope.a.a_id }');" class="deleteBtn">회원탈퇴</button>
            </div>
          </div>
</div>
</body>
</html>