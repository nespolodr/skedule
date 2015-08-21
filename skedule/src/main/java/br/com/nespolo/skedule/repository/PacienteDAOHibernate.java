package br.com.nespolo.skedule.repository;

import org.springframework.stereotype.Repository;
import br.com.nespolo.skedule.model.Paciente;
import br.com.nespolo.skedule.repository.interfaces.PacienteDAO;

@Repository
public class PacienteDAOHibernate extends AbstractHibernateDAO<Paciente> implements PacienteDAO
{
	public PacienteDAOHibernate()
	{
		super();
		setClazz(Paciente.class);
	}
}
