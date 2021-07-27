
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="css/join.css">

  <!--아이콘 불러오는 스크립트-->
	<script src="https://kit.fontawesome.com/e9529a8bd6.js" crossorigin="anonymous"></script>
  <!--웹폰트 불러오는 스크립트-->
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Gugi&family=Nanum+Gothic&family=Nanum+Myeongjo:wght@800&family=Song+Myung&display=swap" rel="stylesheet">



<script type="text/javascript" src="js/joinCheck.js"></script>
<script type="text/javascript" src="js/validCheck.js"></script>

<script>
function numberMaxLength(e){
	if(e.value.length>e.maxLength){
		e.value=e.value.slice(0,e.maxLength);
	}
}
</script>
<script type="text/javascript">
function idCheck(id){
	   
	   
	   
	   if(id ==""){
	   
	      alert("아이디를 먼저 입력하세요");
	      document.joinForm.idj.focus();
	    }else{
	      url="IdCheck?id=" + id;
	     location.href=url;
	      
	    }
}
</script>
</head>
<body>

<form action="Join"  method="post" name="joinForm" enctype="multipart/form-data" onsubmit="return check();">
    <div class="joinContainer">
      <div class="joinBox">
        <div class="joinTitle"><span class="bigSpan">회 원 기 본 정 보</span><hr></div>
        <div class="joinId">
          <div class="joinSpan">아이디</div>
          <input type="text" name="idj"  maxlength="12" placeholder="아이디">${id}
          <c:choose>
        	<c:when test="${check  eq true}">
       		사용불가능한 아이디입니다.
        	<input type="hidden" name="idOk" value="t">
       		 </c:when>
        	<c:when test="${check  eq false}">
        	사용가능한 아이디입니다.
        	<input type="hidden" name="idOk" value="f">
        </c:when>
        </c:choose>
        <input type="button" value="중복확인" onclick="idCheck(this.form.idj.value)">
        </div>
        <div class="joinPw">
          <div class="joinSpan">비밀번호</div>
          <input type="password"  name="pwj" maxlength="12" placeholder="비밀번호">
        </div>
        <div class="joinPwCh">
          <div class="joinSpan">비밀번호 확인</div>
          <input type="password" name="pwj2" placeholder="비밀번호를 한 번 더 입력하세요">
        </div>
        <div class="joinName">
          <div class="joinSpan">이름</div>
          <input type="text" name="name" placeholder="이름">
        </div>
        <div class="joinAge">
          <div class="joinSpan">생년월일</div>
          <input type="number" name="birthday" maxlength="8" placeholder="ex)19991231" oninput="numberMaxLength(this)">
        </div>
        <div class="joinGender">
          <div class="joinSpan">성별</div>
          <input type="radio" name="gender" value="여"><span class="joinSpan">여자</span>
          <input type="radio" name="gender" value="남"><span class="joinSpan">남자</span>
        </div>
        <div class="joinPic">
          <div class="joinSpan">사진</div>
          <div><label class="inputFileBtn" for="inputFile">업로드</label></div>
          <input type="file" name="file" id="inputFile">
        </div>
        <div class="joinIntro">
          <div class="joinSpan">자기소개</div>
          <textarea name="intro" placeholder="프로필페이지에 나올 자기소개"></textarea>
        </div>
  
        <div class="joinBtn">
          <button>회원가입</button>
        </div>
      </div>


    </div>
  
  </form>












<%-- <form action="Join"  method="post" name="joinForm" enctype="multipart/form-data" onsubmit="return check();">
    <table >

        <tr>
            <td>회원 기본 정보</td> 
        </tr>
        <tr>
        <td>아이디</td>
        <td><input type="text" name="idj"  maxlength="12" placeholder="*영문과 숫자만 사용하여 12자리 이하로 입력해주세요.">${id}
        <c:choose>
        <c:when test="${check  eq true}">
       	있는 아이디입니다
        <input type="hidden" name="idOk" value="t">
        </c:when>
        <c:when test="${check  eq false}">
        사용가능한 아이디입니다
        <input type="hidden" name="idOk" value="f">
        </c:when>
        </c:choose>
        </td>
        <td><input type="button" value="중복확인" onclick="idCheck(this.form.idj.value)"></td>
		
		</tr>        
        
        <tr>
            <td>비밀번호</td>
            <td><input type="password"  name="pwj" maxlength="12">*특수문자를 사용하여 12자리 이하로 입력해주세요.</td>       
        </tr>
        <tr>
            <td>비밀번호 확인</td>
            <td><input type="password" name="pwj2"></td>
            
        </tr>
        <tr>
            <td>이름</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>생일</td>
            <td><input type="number" name="birthday" maxlength="8" placeholder="ex)19991231" oninput="numberMaxLength(this)"></td>
        </tr>
        <tr>
            <td>성별</td>
            <td><input type="radio" name="gender" value="여">여</td>
            <td><input type="radio" name="gender" value="남">남</td>
        </tr>
        <tr>
       	<td>사진</td>	
		<td><input type="file" name = "file"></td>	
		</tr>
        <tr>
            <td>소개</td>
            <td><textarea name="intro"></textarea></td>
        </tr>
        <tr>
        <td>
        <button>회원가입</button>
        </td>
        </tr>
    </table>
</form>
 --%>
</body>
</html>