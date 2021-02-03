<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../taglib.jsp"%>
    
    <c:set var="ctx" value="${pageContext.servletContext.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion Salarie</title>
</head>
<body>
<jsp:useBean id="now" class="java.util.Date" />
<fmt:formatDate var="today" value="${now}" pattern="YYYY-MM-dd" />

	

	<h1>Mes demandes</h1>
	
	<!-- Button deconnect -->
	
	<c:if test="${pageContext.request.userPrincipal.name != null }">
			<jsp:include page="../logout.jsp"></jsp:include>
		</c:if>
		

	<!-- Button trigger  -->
	<button type="button" class="btn trigger"data-toggle="modal"
		id="popupAdd">Créer une demande de congé</button>
			
	<!-- form-->

		<div class="modal-wrapper" role="document">
			<div class="modalCreer">
				<div class="head">
				<a class="btn-close trigger" href="javascript:;"></a>
					<h5 class="modal-title" id="popupAjouterLabel">Créer une
						demande de congé</h5>
						
				</div>
				
				<form:form action="${ctx}/salarie/save" method="post" id="FormFiche" modelAttribute="conge">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
					<div class="form-group">
						<form:input type="hidden" path="salarie.id"></form:input>
						<form:errors path="salarie" element="div" cssClass="alert alert-danger"></form:errors>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<form:label path="dateDemande">Date de la demande : </form:label>${today}
							<form:input type="hidden" path="dateDemande" value="${today}"></form:input>
							<form:errors path="dateDemande" element="div" cssClass="alert alert-danger"></form:errors>
						</div>
						<div class="form-group">
							<form:label path="dateDebut">Date de début :</form:label> 
							<form:input path="dateDebut" id="dateDebut" type="date" value="${today}" min="${today}" onchange="dateFinMin()"></form:input>
							<form:errors path="dateDebut" element="div" cssClass="alert alert-danger"></form:errors>
						</div>
						<div class="form-group">
							<form:label path="dateFin">Date de fin :</form:label> 
							<form:input  id="dateFin" path="dateFin" type="date" value="${today}" min="${today}"></form:input>
							<form:errors path="dateFin" element="div" cssClass="alert alert-danger"></form:errors>
						</div>
						<div class="form-group">
							<form:label path="typeConge">Types de congé : </form:label> 
							<form:select id="type" path="typeConge" items="${typesConge}">
							</form:select>
							<form:errors path="typeConge" element="div" cssClass="alert alert-danger"></form:errors>
						</div>
						<div class="form-group">
							<form:label path="motif">Motif de la demande</form:label>
							<form:textarea class="form-control" path="motif" id="motif" rows="3" placeholder="Entrez un motif"></form:textarea>
							<form:errors path="motif" element="div" cssClass="alert alert-danger"></form:errors>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn trigger"
							data-dismiss="modal">Annuler</button>
						<button type="submit" class="btn btn-primary" id="btnSave" name="btnAjouter"
							value="Ajouter">Sauvegarder</button>
					</div>
				</form:form>
			</div>
		</div>
	

	<div id="content">
		<div class="tab-content" id="pills-tabContent">
			<div class="tab-pane fade show active" id="pills-emp" role="tabpanel"
				aria-labelledby="pills-emp-tab">
	<table class="table table-striped text-center">
		<thead>
			<tr>
				<th class="table-dark">Type de demande</th>
				<th class="table-dark">Date de début</th>
				<th class="table-dark">Date de fin</th>
				<th class="table-dark">Nombre de jour</th>
				<th class="table-dark">Motif</th>
				<th class="table-dark">Service</th>
				<th class="table-dark">Etat</th>
				<th class="table-dark"></th>
			</tr>
		</thead>
		<tbody id="listDemande">
			<c:forEach items="${conges}" var="demande">
				<tr>
					<td class="table-active">${demande.typeConge.libelle}</td>
					<td class="table-active">${demande.dateDebut}</td>
					<td class="table-active">${demande.dateFin}</td>
					<td class="table-active">${demande.nbJour}</td>
					<td class="table-active">${demande.motif}</td>
					<td class="table-active">${demande.salarie.service.libelle}</td>
					<c:choose>
					<c:when test="${demande.etat == 'VALIDE'}">
					<td class="table-active" style="color:green">${demande.etat}</td>
					</c:when>
					<c:when test="${demande.etat == 'REFUSE'}">
					<td class="table-active" style="color:red">${demande.etat}</td>
					</c:when>
					<c:when test="${demande.etat == 'ATTENTE'}">
					<td class="table-active" style="color:black">${demande.etat}</td>
					</c:when>
					</c:choose>
					<td class="table-active">
					<c:if test="${demande.etat == 'ATTENTE'}">
						<a href="${ctx}/salarie/delete?id=${demande.id}" class="btn btn-warning">supprimer</a>
					</c:if></td>
				</tr>

			</c:forEach>
		</tbody>
	</table>
	</div>
	</div>
	</div>
</body>
<script>
	

	function dateFinMin() {
		dateFin.value = dateDebut.value;
		dateFin.min = dateDebut.value;
	}
	
	//popup
	
	$( document ).ready(function() {
  $('.trigger').click(function() {
     $('.modal-wrapper').toggleClass('open');
    $('.modal-wrapper').toggleClass('blur');
     return false;
  });
});
</script>
</html>