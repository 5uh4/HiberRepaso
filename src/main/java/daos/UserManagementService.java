package daos;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;

import models.Usuario;

public class UserManagementService {

	private UserDAO userDAO;
	
	public UserManagementService(final Session session) {
		this.userDAO = new UserDAO(session);
	}
	
	public void insertNewUser(final Usuario nuevoUsuario) {
		 if(nuevoUsuario != null && nuevoUsuario.getId() == 0) {
			 userDAO.insert(nuevoUsuario);
		 }
	}
	
	public void updateUser(final Usuario usuarioActualizar) {
		if(usuarioActualizar != null && usuarioActualizar.getId() != 0) {
			userDAO.update(usuarioActualizar);
		}
	}
	
	public void deleteUser(final Usuario usuarioBorrar) {
		if(usuarioBorrar != null && usuarioBorrar.getId() != 0) {
			userDAO.delete(usuarioBorrar);
		}
	}
	
	public Usuario searchById(final long userId) {
		Usuario usuario = null;
		
		if(userId != 0) {
			usuario = userDAO.searchById(userId);
		}
		return usuario;
	}
	
	public List<Usuario> searchByName(final String name) {
		List<Usuario> userList = new ArrayList<>();
		if(StringUtils.isNotBlank(name)) {
			userList = userDAO.searchByName(name);
		}
		
		return userList;
	}
	
	public List<Usuario> searchAll() {
		return userDAO.searchAll();
	}
}
