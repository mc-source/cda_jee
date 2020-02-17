<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>${title}</title>

<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

<link rel="stylesheet" href="./assets/css/custom.css" media="all" />
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
			<a class="navbar-brand" href="#"> <img
				src="./assets/images/jee.png" alt="logo" class="logo" /> WebSite!
			</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarCollapse" aria-controls="navbarCollapse"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarCollapse">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link" href="./main">Accueil</a></li>
					<li class="nav-item"><a class="nav-link" href="./main?page=about">About</a></li>
					<li class="nav-item"><a class="nav-link" href="./main?page=contact">Contact</a></li>
					<li>|</li>
					<li class="nav-item"><a class="nav-link" href="./main?page=login">Admin</a></li>
					<li>|</li>
					<li class="nav-item"><a class="nav-link" href="./docs">Documents</a></li>
					
				</ul>
				<div class="float-right" style="color:white;">
					<c:if test="${not empty user}">
						<h6 style="display:inline;">welcome ${user.firstname}!</h6>
						<a style="display: inline;" class="nav-link" href="./main?page=logout">
							<i class="fa fa-sign-out fa-2x" aria-hidden="true"></i>
						</a>
					</c:if>
					<c:if test="${empty user}">
						<a class="nav-link" href="./main?page=login" >
							<i class="fa fa-sign-in fa-2x" aria-hidden="true"></i>
						</a>
					</c:if>
				</div>
				
<!-- 				<form class="form-inline mt-2 mt-md-0">
					<input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
				</form> -->
			</div>
		</nav>
	</header>