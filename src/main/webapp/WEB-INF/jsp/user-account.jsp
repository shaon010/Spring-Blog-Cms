<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>
<h1><c:out value="${user.name}" /></h1>
<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>Post</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${user.posts}" var="post">
			<tr>
				<td> 
					<strong>
						<a href="<spring:url value="/post/${post.id}.html" />">
							<c:out value="${post.title}" />
						</a> 
					</strong>
					<c:out value="${post.publishedDate}" />
					<br/>
					<a href="<spring:url value="/account.html" />">
					<c:out value="${post.user.name}" />
					</a>
				</td>
				<td><a href="<spring:url value="/post/remove/${post.id}.html" />" class="btn btn-danger triggerRemove">remove blog</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
