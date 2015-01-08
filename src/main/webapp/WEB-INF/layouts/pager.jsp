<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file ="taglibs.jsp" %>

	<nav>
	  <ul class="pager">
	  	<c:if test="${actualPage >0 && actualPage <  maxPage}" >
		    <li ><a href="?page=${actualPage - 1}"><span aria-hidden="true">&larr;</span> POPRZEDNIE</a></li>
	    </c:if>
	    <c:if test="${actualPage < maxPage-1}" >
	    	<li ><a href="?page=${actualPage + 1}">NASTĘPNE <span aria-hidden="true">&rarr;</span></a></li>
	    </c:if>
	  </ul>
	</nav>