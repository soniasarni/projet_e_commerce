
<%@ include file="/menu/header2G.jsp" %>

<div class="container">
	<center>
		<img src="../images/paiement.jpg" alt="" style="height:250px; width:400px;">
		</br></br>
		<img src="../images/cb.png" alt="" style="height:150px;width:400px;">
		</br></br>
		<hr class="hr_paiement">
		<label>Montant :</label> <input type="text" value="50€" disabled>
		<hr class="hr_paiement">
		<label>Vos informations</label></br>
		<input type="text" disabled value="Henry">    <input type="text" disabled value="Dupont">
		<hr class="hr_paiement">
		<label>Votre carte</label></br>
		<input type="text" placeholder="Numéro de carte">
		</br></br>
		<label>Date d'expiration :</label> <input type="month">
		</br></br>
		<input type="number" placeholder="Pictogramme">
		<hr class="hr_paiement">
		<a class="nav-link active contact confir" aria-current="page" style="color:white; " href="<%= request.getContextPath()+"/Merci.jsp" %>">Je confirme le paiement</a>
		
	</center>
</div>


 


<%@ include file="/menu/footerG.jsp" %>