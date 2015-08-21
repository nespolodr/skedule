package br.com.nespolo.skedule.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;

@Entity
public class HistoricoPaciente implements Serializable
{
	private static final long serialVersionUID = 8491336172092338143L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "skedule_historicopaciente_seq")
	@SequenceGenerator(name = "skedule_historicopaciente_seq", sequenceName = "seq_historicopaciente")
	private long id;
	@JoinColumn(name = "idPaciente")
	private Paciente paciente;
	@JoinColumn(name = "idMedico")
	private Medico medico;
	@JoinColumn(name = "idConsulta")
	private Consulta consulta;
	private String historico;

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public Paciente getPaciente()
	{
		return paciente;
	}

	public void setPaciente(Paciente paciente)
	{
		this.paciente = paciente;
	}

	public Medico getMedico()
	{
		return medico;
	}

	public void setMedico(Medico medico)
	{
		this.medico = medico;
	}

	public Consulta getConsulta()
	{
		return consulta;
	}

	public void setConsulta(Consulta consulta)
	{
		this.consulta = consulta;
	}

	public String getHistorico()
	{
		return historico;
	}

	public void setHistorico(String historico)
	{
		this.historico = historico;
	}

}
