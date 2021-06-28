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


@WebServlet("/Accueil")
public class Accueil extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Accueil() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProduitDao pDao = new ProduitDao();
		
		List<Produit> lesPlusPop = pDao.readpop();
		request.setAttribute("les_plus_populaires", lesPlusPop);
		
		List<Produit> lesPlusRec = pDao.readrecent();
		request.setAttribute("les_plus_recents", lesPlusRec);
		
		List<Produit> lesMieuxNote = pDao.readnote();
		request.setAttribute("les_mieux_note", lesMieuxNote);
		
		request.getRequestDispatcher("/accueilG.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
