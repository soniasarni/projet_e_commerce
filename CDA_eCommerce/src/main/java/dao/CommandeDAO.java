package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Commande;
import bean.User;


public class CommandeDAO implements IDAO<Commande>{
Connection connect = Connect.avoirConnection();
	
	@Override
	public boolean createCom(Commande object) {
		boolean connectionOK = false;
		try {
			PreparedStatement req = connect.prepareStatement("INSERT INTO commande " + "(date_commande, qte_com, user_id, reference)" + " VALUES (?,?,?,?) ");
			req.setString(1, object.getDate_commande());
			req.setInt(2, object.getQte_com());
			req.setInt(3, object.getUser_id());
			req.setString(4, object.getReference());
			req.executeUpdate();
			System.out.println("Create ok");
			connectionOK = true;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Create ERREUR !");
		}
		return connectionOK;
	}//fin create

	@Override
	public List<Commande> read() {
		List<Commande> listeCommande = new ArrayList<>();
		Commande tempCommande = new Commande();
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM commande");
			ResultSet rs = req.executeQuery();
			
			while(rs.next()) {
				tempCommande.setCommande_id(rs.getInt("commande_id"));
				tempCommande.setDate_commande(rs.getString("date_commande"));
				tempCommande.setQte_com(rs.getInt("qte_com"));
				tempCommande.setUser_id(rs.getInt("user_id"));
				tempCommande.setReference(rs.getString("reference"));
				
				listeCommande.add(tempCommande);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Read ERREUR !");
		}
		return listeCommande;
	}// fin read

	@Override
	public void updateCom(Commande object) {

		try {
			PreparedStatement req = connect.prepareStatement("UPDATE commande SET date_commande = ?, qte_com = ? WHERE id = ?");
			req.setString(1, object.getDate_commande());
			req.setInt(2, object.getQte_com());
			req.setInt(3, object.getCommande_id());
			req.executeUpdate();
			
			System.out.println("Update ok");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Update ERREUR !");
		}
	} //fin update

	/*@Override
	public void delete(int id) {
		
		try {
			PreparedStatement req = connect.prepareStatement("DELETE FROM commande WHERE id = ?");
			req.setInt(1, id);
			req.executeUpdate();
			
			System.out.println("Delete ok");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Delete ERREUR !");
		}
	}*/ //fin delete
	
	@Override
	public List<Commande> lister() {
		List<Commande> listeCommande = new ArrayList<>();
		Commande tempCommande = new Commande();
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM commande");
			ResultSet rs = req.executeQuery();
			
			while(rs.next()) {
				tempCommande.setCommande_id(rs.getInt("commande_id"));
				tempCommande.setDate_commande(rs.getString("date_commande"));
				tempCommande.setQte_com(rs.getInt("qte_com"));
				tempCommande.setUser_id(rs.getInt("user_id"));
				tempCommande.setReference(rs.getString("reference"));
				
				listeCommande.add(tempCommande);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Read ERREUR !");
		}
		return listeCommande;
	}//fin lister

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
	public boolean create(Commande object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update(Commande object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Commande findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void vider_table(Commande object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Commande object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User login(String email, String pwd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean ajout(Commande objet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void Update(Commande objet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Commande> getStockParMC(String objet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Commande objet) {
		// TODO Auto-generated method stub
		return false;
	}

}