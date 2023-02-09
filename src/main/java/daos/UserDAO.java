package daos;

import java.util.List;

import org.hibernate.Session;

import models.Usuario;

public class UserDAO extends CommonDAO<Usuario>{

	private Session session;
	
	public UserDAO(Session session) {
		super(session);
		this.session = session;
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> searchByName(final String name) {
		if(!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}
		
		return session.createQuery("FROM Usuario where nombre = '" + name + "'").list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> searchByUserName(final String userName) {
		if(!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}
		return session.createQuery("FROM Usuario WHERE userName = '" + userName + "'").list();
	}
}
