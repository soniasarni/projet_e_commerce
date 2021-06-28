package user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.Userdao;


@WebServlet("/allUsers")
public class allUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public allUsers() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Userdao usDao = new Userdao();
		List<User> allUser = usDao.read();
		request.setAttribute("allUser", allUser);
		request.getRequestDispatcher("/listeUsers.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}

}
