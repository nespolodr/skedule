package br.com.nespolo.skedule.repository.global;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T extends Serializable>
{
	public abstract T findOne(final long id);

	public abstract List<T> findAll();

	public abstract void create(final T entity);

	public abstract T update(final T entity);

	public abstract void delete(final T entity);

	public abstract void deleteById(final long entityId);
}
