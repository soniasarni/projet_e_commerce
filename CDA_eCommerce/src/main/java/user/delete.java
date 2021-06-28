package user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import dao.Userdao;

@WebServlet("/delete")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recuperation session
				HttpSession session = request.getSession();
				Object currentUser = session.getAttribute("utilisateur");
				System.out.println("delete " + currentUser);
					
				//Delete
				Userdao udao = new Userdao();
				udao.delete((User) currentUser);
				session.invalidate();
				response.sendRedirect("Accueil");
				//request.getRequestDispatcher("/accueilG.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}

}
