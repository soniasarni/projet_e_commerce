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


@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public update() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/compte.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Recup données du form
		String prenom = request.getParameter("prenom");
		String nom = request.getParameter("nom");
		String adresse = request.getParameter("Adresse");
		String ville = request.getParameter("Ville");
		String mail = request.getParameter("email");
		String password = request.getParameter("mot_de_passe");
		
		//Recuperation session
		HttpSession session = request.getSession();
		Object currentUser = session.getAttribute("utilisateur");
		System.out.println("current " + currentUser);
		
		//Vérif null ou pas
				if(prenom == "" ) {prenom = ((User) currentUser).getPrenom();}
				if(nom == "" ) {nom = ((User) currentUser).getNom();}
				if(adresse == "" ) {adresse = ((User) currentUser).getAdresse();}
				if(ville == "" ) {ville = ((User) currentUser).getVille();}
				if(password == "" ) {request.setAttribute("message_manque_mdp", "Rentrez votre mot de passe");}
				System.out.println(prenom);
		//Hashing mdp
				String hashpwd = BCrypt.hashpw(password, BCrypt.gensalt(10));
				
		//Creation nouveau User et update
			User nouveauUser = new User(nom, prenom, adresse, ville, mail, hashpwd);
			Userdao udao = new Userdao();
			udao.update(nouveauUser);
			
			session.setAttribute("utilisateur", nouveauUser);
			//request.getRequestDispatcher("/accueilG.jsp").forward(request, response);
			response.sendRedirect("Accueil");
	}

}
