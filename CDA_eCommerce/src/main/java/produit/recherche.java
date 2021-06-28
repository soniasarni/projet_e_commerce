package produit;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Produit;
import dao.ProduitDao;

import java.sql.Date;

@WebServlet("/recherche")
public class recherche extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public recherche() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String requete = "SELECT * FROM produit WHERE prix > 0 ";
		
		//Partie DB
		ProduitDao pDao = new ProduitDao();
		List<Produit> listeRecherche = pDao.recherche(requete);
		String tri = request.getParameter("tri");
		System.out.println(tri);
		if (tri != null){
			if(tri.equals("pop")) {
				listeRecherche = pDao.readpop();
				System.out.println("pop ok");
			}
			if(tri.equals("recent")) {
				listeRecherche = pDao.readrecent();
				System.out.println("recent ok");
			}
			if(tri.equals("note")) {
				listeRecherche = pDao.readnote();
				System.out.println("note ok");
			}
		}
		
		request.setAttribute("listeRecherche", listeRecherche);
		
		//Dispatcher
		request.getRequestDispatcher("/rechercheG.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String requete = "SELECT * FROM produit WHERE prix > 0 ";
		
			//Recup données du form
			String search = 	request.getParameter("search");
			String radioTri = 	request.getParameter("tri");
			String radioOrdre = request.getParameter("ordre");
			String roman = 		request.getParameter("roman");
			String fiction = 	request.getParameter("fiction");
			String action = 	request.getParameter("action");
			String drame = 		request.getParameter("drame");
			String aventure = 	request.getParameter("aventure");
			String prix_min = 	request.getParameter("prix_min");
			String prix_max = 	request.getParameter("prix_max");

			//recherche par nom
			if(search != "") {
				requete += " AND nom_produit LIKE \"%" + search + "%\" OR description LIKE \"%"+ search + "%\" ";
			}
			System.out.println(requete);
			//checkbox catégorie

			//if(roman == null && fiction == null && action == null && drame == null && aventure == null) {
				//roman = request.getParameter("roman");
				//String roman = request.getParameter("roman");
				if(roman != null) {requete += " AND categorie LIKE \"roman\" ";}
				if(fiction != null) {requete += " AND categorie LIKE \"fiction\" ";}
				if(action != null) {requete += " AND categorie LIKE \"action\" ";}
				if(drame != null) {requete += " AND categorie LIKE \"drame\" ";}
				if(aventure != null) {requete += " AND categorie LIKE \"aventure\" ";}
			//}
			System.out.println(roman + fiction + drame + action + aventure);
			System.out.println(requete);
			// prix
			//if(prix_min != "0" || prix_max != "10000" ) {
				if(prix_min != "") {requete += " AND prix > " + prix_min +" ";}
				if(prix_max != "") {requete += " AND prix < " + prix_max +" ";}
			//}
			System.out.println("entre " + prix_min + " et " + prix_max);
			System.out.println(requete);
			
			// tri
			requete += " ORDER BY ";
			requete += radioTri +" ";
			requete += radioOrdre + " ";
			requete += " LIMIT 100";

			System.out.println(requete);

			
			//XXXXXXXXXXXX
			
	//------------------------------------------------------------------------------------------------------------------------------		
			//Recup données du form et adaptation requete en fonction
		/*
		//recherche par nom
		if(request.getParameter("search") != null) {
			String cherch = request.getParameter("search");
			requete += " AND nom_produit LIKE \"" + cherch + "\" OR description LIKE \""+ cherch + "\" ";
		}
		*/
		//checkbox accueil
		  //populaire recent promotion mieux_note celebre
		/*String popp = request.getParameter("roman");
		if(popp == "") {requete += " AND categorie LIKE \"roman\" ";}
		if(request.getParameter("fiction") == "") {requete += " AND categorie LIKE \"fiction\" ";}
		if(request.getParameter("action") == "") {requete += " AND categorie LIKE \"action\" ";}
		*/
		/*
		//checkbox catégorie
		System.out.println(request.getParameter("roman"));
		System.out.println(request.getParameter("fiction"));
		System.out.println(request.getParameter("action"));
		System.out.println(request.getParameter("drame"));
		System.out.println(request.getParameter("aventure"));
		if(request.getParameter("roman") == null && request.getParameter("fiction") == null &&
		request.getParameter("action") == null && request.getParameter("drame") == null && request.getParameter("aventure") == null) {
			
			//String roman = request.getParameter("roman");
			if(roman == "") {requete += " AND categorie LIKE \"roman\" ";}
			if(request.getParameter("fiction") == "") {requete += " AND categorie LIKE \"fiction\" ";}
			if(request.getParameter("action") == "") {requete += " AND categorie LIKE \"action\" ";}
			if(request.getParameter("drame") == "") {requete += " AND categorie LIKE \"drame\" ";}
			if(request.getParameter("aventure") == "") {requete += " AND categorie LIKE \"aventure\" ";}
		}
		
		//checkbox prix
		if(request.getParameter("prix_min") != "" || request.getParameter("prix_max") != "" ) {
			//String prix_min = request.getParameter("prix_min");
			//String prix_max = request.getParameter("prix_max");
			System.out.println("Entre "+ prix_min + " et " + prix_max);
			if(request.getParameter("prix_min") != "") {requete += " AND prix > " + prix_min +" ";}
			if(request.getParameter("prix_max") != "") {requete += " AND prix < " + prix_max +" ";}
		}
		//XXXXXXXXXXXX
			//tri
			requete += " ORDER BY reference LIMIT 100";
			System.out.println(requete);
		 */
//--------------------------------------------------------------------------------------------------------------------------------		
		

		//Partie DB
		ProduitDao pDao = new ProduitDao();
		List<Produit> listeRecherche = pDao.recherche(requete);
		
		if(listeRecherche.size() == 0) {
			Date maintenant = new Date(System.currentTimeMillis());
			Produit produitVide = new Produit( "000", "Désolé", "Nous n'avons rien trouvé qui correspond à votre recherche", "Sans Catégorie", 0.0f, "img/livre_inconnu.jpg", maintenant, 0.0f);
			listeRecherche.add(produitVide);
		}
		request.setAttribute("listeRecherche", listeRecherche);
		
		//Dispatcher
		request.getRequestDispatcher("/rechercheG.jsp").forward(request, response);
	}

}