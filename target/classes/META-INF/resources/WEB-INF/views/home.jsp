<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="./taglib.jsp"%>
<c:set var="ctx" value="${pageContext.servletContext.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bienvenue</title>
</head>
<body>
	<div class="container">
		<c:if test="${pageContext.request.userPrincipal.name != null }">
			<jsp:include page="logout.jsp"></jsp:include>
		</c:if>
		<h1>bonjour</h1>
		<div>
			<nav>
				<ul>
					<li><a href="${ctx}/salarie">Voir congés</a></li>
					<li><a href="${ctx}/manager">Voir les validations en
							attente</a></li>
					<li><a href="${ctx}/admin">Menu administrateur</a></li>
				</ul>
			</nav>
		</div>
	</div>
</body>
</html>