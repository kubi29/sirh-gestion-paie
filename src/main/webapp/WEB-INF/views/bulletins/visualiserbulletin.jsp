<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="../header.jsp"></c:import>

<body>

	<c:import url="../navbar.jsp"></c:import>

<form action="">
	<div class="container top">

		<div class="row">

			<div class="col-3">

				<label>Entreprise</label> <br>

				${bulletin.remunerationEmploye.entreprise.denomination} <br>

				SIRET : ${bulletin.remunerationEmploye.entreprise.siret}

			</div>

			<div class="col-3 offset-6">

				<label>Période</label><br> Du

				${bulletin.periode.dateDebut} au

				${bulletin.periode.dateFin} <br> <br> <label>Matricule

					: ${bulletin.remunerationEmploye.matricule}</label>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<h3>Salaire</h3>
				<table class="table table-bordered table-hover">
					<thead>
						<tr class="grey">
							<td>Rubriques</td>
							<td>Base</td>
							<td>Taux Salarial</td>
							<td>Montant Salarial</td>
							<td>Taux patronal</td>
							<td>Cot. patronales</td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="grey">Salaire de base</td>
							<td>${bulletin.remunerationEmploye.grade.nbHeuresBase}</td>
							<td>${bulletin.remunerationEmploye.grade.tauxBase}</td>
							<td>${remuneration.salaireDeBase }</td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td class="grey">Prime Except.</td>
							<td></td>
							<td></td>
							<td>${bulletin.primeExceptionnelle}</td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td class="grey"></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td class="grey">Salaire Brut</td>
							<td></td>
							<td></td>
							<td>${remuneration.salaireBrut}</td>
							<td></td>
							<td></td>
						</tr>
					</tbody>
				</table>
				<h3>Cotisations</h3>
				<table class="table table-bordered table-hover">
					<thead>
						<tr class="grey">
							<td>Rubriques</td>
							<td>Base</td>
							<td>Taux Salarial</td>
							<td>Montant Salarial</td>
							<td>Taux patronal</td>
							<td>Cot. patronales</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach  items="${cotisationsN}" var="cotisation">
							<tr>
								<td>${cotisation.code} ${cotisation.libelle}</td>
								<td>${remuneration.salaireBrut}</td>
								<td>${cotisation.tauxSalarial }</td>
								<td><c:if test="${cotisation.tauxSalarial != null}">
										${remuneration.salaireBrut * cotisation.tauxSalarial}
								</c:if></td>
								<td>${cotisation.tauxPatronal}</td>
								<td><c:if test="${cotisation.tauxPatronal != null}">
									${remuneration.salaireBrut * cotisation.tauxPatronal}
								</c:if></td>
							</tr>
						</c:forEach>
						<tr>
							<td class="grey">Total Retenue</td>
							<td></td>
							<td></td>
							<td>${remuneration.totalRetenueSalarial}</td>
							<td></td>
							<td>${remuneration.totalCotisationsPatronales}</td>
						</tr>
					</tbody>
				</table>
				<h3>NET Imposable : ${remuneration.netImposable }</h3>
				<table class="table table-bordered table-hover">
					<thead>
						<tr class="grey">
							<td>Rubriques</td>
							<td>Base</td>
							<td>Taux Salarial</td>
							<td>Montant Salarial</td>
							<td>Taux patronal</td>
							<td>Cot. patronales</td>
						</tr>
					</thead>
					<tbody>
					<c:forEach  items="${cotisations}" var="cotisation">
							<tr>
								<td>${cotisation.code} ${cotisation.libelle}</td>
								<td>${remuneration.salaireBrut}</td>
								<td>${cotisation.tauxSalarial }</td>
								<td><c:if test="${cotisation.tauxSalarial != null}">
										${remuneration.salaireBrut * cotisation.tauxSalarial}
								</c:if></td>
								<td>${cotisation.tauxPatronal}</td>
								<td><c:if test="${cotisation.tauxPatronal != null}">
									${remuneration.salaireBrut * cotisation.tauxPatronal}
								</c:if></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="col-3 offset-9" style="text-align: right;">
					<label>NET A PAYER : ${remuneration.netAPayer} €</label>
				</div>
			</div>
		</div>
	</div>
</form>



	<c:import url="../footer.jsp"></c:import>

</body>
</html>