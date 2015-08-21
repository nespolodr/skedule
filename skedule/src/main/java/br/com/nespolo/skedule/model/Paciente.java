package br.com.nespolo.skedule.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Paciente implements Serializable
{
	private static final long serialVersionUID = -6839871145436170260L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "skedule_paciente_seq")
	@SequenceGenerator(name = "skedule_paciente_seq", sequenceName = "seq_paciente")
	private long id;
	private String nome;
	private String rg;
	private String cpf;
	@ManyToOne
	@JoinColumn(name = "idMedico")
	private Medico medico;

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public String getRg()
	{
		return rg;
	}

	public void setRg(String rg)
	{
		this.rg = rg;
	}

	public String getCpf()
	{
		return cpf;
	}

	public void setCpf(String cpf)
	{
		this.cpf = cpf;
	}

	public Medico getMedico()
	{
		return medico;
	}

	public void setMedico(Medico medico)
	{
		this.medico = medico;
	}
}
