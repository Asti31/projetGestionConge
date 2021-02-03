<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ include file="../taglib.jsp"%>
    <c:set var="ctx" value="${pageContext.servletContext.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Bonjour Manager</h1>

	<c:if test="${pageContext.request.userPrincipal.name != null }">
			<jsp:include page="../logout.jsp"></jsp:include>
		</c:if>
		
		
		
		<div id="content">
		<div class="tab-content" id="pills-tabContent">
			<div class="tab-pane fade show active" id="pills-emp" role="tabpanel"
				aria-labelledby="pills-emp-tab">
				<table class="table table-striped text-center">
					<thead>
						<tr>
							<th class="table-dark">Nom du demandeur</th>
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
								<td class="table-active">${demande.salarie.nom} ${demande.salarie.prenom}</td>
								<td class="table-active">${demande.typeConge.libelle}</td>
								<td class="table-active">${demande.dateDebut}</td>
								<td class="table-active">${demande.dateFin}</td>
								<td class="table-active">${demande.nbJour}</td>
								<td class="table-active">${demande.motif}</td>
								<td class="table-active">${demande.salarie.service.libelle}</td>
								<c:choose>
					<c:when test="${demande.etat == 'VALIDE'}">
					<td  class="table-active" style="color:green">${demande.etat}</td>
					</c:when>
					<c:when test="${demande.etat == 'REFUSE'}">
					<td  class="table-active" style="color:red">${demande.etat}</td>
					</c:when>
					<c:when test="${demande.etat == 'ATTENTE'}">
					<td  class="table-active" style="color:black">${demande.etat}</td>
					</c:when>
					</c:choose>
					<td  class="table-active">
								<c:if test="${demande.etat == 'ATTENTE'}">
								
								
								<form:form class="formReponse" name="formReponse" action="${ctx}/manager?id=${demande.id}" method="post" modelAttribute="conge">
								<input type="submit" class="btn btn-success" name="btnReponse" value="Valider">
								</form:form>
									<button type="button" name="btnReponse" class="btn btn-danger"
										value="Refuser" data-toggle="modal"
										data-target="#popupRefuser${demande.id}">Refuser</button>
									<div class="modal fade" id="popupRefuser${demande.id}" tabindex="-1"
										role="dialog" aria-labelledby="popupRefuserLabel"
										aria-hidden="true">
										<div class="modal-dialog" role="document">
											<div class="modal-content">
												<div class="modal-header">
													<h5 class="modal-title" id="popupRefuserLabel">Motif
														du refus</h5>
													<button type="button" class="close" data-dismiss="modal"
														aria-label="Close">
														<span aria-hidden="true">&times;</span>
													</button>
												</div>
												<form:form class="formReponse" name="formReponse" action="${ctx}/manager?id=${demande.id}" method="post" modelAttribute="conge">
								<input type="submit" class="btn btn-success" name="btnReponse" value="Valider">>
													<div class="modal-body">
														<input type="hidden" value="${demande.id}" name="id_conge">
														<label for="motifRefus">Motif du refus</label>
														<textarea required class="form-control" name="motifRefus"
															id="motifRefus" rows="3" placeholder="Entrez un motif"></textarea>
													</div>
													<div class="modal-footer">
														<button type="button" class="btn btn-secondary"
															data-dismiss="modal">Fermer</button>
														<button type="submit" name="btnReponse"
															class="btn btn-primary" name="btnRefuser" value="Refuser">Sauvegarder</button>
													</div>
												</form:form>
											</div>
										</div>
									</div>
									
									</c:if>
									</td>
							</tr>

						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>