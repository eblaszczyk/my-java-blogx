<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="../layouts/taglibs.jsp" %>

<script type="text/javascript">
$(document).ready(function(){ 
	 $("#accountForm").validate({
		 rules: {
			   email: {
	                required: true,
	                minlength: 5,
	                email: true
	            }
	 	},
	        
        messages: {
			   email: {
	                required: "Adres email jest wymagany",
	                minlength: "Adress email powinien mieć co najmniej 5 znaków",
	                email: "Nie poprawny format adresu email"
	            }            	            

	    }
	}); 
	
});
</script>

<c:set var="returnFromModalUrl" value="/myaccount/view" />

<h1>Moje dane</h1>
<br>
<div id="container">
	<table class="table">
		<tbody>
			<tr class="col-md-8"> 
			 	<th >Nazwa:</th>
				<td>${user.name}</td>
			</tr>
			<tr class="col-md-8"> 
			 	<th >Imię:</th>
				<td>${user.firstName}</td>
			</tr>
			<tr class="col-md-8"> 
			 	<th >Nazwisko:</th>
				<td>${user.lastName}</td>
			</tr>
			<tr class="col-md-8"> 
			 	<th >Email:</th>
				<td>${user.email}</td>
			</tr>
			<tr class="col-md-8"> 
			 	<th >O mnie:</th>
				<td>${user.about}</td>
			</tr>		
			<tr class="col-md-8"> 
			 	<th>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</th>				<th>
					<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#changeAccountModal">
					  Edytuj dane
					</button>					
				</th>
				<td></td>
			</tr>							
		</tbody>
	</table>	
</div>

<%@include file="modalChangeAccount.jsp" %>

