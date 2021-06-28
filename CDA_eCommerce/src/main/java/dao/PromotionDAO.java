package dao;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.Commande;
import bean.Promotion;
import bean.User;

public class PromotionDAO implements IDAO<Promotion>{
	Connection connect = Connect.avoirConnection();
	
	
	public boolean createPromo(Promotion object) {
		boolean response = false;
		try {
			PreparedStatement request = connect.prepareStatement("INSERT INTO `promotion` (`reduction`, `solde`, `reference`) "
					+ "VALUES (?,?,?);");
			
			request.setInt(1, object.getReduction());
			request.setInt(2, object.getSolde());
			request.setString(3, object.getReference());

			
			request.executeUpdate();
			
			System.out.println(object.getReduction()+ "  " +object.getSolde() +" a été bien ajouté en base");
			
			response = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	
	public boolean updatePromo(Promotion object) {
		boolean reponse = false;
		try {
			PreparedStatement request = connect.prepareStatement("UPDATE 'promotion' ('reduction', 'solde', 'reference')" + "VALUES (?,?,?);");
			request.setInt(1, object.getReduction());
			request.setInt(2, object.getSolde());
			request.setString(3, object.getReference());
			
			request.executeUpdate();
			
			System.out.println(object.getReduction()+ " " +object.getSolde() +"a été bien mis à jour dans la base");
			reponse = true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erreur update promotion");
		}
		return reponse;
		
	}

	
	public boolean deletePromo(Promotion object) {
		boolean reponse = false;
		try {
			PreparedStatement req = connect.prepareStatement("DELETE FROM promotion WHERE id_promotion = ?");
			req.setInt(1, object.getId_promotion());
			req.executeUpdate();
			
			System.out.println("Delete Promotion OK !");
			reponse = true;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Delete Promotion ERREUR !");
		}
		return reponse;
	}

	
	public List<Promotion> readPromo() {
		List<Promotion> listePromotion = new ArrayList<>();
		Promotion tempPromotion = new Promotion();
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM promotion");
			ResultSet rs = req.executeQuery();
			
			while(rs.next()) {
				tempPromotion.setId_promotion(rs.getInt("id_promotion"));
				tempPromotion.setReduction(rs.getInt("reduction"));
				tempPromotion.setSolde(rs.getInt("solde"));
				tempPromotion.setReference(rs.getString("reference"));

				
				listePromotion.add(tempPromotion);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Read Promotion ERREUR !");
		}
		return listePromotion;
	}
	
	public List<Promotion> readPromoByReference(String reference) {
		List<Promotion> promo = new ArrayList<>();
		Promotion tempPromotion = new Promotion();
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM promotion WHERE reference = ?");
			req.setString(1, reference);
			ResultSet rs = req.executeQuery();
			while(rs.next()) {
				tempPromotion.setId_promotion(rs.getInt("id_promotion"));
				tempPromotion.setReduction(rs.getInt("reduction"));
				tempPromotion.setSolde(rs.getInt("solde"));
				tempPromotion.setReference(rs.getString("reference"));

				
				promo.add(tempPromotion);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return promo;
	}

	@Override
	public boolean create(Promotion object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Promotion> read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Promotion object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Promotion object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Promotion> lister() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Promotion findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void vider_table(Promotion object) {
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
	public boolean ajout(Promotion objet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void Update(Promotion objet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Promotion> getStockParMC(String objet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Promotion objet) {
		// TODO Auto-generated method stub
		return false;
	}

}