<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <div class="modal fade" id="modalPostView" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog ">
    <div class="modal-content modal-backcolor-content">
    
      <div class="modal-header">
        <a href="<spring:url value="${returnFromModalUrl}" />" class="close" ><span aria-hidden="true">&times;</span></a>
        <h4 class="modal-title" id="myModalLabel">Podgląd</h4>
      </div>
      
      <div class="modal-body modal-backcolor-post-body" >

	    <h2 class="blog-post-title" id="title">${post.title}</h2>
           <p class="blog-post-meta">
           	<small>Stworzony:</small> <fmt:formatDate type="date"  dateStyle="long"   value="${post.createdAt}" /> 
           	<small>przez</small> <a href="#">${post.user.name}</a>
           </p>
           <br><p >${post.shortCut}<br> </p>
           <hr>
           <p>${post.body}</p>
            
      </div>

      <div class="modal-footer">
        <a href="<spring:url value="${returnFromModalUrl}" />"  class="btn btn-default" >Anuluj</a>
      </div> 
      
    </div>
  </div>
</div>	