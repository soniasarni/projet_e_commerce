package dao;

import java.util.List;

import bean.Commande;
import bean.User;

public interface IDAO<T> {

	public boolean create(T object);
	public List<T> read();
	public void update(T object);
	public void delete(T object);
	public List<T> lister();
	public T findById(int id);
	public void vider_table(T object);
	public User login(String email, String pwd);
	public boolean createCom(Commande object);
	public void updateCom(Commande object);
	public void vider_tableCom(Commande object);
	public Commande findByIdCom(int id);
	public boolean ajout(T objet);
	public void Update(T objet);
	public List<T> getStockParMC(String objet);
	public boolean remove(T objet);
	
}