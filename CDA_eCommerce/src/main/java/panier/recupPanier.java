package panier;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Panier;
import dao.PanierDAO;

@WebServlet("/Panier")
public class recupPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public recupPanier() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PanierDAO panierDAO = new PanierDAO();
		List<Panier> panier = panierDAO.read();
		int qte = panier.size();
		request.setAttribute("taille_panier", qte);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}
 

}