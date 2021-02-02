<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./taglib.jsp"%>

<c:set var="ctx" value="${pageContext.servletContext.contextPath}" />

<div align="right">
	<form action="${ctx}/logout" method="post" class="form-inline">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}">
		${pageContext.request.userPrincipal.name}&nbsp;
		<button class="btn btn-link">lougout</button>
	</form>
</div>