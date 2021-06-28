package user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.bcrypt.BCrypt;

import bean.User;
import dao.Userdao;

@WebServlet("/inscription")
public class inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public inscription() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/loginG.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Recup données du form
		String prenom = request.getParameter("prenom");
		String nom = request.getParameter("nom");
		String adresse = request.getParameter("Adresse");
		String ville = request.getParameter("Ville");
		String mail = request.getParameter("email");
		String password = request.getParameter("mot_de_passe");
		
		//Hashing mdp
		String hashpwd = BCrypt.hashpw(password, BCrypt.gensalt(10));
		
		//Creation User
		User user = new User(nom, prenom, adresse, ville, mail, hashpwd);
		Userdao udao = new Userdao();
		
		//Vérif & Redirection
		if(udao.emailexist(mail)) {
			System.out.println("Vous ne pouvez pas vous inscrire, vous avez déjà un compte");
			request.setAttribute("message_inscr", "Vous ne pouvez pas vous inscrire, vous avez déjà un compte");
		}else if(udao.create(user)) {
			System.out.println("Bravo "+ prenom);
			request.setAttribute("message_inscr", "Bravo "+ prenom);
			
			//Création Session
			HttpSession session = request.getSession();
			//session.setAttribute("utilisateur", current_user.getPrenom());
			session.setAttribute("utilisateur", user);
			//request.getRequestDispatcher("/accueilG.jsp").forward(request, response);
			System.out.println("fin");
			response.sendRedirect("Accueil");
		}else {
			System.out.println( "Dommage tu ne peux pas t'inscrire");
			request.setAttribute("message_inscr", "Dommage tu ne peux pas t'inscrire");
		}
		//request.getRequestDispatcher("/loginG.jsp").forward(request, response);
	}

}
