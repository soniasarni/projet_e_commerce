package bean;

public class User {
	//Attributs
		protected int id_user;
		protected String nom;
		protected String prenom;
		protected String adresse;
		protected String ville;
		protected String mail;
		protected String password;
		protected Boolean admin = false ;

		//Constructeurs
		public User() {
			super();
		}	
		public User(String nom, String prenom, String adresse, String ville, String mail, String password) {
			super();
			this.nom = nom;
			this.prenom = prenom;
			this.adresse = adresse;
			this.ville = ville;
			this.mail = mail;
			this.password = password;
		}
		public User(String nom, String prenom, String adresse, String ville, String mail, String password, Boolean admin) {
			super();
			this.nom = nom;
			this.prenom = prenom;
			this.adresse = adresse;
			this.ville = ville;
			this.mail = mail;
			this.password = password;
			this.admin = admin;
		}
		
		//Méthodes
		
		
		
		//geter & setter

		public int getId_user() {
			return id_user;
		}

		public void setId_user(int id_user) {
			this.id_user = id_user;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getPrenom() {
			return prenom;
		}

		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}

		public String getAdresse() {
			return adresse;
		}

		public void setAdresse(String adresse) {
			this.adresse = adresse;
		}

		public String getVille() {
			return ville;
		}

		public void setVille(String ville) {
			this.ville = ville;
		}

		public String getMail() {
			return mail;
		}

		public void setMail(String mail) {
			this.mail = mail;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		public Boolean getAdmin() {
			return admin;
		}

		public void setAdmin(Boolean admin) {
			this.admin = admin;
		}

}
