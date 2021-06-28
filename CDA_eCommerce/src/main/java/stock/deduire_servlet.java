package stock;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Panier;
import bean.ProduitPanier;
import bean.Stock;
import dao.StockDaoImpl;


@WebServlet("/deduire_servlet")
public class deduire_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public deduire_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Panier panier=(Panier)session.getAttribute("panier");
		panier.getProduitsPanier();
		ArrayList<ProduitPanier>produits=panier.getProduitsPanier();
		for(int counter=0;counter<produits.size();counter++) {
			String ref=produits.get(counter).getProduit().getReference();
			int qte=produits.get(counter).getQuantite();
			StockDaoImpl sdao=new StockDaoImpl();
			Stock sk=new Stock();
			sk.setReference(ref);
			sk.setQuantite(qte);
			sdao.remove(sk);
		}
		
		session.setAttribute("panier", null);
		//response.sendRedirect("Accueil");
		request.getRequestDispatcher("/paiementfinalG.jsp").forward(request, response);
	}

}