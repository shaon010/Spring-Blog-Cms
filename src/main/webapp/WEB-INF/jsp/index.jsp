<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<h1>Latest Blogs from the Java Geeks</h1>

<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>Post</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${posts}" var="post">
			<tr>
				<td> 
					<strong>
						<a href="<spring:url value="/post/${post.title}.html" />">
							<c:out value="${post.title}" />
						</a> 
					</strong>
					<br />
					${post.description}
					<br />
					<c:out value="${post.publishedDate}" />
					<br/>
					<a href="<spring:url value="/users/${post.user.id}.html" />">
					<c:out value="${post.user.name}" />
					</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
