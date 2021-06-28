
<%@ include file="/menu/header2G.jsp" %>


<!-- approvisionner le stock -->
<div class="container stock2">
	<h3 id="stock2">Approvisionner le stock</h3>
	<form method ="post" action="<%=request.getContextPath()%>/servletstock">
		<label for="reference">reference</label>
		<input type="text" name="reference" required>
		
		<label for="quantite">quantite</label>
		<input type="number" name="quantite" required>
		
		<button type="submit" id="btn_enregistrer" class="enregistrer">Enregistrer</button>
	</form>
</div>
 <br><hr><br>

<!-- Chercher une reference si elle existe et afficher  sa quantite  -->

<form method ="post" action="<%=request.getContextPath()%>/listerStockServlet" class="tab_rech stock3">
	<h3 id="stock3" >Chercher un produit dans le stock</h3>
	<table border="1" class="tab_rech">
		<tr>
			<th style="background:#0DD6E4;">Reference</th>
			<th style="background:#0DD6E4;">Quantite</th>
		</tr>
		<c:forEach var="art" items="${articles}">
			<tr>
				<td style="color:white;"><c:out value="${art.reference}"></c:out></td>
				<td style="color:white;"> <c:out value="${art.quantite}"/></td>
			</tr>
		</c:forEach>
	</table>
	<input type="text" name="reference"required>
	<input type="submit" value="recherche" name="action" id="recherche">
</form>
<br><hr><br>
   <!--AFFICHER LA LISTE DU STOCK  -->
<!-- <h3 class="stock4">Liste des produits dans le stock</h3>
<table border="1"  class="table2">
	<tr>
		<th style="background:#0DD6E4;">Reference</th>
		<th style="background:#0DD6E4;">Quantite</th>
		<th style="background:#0DD6E4;">DateApprovisionnement</th>
	</tr>
	<c:forEach var="variable1" items="${requestScope.listearticle}">
		<tr>
			<td style="color:white;"><c:out value="${variable1.reference}" ></c:out></td>
			<td style="color:white;"><c:out value="${variable1.quantite}"/></td>
			<td style="color:white;"><c:out value="${variable1.dateApprovisionnement}"/></td>
		</tr>
	</c:forEach>
</table> -->
<br><hr><br>

<!--   <!--supprimer/modifier les articles du stock -->

<div class="container stock">
	<h3 id="stock6">Modifier /Supprimer les articles</h3>
	<table border="1" class="table1">
		<tr>
			<th style="background:#0DD6E4;">Reference</th>
			<th style="background:#0DD6E4;">Quantite</th>
			<th style="background:#0DD6E4;">DateApprovisionnement</th>
			<th style="background:#0DD6E4;">modifier</th>
			<th style="background:#0DD6E4;">supprimer</th>
		</tr>
		<c:forEach var="variable2" items="${listearticle}">
			<tr>
				<td style="color:white;">${variable2.reference}</td>
				<td style="color:white;">${variable2.quantite}</td>
				<td style="color:white;">${variable2.dateApprovisionnement}</td>
				<td>
					<a href="<%=request.getContextPath()%>/SuppStock_servlet?action=modifier&id=${variable2.id}&reference=${variable2.reference}&quantite=${variable2.quantite}"> 
						modifier
					</a>
				</td>
				<td>
					<a href="<%= request.getContextPath()%>/SuppStock_servlet?action=supprimer&id=${variable2.id}">
						supprimer
					</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>

<!-- saisir les modififcation-->
<div class="container" id="saisir">
	<h3 id="modif">Saisir les modififcations</h3>
	<form  id="modif2" method ="post" action="<%=request.getContextPath()%>/SuppStock_servlet">
		<label for="reference">reference</label>
		<input type="text" name="reference" required value="${ref}">
		
		<label for="quantite">quantite</label>
		<input type="number" name="quantite" required value="${qte}">
		
		<button type="submit" id="btn_enregistrer " class="enre2">Enregistrer</button>
	</form>
</div>

 <%@ include file="/menu/footerG.jsp" %>