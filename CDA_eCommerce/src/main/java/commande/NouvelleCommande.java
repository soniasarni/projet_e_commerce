package commande;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Commande;
import dao.CommandeDAO;

@WebServlet("/nouvelleCommande")
public class NouvelleCommande extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public NouvelleCommande() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/commande.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//int commande_id = parseInt(request.getParameter("commande_id"));
		String date_commande = request.getParameter("date_commande");
		int qte_com = Integer.parseInt(request.getParameter("qte_com"));
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		String reference = request.getParameter("reference");
		
		Commande commande1 = new Commande(date_commande,qte_com,user_id,reference);
		CommandeDAO comDAO = new CommandeDAO(); 
		
		comDAO.createCom(commande1);
		request.getRequestDispatcher("/commande.jsp").forward(request, response);
	}

}