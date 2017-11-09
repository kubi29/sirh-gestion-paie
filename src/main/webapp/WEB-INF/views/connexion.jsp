<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Paie - App</title>
<link rel="stylesheet"
	href='<c:url value="./bootstrap-
3.3.7/dist/css/bootstrap.min.css"></c:url>'>
</head>
<body class="container">
	<h1>Connexion</h1>
	<!-- Spring Security s'attend aux paramètres "username" et "password" -->

	<form method="post" class="top">
		<sec:csrfInput />
		<div>
			<div class="row">
				<div class="col-md-6 offset-md-3">
					<label class="control-label" for="username">Utilisateur</label> <input
						id="username" name="username" type="text"
						placeholder="Nom d'utilisateur" class="form-control input-md"
						required>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6 offset-md-3">
					<label class="control-label" for="password">Mot de passe</label> <input
						id="password" name="password" type="password"
						placeholder="Mot de passe" class="form-control input-md" required>
				</div>
			</div>
			<br>
			<div class="col-md-6 offset-md-3 top">
				<input type="submit" class="btn btn-success float-right" value="Se connecter">
			</div>
		</div>

	</form>

	<!-- en cas d'erreur un paramètre "error" est créé par Spring Security -->
	<c:if test="${param.error !=null}">
Erreur d'authentification
</c:if>
</body>
</html>