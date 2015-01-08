<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- ========================================================================= -->			
<!-- Modal -->   
<div class="modal fade" id="modalPostView" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog ">
    <div class="modal-content modal-backcolor-content">
    
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Podgląd</h4>
      </div>
      
      <div class="modal-body modal-backcolor-body" >

	    <h2 class="blog-post-title" id="title"></h2>
           <p class="blog-post-meta">
           	<small>Opublikowany:</small> <fmt:formatDate type="date"  dateStyle="long"   value="${now}" /> 
           	<small>przez</small> <a href="#">${user}</a>
           </p>
           <br><p id="shortCut"><br> </p>
           <hr>
           <p id="body"></p>
            
      </div>

      <div class="modal-footer">
       <button type="button" class="btn btn-default" data-dismiss="modal">Anuluj</button>
      </div> 
      
    </div>
  </div>
</div>		
<!-- ========================================================================= -->	