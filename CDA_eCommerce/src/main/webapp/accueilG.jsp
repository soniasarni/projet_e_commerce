
<%@ include file="../menu/header2G.jsp" %> 




<div class="container">
	<p class="p_white"><a class="nav-link active pop" aria-current="page" href="<%= request.getContextPath()+"/recherche?tri=pop" %>">Les + populaire</a></p>
	<hr class="hr">
</div>

<div class="container">
	<div class="row">
		<c:forEach items="${les_plus_populaires}" var="popul">
			<div class="col-sm-4">
				<div class="card mt-3">
					<div class="card-body">
						<center>
							<img src="${popul.image}"/>
							<h5 class="card-title">${popul.nom}</h5>
							<p class="card-text">${popul.description}</p>
							<a href="<%= request.getContextPath()+"/consulterProduit?reference=" %>${popul.reference}" class="btn btn-primary" style="background:#F90FC4;">Consulter</a>
						</center>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>



<div class="container">

	<a class="nav-link active pop2" aria-current="page" href="<%= request.getContextPath()+"/recherche?tri=recent" %>">Les + récents</a>

	<hr class="hr">
</div>
<div class="container">
	<div class="row">
		<c:forEach items="${les_plus_recents}" var="recent">
			<div class="col-sm-4">
				<div class="card mt-3">
					<div class="card-body">
						<center>
							<img src="${recent.image}"/>
							<h5 class="card-title">${recent.nom}</h5>
							<p class="card-text">${recent.description}</p>
							<a href="<%= request.getContextPath()+"/consulterProduit?reference=" %>${recent.reference}" class="btn btn-primary" style="background:#F90FC4;">Consulter</a>
						</center>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>


<div class="container">

	<a class="nav-link active pop3" aria-current="page" href="<%= request.getContextPath()+"/recherche?tri=note" %>">Les mieux notés</a>

	<hr class="hr">
</div>
<div class="container">
	<div class="row">
		<c:forEach items="${les_mieux_note}" var="notes">
			<div class="col-sm-4">
				<div class="card mt-3">
					<div class="card-body">
						<center>
						<div id="imgg">	<img src="${notes.image}"/></div>
							<h5 class="card-title">${notes.nom}</h5>
							<p class="card-text">${notes.description}</p>
							<a href="<%= request.getContextPath()+"/consulterProduit?reference=" %>${notes.reference}" class="btn btn-primary" style="background:#F90FC4;">Consulter</a>
						</center>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>
<!-- Partie admin -->
<c:if test="${utilisateur.admin}">
    <a href="<%= request.getContextPath()+"/produit.jsp" %>"><button class="btn btn deconection" style="color:white;border:solid 2px; background:#F90FC4;">Ajouter un Livre</button></a>
    <a href="<%= request.getContextPath()+"/listerStockServlet" %>"><button class="btn btn deconection" style="color:white;border:solid 2px; background:#F90FC4;">Stock</button></a>
    <a href="<%= request.getContextPath()+"/Promotion.jsp" %>"><button class="btn btn deconection" style="color:white;border:solid 2px; background:#F90FC4;">Promotion</button></a>
    <a href="<%= request.getContextPath()+"/allUsers" %>"><button class="btn btn deconection" style="color:white;border:solid 2px; background:#F90FC4;">Rendre Admin</button></a>
 </c:if>


<%@ include file="/menu/footerG.jsp" %>