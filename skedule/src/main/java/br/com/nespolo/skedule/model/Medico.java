package br.com.nespolo.skedule.model;

import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@DiscriminatorValue("1")
public class Medico extends Funcionario
{
	private static final long serialVersionUID = 4034326634139281847L;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "medico")
	@Fetch(FetchMode.SUBSELECT)
	@OrderBy(value = "id")
	private List<Paciente> pacientes;

	public List<Paciente> getPacientes()
	{
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes)
	{
		this.pacientes = pacientes;
	}

}
