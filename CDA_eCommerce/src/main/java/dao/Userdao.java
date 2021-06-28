package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCrypt;

import bean.Commande;
import bean.User;

public class Userdao implements IDAO<User>{

	Connection connect = Connect.avoirConnection();
	
	@Override
	public boolean create(User object) {
		boolean connectionOK = false;
		try {
			PreparedStatement req = connect.prepareStatement("INSERT INTO user " + "(nom, prenom, Adresse, ville, mail, password, admin)" + " VALUES (?,?,?,?,?,?,?) ");
			req.setString(1, object.getNom());
			req.setString(2, object.getPrenom());
			req.setString(3, object.getAdresse());
			req.setString(4, object.getVille());
			req.setString(5, object.getMail());
			req.setString(6, object.getPassword());
			req.setBoolean(7, object.getAdmin());
			System.out.println(req);
			req.executeUpdate();
			System.out.println("Create ok");
			connectionOK = true;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Create ERREUR !");
		}
		return connectionOK;
	}

	@Override
	public List<User> read() {
		List<User> listeUser = new ArrayList<>();
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM user");
			ResultSet rs = req.executeQuery();
			
			while(rs.next()) {
				User tempUser = new User();
				tempUser.setId_user(rs.getInt("user_id"));
				tempUser.setNom(rs.getString("nom"));
				tempUser.setPrenom(rs.getString("prenom"));
				tempUser.setAdresse(rs.getString("Adresse"));
				tempUser.setVille(rs.getString("ville"));
				tempUser.setMail(rs.getString("mail"));
				tempUser.setPassword(rs.getString("password"));
				tempUser.setAdmin(rs.getBoolean("admin"));
				
				listeUser.add(tempUser);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Read ERREUR !");
		}
		return listeUser;
	}

	@Override
	public void update(User object) {

		try {
			PreparedStatement req = connect.prepareStatement("UPDATE user "
		+"SET nom = ?, prenom = ?, Adresse = ?, ville = ?, password = ? WHERE mail = ?");
			req.setString(1, object.getNom());
			req.setString(2, object.getPrenom());
			req.setString(3, object.getAdresse());
			req.setString(4, object.getVille());
			req.setString(5, object.getPassword());
			req.setString(6, object.getMail());
			req.executeUpdate();
			
			System.out.println("Update ok");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Update ERREUR !");
		}
	}
	
	@Override
	public void delete(User user) {
		try {
			PreparedStatement req = connect.prepareStatement("DELETE FROM user WHERE mail = ?");
			req.setString(1, user.getMail());
			req.executeUpdate();
			System.out.println("Delete ok");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Delete ERREUR !");
		}
	}
	
	@Override
	public List<User> lister() {
		List<User> listeUser = new ArrayList<>();
		User tempUser = new User();
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM user");
			ResultSet rs = req.executeQuery();
			
			while(rs.next()) {
				tempUser.setId_user(rs.getInt("id_user"));
				tempUser.setNom(rs.getString("nom"));
				tempUser.setPrenom(rs.getString("prenom"));
				tempUser.setPrenom(rs.getString("email"));
				tempUser.setPrenom(rs.getString("pwd"));
				
				listeUser.add(tempUser);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Read ERREUR !");
		}
		return listeUser;
	}
	@Override
	public User login(String email, String pwd) {
		
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM user WHERE mail = ?");
			req.setString(1, email);
			ResultSet rs = req.executeQuery();
			
			while (rs.next()) {
				if(BCrypt.checkpw(pwd, rs.getString("password"))) {
					return new User(rs.getString("nom"),rs.getString("prenom"),rs.getString("Adresse"),rs.getString("ville"),rs.getString("mail"),rs.getString("password"),rs.getBoolean("admin"));
				}
			}
		} catch (Exception e3) {
			e3.printStackTrace();
		}
		return null;
	}
	
	public boolean emailexist(String email) {
		List<User> tableauUser = new ArrayList<>();
		try {
			PreparedStatement listUser = connect.prepareStatement("SELECT * FROM user WHERE mail = ?");
			listUser.setString(1, email);
			ResultSet rs = listUser.executeQuery();
			
			while (rs.next()) {
				User userTempBoucle = new User();
				userTempBoucle.setId_user(rs.getInt("user_id"));
				userTempBoucle.setNom(rs.getString("nom"));
				userTempBoucle.setPrenom(rs.getString("prenom"));
				userTempBoucle.setAdresse(rs.getString("Adresse"));
				userTempBoucle.setVille(rs.getString("ville"));
				userTempBoucle.setMail(rs.getString("mail"));
				userTempBoucle.setPassword(rs.getString("password"));
				userTempBoucle.setAdmin(rs.getBoolean("admin"));
				tableauUser.add(userTempBoucle);
			}
			System.out.println(tableauUser.size());
			return tableauUser.size() == 1 ? true : false;
		} catch (Exception e3) {
			e3.printStackTrace();
			return false;
		}
	}
	
	public void rendreAdministrateur(String mail) {

		try {
			PreparedStatement req = connect.prepareStatement("UPDATE user SET admin = ? WHERE mail = ?");
			req.setBoolean(1, true);
			req.setString(2, mail);
			req.executeUpdate();
			
			System.out.println("nv admin ok");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("nv admin ERREUR !");
		}
	}
	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void vider_table(User object) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean createCom(Commande object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateCom(Commande object) {
		// TODO Auto-generated method stub
	}

	@Override
	public void vider_tableCom(Commande object) {
		// TODO Auto-generated method stub
	}

	@Override
	public Commande findByIdCom(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean ajout(User objet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void Update(User objet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getStockParMC(String objet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(User objet) {
		// TODO Auto-generated method stub
		return false;
	}
}
