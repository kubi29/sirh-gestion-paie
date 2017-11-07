<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<c:import url="../header.jsp"></c:import>

<body>

	<c:import url="../navbar.jsp"></c:import>


  <div class="container">
        <!-- <a href="index.html"><i class="icon icon-arrow-left" aria-hidden="true" style="font-size:100px;color:black;"></i></a> -->
        <div class="text-center">
            <h1>Liste des employés</h1>
        </div>

        <a href="<c:url value='/mvc/employes/creer'/>">Ajouter un employé</a>

        <table class="table table-hover table-bordered">
            <thead>
                <tr>
                    <th width="40%;">Date / Heure de création</th>
                    <th>Matricule</th>
                    <th>Grade</th>
                </tr>
            </thead>
            <tbody>
				<c:forEach var="employe" items="${employes}">
					<tr>
						<td>${employe.dateHeureCreation}</td>
						<td>${employe.matricule}</td>
						<td>${employe.grade.code}</td>
					</tr>
				</c:forEach>
			</tbody>
        </table>
    </div>


	<c:import url="../footer.jsp"></c:import>
</body>
</html>