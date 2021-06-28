<%@ include file="/menu/header2G.jsp" %>

<body>
	<div class=container id="promo">
		<h3 class="promo">Ajout/suppresion de promotion</h3>
		<form method ="post" action="<%=request.getContextPath()%>/PromotionServelet">
		<label for="reference">Référence</label>
		<input type="text" name="reference"/>
		<label for="reduction">Réduction</label>
		<input type="text" name="reduction"/>
		<label for="solde">Solde</label>
		<input type="text" name="solde"/>
		<button type="submit" id="btn_enregister" class="enre2">Appliquer</button>
		</form>
	</div>
	
	<table border=1 id="table20">
		<tr>
			<th>Référence</th>
			<th>Réduction</th>
			<th>Solde</th>
		</tr>
		<c:forEach var="variable1" items="${listePromotion}">
			<tr>
				<td> <c:out value="${variable1.reference}"/></td>
				<td> <c:out value="${variable1.reduction}"/></td>
				<td> <c:out value="${variable1.solde}"/></td>
			</tr>
		
		</c:forEach>
	</table>
	<!-- Affichage des promotions -->
	<form style = "float: right;" method ="post" action="<%=request.getContextPath()%>/listerPromoServlet" class="tab_rech">
		
	</form>
	<table border=1 id="table21">
		<tr>
			<th>Référence</th>
			<th>Réduction</th>
			<th>Solde</th>
		</tr>
		<c:forEach var="listePromo" items="${Promotion}">
			<tr>
				<td> <c:out value="${Promotion.reference}"/></td>
				<td> <c:out value="${Promotion.reduction}"/></td>
				<td> <c:out value="${Promotion.solde}"></c:out>
		</c:forEach>
	</table>
	
<%@ include file="/menu/footerG.jsp" %> 