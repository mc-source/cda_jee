<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.ZoneId" %>
<%@ page import="java.time.format.DateTimeFormatter" %>

<%
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy - HH:mm");
	LocalDateTime date = LocalDateTime.now(ZoneId.of("Europe/Paris"));
	String parsedDate = date.format(formatter);
%>

<%-- <%@ page import="cda.afip.model.User" %> --%>
<%
	//Récup user (eventuel) à partir Session!
	//User u = (User)request.getSession().getAttribute("user");
%>

<jsp:include page="shared/header.jsp" />
<div role="main" class="container" style="margin-top: 100px;">
	<h3>Admin. Area! [${user}]</h3>
	 <!-- object 'user' (User) dans Session!! -->
	
	<div class="alert alert-success" role="alert">
<%-- 		${message} ${user}
		<br/> --%>

		<h6>Bienvenue sur zone admin! Nous sommes le <%=parsedDate%>.</h6>
	
	</div>
	<a href="${pageContext.request.contextPath}/main">Accueil</a>
</div>
<jsp:include page="shared/footer.jsp" />   