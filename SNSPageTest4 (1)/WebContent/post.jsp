<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>육각정 : Home</title>

<link rel="stylesheet" href="css/home.css">
  <!--아이콘 불러오는 스크립트-->
  <script src="https://kit.fontawesome.com/e9529a8bd6.js" crossorigin="anonymous"></script>
  <!--웹폰트 불러오는 스크립트-->
  <link rel="preconnect" href="https://fonts.gstatic.com">
  <link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Gugi&family=Nanum+Gothic&family=Nanum+Myeongjo:wght@800&family=Song+Myung&display=swap" rel="stylesheet">

	<!--  제이쿼리 -->
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.0.min.js" ></script>
	  
	<!-- 기능 연결 스크립트 -->
	<script type="text/javascript" src="js/bookmark.js"></script>  
	<script type="text/javascript" src="js/post.js"></script>
</head>
<body>

     <div class="contentPage">
        
        <form action="RegController" method="post" enctype="multipart/form-data" class="reg">
          
            <div class="regBox">
            
            <div class="regMenu"><textarea placeholder="내용" name="content" class="regContent"></textarea></div>
          <div class="regMenu regFile"><input type="file" name="file"></div>
          	
<%--           	아이디 :  ${sessionScope.a.a_id } --%>
            <input name="iid" type="hidden" value="${sessionScope.a.a_id }">
            <div class="regMenu"><button class="regBtn">등록</button></div>
          </div>
        </form>
        
        
        <!-- foreach 추가해야함 / 이 페이지는 게시물 등록 및 확인, 서치결과 게시물 확인에 사용됩니다. -->
        
       	<c:forEach var="p" items="${posts }" >
        <div class="post">
        	
      
        	
          <div class="postImg"><img src="img/${p.p_img }" width="300px" class="postImg2"></div>
          
          <div class="postDownBox">

            <div class="postContents">
              <div class="postWriter">${p.p_id }</div>
              <div class="postTxt">${p.p_content }</div>
            </div>
            <div class="postMenu">
              <div class="pmStyle"><button onclick="insertBookmark('${p.p_no }');"><i class="far fa-bookmark"></i></button></div>
              <div class="pmStyle"><button onclick="location.href='UpdateController?no=${p.p_no }'"><i class="fas fa-eraser"></i></button></div>
              <div class="pmStyle"><button onclick="location.href='DelController?no=${p.p_no }'"><i class="far fa-trash-alt"></i></button></div>
            </div>
            <div class="comment">
              <div class="commentArea"><textarea placeholder="댓글내용" class="commentCon"></textarea></div>
              <div class="commentBtn"><a href="#"><i class="far fa-comment-dots"></i></a></div>
            </div>

          </div>
          
        
        </div>
       
       	</c:forEach>
      </div>

</body>
</html>