<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>  
<html>
<head>
<meta charset="UTF-8">
<title>BookBlog</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<link rel="stylesheet" href="<%= request.getContextPath()+"/css/NewFile.css" %>">
</head>
<body>
<div class="container-fluid">
  ...


<nav class="navbar navbar-expand-lg navbar-red bg-red nav">
<div id="logo">
<!--  <img src="../img/logolivre.jpg">-->
 <a class="nav-link active " aria-current="page" href="<%= request.getContextPath()+"/Accueil" %>">

<img src="<%= request.getContextPath()+"/img/logolivre.jpg" %>"> <p id="titre">BookBlog</p> 

 </a>
</div>


  <div class="container-fluid">
   
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    
    <div class="collapse navbar-collapse" id="navbarSupportedContent"> 
    <li class="nav-item">
      <a class="nav-link active recherche" aria-current="page" href="<%= request.getContextPath()+"/recherche" %>">RECHERCHE</a>
        
        </li>
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
       <a class="nav-link active apropos" aria-current="page" href="<%= request.getContextPath()+"/aproposG.jsp" %>">A PROPOS</a>
        </li>
       <li class="nav-item">
             <a class="nav-link active contact" aria-current="page" href="<%= request.getContextPath()+"/ContactG.jsp" %>">CONTACT</a>
        </li>
      <li class="nav-item iteme">
          <a class="nav-link active bienvenue" aria-current="page" href="<%= request.getContextPath()+"/Accueil" %>">Bienvenue</a>
        </li>
        <li class="nav-item">
 
 
	         <a class="nav-link active panier" aria-current="page" href="<%= request.getContextPath()+"/afficherpanier" %>">Panier 
	         <img src="<%= request.getContextPath()+"/img/panier3.png" %>"id="imgpanier">
	         <span style="color:white;"> <c:choose><c:when test = "${taille_panier != null}">${taille_panier}</c:when><c:otherwise>0</c:otherwise></c:choose></span></a>
         
          
       
        </li>
     
      </ul> 
     
     
	<c:if test="${empty utilisateur}">
	    <a href="<%= request.getContextPath()+"/login" %>"><button class="btn btn deconection" style="color:pink;border:solid 2px; background:white;">Connexion</button></a>
	</c:if>
	<c:if test="${not empty utilisateur}">
		<a href="<%= request.getContextPath()+"/update" %>"><button class="btn btn deconection">${utilisateur.getPrenom()}</button></a> ||
	    <a href="<%= request.getContextPath()+"/logout" %>"><button class="btn btn deconection">Deconnexion</button></a>
	</c:if>
     
    </div>
  </div>
</nav>
</div>