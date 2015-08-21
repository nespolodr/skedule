package br.com.nespolo.skedule.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;

@Entity
public class Notificacao implements Serializable
{
	private static final long serialVersionUID = 5553355861256127343L;

	// PARAMETRIZAR NO BANCO
	public static final int N_PACIENTE_CHEGOU = 1;
	public static final int N_PACIENTE_FALTOU = 2;
	public static final int N_COMPARECER_A_SALA_MEDICO = 3;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "skedule_notificacao_seq")
	@SequenceGenerator(name = "skedule_notificacao_seq", sequenceName = "seq_notificacao")
	private long id;
	private Date criacao;
	@JoinColumn(name = "idFuncionario")
	private Funcionario funcionario; //Destinatario
	private int tipo;
	private String detalhes;

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public Date getCriacao()
	{
		return criacao;
	}

	public void setCriacao(Date criacao)
	{
		this.criacao = criacao;
	}

	public Funcionario getFuncionario()
	{
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario)
	{
		this.funcionario = funcionario;
	}

	public int getTipo()
	{
		return tipo;
	}

	public void setTipo(int tipo)
	{
		this.tipo = tipo;
	}

	public String getDetalhes()
	{
		return detalhes;
	}

	public void setDetalhes(String detalhes)
	{
		this.detalhes = detalhes;
	}

}
