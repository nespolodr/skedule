package br.com.nespolo.skedule.repository;

import org.springframework.stereotype.Repository;
import br.com.nespolo.skedule.model.Funcionario;
import br.com.nespolo.skedule.repository.interfaces.FuncionarioDAO;

@Repository
public class FuncionarioDAOHibernate extends AbstractHibernateDAO<Funcionario> implements FuncionarioDAO
{
	public FuncionarioDAOHibernate()
	{
		super();
		setClazz(Funcionario.class);
	}
}
