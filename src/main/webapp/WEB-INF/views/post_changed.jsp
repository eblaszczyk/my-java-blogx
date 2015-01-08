<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layouts/taglibs.jsp" %>

<h1> Post zmieniony </h1>


<c:if test="${!post.published}">
	<div class="">Nieopublikowany</div>
</c:if>

<hr>
<%@include file="view_post.jsp" %>