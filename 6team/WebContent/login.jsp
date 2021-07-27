<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/login.css">

	<!--아이콘 불러오는 스크립트-->
	<script src="https://kit.fontawesome.com/e9529a8bd6.js" crossorigin="anonymous"></script>
	<!--웹폰트 불러오는 스크립트-->
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Gugi&family=Nanum+Gothic&family=Nanum+Myeongjo:wght@800&family=Song+Myung&display=swap" rel="stylesheet">
<script type="text/javascript" src="js/logincheck.js"></script>
<script type="text/javascript" src="js/validCheck.js"></script>

</head>
<body>
${s }

<form action="Login" method="post" name ="loginForm" onsubmit="return call();">
    	<div class="loginContainer">
      		<div class="designBox"></div>
      		<div class="updown"></div>
      		<div class="login">
        		<div class="loginPage">
          		<div class="idInput">
          			<div><span>${r }</span></div>
          			
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
  	</form>





<%-- <form action="Login" method="post" name ="loginForm" onsubmit="return call();">
<table border="1">
    <tr>
    <td>아이디 :</td> 
    <td><input type="text" name="id"></td>
    </tr>
    <tr>
    <td>비밀번호 :</td> 
    <td><input type="password" name="pw"></td>
    </tr>
    <tr>
    <td>${r }</td>
    </tr>
    <tr>
   <td><button>로그인</button></td>
    <td><a href="join.jsp">회원가입</a></td>
    </tr>
</table>
</form> --%>
</body>
</html>