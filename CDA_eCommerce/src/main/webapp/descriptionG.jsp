
<%@ include file="/menu/header2G.jsp" %>

<div class="container">
	<div class="card mb-3">
		</br>
		<form method="post" action="<%=request.getContextPath()%>/ajouterpanier">
			<input name="reference" type="hidden" value="${produit_actuel.reference}">
			<input name="quantite" type="hidden" value="1">
			<button type="submit" class="btn btn m-3 ajoutt" id="ajou">Ajouter au panier</button>
		</form>
		<center>
			<img src="${produit_actuel.image}" id="img13" class="" alt="...">
			<div class="card-body">
				<h5 class="card-title">${produit_actuel.nom}</h5>
				<p class="card-text">${produit_actuel.description}</p>
				<p class="card-text">${produit_actuel.prix}</p>
				<i><p class="card-text"><small class="text-muted">Auteur</small></p></i>
			</div>
		</center>
	</div>
</div>

<div class="container">
	<div class="card mb-3">
		<h5 class="card-title">Camille <i>le 21/04/2021</i></h5>
		<table>
			<tr>
				<td><img src="img/etoile.png" class="etoile"></td>
				<td><img src="img/etoile.png" class="etoile"></td>
				<td><img src="img/etoile.png" class="etoile"></td>
				<td><img src="img/etoile.png" class="etoile"></td>
				<td><img src="img/etoile_vide.png" class="etoile"></td>
			</tr>
		</table>
		<p>Super livre je le recommande</p>
	</div>
</div>

<div class="container">
	<div class="card mb-3">
		<h5 class="card-title">Nadia <i>le 21/04/2021</i></h5>
		<table>
			<tr>
				<td><img src="img/etoile.png" class="etoile"></td>
				<td><img src="img/etoile.png" class="etoile"></td>
				<td><img src="img/etoile.png" class="etoile"></td>
				<td><img src="img/etoile.png" class="etoile"></td>
				<td><img src="img/etoile_vide.png" class="etoile"></td>
			</tr>
		</table>
		<p>Super livre je le recommande</p>
	</div>
</div>

<div class="container">
	<div class="card mb-3">
		<h5 class="card-title">Camille <i>le 21/04/2021</i></h5>
		<table>
			<tr>
				<td><img src="img/etoile.png" class="etoile"></td>
				<td><img src="img/etoile.png" class="etoile"></td>
				<td><img src="img/etoile.png" class="etoile"></td>
				<td><img src="img/etoile.png" class="etoile"></td>
				<td><img src="img/etoile_vide.png" class="etoile"></td>
			</tr>
		</table>
		<p>Super livre je le recommande</p>
	</div>
</div>

<div class="container">
	<div class="card mb-3">
		<h5 class="card-title">Camille <i>le 21/04/2021</i></h5>
		<table>
			<tr>
				<td><img src="img/etoile.png" class="etoile"></td>
				<td><img src="img/etoile.png" class="etoile"></td>
				<td><img src="img/etoile.png" class="etoile"></td>
				<td><img src="img/etoile.png" class="etoile"></td>
				<td><img src="img/etoile_vide.png" class="etoile"></td>
			</tr>
		</table>
		<p>Super livre je le recommande</p>
	</div>
</div>

<div class="container">
	<div class="card mb-3">
		<h5 class="card-title">Nadia <i>le 21/04/2021</i></h5>
		<table>
			<tr>
				<td><img src="img/etoile.png" class="etoile"></td>
				<td><img src="img/etoile.png" class="etoile"></td>
				<td><img src="img/etoile.png" class="etoile"></td>
				<td><img src="img/etoile.png" class="etoile"></td>
				<td><img src="img/etoile_vide.png" class="etoile"></td>
			</tr>
		</table>
		<p>Super livre je le recommande</p>
	</div>
</div>

<div class="container">
	<div class="card mb-3">
		</br>
		<form action="" method="get" class="form-example">
			<center>
			<textarea id="story" name="story" rows="5" cols="100"></textarea></br></br>
			<label for="pet-select">Note:</label>
			<select name="pets" id="pet-select">
				<option value="">--Selectionnez un chiffre--</option>
				<option value="UN">1</option>
				<option value="DEUX">2</option>
				<option value="TROIS">3</option>
				<option value="QUATRE">4</option>
				<option value="CINQ">5</option>
			</select>
			</br></br>
			
			</center>
		</form>
		</br>
	</div>
</div>

<hr>
<%@ include file="/menu/footerG.jsp" %>