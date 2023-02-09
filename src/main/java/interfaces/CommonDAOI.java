package interfaces;

import java.util.List;

public interface CommonDAOI<T> {
	public void insert(final T paramT);
	
	public void update(final T paramT);
	
	public void delete(final T paramT);
	
	public List<T> searchAll();
	
	public T searchById(final Long id);
}
