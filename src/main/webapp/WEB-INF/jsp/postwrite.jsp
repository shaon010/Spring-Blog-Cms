<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<script src="//cdn.tinymce.com/4/tinymce.min.js"></script>
<script>tinymce.init({
	selector:'textarea',
	plugins: [
		'advlist autolink lists link image charmap print preview anchor',
		'searchreplace visualblocks code fullscreen',
		'insertdatetime media table contextmenu paste code'
	]
});</script>

<form:form commandName="post" cssClass="form-horizontal postform"  enctype="multipart/form-data">
	<div class="form-group">
		<label for="title" class="col-sm-2 control-label">Name:</label>
		<div class="col-sm-10">
			<form:input path="title" cssClass="form-control" />
		</div>
	</div>
	<div class="form-group">
		<label for="imageName" class="col-sm-2 control-label">Banner Image:</label>
		<div class="col-sm-10">
			<input type="file" id="imageName" name="imageName"/>
		</div>
	</div>
	<div class="form-group">
		<label for="description" class="col-sm-2 control-label">Write Blog</label>
		<div class="col-sm-10">
			<form:textarea path="description" class="form-control required" id="description" rows="10" />
		</div>
	</div>
	<div class="form-group">
		<label for="category" class="col-sm-2 control-label">Category:</label>
		<div class="col-sm-10">
			<form:select path="category.id" class="form-control required">
				<option value="" label="--- Select ---" />
				<c:forEach var="category" items="${categoryList}">
					<option value="${category.getId() }">
						${category.getTitle()}
                    </option>
				</c:forEach>
			</form:select>
			<div class="form-group">
				<div class="col-sm-2 control-label">
					<input type="submit" value="Submit Post"
						class="btn btn-lg btn-primary" />
				</div>
			</div>
		</div>
	</div>
</form:form>

<script type="text/javascript">
$(document).ready(function() {
	$(".postform").validate(
		{
			rules: {
				title: {
					required : true,
					minlength : 3,
				},
				description: {
					required : true,
					minlength : 3,
				}
			},
			highlight: function(element) {
				$(element).closest('.form-group').removeClass('has-success').addClass('has-error');
			},
			unhighlight: function(element) {
				$(element).closest('.form-group').removeClass('has-error').addClass('has-success');
			}
		}
	);
});
</script>