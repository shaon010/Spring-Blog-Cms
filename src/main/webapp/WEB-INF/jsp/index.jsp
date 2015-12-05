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
		<c:forEach items="${posts.getContent()}" var="post">
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
<center>
    <c:url var="firstUrl" value="/index/1" />
    <c:url var="lastUrl" value="/index/${posts.totalPages}" />
    <c:url var="prevUrl" value="/index/${currentIndex - 1}" />
    <c:url var="nextUrl" value="/index/${currentIndex + 1}" />

    <div class="pagination">
        <ul class="pagination">
            <c:choose>
                <c:when test="${currentIndex == 1}">
                    <li class="disabled"><a href="#">&lt;&lt;</a></li>
                    <li class="disabled"><a href="#">&lt;</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="${firstUrl}">&lt;&lt;</a></li>
                    <li><a href="${prevUrl}">&lt;</a></li>
                </c:otherwise>
            </c:choose>
            <c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
                <c:url var="pageUrl" value="/index/${i}" />
                <c:choose>
                    <c:when test="${i == currentIndex}">
                        <li class="active"><a href="${pageUrl}"><c:out value="${i}" /></a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="${pageUrl}"><c:out value="${i}" /></a></li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <c:choose>
                <c:when test="${currentIndex == posts.totalPages}">
                    <li class="disabled"><a href="#">&gt;</a></li>
                    <li class="disabled"><a href="#">&gt;&gt;</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="${nextUrl}">&gt;</a></li>
                    <li><a href="${lastUrl}">&gt;&gt;</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</center>


