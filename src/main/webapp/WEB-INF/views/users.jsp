<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../layouts/taglibs.jsp" %>


<script type="text/javascript">
$(document).ready(function(){ 
	$(".open-modalEntityRemove").click(function(e){
		e.preventDefault();
		var postID = $(this).attr("href");
		$(".modal-body #question" ).text("Usunąć użytkownika: " + $(this).data("id") +"?");
		$(".modal-footer #removeBtn").attr( "href", postID ); 
		$("#modalEntityRemove").modal();
	});

	 $("#userForm").validate({

		   rules: {
			   name: {
	                required: true,
	                minlength: 3,
	                remote:{
		                url: "<spring:url value='/users/isUserExists' />",
		                type: "get",
		                data:{
		                	username: function(){
				                return $("#name").val();
		                	}
				        }
		            }
	            },
			   email: {
	                required: true,
	                minlength: 5,
	                email: true
	            },
			   password: {
	                required: true,
	                minlength: 5
	            },	   
			   passwordRepeat: {
	                required: true,
	                minlength: 5,
	                equalTo: "#password"
	            }         
	        },
	        
	        messages: {
				   name: {
		                required: "Nazwa użytkownika nie może być pusta",
		                minlength: "Nazwa użytkownika musi mieć co najmniej 3 znaki",
			            remote: "Taki użytkownik już istnieje"
		            },
				   email: {
		                required: "Adres email jest wymagany",
		                minlength: "Adress email powinien mieć co najmniej 5 znaków",
		                email: "Nie poprawny format adresu email"
		            },
				   password: {
		                required: "Hasło jest wymagane",
		                minlength: "Hasło powinno mieć co najmniej 5 znaków"
		            },
				   passwordRepeat: {
		                required: "Hasła się różnią",
		                minlength: "Hasła się różnią",
		                equalTo: "Hasła się różnią"
		            }  		            	            

		    }
	}); 
	
});
</script>

<c:set var="returnFromModalUrl" value="/users" />

<h1>Użytkownicy:</h1>

<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th> nazwa </th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${users}"  var="user">
			<tr>
				<td> ${user.name} </td>
				<td> 
					<a href="<spring:url value="/users/remove/user${user.id}" />"  data-id="${user.name}"
						class="open-modalEntityRemove btn btn-danger btn-sm" >
						Usuń
					</a> 
				</td>
	     	</tr>
	 	</c:forEach> 
	</tbody>
</table>

<!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addUserModal">
  Dodaj nowego użytkownika
</button>

<%@ include file="modalAddUserForm.jsp" %>

<%@ include file="modalEntityRemove.jsp" %>
