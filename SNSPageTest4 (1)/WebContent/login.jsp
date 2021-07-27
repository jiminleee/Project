<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>육각정에 오신 걸 환영합니다!</title>
	<!-- css연결 -->
	<link rel="stylesheet" href="css/login.css">

	<!--아이콘 불러오는 스크립트-->
	<script src="https://kit.fontawesome.com/e9529a8bd6.js" crossorigin="anonymous"></script>
	<!--웹폰트 불러오는 스크립트-->
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Gugi&family=Nanum+Gothic&family=Nanum+Myeongjo:wght@800&family=Song+Myung&display=swap" rel="stylesheet">

	<!-- js연결 -->
	<script type="text/javascript" src="js/logincheck.js"></script>
	<script type="text/javascript" src="js/validCheck.js"></script>
</head>

<body>

	<form action="Login" method="post" name ="loginForm" onsubmit="return call();">
    	<div class="allLoginBox">
			<div class="bgBox"><img src="images/bg1.jpg" style="width: 100%; margin-top: 80px;"></div>
    	
		    	<div class="loginContainer">
		      		<div class="designBox"></div>
		      		<div class="updown"></div>
		      		<div class="login">
		        		<div class="loginPage">
		          		<div class="idInput">
		          			<div><span class="resultSpan">${r }</span></div>
		          			<div><span class="resultSpan">${s }</span></div>
		          			
		            		<input type="text" name="id" placeholder="아이디">
		          		</div>
		          		<div class="pwInput">
		            		<input type="password" name="pw" placeholder="비밀번호">
		          		</div>
		          		<div class="loginPageBtn">
		            		<div class="loginBtn"><button>로그인</button></div>
		            		<div class="signupBtn"><a href="join.jsp">회원가입</a></div>
		          		</div>
		        		</div>
		      		</div>
		    	</div>
    		<div class="bgBox"><img src="images/bg2.jpg" style="width: 100%; padding-top: 580px;"></div>
		</div>
  	</form>
</body>
</html>