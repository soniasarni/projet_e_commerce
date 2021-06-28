package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Commande;
import bean.Panier;
import bean.User;

public class PanierDAO implements IDAO<Panier> {
	
	Connection connect = Connect.avoirConnection();
	
	@Override
	public boolean create(Panier object) {
		boolean connectionOK = false;
		try {
			PreparedStatement req = connect.prepareStatement("INSERT INTO panier " + "(reference, quantite)" + " VALUES (?,?) ");
			req.setString(1, object.getReference());
			req.setInt(2, object.getQuantite());
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
	public List<Panier> read() {
		List<Panier> listeUser = new ArrayList<>();
		Panier tempUser = new Panier();
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM panier");
			ResultSet rs = req.executeQuery();
			
			while(rs.next()) {
				tempUser.setId_panier(rs.getInt("id_panier"));
				tempUser.setReference(rs.getString("reference"));
				tempUser.setQuantite(rs.getInt("quantite"));
				
				listeUser.add(tempUser);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Read ERREUR !");
		}
		return listeUser;
	}
	
	@Override
	public void update(Panier object) {
		try {
			PreparedStatement req = connect.prepareStatement("UPDATE panier SET reference = ?, quantite = ? WHERE id = ?");
			req.setString(1, object.getReference());
			req.setInt(2, object.getQuantite());
			req.setInt(3, object.getId_panier());
			req.executeUpdate();
			
			System.out.println("Update ok");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Update ERREUR !");
		}
		
	}

	@Override
	public void delete(Panier panier) {
		try {
			PreparedStatement req = connect.prepareStatement("DELETE FROM panier WHERE id = ?");
			req.setInt(1, panier.getId_panier());
			req.executeUpdate();
			
			System.out.println("Delete ok");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Delete ERREUR !");
		}
	}

	

	@Override
	public List<Panier> lister() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Panier findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void vider_table(Panier object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User login(String email, String pwd) {
		// TODO Auto-generated method stub
		return null;
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
	public boolean ajout(Panier objet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void Update(Panier objet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Panier> getStockParMC(String objet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Panier objet) {
		// TODO Auto-generated method stub
		return false;
	}

}