<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file ="taglibs.jsp" %>

<c:set var="urlPrefix" value="" />
<c:if test="${categoryName != null}">
	<c:set var="urlPrefix" value="/category/${categoryName}" />
</c:if>

<nav>
  <ul class="pager">
  	<c:if test="${postAfter != null}" >
	    <li class="previous">
		    <a href="<spring:url value= "/${postAfter.month.yearNumber}/${postAfter.month.monthNumber}/${postAfter.id}" />">
		   		<span aria-hidden="true">&larr;</span> Poprzedni post
		    </a>
	    </li>
    </c:if>
    <c:if test="${postBefore != null}" >
    	<li class="next">
    		<a href="<spring:url value= "/${postBefore.month.yearNumber}/${postBefore.month.monthNumber}/${postBefore.id}" />">
    			Następny post <span aria-hidden="true">&rarr;</span>
    		</a>
    	</li>
    </c:if>
  </ul>
</nav>

