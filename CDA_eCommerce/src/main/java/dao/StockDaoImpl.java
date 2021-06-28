package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Commande;
import bean.Stock;
import bean.User;


public class StockDaoImpl implements IDAO<Stock> {

	Connection connect = Connect.avoirConnection();
	@Override
	public void Update(Stock objet) {
		PreparedStatement req1;
			 try {
				req1 = connect.prepareStatement("UPDATE stock SET quantite =?, dateApprovisionnement=now(),reference=? WHERE id=?");
				req1.setInt(1,objet.getQuantite());
				req1.setString(2,objet.getReference());
				req1.setInt(3,objet.getId());
				
				System.out.println(req1);
				req1.execute();
				System.out.println("mise a jour faite");
            } catch (SQLException e) {
				e.printStackTrace();
				System.out.println("unable to save the the product");
			}
		}

	
	public void modifier(Stock objet) {
		PreparedStatement req1;
		 try {
			req1 = connect.prepareStatement("UPDATE stock SET quantite =?, dateApprovisionnement=now() WHERE reference=?");
			req1.setInt(1,objet.getQuantite());
			req1.setString(2,objet.getReference());


			System.out.println(req1);
			req1.execute();
			System.out.println("mise a jour faite");
       } catch (SQLException e) {
			e.printStackTrace();
			System.out.println("unable to save the the product");
		}
	}

	//recuperer la quantite d'une reference si elle existe
	public int recupQte(Stock objet) {
		int X=0;
	
		if(objet.getReference()!=null) {
			 try {
				PreparedStatement req2= connect.prepareStatement("SELECT quantite FROM stock WHERE reference=?");
				req2.setString(1,objet.getReference());
				ResultSet rs2 = req2.executeQuery();
				while(rs2.next()) {
					Stock article2 = new Stock();
					article2.setQuantite(rs2.getInt("quantite"));
				    X =rs2.getInt("quantite");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
			}
		}
	return X;
	} 

	@Override
	public boolean ajout(Stock objet) {
		recupQte(objet);
		boolean message= false; 
		if(recupQte(objet) > 0) {
			//Si on a une quantit�, je fais une mise � jour (Update)
			try {
			  PreparedStatement req = connect.prepareStatement(
						"UPDATE stock SET quantite =?, dateApprovisionnement=now() WHERE reference=?");
						//"Update stock(quantite,reference,dateApprovisionnement)" + "values(?,?,now())");
				req.setInt(1, objet.getQuantite()+recupQte(objet));
				req.setString(2, objet.getReference());
				req.executeUpdate();
			//SI LE PRODUIT EXISTE
	       message=true;
			} catch (Exception e) {
				e.printStackTrace();
				 message=false;
			}
		}else {
			try {
				//Si la quantite ou la reference n'existe pas je fais un insert en BDD
			PreparedStatement req = connect.prepareStatement(
					"INSERT INTO stock(quantite,reference,dateApprovisionnement)" + "values(?,?,now())");
			req.setInt(1, objet.getQuantite());
			req.setString(2, objet.getReference());
			req.executeUpdate();
		//SI LE PRODUIT EXISTE
       message=true;
		} catch (Exception e) {
			e.printStackTrace();
			 message=false;
		}
		return message;
		}
		return message;
	}
		
//////Liste des articles dans le stock
	public List<Stock> read() {
	List<Stock> listearticle = new ArrayList<Stock>();	
		
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM stock GROUP BY reference;");
			
			ResultSet rs = req.executeQuery();
			
			while(rs.next()) {
				
				Stock article1 = new Stock();
				article1.setId(rs.getInt("id"));
				article1.setReference(rs.getString("reference"));
				article1.setQuantite(rs.getInt("quantite"));
				article1.setDateApprovisionnement(rs.getDate("dateApprovisionnement"));
				listearticle.add(article1);
			}
	
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("erreur");
		}
	return listearticle;
	}

    @Override
	public List<Stock> getStockParMC(String mc) {
		List<Stock>produits=new ArrayList<Stock>();
		try {
			PreparedStatement pro = connect.prepareStatement("SELECT * FROM stock where  reference  LIKE ?  GROUP BY reference");
			pro.setString(1,"%"+mc+"%");
			System.out.println(pro);
			ResultSet rs = pro.executeQuery();
			 while (rs.next()) {
				Stock artic =new Stock();
				artic.setId(rs.getInt("id"));
				artic.setQuantite(rs.getInt("quantite"));
				artic.setReference(rs.getString("reference"));
				artic.setDateApprovisionnement(rs.getDate("dateApprovisionnement"));
				produits.add(artic);
			}
			
		}catch(Exception e) {
				e.printStackTrace();
			}
		return produits;
	}

   /* @Override
     public void delete(Stock objet) {
	try {
		PreparedStatement req= connect.prepareStatement("DELETE FROM stock WHERE id = ?");
		req.setInt(1,objet.getId());
		System.out.println(req);
		req.executeUpdate();
		System.out.println("l'article � �t� supprim�");
	}
	catch (Exception e) {
		e.printStackTrace();
		System.out.println("Delete KO");
		}
	}*/
    
    public void deleteById(int id) {
    	try {
    		PreparedStatement req= connect.prepareStatement("DELETE FROM stock WHERE id = ?");
    		req.setInt(1,id);
    		System.out.println(req);
    		req.executeUpdate();
    		System.out.println("l'article � �t� supprim�");
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    		System.out.println("Delete KO");
    		}
    	}
   
    @Override
    public boolean remove(Stock objet) {
	recupQte(objet);
	System.out.println(recupQte(objet));
	boolean message= false; 
	if(recupQte(objet) >= objet.getQuantite()) {
		//Si on a une quantit�, je fais une mise � jour (Update)
		try {
		    PreparedStatement req = connect.prepareStatement(
					"UPDATE stock SET quantite =?, dateApprovisionnement=now() WHERE reference=?");
		//"Update stock(quantite,reference,dateApprovisionnement)" + "values(?,?,now())");
			req.setInt(1,recupQte(objet) - objet.getQuantite());
			req.setString(2, objet.getReference());
			
			
			req.executeUpdate();
			System.out.println(objet.getReference()+ "Insertion OK");
			
		}
		
	 catch (Exception e) {
		e.printStackTrace();
		 message=false;
	} 
	}
	return message;
	
	}
  
	//public List<Stock>r�cup�r�(Stock objet) {
	   public List<Stock> recuperer(int id) {
		List<Stock> listearticle = new ArrayList<Stock>();	
				
				try {
					//PreparedStatement req = connect.prepareStatement("SELECT quantite FROM stock WHERE reference=?");
					PreparedStatement req = connect.prepareStatement("SELECT * FROM stock WHERE id=?");
					req.setInt(1,id);
					System.out.println(req +"Find by ID");
					
					ResultSet rs = req.executeQuery();
					
					while(rs.next()) {
						
						Stock article1 = new Stock();
						article1.setId(rs.getInt("id"));
						article1.setReference(rs.getString("reference"));
						article1.setQuantite(rs.getInt("quantite"));
						article1.setDateApprovisionnement(rs.getDate("dateApprovisionnement"));
						listearticle.add(article1);
					}
				System.out.println(listearticle);
				}catch(Exception e) {
					e.printStackTrace();
					System.out.println("erreur");
				}
			return listearticle;
			}
	   
	 
@Override
public boolean create(Stock object) {
	// TODO Auto-generated method stub
	return false;
}
@Override
public void update(Stock object) {
	// TODO Auto-generated method stub
	
}
@Override
public List<Stock> lister() {
	// TODO Auto-generated method stub
	return null;
}
@Override
public Stock findById(int id) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public void vider_table(Stock object) {
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
public void delete(Stock object) {
	// TODO Auto-generated method stub
	
}


	
	



    }
	
	



