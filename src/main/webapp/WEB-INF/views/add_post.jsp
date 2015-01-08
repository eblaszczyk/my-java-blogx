<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<h1> Dodaj post</h1>

<%@ include file="../layouts/taglibs.jsp" %>

<script type="text/javascript">
$(document).ready(function(){
	$(".modalViewPost").click(function(){
		$(".modal-body #title").html($("#postTitle").val());
		$(".modal-body #shortCut").html($("#postShortCut").val());
		$(".modal-body #body").html($("#postBody").val());
	});
	
	 $("#postForm").validate({

		   rules: {
			   'post.title': {
	                required: true,
	                minlength: 5
	            },
			   'post.shortCut': {
	                required: true,
	                minlength: 20
	            },
			   'post.body': {
	                required: true,
	                minlength: 50
	            },	            
		   		categoriesList :{
				     required: true,
				     minlength: 1
		    	}
	        },
	        
	        // Specify the validation error messages
	        messages: {
	        	'post.title': {
	                required: "Tytuł nie może być pusty",
	                minlength: "Tytuł powinien mieć co najmniej 5 znaków"
	            },
	        	'post.shortCut': {
	                required: "Streszczenie nie może być puste",
	                minlength: "Streszczenie powinno mieć co najmniej 20 znaków"
	            },	     
	        	'post.body': {
	                required: "Treść nie może być pusta",
	                minlength: "Treść powinna mieć co najmniej 50 znaków"
	            },
	            categoriesList :"Co najmniej jedna kategoria musi być wybrana"
	        }	
	}); 
});
</script>

<c:set var="now" value="<%=new java.util.Date()%>" />	
<c:set var="user" value="user" />	

${postAndCategoriesWrapper.post.id} 

	<div id="container">
	
		
		<form:form role="form" method="POST" action="${pageContext.request.contextPath}/posts/added/post" 
			modelAttribute="postAndCategoriesWrapper" id="postForm">
		<table class="table">
			<tbody>
			</tr>
			<tr> 
			 	<th class="form-group col-md-8">
					<label for="postTitle">Tytuł: </label>
					<form:input id="postTitle"  path="post.title" class="form-control"  />
					<form:errors path="post.title" cssClass="error" />
				</th>
				<th></th>
			</tr>
			<tr>
				<th class="form-group">
					<label for="postShorCut">Skrót: </label>
					<form:textarea class="form-control" rows="5"  path="post.shortCut" id="postShortCut"/>
					<form:errors path="post.shortCut" cssClass="error" />
				</th>
				<th></th>
			</tr>
			<tr>						
				<th class="form-group">
					<label for="postBody">Treść: </label>
					<form:textarea class="form-control" rows="20" path="post.body" id="postBody"/>
					<form:errors path="post.body" cssClass="error" />
				</th>
				<th></th>
			</tr> 
			<tr>	
				<th class="form-group">
					<label for="categoryOptions">Wybierz kategorie: </label>
					<form:checkboxes items="${categoryNames}" path="categoriesList" id="categoryOptions" />
					<form:errors path="categoriesList" cssClass="error" />
					<label class="error" for="categoriesList" generated="true"></label>
				</th>
				<th></th>
			</tr>
			<tr>	
				<th class="form-group">
					<label for="publishedOptions">Opublikować? </label>
					<form:checkbox path="post.published" />
				</th>
				<th></th>
			</tr> 
			 <tr>
			 	<th>		
			 			<input  type="button" class="btn btn-default" onclick="history.go(-1);" value="Cancel" />
						<input type="button" class="btn btn-info modalViewPost" value="Podejrzyj post"  data-toggle="modal" 
							data-target="#modalPostView"  /> 
						<input type="submit" class="btn btn-primary" value="Zapisz" />	
				</th>
				<th></th>	
			</tr>
			</tbody>
		</table>				
		</form:form>
	</div>
	
<!-- ========================================================================= -->			
<!-- Modal -->
<%@include file="modalPostView.jsp" %>
<!-- ========================================================================= -->	


