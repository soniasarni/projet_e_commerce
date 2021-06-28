<%@ include file="/menu/header2G.jsp" %> 

<link rel="stylesheet" href="<%= request.getContextPath()+"/css/NewFile.css" %>">

<!-- --------------------------------------------------------------------------------------------------------------------- -->
<!-- Partie update  -->
<p>${message_manque_mdp}</p>

<h2 id="misea">Mise à jour de vos données personnelles</h2>

	<form method="post" action="<%= request.getContextPath()%>/update">
	<div id="bloc5">
	<div class="mb-3 p">
	  <label for="exampleFormControlInput1" class="form-label">Prenom</label>
	  <input type="text" class="form-control prenom"  value="${utilisateur.getPrenom()}" name="prenom" maxlength="25">
	  
	</div>
	<div class="mb-3">
	  <label for="exampleFormControlInput1" class="form-label">Nom</label>
	  <input type="text" class="form-control"  value="${utilisateur.getNom()}" name="nom" maxlength="25">
	</div>
	<div class="mb-3">
	  <label for="exampleFormControlInput1" class="form-label">Adresse</label>
	  <input type="text" class="form-control"  value="${utilisateur.getAdresse()}"  name="Adresse" maxlength="200">
	</div>
	
</div>
	
<div id="bloc6">	
	<div class="mb-3">
	  <label for="exampleFormControlInput1" class="form-label">Ville</label>
	  <input type="text" class="form-control"  value="${utilisateur.getVille()}"  name="Ville" maxlength="25">
	  </div>
	<div class="mb-3">
	  <label for="exampleFormControlInput1" class="form-label">Email</label>
		  <input type="text" class="form-control"  value="${utilisateur.getMail()}" name="email" readonly>
	</div>
	<div class="mb-3">
	  <label for="exampleFormControlInput1" class="form-label">Mot_de_passe</label>
	  <input type="password" class="form-control"  name="mot_de_passe" required>
	  <hr>
	   <button type="submit" class="btn btn-secondary btn-lg bouton2">Modifier</button>
	   <a href="<%= request.getContextPath()+"/delete" %>"><button class="btn btn deconection sup">Supprimer</button></a>
 	</div>
	</div>
</form>

	


<%@ include file="/menu/footerG.jsp" %> 