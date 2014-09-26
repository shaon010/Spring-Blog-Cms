<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<h1><c:out value="${user.name}" /></h1>

<br /><br />

<script type="text/javascript">
$(document).ready(function() {
	$(".triggerRemove").click(function(e) {
		e.preventDefault();
		$("#modalRemove .removeBtn").attr("href", $(this).attr("href"));
		$("#modalRemove").modal();
	});
});
</script>

	<table class="table table-bordered table-hover table-striped">
		<thead>
			<tr>
				<th>Title</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${user.posts}" var="post">
				<tr>
					<td><h3><c:out value="${post.title}" /></h3>
					<c:out value="${post.description}" /></td>
					<security:authorize access="hasRole('ROLE_ADMIN')">
              					<td><a href="<spring:url value="/post/remove/${post.id}.html" />" class="btn btn-danger triggerRemove">remove blog</a></td>
              </security:authorize>
				</tr>
			</c:forEach>
		</tbody>
	</table>

<!-- Modal -->
<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">Remove blog</h4>
      </div>
      <div class="modal-body">
        Really remove?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
        <a href="" class="btn btn-danger removeBtn">Remove</a>
      </div>
    </div>
  </div>
</div>