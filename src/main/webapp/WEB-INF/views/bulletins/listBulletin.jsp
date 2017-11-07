<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="../header.jsp"></c:import>

<body>

	<c:import url="../navbar.jsp"></c:import>

	<div class="container">
		<!-- <a href="index.html"><i class="icon icon-arrow-left" aria-hidden="true" style="font-size:100px;color:black;"></i></a> -->
		<div class="text-center">
			<h1>Liste des Bulletin</h1>
		</div>

		<a href="<c:url value='/mvc/bulletins/creer'/>" class="btn btn-info" role="button"
			style="margin-bottom: 2%; margin-left: 84%;">Crée un nouveau
			bulletin</a>

		<table class="table table-hover table-bordered">
			<thead>
				<tr>
					<th width="20%;">Date / Heure de création</th>
					<th>Période</th>
					<th>Matricule</th>
					<th>Salaire Brut</th>
					<th>Net Impossable</th>
					<th>Net A Payer</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="bulletin" items="${bulletins}">
					<tr>
						<td>${bulletin.remunerationEmploye.dateHeureCreation}</td>
						<td>${bulletin.periode.dateDebut} - ${bulletin.periode.dateFin}</td>
						<td>${bulletin.remunerationEmploye.matricule}</td>
						<td>xxx</td>
						<td>xxx</td>
						<td>xxx</td>
						<td><a class="btn" href="<c:url value='/mvc/bulletins/visualiser/${bulletin.id}'/>">Visualiser</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<c:import url="../footer.jsp"></c:import>

</body>
</html>