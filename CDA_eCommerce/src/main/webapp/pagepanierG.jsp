
<%@ include file="/menu/header2G.jsp" %>

<title>Insert title here</title>

<div id="recap">
<form method="post" action="<%= request.getContextPath() %>/deduire_servlet">
 <h2>Recapitulatif de votre commande</h2>
	<div class="mb-3 p">
	 <c:forEach items="${panier}" var="panier">
            <div class="alert alert-light m-2" role="alert">
			  <img src="${panier.getProduit().getImage()}"/> | ${panier.getProduit().getNom()} | ${panier.getProduit().getCategorie()} | ${panier.getProduit().getNote()} | ${panier.getProduit().getPrix() * panier.getQuantite()} | ${ panier.getQuantite()}  
			</div>
        </c:forEach>
	  
	</div>
	
	<hr>
		<h5 style="color:#F90FC4;" >Frai de livraison gratuit à partir de 50 euros d'achat</h5>
	<hr>	
		<h5 style="color:#F90FC4;">TVA 19.6 %</h5>
	<hr>
	 <label for="exampleFormControlInput1" class="form-label total">TOTAL</label>
	<!--<input type="text" class="form-control payer1" aria-label="Amount (to the nearest dollar)">  -->
  	<!-- Ajout prix cedric -->
  	<input type="text" class="form-control payer1" aria-label="Amount (to the nearest dollar)" value="${prixtotal}">
  	<!-- FIN Ajout prix cedric -->
	<c:if test="${not empty utilisateur}">
	<button type ="submit" class="btn btn-primary" style="color:pink;border:solid 2px; background:white;">Confirmer et Payer</button>
	</c:if>
	</form>
	<c:if test="${empty utilisateur}">
	    <a href="<%= request.getContextPath()+"/login" %>"><button class="btn btn-primary" style="color:pink;border:solid 2px; background:white;">Connexion</button></a>
	</c:if>
</div>


<%@ include file="/menu/footerG.jsp" %>menu/footerG.jsp" %>