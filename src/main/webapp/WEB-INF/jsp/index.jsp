<%@ taglib prefix="mytags" uri="/WEB-INF/mytags.tld" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<h1>Latest Blogs from the Java Geeks</h1>

<!-- ***************Begin Content Section*************** -->
<section class="content-area">
    <div class="container">
        <div class="row">
            <div class="col-lg-8">
                <div class="article-section">
                    <c:forEach items="${posts.getContent()}" var="post">
                        <div class="col-lg-6">
                            <div class="single-article">
                                <div class="art-title">
                                    <img src=<spring:url value="/resources/img/flash-post.png"/> alt="">
                                    <h3><a href="<spring:url value="/post/${post.title}.html" />">
                                        <c:out value="${post.title}" />
                                    </a></h3>
                                    <span><c:out value="${post.publishedDate}" />,
                                        <a href="<spring:url value="/users/${post.user.id}.html" />">
                                        <c:out value="${post.user.name}" />
                                    </a></span>
                                    <hr></hr>
                                </div>
                                <div class="art-body">
                                    <p><mytags:cropDescription description="${post.description}"/></p>
                                    <button type="button" class="btn btn-success read-more"><a href="<spring:url value="/post/${post.title}.html" />">Read More</a></button>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <div class="col-lg-12 ">
                    <div class="pagination-area">
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
                    </div>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="widget-area">
                    <!-- begin single widget -->
                    <div class="single-widget">
                        <div class="widget-title">
                            <h3>Authors Favorites</h3>
                        </div>
                        <div class="widget-content">
                            <ul class="tales-list">
                                <li><a href="index.html">Email Encryption Explained</a></li>
                                <li><a href="#">Selling is a Function of Design.</a></li>
                                <li><a href="#">It’s Hard To Come Up With Dummy Titles</a></li>
                                <li><a href="#">Why the Internet is Full of Cats</a></li>
                                <li><a href="#">Last Made-Up Headline, I Swear!</a></li>
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
                                <li><a href="index.html">Email Encryption Explained</a></li>
                                <li><a href="#">Selling is a Function of Design.</a></li>
                                <li><a href="#">It’s Hard To Come Up With Dummy Titles</a></li>
                                <li><a href="#">Why the Internet is Full of Cats</a></li>
                                <li><a href="#">Last Made-Up Headline, I Swear!</a></li>
                            </ul>
                        </div>
                    </div>
                    <!-- End single widget -->

                    <!-- begin single widget -->
                    <div class="single-widget">
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
                    </div>
                    <!-- End single widget -->

                </div><!--  End Widget_area -->
            </div>
        </div>
    </div>
</section>
<!-- ***************End Content Section*************** -->


