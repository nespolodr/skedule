package br.com.nespolo.skedule.repository;

import org.springframework.stereotype.Repository;
import br.com.nespolo.skedule.model.Medico;
import br.com.nespolo.skedule.repository.interfaces.MedicoDAO;

@Repository
public class MedicoDAOHibernate extends AbstractHibernateDAO<Medico> implements MedicoDAO
{
	public MedicoDAOHibernate()
	{
		super();
		setClazz(Medico.class);
	}
}
