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

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public login() {
        super();
        // TODO Auto-generated constructor stub
    } 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/loginG.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Recup données du form
		String email_saisi = request.getParameter("email");
		String pwd_saisi = request.getParameter("mot_de_pass");
		
		//Vérif mdp
		Userdao usDao = new Userdao();
		if(usDao.login(email_saisi, pwd_saisi) != null) {
			User current_user = usDao.login(email_saisi, pwd_saisi); 
			
			//Création Session
			HttpSession session = request.getSession();
			//session.setAttribute("utilisateur", current_user.getPrenom());
			session.setAttribute("utilisateur", current_user);
			//request.getRequestDispatcher("/produitAccueil").forward(request, response);
			response.sendRedirect("Accueil");
		}else{
			request.setAttribute("message_login_erreur", "Données invalides");
			request.getRequestDispatcher("/loginG.jsp").forward(request, response);
		}
	}

}
