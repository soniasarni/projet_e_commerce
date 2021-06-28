package bean;

public class Promotion {
	private int id_promotion;
	private int reduction;
	private int solde;
	private String reference;
	
	public Promotion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Promotion(int reduction, int solde, String reference) {
		super();
		this.reduction = reduction;
		this.solde = solde;
		this.reference = reference;
	}
	public int getId_promotion() {
		return id_promotion;
	}
	public void setId_promotion(int id_promotion) {
		this.id_promotion = id_promotion;
	}
	public int getReduction() {
		return reduction;
	}
	public void setReduction(int reduction) {
		this.reduction = reduction;
	}
	public int getSolde() {
		return solde;
	}
	public void setSolde(int solde) {
		this.solde = solde;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	
}