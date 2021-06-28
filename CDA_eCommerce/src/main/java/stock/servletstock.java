package stock;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.StockDaoImpl;

import bean.Stock;


@WebServlet("/servletstock")
public class servletstock extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public servletstock() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
			}
		
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ref= request.getParameter("reference");
		int qte=Integer.parseInt(request.getParameter("quantite")) ;
			
		//le mettre dans ma base de données
		 StockDaoImpl nSDao = new  StockDaoImpl();
	     Stock article = new Stock(qte,ref);
			if(nSDao.ajout(article)) {
				 request.setAttribute("message", " L'article a bien été ajouté");
				// request.getRequestDispatcher("/Stock.jsp").forward(request, response);
			}else {
				request.setAttribute("message1", "Oups, erreur ");
				//request.getRequestDispatcher("/Stock.jsp").forward(request, response);
			}
			
			response.sendRedirect("listerStockServlet");
		}
			
}