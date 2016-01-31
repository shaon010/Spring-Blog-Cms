<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<h1>${post.title}</h1>

<p>${post.description}</p>

<br/>
<br/>
<br/>

<H3>Comments</H3>
<c:forEach items="${post.comment}" var="comment">
<tr>
				<td> 
					${comment.description}
					<br />
					<c:out value="${comment.publishedDate}" />
				</td>
				<td> 
				<a href="<spring:url value="/users/${user.id}.html" />">
					${comment.user.name}
					</a>
			</tr>
			<br/>

</c:forEach>

<br/>
<br/>
<br/>

<form:form commandName="comment" cssClass="form-horizontal comment">

	<div class="form-group">
		<label for="description" class="col-sm-3 col-lg-3 control-label">Give your comments here<span class="mandatory">*</span></label>
		<div class="col-sm-10 col-lg-5">
			<form:textarea path="description" class="form-control" rows="5" />
		</div>
	</div>
	<div class="form-group">
		<label for="email" class="col-sm-3 col-lg-3 control-label">Email:<span class="mandatory">*</span></label>
		<div class="col-sm-10 col-lg-5">
			<form:input type="email" path="email" class="form-control" rows="5" />
		</div>
	</div>
	<div class="form-group">
		<label for="email" class="col-sm-3 col-lg-3 control-label">Email:<span class="mandatory">*</span></label>
		<div class="col-sm-10 col-lg-5">
			<form:input type="tex" path="name" class="form-control" rows="5" />
		</div>
	</div>
	<form:input type="hidden" path="post" value="${post.id}" />
	<div style="text-align: center">
			<input type="submit" value="Submit Comment" class="btn btn-sm btn-primary" />
		</div>
</form:form>

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