<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../layouts/taglibs.jsp" %>


<script type="text/javascript">
$(document).ready(function(){ 

	 $("#categoryForm").validate({

		   rules: {
			   categoryName: {
	                required: true,
	                minlength: 3
       			},
			   description: {
	                required: true,
	                minlength: 10
	            }         
	        },
	        
	        messages:{
	        	categoryName: {
		                required: "Nazwa kategorii nie może być pusta",
		                minlength: "Nazwa kategorii musi mieć co najmniej 3 znaki"
		            },
		            description: {
		                required: "Opis kategorii jest wymagany",
		                minlength: "Opis kategorii powinien mieć co najmniej 10 znaków",
		            } 		            	            

		    }
	}); 
	
});
</script>
<h1> Edytuj kategorię</h1>

<div id="container">
	<form:form modelAttribute="category" role="form" method="POST" id="categoryForm" action="${pageContext.request.contextPath}/categories">
	   	<table class="table">
			<tbody>
			<tr> 
			 	<th class="form-group col-md-8">
					<form:input type="hidden" class="form-control" path="id" id="categoryId" />	
				</th>
				<th></th>
			</tr>			
			<tr> 
			 	<th class="form-group col-md-8">
					<label for="categoryName">nazwa: </label>
					<form:input id="categoryName"  path="categoryName"  class="form-control"  />
					<form:errors path="categoryName" cssClass="error" />
				</th>
				<th></th>
			</tr>
			<tr> 
			 	<th class="form-group col-md-8">
					<label for="description">Opis kategorii: </label>
					<form:textarea rows="5" id="description"  path="description"   class="form-control" />
					<form:errors path="description" cssClass="error" />
				</th>
				<th></th>
			</tr>	
			<tr>
				<th>
				     <div class="modal-footer">
				       <input  type="button" class="btn btn-default" onclick="history.go(-1);" value="Anuluj" />
				       <input type="submit" class="btn btn-primary" value="Zapisz" />
				     </div>				
				</th>
				<th></th>
			</tr>				
			</tbody>
		</table>



	</form:form>
</div>