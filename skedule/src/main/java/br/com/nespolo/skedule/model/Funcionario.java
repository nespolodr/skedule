package br.com.nespolo.skedule.model;

import java.io.Serializable;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue("0")
public class Funcionario implements Serializable
{
	private static final long serialVersionUID = 7497161695752779603L;

	protected static final int TIPO_DEFAULT = 0;
	protected static final int TIPO_MEDICO = 1;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "skedule_funcionario_seq")
	@SequenceGenerator(name = "skedule_funcionario_seq", sequenceName = "seq_funcionario")
	private long id;
	private String nome;
	private String rg;
	private String cpf;

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
}
