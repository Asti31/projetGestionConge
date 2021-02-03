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
				<form action="salarie/save" method="post" id="FormFiche" modelAttribute="conge">
					<div class="modal-body">
						<label for="date">Date de la demande :</label> ${aujourdhui}<br>
						<label for="dateDebut">Date de début :</label> <input required
							id="dateDebut" name="dateDebut" type="date" value="${today}"
							min="${today}" onchange="dateFinMin()"><br> <label
							for="dateFin">Date de fin :</label> <input required id="dateFin"
							name="dateFin" type="date" value="${today}" min="${today}"><br>
						<label for="type">Types de congé : </label> <select required
							id="type" name="type">
							<option value="" selected="selected">Choisir un type de
								congé</option>
							<option value="CP">Congés payés</option>
							<option value="CSS">Congés sans solde</option>
							<option value="AA">Absence autorisée</option>
							<option value="AJ">Absence justifiée</option>
						</select><br> <label for="motif">Motif de la demande</label>
						<textarea class="form-control" name="motif" id="motif" rows="3"
							placeholder="Entrez un motif"></textarea>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn trigger"
							data-dismiss="modal">Annuler</button>
						<button type="submit" class="btn btn-primary" id="btnSave" name="btnAjouter"
							value="Ajouter">Sauvegarder</button>
					</div>
				</form>
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
					
						<form class="formReponse" name="formReponse"
								action="salarie" method="post">
								<input type="hidden" value="${demande.id}" name="id_conge">
								<input type="submit" name="btnAnnuler" class="btn btn-warning"
									value="Annuler">
							</form>
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