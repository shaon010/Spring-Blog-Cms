<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>
<section class="post-area">
	<div class="container">
		<div class="row">
	<div class="col-lg-8">
		<div class="post-content">
			<div class="article">
				<div class="title">
					<h1>${post.title}</h1>
					<div class="image">
						<img src="/resources/img/postImages/${post.bannerImageName == null ? "post.jpg": post.bannerImageName}"/>
						<div class="meta clearfix">
							<div class="author">
								<i class="fa fa-user"></i>
								<span class="data">${post.user.name}</span>
							</div>
							<div class="date">
								<i class="fa fa-calendar"></i>
								<span class="data"><c:out value="${post.publishedDate}"/></span>
							</div>
							<div class="comments">
								<i class="fa fa-comments"></i>
								<span class="data"><a href="#comments">${post.comment != null? post.comment.size(): 0} Comments</a></span>
							</div>
						</div>
					</div>
				</div>
				<div class="body">
					<p>${post.description}</p>
				</div><!--   ENd BODy -->

			</div><!--  END article -->

			<!--      Social Icon below  -->
			<div class="col-md-10 tales-superblock">
				<div class="social-icons clearfix">
					<a href="#" class="social-icon color-one">
						<div class="inner-circle" ></div>
						<i class="fa fa-twitter"></i>
					</a>

					<a href="#" class="social-icon color-two">
						<div class="inner-circle" ></div>
						<i class="fa fa-google-plus"></i>
					</a>

					<a href="#" class="social-icon color-three">
						<div class="inner-circle" ></div>
						<i class="fa fa-github-alt"></i>
					</a>
				</div>
				<hr>
			</div>
			<!--   ********************   Comment Section ******************** -->
			<div class="col-lg-12 comment-section-area">
				<h2><i class="fa fa-comments"></i>${post.comment != null? post.comment.size(): 0} Comments</h2>
				<c:forEach items="${post.comment}" var="comment">
					<div class="comment">
						<div class="cmt-title clearfix">
							<img src="img/avatar.png" alt="A Smart Guy" class="avatar">
							<div class="meta">
								<h3><a href="#">${comment.name}</a></h3>
                                                    <span class="date">
                                                       <c:out value="${comment.publishedDate}" />
                                                    </span>
                                                    <span class="separator">
                                                        -
                                                    </span>
								<a href="#create-comment" class="reply-link">Reply</a>
							</div>
						</div>
						<div class="cmt-body">${comment.description}</div>
					</div>
				</c:forEach>

			</div>
			<div class="col-lg-12">
				<div class="create-comment" id="create-comment">
					<hr>
					<h2><i class="fa fa-heart"></i> Add Comment</h2>
					<form:form commandName="comment" accept-charset="utf-8">
						<div class="row">
							<div class="col-md-6">
								<form:input type="text" path="name" id="comment-name" placeholder="Name" class="form-control input-lg"/>
							</div>
							<input type="hidden" name="postId" value="${post.id}"/>
							<div class="col-md-6">
								<form:input type="email" path="email" id="comment-email" placeholder="Email" class="form-control input-lg"/>
							</div>
						</div>
						<form:textarea path="description" id="comment-body" placeholder="Your thoughts..." class="form-control input-lg"/>

						<div class="buttons clearfix">
							<button class="btn btn-lg btn-cancel">Cancel</button>
							<button type="submit" class="btn btn-lg btn-success">Submit</button>
						</div>
					</form:form>
				</div>
			</div>
		</div><!--  ENd post-content-->
	</div><!--  End Col-lg-8 -->


			<!--       Sidebar  -->
			<div class="col-lg-4">
				<div class="widget-area">

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


				</div><!--  End Widget_area -->
			</div>
		</div>
	</div>
</section>
<!-- ***************End Content Section*************** -->

<script type="text/javascript">
$(document).ready(function() {
	$(".comment").validate(
		{
			rules: {
				description: {
					required : true,
					minlength : 1,
				}
			
			},
			highlight: function(element) {
				$(element).closest('.form-group').removeClass('has-success').addClass('has-error');
			},
			unhighlight: function(element) {
				$(element).closest('.form-group').removeClass('has-error').addClass('has-success');
			},
		}
	);
});
</script>