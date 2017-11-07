<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="../header.jsp"></c:import>

<body>

	<c:import url="../navbar.jsp"></c:import>

	<div class="container">
		<a href="index.html"><i class="icon icon-arrow-left"
			aria-hidden="true" style="font-size: 100px; color: black;"></i></a>
		<div class="text-center" style="margin-top: -8%;">
			<h1>Ajouter un bulletin</h1>
		</div>
		<form class="form-horizontal" role="form" name="form" action="lister"
			method="post">
			<div class="form-group">
				<label for="inputPeriode" class="col-sm-7 control-label">Période</label>
				<div class="col-sm-10">
					<select class="form-control" name="periode" id="periode">
					<c:forEach items="${periodes}" var="periode">
						<option value="${periode.id}">${periode.dateDebut} - ${periode.dateFin}</option>
					</c:forEach>
					</select>
				</div>
			</div>

			<div class="form-group">
				<label for="inputMatricule" class="col-sm-7 control-label">Matricule</label>
				<div class="col-sm-10">
					<select class="form-control" name="employe" id="employe">
						<c:forEach items="${employes}" var="employe">
						<option value="${employe.id}">${employe.matricule}</option>
					</c:forEach>
					</select>
				</div>
			</div>

			<div class="form-group">
				<label for="inputPrime" class="col-sm-7 control-label">Prime
					Exceptionnelle</label>
				<div class="col-sm-10">
					<input type="text" name="primeExceptionnelle" class="form-control" id="primeExceptionnelle">
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-20">
					<button type="submit" class="btn btn-primary"
						style="margin-left: 54.5%;">
						<i class="icon icon-check icon-lg"></i> Ajouter
					</button>
				</div>
			</div>
		</form>

	</div>
	<c:import url="../footer.jsp"></c:import>

</body>
</html>