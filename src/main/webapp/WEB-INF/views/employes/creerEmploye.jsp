<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<c:import url="../header.jsp"></c:import>

<body>

	<c:import url="../navbar.jsp"></c:import>
	
	<div class="container">
		<a href="index.html"><i class="icon icon-arrow-left"
			aria-hidden="true" style="font-size: 100px; color: black;"></i></a>
		<div class="text-center" style="margin-top: -8%;">
			<h1>Ajouter un employé</h1>
		</div>
		<form class="form-horizontal" role="form" name="form" action="lister"
			method="post">
			<div class="form-group">
				<label for="inputMatricule" class="col-sm-7 control-label">Matricule</label>
				<div class="col-sm-10">
					<input type="text" name="matricule" class="form-control"id="matricule">
				</div>
			</div>
			<div class="form-group">
				<label for="inputEntreprise" class="col-sm-7 control-label">Entreprise</label>
				<div class="col-sm-10">
					<select class="form-control" name="entreprise">
						<c:forEach items="${entreprises}" var="entreprise">
							<option value="${entreprise.id}">${entreprise.denomination}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="form-group">
				<label for="inputProfil" class="col-sm-7 control-label">Profil</label>
				<div class="col-sm-10">
					<select class="form-control" name="profil">
						<c:forEach items="${profils}" var="profil">
							<option value="${profil.id}">${profil.code}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="form-group">
				<label for="inputPassword1" class="col-sm-7 control-label">Grade</label>
				<div class="col-sm-10">
					<select class="form-control" name="grade">
					<c:forEach items="${grades}" var="grade">
							<option value="${grade.id}">${grade.code} - ${grade.nbHeuresBase * grade.tauxBase * 12}/ ans</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-4 ">
					<div>
					<input type="submit" class="btn btn-success" value="Ajouter">
					</div>
				</div>
			</div>
		</form>

	</div>


<c:import url="../footer.jsp"></c:import>

</body>
</html>