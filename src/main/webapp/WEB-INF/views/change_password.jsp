<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../layouts/taglibs.jsp" %>


<script type="text/javascript">
$(document).ready(function(){ 
	 $("#passwordForm").validate({

		   rules: {
			   oldPassword: {
	                remote:{
		                url: "<spring:url value='/myaccount/isOldPasswordCorrect' />",
		                type: "get",
		                data:{
		                	oldPassword: function(){
				                return $("#oldPassword").val();
		                	}
				        }
		            }
	            },
			   newPassword: {
	                required: true,
	                minlength: 5
	            },	   
	            newPasswordRepeat: {
	                required: true,
	                equalTo: "#newPassword"
	            }         
	        },
	        
	        messages: {
	        	oldPassword: {
			            remote: "Stare hasło jest niepoprawne"
		            },
		            newPassword: {
		                required: "Hasło jest wymagane",
		                minlength: "Hasło powinno mieć co najmniej 5 znaków"
		            },
		            newPasswordRepeat: {
		                required: "Musisz ponownie wprowadzić hasło",				   
		                equalTo: "Wprowadzone hasła się różnią"
		            }  		            	            

		    }
	}); 
	
});
</script>


<h1> Zmiana hasła</h1>

<div id="container">
	<form:form modelAttribute="passwordChangeWrapper" role="form" method="POST" id="passwordForm" 
			action="${pageContext.request.contextPath}/myaccount/changed/password">
	   	<table class="table">
			<tbody>
				<tr> 
				 	<th class="form-group col-md-8">
						<label for="oldPassword">Stare hasło:</label>
						<form:password  id="oldPassword"  path="oldPassword"  class="form-control"  />
						<form:errors path="oldPassword" cssClass="error" />
					</th>
					<th></th>
				</tr>
				<tr> 
				 	<th class="form-group col-md-8">
						<label for="newPassword">Nowe hasło: </label>
						<form:password id="newPassword"  path="newPassword"  class="form-control"  />
						<form:errors path="newPassword" cssClass="error" />
					</th>
					<th></th>
				</tr>
				<tr> 
				 	<th class="form-group col-md-8">
						<label for="newPasswordRepeat">Powtórz hasło: </label>
						<form:password id="newPasswordRepeat"  path="newPasswordRepeat"  class="form-control"  />
						<form:errors path="newPasswordRepeat" cssClass="error" />
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
