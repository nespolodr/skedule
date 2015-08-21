package br.com.nespolo.skedule.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Consulta implements Serializable
{
	private static final long serialVersionUID = 8236991048618798284L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "skedule_consulta_seq")
	@SequenceGenerator(name = "skedule_consulta_seq", sequenceName = "seq_consulta")
	private long id;
	@JoinColumn(name = "idMedico")
	private Medico medico;
	@JoinColumn(name = "idPaciente")
	private Paciente paciente;
	@JoinColumn(name = "idSecretaria")
	private Funcionario secretaria;
	private Date dataInsercao;
	private Date dataConsulta;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "consulta")
	@Fetch(FetchMode.SUBSELECT)
	@OrderBy(value = "id")
	private List<Exame> listaExame;
	// Convenio, particular, SUS
	private int tipo;
	private BigDecimal valor;
	private String observacao;
	// Agendada, cancelada, realizada
	private int status;

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public Medico getMedico()
	{
		return medico;
	}

	public void setMedico(Medico medico)
	{
		this.medico = medico;
	}

	public Paciente getPaciente()
	{
		return paciente;
	}

	public void setPaciente(Paciente paciente)
	{
		this.paciente = paciente;
	}

	public Funcionario getSecretaria()
	{
		return secretaria;
	}

	public void setSecretaria(Funcionario secretaria)
	{
		this.secretaria = secretaria;
	}

	public Date getDataInsercao()
	{
		return dataInsercao;
	}

	public void setDataInsercao(Date dataInsercao)
	{
		this.dataInsercao = dataInsercao;
	}

	public Date getDataConsulta()
	{
		return dataConsulta;
	}

	public void setDataConsulta(Date dataConsulta)
	{
		this.dataConsulta = dataConsulta;
	}

	public List<Exame> getListaExame()
	{
		return listaExame;
	}

	public void setListaExame(List<Exame> listaExame)
	{
		this.listaExame = listaExame;
	}

	public int getTipo()
	{
		return tipo;
	}

	public void setTipo(int tipo)
	{
		this.tipo = tipo;
	}

	public BigDecimal getValor()
	{
		return valor;
	}

	public void setValor(BigDecimal valor)
	{
		this.valor = valor;
	}

	public String getObservacao()
	{
		return observacao;
	}

	public void setObservacao(String observacao)
	{
		this.observacao = observacao;
	}

	public int getStatus()
	{
		return status;
	}

	public void setStatus(int status)
	{
		this.status = status;
	}

}
