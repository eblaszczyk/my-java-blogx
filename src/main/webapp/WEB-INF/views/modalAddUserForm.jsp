<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../layouts/taglibs.jsp" %>

<form:form modelAttribute="user" role="form" method="POST" id="userForm" action="${pageContext.request.contextPath}/users">
<!-- Modal -->
	<div class="modal fade" id="addUserModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content modal-backcolor-content">
	      <div class="modal-header">
	        <a href="<spring:url value="${returnFromModalUrl}" />" class="close" ><span aria-hidden="true">&times;</span></a>
	        <h4 class="modal-title" id="myModalLabel">Dodaj użytkownika</h4>
	      </div>
	      <div class="modal-body modal-backcolor-body">
	       	 
	      	<table class="table">
				<tbody>
				<tr> 
				 	<th class="form-group col-md-8">
						<label for="name">nazwa: </label>
						<form:input id="name"  path="name"  class="form-control"  />
						<form:errors path="name" cssClass="error" />
					</th>
				</tr>
				<tr> 
				 	<th class="form-group col-md-8">
						<label for="firstName">Imię: </label>
						<form:input id="firstName"  path="firstName" class="form-control"  />
						<form:errors path="firstName" cssClass="error" />
					</th>
				</tr>
				<tr> 
				 	<th class="form-group col-md-8">
						<label for="lastName">Nazwisko: </label>
						<form:input id="lastName"  path="lastName"   class="form-control" />
						<form:errors path="lastName" cssClass="error" />
					</th>
				</tr>
				<tr> 
				 	<th class="form-group col-md-8">
						<label for="email"> Email:</label>
						<form:input  path="email"  id="email"  class="form-control" />
						<form:errors path="email" cssClass="error" />
					</th>
				</tr>
				<tr> 
				 	<th class="form-group col-md-8">
						<label for="about">O użytkowniku: </label>
						<form:textarea rows="5" id="about"  path="about"   class="form-control" />
						<form:errors path="about" cssClass="error" />
					</th>
				</tr>		
				<tr> 
				 	<th class="form-group col-md-8">
						<label for="password">Hasło: </label>
						<form:password id="password"  path="password"  class="form-control" />
						<form:errors path="password" cssClass="error" />
					</th>
				</tr>	
				<tr> 
				 	<th class="form-group col-md-8">
						<label for="passwordRepeat">Ponów hasło: </label>
						<input id="passwordRepeat" type="password" name="passwordRepeat"  class="form-control" />
					</th>
				</tr>								
	
																
	       	 	</tbody>
	       	 </table>
	       	 
	      </div>
	      <div class="modal-footer">
	        <a href="<spring:url value="${returnFromModalUrl}" />"  class="btn btn-default" >Anuluj</a>
	        <input type="submit" class="btn btn-primary" value="Zapisz" />
	      </div>
	    </div>
	  </div>
	</div>
</form:form>