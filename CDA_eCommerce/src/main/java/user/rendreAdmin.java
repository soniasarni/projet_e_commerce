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


@WebServlet("/rendreAdmin")
public class rendreAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public rendreAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User currentUser = (User)session.getAttribute("utilisateur");
		if(currentUser.getAdmin()) {
			String email = request.getParameter("mail"); 
			Userdao udao = new Userdao();
			udao.rendreAdministrateur(email);
		}
		response.sendRedirect("allUsers");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
