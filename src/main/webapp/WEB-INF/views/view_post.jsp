<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="../layouts/taglibs.jsp" %>
    
<div class="container">
	<div class="row">
        <div class="col-sm-8 blog-main">
          <div class="blog-post">
            <h2 class="blog-post-title">${post.title}</h2>
            <p class="blog-post-meta">
            	<small>Opublikowany:</small> <fmt:formatDate type="date"  dateStyle="long"   value="${post.publishedAt}" /> 
            	<small>przez</small> <a href="#">${post.user.name}</a>
            </p>

            <p><b> ${post.shortCut} </b> </p>
            <hr>
            <p> ${post.body}</p>
          </div><!-- /.blog-post -->
		  <hr>
		  <c:choose>
		 	<c:when test="${returnBtn == 'true'}">
		 		<input  type="button" class="btn btn-default" onclick="history.go(-1);" value="Wróć" />
		  	</c:when>
		  	<c:otherwise> 
		  		<%@include file="../layouts/pager2.jsp" %> 
		  	</c:otherwise>
		  </c:choose>
        </div><!-- /.blog-main -->

        <div class="col-sm-3 col-sm-offset-1 blog-sidebar">
<!--           <div class="sidebar-module sidebar-module-inset">
            <h4>About</h4>
            <p>Etiam porta <em>sem malesuada magna</em> mollis euismod. Cras mattis consectetur purus sit amet fermentum. Aenean lacinia bibendum nulla sed consectetur.</p>
          </div> -->
          <div class="sidebar-module">
            <h4>Archiwum</h4>
            <ol class="list-unstyled">
            	<c:forEach items="${months}" var="month"> 
              		<li><a href="<spring:url value="/${month.yearNumber}/${month.monthNumber}" />">
              			${month.name}
              		</a></li>
                </c:forEach>
            </ol>
          </div>

        </div><!-- /.blog-sidebar -->
	</div><!-- /.row -->
</div><!-- /.container -->

