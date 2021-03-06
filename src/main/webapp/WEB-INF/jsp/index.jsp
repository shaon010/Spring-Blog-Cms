<%@ taglib prefix="mytags" uri="/WEB-INF/mytags.tld" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<h1>Latest Blogs from the Java Geeks</h1>

<!-- ***************Begin Content Section*************** -->
<section class="content-area">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-9">
                <div class="article-section">
                    <div class="row">
                        <c:forEach items="${posts.getContent()}" var="post">
                                <div class="col-lg-4 col-md-4 col-sm-6"> <!-- col change 6 to 4 -->
                                    <div class="new-article">
                                        <div class="box-img" style="background-image: url('/resources/img/postImages/${post.bannerImageName == null ? "post.jpg": post.bannerImageName}');">

                                        </div>
                                        <div class="article-details">
                                            <h3><a post-id="${post.id}" class="read-post" href="<spring:url value="/post/${post.title}.html?postId=${post.id}" />">
                                                <c:out value="${post.title}" />
                                            </a></h3>
                                            <span><c:out value="${post.publishedDate}" />,
                                        <a href="<spring:url value="/users/${post.user.id}.html" />">
                                            <c:out value="${post.user.name}" />
                                        </a></span>
                                            <hr />
                                            <div class="short-description">
                                                <p><mytags:cropDescription description="${post.description}"/></p>
                                            </div>


                                        </div>
                                    </div>
                                </div>

                        </c:forEach>
                    </div>

                </div>
                <div class="col-lg-12 ">
                    <div class="pagination-area">
                        <c:url var="firstUrl" value="/index/1${categorySuffix}" />
                        <c:url var="lastUrl" value="/index/${posts.totalPages}${categorySuffix}" />
                        <c:url var="prevUrl" value="/index/${currentIndex - 1}${categorySuffix}" />
                        <c:url var="nextUrl" value="/index/${currentIndex + 1}${categorySuffix}" />

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
                                    <c:url var="pageUrl" value="/index/${i}${categorySuffix}" />
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
                    </div>
                </div>
            </div>
            <div class="col-lg-3">
                <div class="widget-area">
                    <!-- begin single widget -->
                    <div class="single-widget">
                        <div class="widget-title">
                            <h3>Category</h3>
                        </div>
                        <div class="widget-content">
                            <ul class="tales-list">
                                <c:forEach items="${categoryList}" var="category">
                                    <li><a href="<c:url value="/index/1/categoryId=${category.id}" />"><c:out value="${category.name}" /></a></li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                    <!-- End single widget -->

                    <!-- begin single widget -->
                    <div class="single-widget">
                        <div class="widget-title">
                            <h3>Read next...</h3>
                        </div>
                        <div class="widget-content">
                            <ul class="tales-list">
                                <c:forEach items="${readNext.getContent()}" var="nextPost">
                                    <li><a post-id="${nextPost.id}" class="read-post" href="<spring:url value="/post/${nextPost.title}.html?postId=${nextPost.id}" />">
                                        <c:out value="${nextPost.title}" />
                                    </a></li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                    <!-- End single widget -->

                    <!-- begin single widget -->
                    <%--<div class="single-widget">
                        <div class="widget-title">
                            <h3>Tags</h3>
                        </div>
                        <div class="widget-content">
                            <ul class="tags">
                                <li><a href="#">OpenPGP</a></li>
                                <li><a href="#">Django</a></li>
                                <li><a href="#">Bitcoin</a></li>
                                <li><a href="#">Security</a></li>
                                <li><a href="#">GNU/Linux</a></li>
                                <li><a href="#">Git</a></li>
                                <li><a href="#">Homebrew</a></li>
                                <li><a href="#">Debian</a></li>
                            </ul>
                        </div>
                    </div>--%>
                    <!-- End single widget -->

                </div><!--  End Widget_area -->
            </div>
        </div>
    </div>
</section>
<!-- ***************End Content Section*************** -->

<%--
<script type="text/javascript">
    $(document).ready(function() {
        $(".read-post").on("click", function(e) {
            e.preventDefault();
            e.stopPropagation();
            var postId = $(this).attr("post-id");
            var postLink = $(this).attr("href");
            $.get(postLink, {postId: postId});
        })
     });
</script>--%>


