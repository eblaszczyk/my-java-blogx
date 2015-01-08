<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="../layouts/taglibs.jsp" %>

<script type="text/javascript">
$(document).ready(function(){ 

	 $("#categoryForm").validate({

		   rules: {
			   categoryName: {
	                required: true,
	                minlength: 3,
		            remote:{
		               url: "<spring:url value='/categories/isCategoryExists' />",
		               type: "get",
		               data:{
		            	   categoryName: function(){
				                return $("#categoryName").val();
		               		}
			       	  }
          			}
       			},
			   description: {
	                required: true,
	                minlength: 10
	            }         
	        },
	        
	        messages:{
	        	categoryName: {
		                required: "Nazwa kategorii nie może być pusta",
		                minlength: "Nazwa kategorii musi mieć co najmniej 3 znaki",
			            remote: "Taka kategoria już istnieje"
		            },
		            description: {
		                required: "Opis kategorii jest wymagany",
		                minlength: "Opis kategorii powinien mieć co najmniej 10 znaków",
		            } 		            	            

		    }
	}); 
	
});
</script>

<c:set var="returnFromModalUrl" value="/categories" />

<h1>Kategorie:</h1>

<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th> nazwa </th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${categories}"  var="cat">
			<tr>
				<td> ${cat.categoryName} </td>
				<td> 
					<a href="<spring:url value="/categories/change/category${cat.id}" />"  
						class="btn btn-info btn-sm" >
						Edytuj
					</a>  
				</td>
	     	</tr>
	 	</c:forEach> 
	</tbody>
</table>  
 
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addCategoryModal">
  Dodaj nową kategorię
</button>

<%@ include file="modalAddCategoryForm.jsp" %> 