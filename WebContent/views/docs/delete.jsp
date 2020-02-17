<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../shared/header.jsp" />
<style>
	form{max-width: 100% !important;}
</style>
<div role="main" class="container" style="margin-top: 100px;">
	<h3>
		<a class="btn float-right" href="${pageContext.request.contextPath}/docs">
			<i class="fa fa-list"></i>
		</a>
		Documents : ${title}
	</h3>
	<c:if  test="${not empty item}">
		<div class="alert alert-danger" role="alert">
		 
		 <form action="${pageContext.request.contextPath}/docs" method="post">
		 	<div class="form-group">
		 		<input name="id" type="hidden" value="${item.id}" />	
		 		<input name="btn_delete_action" type="submit" value="Delete!" class="btn btn-dark float-right login_btn">
				<h6>Delete '${item.name} (owner : ${item.user})' ?</h6> 								
			</div>
		 </form>
		</div>
	</c:if>	
	
</div>
<jsp:include page="../shared/footer.jsp" />   