<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

	<!-- search -->
	<div class="search">
		<form action="searchController">
          	<input name="content" placeholder="게시물 검색">
          	<button><i class="fas fa-search"></i></button>
    	</form>
    </div>
    
    
    <!-- profile -->
    <!-- account db 데이터와 연결해주세요 -->
        <div class="profile">
          <div class="profileInfo">
            <div class="profileMenu">
               <img src="img/${sessionScope.a.a_img }" width="100px" >
            </div>
            <div class="profileName">
              <div class="profileMenu">이름 : ${sessionScope.a.a_name }</div>
              <div class="profileMenu">ID : ${sessionScope.a.a_id }</div>
            </div>
            
            
            
            
          </div>
        </div>
       
        
        
        <!-- suggest -->
        <!-- account db와 연결한 foreach문 사용 -->
        <div class="suggest"><span class="suggestSpan">우연히 마주친 사람들</span>
			<c:forEach var="u" items="${users }">
	          <div class="suggestContent">
	            <div class="suggestP"><img src="img/${u.a_img }"></div>
	            	<div class="suggestPerson">
		            	<div class="suggestName">${u.a_id }</div>
		            	<div class="suggestName">${u.a_name }</div>
	            	</div>
	
		
	            </div>
		</c:forEach>
          </div>
          
          <div align="center">
          <form action="HC">
          <button class="regBtn" style="margin-bottom: 2%;">로그아웃</button>
    		</form>
		</div>
</body>
</html>