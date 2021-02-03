<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="./taglib.jsp"%>
<c:set var="ctx" value="${pageContext.servletContext.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">

<title>Accueil</title>
</head>
<body>

	<div id="container">
		<c:if test="${param.error != null}">
			<div class="alert alert-danger">erreur d'authentification</div>
		</c:if>
		<div class="login">

			<h1>Se connecter</h1>
		</div>
		<form  method="post">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}">
			<div class="form-group">
				<label><b>Email :</b></label> <input name="username" placeholder="Entrer votre mail"
					class="form-control" required="required">
			</div>
			<div class="form-group">
				<label>Mot de passe : </label><input type="password" name="password"
					class="form-control" required="required">
			</div>
			<div class="form-group">
				<button class="btn btn-outline-success" type="submit">envoyer</button>
				<a href="${ctx}" class="btn btn-outline-warning">annuler</a>
			</div>
		</form>

	</div>
</body>
</html>