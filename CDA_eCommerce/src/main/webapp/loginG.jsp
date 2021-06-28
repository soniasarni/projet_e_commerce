<%@ include file="/menu/header2G.jsp" %> 
 
<link rel="stylesheet" href="<%= request.getContextPath()+"/css/NewFile.css" %>">
<div id="bloc1">									<!-- vers la page -->
<form method="post" action="<%= request.getContextPath()%>/login">
	<div class="mb-3">
	  <label for="exampleFormControlInput1" class="form-label">Entrer votre email</label>
	  <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="" name="email">
	
	</div>
	<div class="mb-3">
	  <label for="exampleFormControlInput1" class="form-label">Entrer votre mot de passe</label>
	  <input type="password" class="form-control" id="exampleFormControlInput1" placeholder="" name="mot_de_pass">
	</div>
	  <hr>
	   <button type="submit" class="btn btn-primary btn-lg bouton1" style="background:white;color:rgb(255, 0, 255);border-color:rgb(255, 0, 255);">Se connecter</button>
</form>
</div> 


<p>${message_inscr}</p>
 <p>${message_login_erreur}</p>
 
<!-- --------------------------------------------------------------------------------------------------------------------- -->
<!-- Partie inscription  -->

<div id="bloc2">


	<form method="post" action="<%= request.getContextPath()%>/inscription">
	<div class="mb-3 p">
	  <label for="exampleFormControlInput1" class="form-label">Prenom</label>
	  <input type="text" class="form-control prenom"  placeholder="" name="prenom" maxlength="25">
	  <!-- rajouter name car on souhaite recuperer le nom ici --> 
	  
	</div>
	<div class="mb-3">
	  <label for="exampleFormControlInput1" class="form-label">Nom</label>
	  <input type="text" class="form-control"  placeholder="" name="nom" maxlength="25">
	</div>
	<div class="mb-3">
	  <label for="exampleFormControlInput1" class="form-label">Adresse</label>
	  <input type="text" class="form-control"  placeholder=""  name="Adresse" maxlength="200">
	</div>
	<div class="mb-3">
	  <label for="exampleFormControlInput1" class="form-label">Ville</label>
	  <input type="text" class="form-control"  placeholder=""  name="Ville" maxlength="25">
	  </div>
	<div class="mb-3">
	  <label for="exampleFormControlInput1" class="form-label">Email</label>
		  <input type="text" class="form-control"  placeholder="" name="email" maxlength="140">
	</div>
	
	<div class="mb-3">
	  <label for="exampleFormControlInput1" class="form-label">Mot de passe</label>
	  <input type="password" class="form-control"  placeholder=""  name="mot_de_passe" >
	  <hr>
	   <button type="submit" class="btn btn-secondary btn-lg bouton2">S'inscrire</button>
 
	</div>
</form>
</div>
