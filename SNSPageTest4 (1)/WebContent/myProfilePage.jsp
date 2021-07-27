<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>육각정 : 내 게시물</title>

<link rel="stylesheet" href="css/home.css">
  <!--아이콘 불러오는 스크립트-->
  	<script src="https://kit.fontawesome.com/e9529a8bd6.js" crossorigin="anonymous"></script>
  <!--웹폰트 불러오는 스크립트-->
  	<link rel="preconnect" href="https://fonts.gstatic.com">
  	<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Gugi&family=Nanum+Gothic&family=Nanum+Myeongjo:wght@800&family=Song+Myung&display=swap" rel="stylesheet">
  <!-- js 연결 -->
	<script type="text/javascript" src="js/post.js"></script>
	<script type="text/javascript" src="js/bookmark.js"></script>
</head>
<body>

<div class="contentPage">

	<input name="iiid" type="hidden" value="${sessionScope.a.a_id }">
	<div class="contentPage"> 
          <div class="pageTitle">자기소개</div>
          <div class="myProfile">
            <div class="profileBox">
              <div class="flexBox1">
                <div class="myPic"><img src="img/${sessionScope.a.a_img }"></div>
              </div>
              <div class="flexBox2">
                <div class="myNames">
                  <div class="myName">${sessionScope.a.a_name }</div>
                  <div class="myId">${sessionScope.a.a_id }</div>
                </div>
                <div class="myIntro">${sessionScope.a.a_intro }</div>
              </div>
            </div>
          </div>
          
          <div class="pageTitle">내 게시물</div>
          
          
          
          <c:forEach var="p" items="${myP }" >
		        <div class="post">
		        	
		      
		        	
		          <div class="postImg"><img src="img/${p.p_img }" width="300px"></div>
		          
		          <div class="postDownBox">
		
		            <div class="postContents">
		              <div class="postWriter">${p.p_id }</div>
		              <div class="postTxt">${p.p_content }</div>
		            </div>
		            <div class="postMenu">
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
</div>
 


</body>
</html>