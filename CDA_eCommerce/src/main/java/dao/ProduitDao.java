package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.Produit;

public class ProduitDao {

	Connection connect = Connect.avoirConnection();
	
	public boolean create(Produit object) {
		boolean response = false;
		try {
			PreparedStatement request = connect.prepareStatement("INSERT INTO `produit` (`nom_produit`, `reference`, `description`, `categorie`, `prix`, `image`, `date_sortie`, `note`) "
					+ "VALUES (?,?,?,?,?,?,?,?);");

			request.setString(1, object.getNom());
			request.setString(2, object.getReference());
			request.setString(3, object.getDescription());
			request.setString(4, object.getCategorie());
			request.setFloat(5, object.getPrix());
			request.setString(6, object.getImage());
			request.setDate(7, (Date) object.getDate());
			request.setFloat(8, object.getNote());
			
			request.executeUpdate();
			
			System.out.println( object.getNom()+ "  " +object.getReference() +" a été bien ajouté en base");
			
			response = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
	public Produit read(String reference) {
		Produit prod = new Produit();
		//List<Produit> response = new ArrayList<>();
		try {
			PreparedStatement request = connect.prepareStatement("SELECT * FROM produit WHERE reference = ? ;");
			request.setString(1, reference);
			ResultSet rs = request.executeQuery();
			while(rs.next()) {
				prod = new Produit(rs.getString("reference"),rs.getString("nom_produit"),rs.getString("description"),rs.getString("categorie"),rs.getFloat("prix"),rs.getString("image"),rs.getDate("date_sortie"),rs.getFloat("note"));
				//Produit current = new Produit(rs.getString("reference"),rs.getString("nom_produit"),rs.getString("description"),rs.getString("categorie"),rs.getFloat("prix"),rs.getString("image"),rs.getDate("date_sortie"),rs.getFloat("note"));
				//response.add(current);
				//prod = current;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prod;
	};

	public ArrayList<Produit> readAll() {
		ArrayList<Produit> response = null;
		try {
			PreparedStatement request = connect.prepareStatement("SELECT * FROM produit;");
			ResultSet rs = request.executeQuery();
			response = new ArrayList<Produit>();
			while(rs.next()) {
				Produit current = new Produit(rs.getString("reference"),rs.getString("nom_produit"),rs.getString("description"),rs.getString("categorie"),rs.getFloat("prix"),rs.getString("image"),rs.getDate("date_sortie"),rs.getFloat("note"));
				response.add(current);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
	public boolean update(Produit object) {
		boolean response = false;
		try {
			PreparedStatement request = connect.prepareStatement("UPDATE produit SET nom_produit=?, reference=?, description=?, categorie=?, prix=? , image=?, date_sortie=?, note=? WHERE reference= ?");
			request.setString(1, object.getNom());
			request.setString(2, object.getReference());
			request.setString(3, object.getDescription());
			request.setString(4, object.getCategorie());
			request.setFloat(5, object.getPrix());
			request.setString(6, object.getImage());
			request.setDate(7, (Date) object.getDate());
			request.setFloat(8, object.getNote());
			request.setString(9, object.getReference());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
	public boolean delete(String reference) {
		boolean response = false;
		try {
			PreparedStatement request = connect.prepareStatement("DELETE FROM produit WHERE reference = ? ;");
			request.setString(1, reference);
			request.executeUpdate();
			response = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
	public ArrayList<Produit> readpop() {
		ArrayList<Produit> listePop = new ArrayList<>();
		try {
			PreparedStatement req = connect.prepareStatement("SELECT nom_produit, produit.reference, description, categorie, prix, date_sortie, note, image, COUNT(*)\r\n" 
					+ "FROM commande\r\n"
					+ "INNER JOIN produit\r\n"
					+ "ON commande.reference = produit.reference\r\n"
					+ "GROUP BY commande.reference\r\n"
					+ "ORDER BY COUNT(*) DESC\r\n"
					+ "LIMIT 8");
			ResultSet rs = req.executeQuery();
			
			while(rs.next()) {
				Produit tempPop = new Produit();
				tempPop.setReference(rs.getString("reference"));
				tempPop.setNom(rs.getString("nom_produit"));
				tempPop.setDescription(rs.getString("description"));
				tempPop.setCategorie(rs.getString("categorie"));
				tempPop.setImage(rs.getString("image"));
				tempPop.setPrix(rs.getFloat("prix"));
				tempPop.setDate(rs.getDate("date_sortie"));
				tempPop.setNote(rs.getFloat("note"));
	
				listePop.add(tempPop);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Read ERREUR !");
		}
		return listePop;
	}
	
	public ArrayList<Produit> readrecent() {
		ArrayList<Produit> listeRecent = new ArrayList<Produit>();
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM produit ORDER BY date_sortie DESC LIMIT 8");
			ResultSet rs = req.executeQuery();
			
			while(rs.next()) {
				Produit tempRecent = new Produit();
				tempRecent.setReference(rs.getString("reference"));
				tempRecent.setNom(rs.getString("nom_produit"));
				tempRecent.setDescription(rs.getString("description"));
				tempRecent.setCategorie(rs.getString("categorie"));
				tempRecent.setImage(rs.getString("image"));
				tempRecent.setPrix(rs.getFloat("prix"));
				tempRecent.setDate(rs.getDate("date_sortie"));
				tempRecent.setNote(rs.getFloat("note"));
	
				listeRecent.add(tempRecent);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Read ERREUR !");
		}
		return listeRecent;
	}

	public ArrayList<Produit> readnote() {
		ArrayList<Produit> listeNote = new ArrayList<>();
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM produit ORDER BY note DESC LIMIT 8");
			ResultSet rs = req.executeQuery();
			
			while(rs.next()) {
				Produit tempNote = new Produit();
				tempNote.setReference(rs.getString("reference"));
				tempNote.setNom(rs.getString("nom_produit"));
				tempNote.setDescription(rs.getString("description"));
				tempNote.setCategorie(rs.getString("categorie"));
				tempNote.setImage(rs.getString("image"));
				tempNote.setPrix(rs.getFloat("prix"));
				tempNote.setDate(rs.getDate("date_sortie"));
				tempNote.setNote(rs.getFloat("note"));
	
				listeNote.add(tempNote);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Read ERREUR !");
		}
		return listeNote;
	}
	
	
	public ArrayList<Produit> recherche(String requete) {
		ArrayList<Produit> listSearch = new ArrayList<Produit>();
		try {
            PreparedStatement req = connect.prepareStatement(requete);
			ResultSet rs = req.executeQuery();
			System.out.println(req);
			
			while(rs.next()) {
				Produit produit_recherche = new Produit();
				produit_recherche.setReference(rs.getString("reference"));
				produit_recherche.setNom(rs.getString("nom_produit"));
				produit_recherche.setDescription(rs.getString("description"));
				produit_recherche.setCategorie(rs.getString("categorie"));
				produit_recherche.setImage(rs.getString("image"));
				produit_recherche.setPrix(rs.getFloat("prix"));
				produit_recherche.setDate(rs.getDate("date_sortie"));
				produit_recherche.setNote(rs.getFloat("note"));
	
				listSearch.add(produit_recherche);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Read ERREUR !");
		}
		return listSearch;
	}
	
}