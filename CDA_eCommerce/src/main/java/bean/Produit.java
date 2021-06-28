package bean;

import java.sql.Date;

public class Produit {
	
	private String reference;
	private String nom;
	private String description;
	private String categorie;
	private String image;
	private Date date;
	private float note;
	private float prix;

	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Produit(String reference, String nom, String description, String categorie, float prix,String image,Date date,float note) {
		super();
		this.reference = reference;
		this.nom = nom;
		this.description = description;
		this.categorie = categorie;
		this.prix = prix;
		this.image= image;
		this.date=date;
		this.note=note;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public float getNote() {
		return note;
	}

	public void setNote(float note) {
		this.note = note;
	}

	
	
}