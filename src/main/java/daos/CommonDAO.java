package daos;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;

import interfaces.CommonDAOI;
import models.AbstractEntity;

public class CommonDAO<T extends AbstractEntity> implements CommonDAOI<T> {

	private Class<T> entityClass;
	private Session sesion;

	@SuppressWarnings("unchecked")
	protected CommonDAO(Session sesion) {
		setEntityClass(
				(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
		this.sesion = sesion;
	}

	@Override
	public void insert(final T paramT) {
		if (!sesion.getTransaction().isActive()) {
			sesion.getTransaction().begin();
		}

		sesion.save(paramT);
		sesion.flush();

		sesion.getTransaction().commit();
	}

	@Override
	public void update(final T paramT) {

		if (!sesion.getTransaction().isActive()) {
			sesion.getTransaction().begin();
		}

		sesion.saveOrUpdate(paramT);

		sesion.getTransaction().commit();
	}

	@Override
	public void delete(final T paramT) {
		if (!sesion.getTransaction().isActive()) {
			sesion.getTransaction().begin();
		}
		sesion.delete(paramT);
		sesion.getTransaction().commit();
	}

	@Override
	public T searchById(final Long id) {
		if (!sesion.getTransaction().isActive()) {
			sesion.getTransaction().begin();
		}
		return sesion.get(this.entityClass, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> searchAll() {
		if (!sesion.getTransaction().isActive()) {
			sesion.getTransaction().begin();
		}
		return sesion.createQuery("FROM " + this.entityClass.getName()).list();
	}

	public Class<T> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

}
