package br.com.nespolo.skedule.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.springframework.stereotype.Controller;
import br.com.nespolo.skedule.model.Medico;
import br.com.nespolo.skedule.model.Paciente;
import br.com.nespolo.skedule.service.interfaces.MyService;

@ViewScoped
@Controller
@ManagedBean(name = "pacienteController")
public class PacienteController implements Serializable
{
	private static final long serialVersionUID = 83608156751823705L;

	private Paciente paciente = new Paciente();
	private Medico medico = new Medico();
	private List<Medico> medicos = new ArrayList<Medico>();

	@ManagedProperty(name = "myService", value = "#{myService}")
	private MyService myService;

	public void setMyService(MyService myService)
	{
		this.myService = myService;
		paciente = new Paciente();
		atualizarMedicos();
		if (!medicos.isEmpty())
			medico = medicos.get(0);
	}

	public PacienteController()
	{
		paciente = new Paciente();
		medico = new Medico();
	}

	public void refreshMedicoSelecionado()
	{
		long id = medico.getId();
		Medico medicoAtualizado = myService.pegarMedico(id);
		medicos.remove(medico);
		medicos.add(medicoAtualizado);
//		atualizarMedicos();
		medico = medicoAtualizado;
		paciente = new Paciente();

		Collections.sort(medicos, new Comparator<Medico>()
		{
			@Override
			public int compare(Medico o1, Medico o2)
			{
				return o1.getNome().compareTo(o2.getNome());
			}
		});
	}

	public void atualizarMedicos()
	{
		medicos.clear();
		medicos = this.myService.listarMedicos();
	}

	public void cadastrar()
	{
		if (medico != null)
		{
			paciente.setMedico(medico);
			myService.inserirPaciente(paciente);
			paciente = new Paciente();

			refreshMedicoSelecionado();
		}
	}

	public void alterar(ActionEvent actionEvent)
	{
		myService.alterarPaciente(paciente);
		paciente = new Paciente();

		refreshMedicoSelecionado();
	}

	public void alterar()
	{
		myService.alterarPaciente(paciente);
		paciente = new Paciente();

		refreshMedicoSelecionado();
	}

	public void excluir(ActionEvent actionEvent)
	{
		myService.excluirPaciente(paciente);
		paciente = new Paciente();

		refreshMedicoSelecionado();
	}

	public Paciente getPaciente()
	{
		return paciente;
	}

	public void setPaciente(Paciente paciente)
	{
		// XXX corrija isto!
		if (paciente == null)
			this.paciente = new Paciente();
		else
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

	public List<Medico> getMedicos()
	{
		return medicos;
	}

	public void setMedicos(List<Medico> medicos)
	{
		this.medicos = medicos;
	}

}
