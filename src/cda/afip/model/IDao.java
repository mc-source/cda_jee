package cda.afip.model;

import java.util.List;

public interface IDao<T> {
	List<T> getAll();
	T getById(int id);
	
	T add(T item);
	T update(T item);
	boolean delete(T item);
}
