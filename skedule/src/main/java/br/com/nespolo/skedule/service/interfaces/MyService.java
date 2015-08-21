package br.com.nespolo.skedule.service.interfaces;

import java.util.List;
import br.com.nespolo.skedule.model.Medico;
import br.com.nespolo.skedule.model.Paciente;

public interface MyService
{
	public abstract List<Paciente> listarPacientes();

	public abstract void inserirPaciente(Paciente paciente);

	public abstract void alterarPaciente(Paciente paciente);

	public abstract void excluirPaciente(Paciente paciente);

	public abstract List<Medico> listarMedicos();

	public abstract Medico pegarMedico(long id);
}
