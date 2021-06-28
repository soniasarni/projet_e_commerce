

<%@ include file="/menu/header2G.jsp" %>

<div>
<form method="post" action="<%= request.getContextPath()%>/recherche" class="d-flex cherche">
      
         <!--   <button class="btn btn-outline-success" type="submit">Recherche</button>
      </form>
<form method="post" action="<%= request.getContextPath()%>/recherche">-->

<ul class="list-group check">
<p id="ordre">Recherche nom </p>
<li>
	 <input class="form-control me-2 inputt" name="search" type="search" placeholder="Recherche" aria-label="Chercher">
</li>
<p id="ordre">Trier par </p>
  <li class="list-group-item">
   <input class="form-check-input" type="radio" name="tri" value="prix" id="flexRadioDefault1">
  <label class="form-check-label" for="flexRadioDefault1">
   Prix
  </label>
  </li>
  <li class="list-group-item">
    <input class="form-check-input" type="radio" name="tri" value="date_sortie" id="flexRadioDefault1">
  <label class="form-check-label" for="flexRadioDefault1">
   Date de sortie
  </label>
  </li>
  <li class="list-group-item">
  <input class="form-check-input" type="radio" name="tri" value="note" id="flexRadioDefault1" checked>
  <label class="form-check-label" for="flexRadioDefault1">
 	Note
  </label>
  </li>
  	<p id="ordre">Ordre</p>
  <li class="list-group-item">
  <input class="form-check-input" type="radio" name="ordre" value="ASC" id="flexRadioDefault1">
  <label class="form-check-label" for="flexRadioDefault1">
 	Croissant
  </label>
  <li class="list-group-item">
  <input class="form-check-input" type="radio" name="ordre" value="DESC" id="flexRadioDefault1" checked>
  <label class="form-check-label" for="flexRadioDefault1">
 	Décroissant
  </label>
  </li>
  
  <!-- <button type="submit" class=" apli" style="background:white;color:rgb(255, 0, 255);border-color:rgb(255, 0, 255);height: 5em;">Appliquer</button>
  
  </form>
<form method="post" action="<%= request.getContextPath()%>/recherche">  
--> 
	
	<p id="categoriee">Catégorie</p>
	
  <li class="list-group-item">
    <input class="form-check-input me-1" name="roman" type="checkbox" value="" aria-label="...">
    Romans
  </li>
  <li class="list-group-item">
    <input class="form-check-input me-1" name="fiction" type="checkbox" value="" aria-label="...">
    Fiction
  </li>
  <li class="list-group-item">
    <input class="form-check-input me-1" name="action" type="checkbox" value="" aria-label="...">
    Action
  </li>
  <li class="list-group-item">
    <input class="form-check-input me-1" name="drame" type="checkbox" value="" aria-label="...">
   	Drame
  </li>
  <li class="list-group-item">
    <input class="form-check-input me-1" name="aventure" type="checkbox" value="" aria-label="...">
    Aventure
  </li>
  
   <label for="customRange1" class="form-label curseur">Prix min</label>
  <input type="text" name="prix_min" id="nommin" value = "" placeholder = "Prix Min">
  
  <label for="customRange1" class="form-label curseur">Prix max</label>
  <input type="text" name="prix_max" id="nommax" value = "" placeholder = "Prix Max">
  
 <button type="submit" class=" apli" style="background:rgb(255, 0, 255);color:white;border-color:rgb(255, 0, 255);height: 5em;">Appliquer</button>
</ul>
</form>



<div id="blocarticle">
	<c:forEach items="${listeRecherche}" var="cherch">
		<div class="col-sm-4">
			<div class="card">
				<div class="card-body card1">
					<center>
						<img src="${cherch.image}"/>
						<h5 class="card-title" style="color:#F90FC4;">${cherch.nom}</h5>
						<p class="card-text" style="color:#F90FC4;">${cherch.description}</p>
						<a href="<%= request.getContextPath()+"/consulterProduit?reference=" %>${cherch.reference}" class="btn btn-primary" style="background:#F90FC4;">Consulter</a>
					</center>
				</div>
			</div>
		</div>
	</c:forEach>
</div> 
</div>
<%@ include file="/menu/footerG.jsp" %>