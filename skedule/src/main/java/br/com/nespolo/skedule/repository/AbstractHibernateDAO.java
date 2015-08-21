package br.com.nespolo.skedule.repository;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.nespolo.skedule.repository.global.GenericDAO;
import com.google.common.base.Preconditions;

public abstract class AbstractHibernateDAO<T extends Serializable> implements GenericDAO<T>
{
	private Class<T> clazz;

	@Autowired
	private SessionFactory sessionFactory;

	protected final void setClazz(final Class<T> clazzToSet)
	{
		clazz = Preconditions.checkNotNull(clazzToSet);
	}

	public final T findOne(final long id)
	{
		return (T) session().get(clazz, id);
	}

	public final List<T> findAll()
	{
		Criteria criteria = session().createCriteria(clazz);
		return criteria.list();
//		return getCurrentSession().createQuery("from " + clazz.getName()).list();
	}

	public final void create(final T entity)
	{
		Preconditions.checkNotNull(entity);
		// getCurrentSession().persist(entity);
		session().saveOrUpdate(entity);
	}

	public final T update(final T entity)
	{
		Preconditions.checkNotNull(entity);
		return (T) session().merge(entity);
	}

	public final void delete(final T entity)
	{
		Preconditions.checkNotNull(entity);
		session().delete(entity);
	}

	public final void deleteById(final long entityId)
	{
		final T entity = findOne(entityId);
		Preconditions.checkState(entity != null);
		delete(entity);
	}

	protected final Session session()
	{
		return sessionFactory.getCurrentSession();
	}
}
