<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <!-- Modal -->
<div class="modal fade" id="modalEntityRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content modal-backcolor-content">
      <div class="modal-header">
        <a href="<spring:url value="${returnFromModalUrl}" />" class="close" ><span aria-hidden="true">&times;</span></a>
      </div>
      <div class="modal-body modal-backcolor-body">
        <h4 id ="question" ></h4>
      </div>
      <div class="modal-footer">
        <a href="<spring:url value="${returnFromModalUrl}" />" class="btn btn-default" >Nie</a>
        <a href="" class="btn btn-danger" id="removeBtn">Tak</a>
      </div>
    </div>
  </div>
</div>

