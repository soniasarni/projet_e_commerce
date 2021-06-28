

<%@ include file="/menu/header2G.jsp" %>

<h2>Ajout d'un article</h2>

<form method="post" id="bloc20" action="<%=request.getContextPath()%>/Create">
		<label for="nom">Nom :</label>
		<input type="text" name="nom" id="nom">
		<br>
		<label for="reference">Reference :</label>
		<input type="text" name="reference" id="reference">
		<br>
		<label for="description">Description :</label>
		<input type="text" name="description" id="description">		
		<br>
		<label for="categorie">Categorie :</label>
		<input type="text" name="categorie" id="categorie">
		<br>
		<label for="prix">Prix :</label>
		<input type="text" name="prix" id="prix">
		<br>
		<button type="submit" class="btn btn-primary ajout">Ajouter produit</button>
	</form>
	
	<%@ include file="/menu/footerG.jsp" %> 