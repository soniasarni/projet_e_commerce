package panier;

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

/**
 * Servlet implementation class afficherpanier
 */
@WebServlet("/afficherpanier")
public class afficherpanier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public afficherpanier() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Panier panier = (Panier)session.getAttribute("panier");
		System.out.println(panier);
		if(panier!=null) {
			request.setAttribute("panier", panier.getProduitsPanier());
			//Cedric prix
			System.out.println("prix panier afficherPanier = " + panier.prixtotal());
			request.setAttribute("prixtotal", panier.prixtotal());
			//Fin Cedric prix
		}
		request.getRequestDispatcher("/pagepanierG.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/pagepanierG.jsp").forward(request, response);
	}

}