<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../layouts/taglibs.jsp" %>

<form:form modelAttribute="category" role="form" method="POST" id="categoryForm" action="${pageContext.request.contextPath}/categories">
<!-- Modal -->
	<div class="modal fade" id="addCategoryModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content modal-backcolor-content">
	      <div class="modal-header">
	        <a href="<spring:url value="${returnFromModalUrl}" />" class="close" ><span aria-hidden="true">&times;</span></a>
	        <h4 class="modal-title" id="myModalLabel">Dodaj kategorię</h4>
	      </div>
	      <div class="modal-body modal-backcolor-body">
	      
	      	<table class="table">
				<tbody>
				<tr> 
				 	<th class="form-group col-md-8">
						<label for="categoryName">nazwa: </label>
						<form:input id="categoryName"  path="categoryName"  class="form-control"  />
						<form:errors path="categoryName" cssClass="error" />
					</th>
				</tr>
				<tr> 
				 	<th class="form-group col-md-8">
						<label for="description">Opis kategorii: </label>
						<form:textarea rows="5" id="description"  path="description"   class="form-control" />
						<form:errors path="description" cssClass="error" />
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