package bean;


public class Commande {
	protected int commande_id;
	protected String date_commande;
	protected int qte_com;
	protected int user_id;
	protected String reference;
	
	public Commande() {
		super();
	}
	
	public Commande(String date_commande, int qte_com, int user_id, String reference ) {
		super();
		this.date_commande = date_commande;
		this.qte_com = qte_com;
		this.user_id = user_id;
		this.reference = reference;
	}

	public int getCommande_id() {
		return commande_id;
	}

	public void setCommande_id(int commande_id) {
		this.commande_id = commande_id;
	}

	public String getDate_commande() {
		return date_commande;
	}

	public void setDate_commande(String date_commande) {
		this.date_commande = date_commande;
	}

	public int getQte_com() {
		return qte_com;
	}

	public void setQte_com(int qte_com) {
		this.qte_com = qte_com;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	
	
	
}

