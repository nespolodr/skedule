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
public class Registro implements Serializable
{
	private static final long serialVersionUID = -5787445341500968349L;

	public static final int TIPO_LOGIN = 1;
	public static final int TIPO_LOGOUT = 2;
	public static final int TIPO_PESQUISA = 3;
	public static final int TIPO_VISUALIZACAO = 4;
	public static final int TIPO_CADASTRO = 5;
	public static final int TIPO_ALTERACAO = 6;
	public static final int TIPO_EXCLUSAO = 7;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "skedule_registro_seq")
	@SequenceGenerator(name = "skedule_registro_seq", sequenceName = "seq_registro")
	private long id;
	private Date instante;
	private int tipo;
	@JoinColumn(name = "idFuncionario")
	private Funcionario funcionario;
	private String detalhe;
	private String action;

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public Date getInstante()
	{
		return instante;
	}

	public void setInstante(Date instante)
	{
		this.instante = instante;
	}

	public int getTipo()
	{
		return tipo;
	}

	public void setTipo(int tipo)
	{
		this.tipo = tipo;
	}

	public Funcionario getFuncionario()
	{
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario)
	{
		this.funcionario = funcionario;
	}

	public String getDetalhe()
	{
		return detalhe;
	}

	public void setDetalhe(String detalhe)
	{
		this.detalhe = detalhe;
	}

	public String getAction()
	{
		return action;
	}

	public void setAction(String action)
	{
		this.action = action;
	}

}
