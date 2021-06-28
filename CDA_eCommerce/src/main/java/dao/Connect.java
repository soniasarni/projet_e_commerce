package dao;


import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
	
	public static Connection avoirConnection() {
		
		//Preparation
		String url = "jdbc:mysql://localhost/";
		String nomDB = "projet_1_ecommerce";
		String user = "root";
		String passeword = "";
		Connection connect = null;
		
		//Connection
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection(url+nomDB, user, passeword);
			System.out.println("je suis bien connecté");
		}catch(Exception e){
			System.out.println(e);
			e.printStackTrace();
		}
		return connect;
	}//Fin avoirConnection
	
}//Fin SeConnecter