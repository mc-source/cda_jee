<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../shared/header.jsp" />
<style>
	.btn{
		padding : 0 !important;
		display : inline !important;
	}
	table.table tr td {
	    padding: 5px 15px !important;
	}
</style>
<div role="main" class="container" style="margin-top: 100px;">	
	<c:if test="${not empty user && user.admin==1}">
		<a href="./docs?action=add" class="btn float-right"><i class="fa fa-2x fa-plus-square" aria-hidden="true"></i></a>
	</c:if>
	<h3>${title}</h3>
	
	<c:if test="${empty user}">
		<div class="alert alert-danger" role="alert">
			<h5>Vous devez vous authentifier pour avoir accès aux documents!</h5>
			<a href="./main?page=login">Login</a>
		</div>
	</c:if>
	<c:if test="${not empty user}">
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th>#</th>
					<th>Name</th>
					<th>Path</th>
					<th>Type</th>
					<th>User</th>
					<c:if test="${user.admin==1}">
						<th></th>
					</c:if>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${items}" var="item">
					<tr>
						<td>${item.id}</td>
						<td>${item.name}</td>
						<td>
							${item.path} <%-- <a href="${item.path}">${item.path}</a> --%>					
						</td>
						<td>${item.type}</td>
						<td>${item.user}</td>
						<c:if test="${user.admin==1}">
						<td>
							<a class="btn" href="./docs?action=delete&id=${item.id}">
								<i class="fa fa-trash" aria-hidden="true"></i>
							</a>
							<a class="btn" href="./docs?action=update&id=${item.id}">
								<i class="fa fa-pencil" aria-hidden="true"></i>
							</a>
						</td>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</div>
<jsp:include page="../shared/footer.jsp" />
