<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>육각정을 즐겨주세요!</title>
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

<!--메뉴, 포스트영역-->

  <div class="allBox">

    <div class="mainContainer">

      <div class="nav">
        <div class="navBox">
          <div class="home" id="home"><a href="MainController?id=${a.a_id }">육각정으로</a></div>
  
          <div class="menuBox">
              <div class="menu"><a href="MyProfileController?id=${a.a_id }"><i class="fas fa-user-circle"></i></a></div>
              <div class="menu"><a href="SeeBMController?id=${a.a_id }"><i class="fas fa-bookmark"></i></a></div>
              <div class="menu"><a href="profileController?id=${a.a_id }"><i class="fas fa-id-card"></i></a></div>
          </div>
        </div>
        
      </div>
      <div class="postContainer">
        <div class="contentPage"> 
          <!--컨텐츠 페이지 넣는 공간-->
          <jsp:include page="${contentPage }"></jsp:include>
        </div>
  
      <!--오른쪽-->
  
      <div class="side">
  
        <jsp:include page="${sidePage }"></jsp:include>
  
      </div>
  
    </div>
  </div>
</div>

		<!-- 페이지업버튼 -->
		<div style="position: fixed; bottom: 4%; right: 4%; font-size: 2em;">
			<a href="#home">
				<i class="fas fa-chevron-circle-up"></i>
			</a>	
		</div>


</body>
</html>