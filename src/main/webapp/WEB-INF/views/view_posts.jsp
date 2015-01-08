<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layouts/taglibs.jsp" %> 


<!-- <script type='text/javascript' src='http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js'></script>
 -->
<script type="text/javascript">
$(document).ready(function(){ 
	$(".open-modalEntityRemove").click(function(e){
		e.preventDefault();
		var postID = $(this).attr("href");
		$(".modal-body #question" ).text("Usunąć post: " + $(this).data("id") +"?");
		$(".modal-footer #removeBtn").attr( "href", postID ); 
		$("#modalEntityRemove").modal();
		});
	
});
</script>

<c:if test="${fn:length(posts) == 0}" >
  	<h3> Nie masz jeszcze żadnych postów </h3>    
</c:if> 

<c:choose>
	<c:when test="${fromLink == 'myPosts'}">
		<c:set var="urlRemove" value="/posts/myPosts/remove/post" />
		<c:set var="returnFromModalUrl" value="/posts/myPosts" />
	</c:when>
	<c:when test="${fromLink == 'allPosts'}">
		<c:set var="urlRemove" value="/posts/allPosts/remove/post" /> 
		<c:set var="returnFromModalUrl" value="/posts/allPosts" />
	</c:when>
</c:choose>

<table class="table">
	<c:forEach items="${posts}" var="post">
		<tr>
			<th>
	           <h4 class="blog-post-title">${post.title}</h4>
	            <p class="blog-post-meta">
		           <small>Stworzony:</small> <fmt:formatDate type="date"  dateStyle="long"   value="${post.createdAt}" /> 
			           		<small>by</small> <a href="#">${post.user.name}</a> <br>
					<c:choose>
					      <c:when test="${post.published}">
								<small>Opublikowany: <fmt:formatDate type="date"  dateStyle="long"   value="${post.createdAt}" /></small>
					      </c:when>
					      <c:otherwise>
					      	 <small>Nieopublikowany</small>
					      </c:otherwise>
					</c:choose>		           	

   					<br> <br>
	            	${post.shortCut}
	            </p>
				<a href="<spring:url value="/posts/post${post.id}" />" 
					class="btn btn-default">
					Zobacz
				</a> 
				<a href="<spring:url value="/posts/change/post${post.id}" />" 
					class="btn btn-primary">
					Edytuj
				</a> 
				<a href="<spring:url value="${urlRemove}${post.id}" />" data-id="${post.title}"
					class="open-modalEntityRemove btn btn-danger"  >
					Usuń
				</a>
							
				<hr>
			</th>
		</tr>


<!-- ========================================================================= -->			
<%@ include file="modalPostView.jsp" %>
<%@ include file="modalEntityRemove.jsp" %>
<!-- ========================================================================= -->	

	</c:forEach>
</table>

  <%@ include file="../layouts/pager.jsp" %>
