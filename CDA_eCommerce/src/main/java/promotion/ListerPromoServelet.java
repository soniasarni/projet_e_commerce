package promotion;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Promotion;
import dao.PromotionDAO;


@WebServlet("/ListerPromoServelet")
public class ListerPromoServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListerPromoServelet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entrez dans PromotionServelet");
		
		int reduction = Integer.parseInt(request.getParameter("reduction"));
		int solde = Integer.parseInt(request.getParameter("solde"));
		String reference = request.getParameter("reference");
		
		Promotion promo = new Promotion(reduction, solde, reference);
		PromotionDAO promoDAO = new PromotionDAO();
		promoDAO.createPromo(promo);
		
		request.getRequestDispatcher("/Promotion.jsp").forward(request, response);
		
	}

}