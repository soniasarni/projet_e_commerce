package panier;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Panier;
import bean.ProduitPanier;
import dao.ProduitDao;

@WebServlet("/ajouterpanier")
public class ajouterpanier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ajouterpanier() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("panier")==null) {
			Panier panier = new Panier();
			ProduitDao prDao = new ProduitDao();
			ProduitPanier produit = new ProduitPanier(prDao.read(request.getParameter("reference")),Integer.parseInt(request.getParameter("quantite")) );
			panier.ajouterProduit(produit);
			session.setAttribute("panier", panier);
			session.setAttribute("taille_panier",panier.getSize());
		}else {
			Panier panier = (Panier)session.getAttribute("panier");
			ProduitDao prDao = new ProduitDao();
			ProduitPanier produit = new ProduitPanier(prDao.read(request.getParameter("reference")),Integer.parseInt(request.getParameter("quantite")) );
			panier.ajouterProduit(produit);
			session.setAttribute("panier", panier);
			session.setAttribute("taille_panier",panier.getSize());
		}
		
		request.getRequestDispatcher("/consulterProduit?reference="+request.getParameter("reference")).forward(request, response);
	}

}