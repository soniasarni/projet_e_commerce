package bean;

import java.util.ArrayList;

public class Panier {

		private ArrayList<ProduitPanier> produits;
		
		public Panier() {
			super();
			// TODO Auto-generated constructor stub
			produits = new ArrayList<ProduitPanier>();
		}

		public ArrayList<ProduitPanier> getProduitsPanier() {
			return produits;
		}
		//Cedric prix
		public float prixtotal() {
			float prixtotal = 0;
			for (ProduitPanier produitPanier : produits) {
				prixtotal += produitPanier.getQuantite() * produitPanier.getProduit().getPrix();
			}
			System.out.println("prix panier Panier = " + prixtotal);
			return prixtotal;
		}
		//Fin Cedric prix
		public int getSize() {
			int count = 0;
		    for (int counter = 0; counter < produits.size(); counter++) { 		      
			       count += produits.get(counter).getQuantite();
			}
		    return count;
		}
		
		public void ajouterProduit(ProduitPanier produit) {
			int index = produitExist(produit.getProduit().getReference());
		    if(index==-1) {
		    	produits.add(produit);
		    }else if(index!=-1) {
		    	plusQuantiteProduit(produit);
		    } 
		}
		
		public void supprimerProduit(String reference) {
			int index = produitExist(reference);
			produits.remove(index);
		}
		
		public int produitExist(String reference) {
			int response = -1;
		    for (int counter = 0; counter < produits.size(); counter++) {
			       if(produits.get(counter).getProduit().getReference().equals(reference)) {
			    	   response=counter;
			       }
			    }
			return response;
		}
		
		public void plusQuantiteProduit(ProduitPanier produit) {
			int index = produitExist(produit.getProduit().getReference());
			if(produit.getQuantite()>0 && index!=-1) {
				produits.get(index).setQuantite(produits.get(index).getQuantite()+produit.getQuantite());
			}
		};
		
		public void moinsQuantiteProduit(ProduitPanier produit) {
			int index = produitExist(produit.getProduit().getReference());
			if(produit.getQuantite()>0 && produit.getQuantite()<=produits.get(index).getQuantite() && index!=-1) {
				produits.get(index).setQuantite(produits.get(index).getQuantite()+produit.getQuantite());
			}else if(produit.getQuantite()>=produits.get(index).getQuantite() && index!=-1) {
				supprimerProduit(produit.getProduit().getReference());
			}
		}
		
		
	}