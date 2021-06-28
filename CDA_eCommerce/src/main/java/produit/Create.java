package produit;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Produit;
import dao.ProduitDao;

/**
 * Servlet implementation class Create
 */
@WebServlet("/Create")
public class Create extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Create() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/produit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String reference = request.getParameter("reference");
		String description = request.getParameter("description");
		String categorie = request.getParameter("categorie");
		Float prix = Float.parseFloat(request.getParameter("prix").replace(",", "."));
		String image = request.getParameter("image");
		long millis=System.currentTimeMillis();  
		Date date = new java.sql.Date(millis);
		Float note = Float.parseFloat(request.getParameter("note").replace(",", "."));
		
		Produit produit1 = new Produit(reference,nom,description,categorie,prix,image, date,note);
		ProduitDao prDao = new ProduitDao();
		
		prDao.create(produit1);
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/produit.jsp").forward(request, response);
	}

}