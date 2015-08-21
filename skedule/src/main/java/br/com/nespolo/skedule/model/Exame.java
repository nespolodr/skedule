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
public class Exame implements Serializable
{
	private static final long serialVersionUID = -8510749256359330980L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "skedule_exame_seq")
	@SequenceGenerator(name = "skedule_exame_seq", sequenceName = "seq_exame")
	private long id;
	private int tipo;
	@ManyToOne
	@JoinColumn(name = "idConsulta")
	private Consulta consulta;
	private String descricao;
}
