<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>육각정 : 책갈피</title>

<link rel="stylesheet" href="css/home.css">

  <!--아이콘 불러오는 스크립트-->
  <script src="https://kit.fontawesome.com/e9529a8bd6.js" crossorigin="anonymous"></script>
  <!--웹폰트 불러오는 스크립트-->
  <link rel="preconnect" href="https://fonts.gstatic.com">
  <link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Gugi&family=Nanum+Gothic&family=Nanum+Myeongjo:wght@800&family=Song+Myung&display=swap" rel="stylesheet">

<script type="text/javascript" src="js/bookmark.js"></script>
</head>
<body>

	<div class="bmContainer">
	
		<div class="pageTitle">책갈피를 꽂아둔</div>
        
          <c:forEach var="bm" items="${bm }" >
        <div class="post">
        	
          <div class="postImg"><img src="img/${bm.b_img }"></div>
          
          <div class="postDownBox">
          

            <div class="postContents">
              <div class="postWriter">${bm.b_id }</div>
              <div class="postTxt">${bm.b_content }</div>
            </div>
            <div class="postMenu">
              <div class="pmStyle"><button onclick="delBookmark('${bm.b_no }');"><i class="fas fa-bookmark"></i></button></div>
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