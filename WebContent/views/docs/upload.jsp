<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../shared/header.jsp" />
<style>
	form{min-width:50%;}
</style>
<div role="main" class="container" style="margin-top: 100px;">
	<h3>
		<a class="btn float-right"
			href="${pageContext.request.contextPath}/docs"> <i
			class="fa fa-list"></i>
		</a> Documents : ${title}
	</h3>
	<form action="${pageContext.request.contextPath}/uploads" method="post"
		enctype="multipart/form-data">

		<c:if test="${not empty message}">
			<div class="alert alert-danger" role="alert">${message}</div>
		</c:if>

		<!-- 			
			<div class="input-group form-group">
 				<div class="input-group-prepend">
					<span class="input-group-text"><i class="fa fa-file-o"></i></span>
				</div>
				<input type="text" class="form-control" placeholder="name" name="name" />
			</div> -->
		<div class="input-group form-group">
			<input type="file" class="custom-file-input" id="customFile"
				name="filename"> <label class="custom-file-label"
				for="customFile"><i class="fa fa-file-o"></i> Choose file</label>
				
		</div>
		<input type="submit" name="btn_file_upload" value="Upload"
				class="btn btn-dark login_btn" /> 
		

		<%--
			<div class="input-group form-group">
 				<div class="input-group-prepend">
					<span class="input-group-text"><i class="fa fa-th-list"></i></span>
				</div> 
				<select name="type" class="form-control">
				    <option value="0">-- select type --</option>
				    <option value="1">Image</option>
				    <option value="2">PDF</option>
				    <option value="3">Word</option>
				    <option value="4">Other..</option>
				</select>
			</div>
 			<div class="input-group form-group">
 				<div class="input-group-prepend">
					<span class="input-group-text"><i class="fa fa-user-o"></i></span>
				</div> 
				<!-- <input type="number" class="form-control" placeholder="user(owner)" name="user" /> -->
				<select class="form-control" name="user">
				    <option value="0">-- select user --</option>
				    <c:forEach items="${users}" var="user">
				    	 <option value="${user.id}">${user}</option>
				    </c:forEach>
				</select>
			</div> 
			<div class="form-group">
				<input type="submit" value="Add" class="btn btn-dark float-right login_btn">				
			</div>--%>
	</form>


</div>
<jsp:include page="../shared/footer.jsp" />
<script>
$(".custom-file-input").on("change", function() {
  var fileName = $(this).val().split("\\").pop();
  $(this).siblings(".custom-file-label").addClass("selected").html('<i class="fa fa-file-o"></i> '+fileName);
});
</script>
