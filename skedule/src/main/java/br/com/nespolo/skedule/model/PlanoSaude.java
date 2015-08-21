package br.com.nespolo.skedule.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class PlanoSaude implements Serializable
{
	private static final long serialVersionUID = -8833737910667522810L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "skedule_planosaude_seq")
	@SequenceGenerator(name = "skedule_planosaude_seq", sequenceName = "seq_planosaude")
	private long id;
	private String codigo;
	private String nome;
	private String endereco;
	private String telefone;

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getCodigo()
	{
		return codigo;
	}

	public void setCodigo(String codigo)
	{
		this.codigo = codigo;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public String getEndereco()
	{
		return endereco;
	}

	public void setEndereco(String endereco)
	{
		this.endereco = endereco;
	}

	public String getTelefone()
	{
		return telefone;
	}

	public void setTelefone(String telefone)
	{
		this.telefone = telefone;
	}
}
