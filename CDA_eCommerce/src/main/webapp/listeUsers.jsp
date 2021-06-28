

<%@ include file="/menu/header2G.jsp" %>

 <div class="container">
	<%! int nombre = 1; %>
	
	<h2 id="accés">Accés Admin</h2>
	
	<table border="1" class="table1 tab">
		<tr>
			<th style="background:white;">N°</th>
			<th style="background:white;">Mail</th>
			<th style="background:white;">Admin</th>
			<th style="background:white;">Rendre Admin</th>
		</tr>
		<c:forEach items="${allUser}" var="user">
			<tr>
				<td><%= nombre++ %></td>
				<td>${user.mail}</td>
				<td>${user.admin}</td>
				<td>
					<a href="<%=request.getContextPath()%>/rendreAdmin?mail=${user.mail}" style="color:black">Rendre Admin</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<% nombre = 1; %>
</div>
