<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>육각정 : 내 정보 수정</title>


<link rel="stylesheet" href="css/home.css">
  <!--아이콘 불러오는 스크립트-->
  	<script src="https://kit.fontawesome.com/e9529a8bd6.js" crossorigin="anonymous"></script>
  <!--웹폰트 불러오는 스크립트-->
  	<link rel="preconnect" href="https://fonts.gstatic.com">
  	<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Gugi&family=Nanum+Gothic&family=Nanum+Myeongjo:wght@800&family=Song+Myung&display=swap" rel="stylesheet">
  <!-- js 연결 -->
	<script type="text/javascript" src="js/post.js"></script>

</head>
<body>
	<div class="contentPage"> 
		<form action="UpdateProfile" enctype="multipart/form-data" method="post" name="updForm">
          <div class="myProfile2">
            <div class="myProfileBox2">
             <div class="upd">
	              <div class="profileSpan">
	              	<p class="titleSpan">이미지</p>
	              	<p class="myInput"><img src="img/${sessionScope.a.a_img }"></p>
	              	<p class="myInput"><input type="file" name="file"></p>
	              </div>
	              <div class="profileSpan">
	              	<p class="titleSpan">아이디</p>
	              	<p class="myInput"><input name="id" value="${sessionScope.a.a_id }" readonly="readonly"></p>
	              </div>
	              <div class="profileSpan">
	              	<p class="titleSpan">비밀번호</p>
	              	<p class="myInput"><input name="pw" value="${sessionScope.a.a_pw }"></p>
	              </div>
	              <div class="profileSpan">
	              	<p class="titleSpan">이름</p>
	              	<p class="myInput"><input name="name" value="${sessionScope.a.a_name }"></p>
	              </div>
	              <div class="profileSpan">
	              	<p class="titleSpan">생일</p>
	              	<p class="myInput"><input name="birth" value="${sessionScope.a.a_birth }"></p>
	              </div>
	              <div class="profileSpan">
	              	<p class="titleSpan">성별</p>
	              	<p class="myInput"><input name="gender" value="${sessionScope.a.a_gender }"></p>
	              </div>
	              <div class="profileSpan">
	              	<p class="titleSpan">자기소개</p>
	              	<p class="myInput"><input name="intro" value="${sessionScope.a.a_intro }"></p>
	              </div>
	              
	              <button class="updateBtn">저장</button>
            </div>
            </div>
          </div>
       </form>
</div>
</body>
</html>