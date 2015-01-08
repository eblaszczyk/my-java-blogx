<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglibs.jsp" %>

<c:set var="urlPrefix" value=""/>

    <div class="row row-offcanvas row-offcanvas-right">
        <div class="col-xs-15 col-sm-11">
          <p class="pull-right visible-xs">
            <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Toggle nav</button>
          </p>
          
		  <c:if test="${title != null}">		
		  		<c:set var="urlPrefix" value="/category/${category.categoryName}"/>	
				<div class="panel panel-default">
			  		<div class="panel-body">
			    		${title} 
			  		</div>
				</div>
				
		  </c:if>
          
          <div class="row">         
<!-- -------------------------------------------- *-->
			<c:forEach items="${posts}"  var="post">
				<div class="col-xs-6 col-lg-4">
			        <h2> ${post.title}</h2>
			        <small><fmt:formatDate type="date"  dateStyle="long"   value="${post.publishedAt}" /> 
            	 		by <a href="#">${post.user.name}</a></small>
            	 	<br><br>
			        <p> ${post.shortCut}</p>
			        <p><a class="btn btn-default" href="<spring:url value="/${post.month.yearNumber}/${post.month.monthNumber}/${post.id}" />" role="button">Pokaż &raquo;</a></p>
		         </div><!--/.col-xs-6.col-lg-4-->
		
		    </c:forEach> 
<!-- -------------------------------------------- *-->
          </div><!--/row-->
        </div><!--/.col-xs-12.col-sm-9-->
      </div><!--/row row-offcanvas row-offcanvas-right-->

      <%@ include file="../layouts/pager.jsp" %>