<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="taglibs.jsp" %> 

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
	
	<script src="//code.jquery.com/jquery-1.9.1.js"></script>
	<script src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
	<!-- BOOTSTRAMP:END -->
	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<title>
		<tiles:insertAttribute name="pageTitle"/>
	</title>
	
 	<style>
		<%@ include file="../css/mjbx.css" %>
	</style>
</head>
<body class="modal-open">

    <titlesEx:useAttribute name="current"/>

  	<div class="container">
        <div class="jumbotron">
           <h1>Java Rendez-Vous</h1>
           <p>Witaj na moim blogu. Będzie tu trochę o mnie i o mojej przygodzie z Javą.<br> Z czasem pojawią się też inne interesujące tematy...</p>
        </div> 
        
        <c:if test="${currentLoggedUserName != null}">	
        	<p style="text-align:right"> Użytkownik:  ${currentLoggedUserName}</p>
        </c:if>
        
		<%@ include file="navbar.jsp" %>
		<tiles:insertAttribute name="body"/>
		
	    <hr>	
	    
	    <footer>
	    	<p><tiles:insertAttribute name="footer"/></p>
	    </footer>
	
	</div><!--/.container-->
</body>
</html>