<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<jsp:include page="shared/header.jsp" />
<div role="main" class="container" style="margin-top: 100px;">
	<form action="${pageContext.request.contextPath}/main" method="post">
			
			<%-- <div> User (Session) : ${user}</div> --%>
			<c:if test="${not empty user}">
				<jsp:forward page="admin.jsp"></jsp:forward>
			</c:if>
			
			<c:if  test="${not empty message}">
				<div class="alert alert-danger" role="alert">
				 ${message}
				</div>
			</c:if>	

			<div class="input-group form-group">
				<div class="input-group-prepend">
					<span class="input-group-text"><i class="fa fa-user"></i></span>
				</div>
				<input type="text" class="form-control" placeholder="username" name="login" />
			</div>
			<div class="input-group form-group">
				<div class="input-group-prepend">
					<span class="input-group-text"><i class="fa fa-key"></i></span>
				</div>
				<input type="password" class="form-control" placeholder="password" name="password" />
			</div>
			<div class="form-group">
				<a href="${pageContext.request.contextPath}/main" class="btn btn-dark float-right login_btn" style="margin-left:10px;">Cancel</a>
				<input type="submit" value="Login" class="btn btn-dark float-right login_btn">
				
			</div>
		</form>
</div>
<jsp:include page="shared/footer.jsp" />   