package br.com.nespolo.skedule.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.nespolo.skedule.model.Medico;
import br.com.nespolo.skedule.model.Paciente;
import br.com.nespolo.skedule.repository.interfaces.FuncionarioDAO;
import br.com.nespolo.skedule.repository.interfaces.MedicoDAO;
import br.com.nespolo.skedule.repository.interfaces.PacienteDAO;
import br.com.nespolo.skedule.service.interfaces.MyService;

@Service
@Transactional(rollbackFor = Exception.class)
public class MyServiceImpl implements MyService
{
	@Autowired
	private FuncionarioDAO funcionarioDAO;

	@Autowired
	private MedicoDAO medicoDAO;

	@Autowired
	private PacienteDAO pacienteDAO;

	public void setFuncionarioDAO(FuncionarioDAO funcionarioDAO)
	{
		this.funcionarioDAO = funcionarioDAO;
	}

	public void setMedicoDAO(MedicoDAO medicoDAO)
	{
		this.medicoDAO = medicoDAO;
	}

	public void setPacienteDAO(PacienteDAO pacienteDAO)
	{
		this.pacienteDAO = pacienteDAO;
	}

	public void doAnything()
	{
		// Funcionario user = new Funcionario();
		// String[] texto = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
		// "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
		// "w", "x", "y", "z" };
		// user.setName(texto[new Random().nextInt(26)]
		// + texto[new Random().nextInt(26)]
		// + texto[new Random().nextInt(26)]
		// + texto[new Random().nextInt(26)]
		// + texto[new Random().nextInt(26)]);
		// userDao.create(user);
	}

	@Override
	public List<Paciente> listarPacientes()
	{
		return pacienteDAO.findAll();
	}

	@Override
	public void inserirPaciente(Paciente paciente)
	{
//		Funcionario medico = funcionarioDAO.findAll().get(0);
//		paciente.setFuncionario(medico);
		pacienteDAO.create(paciente);
	}

	@Override
	public void alterarPaciente(Paciente paciente)
	{
		pacienteDAO.update(paciente);
	}

	@Override
	public void excluirPaciente(Paciente paciente)
	{
		pacienteDAO.delete(paciente);
	}

	@Override
	public List<Medico> listarMedicos()
	{
		return medicoDAO.findAll();
	}

	@Override
	public Medico pegarMedico(long id)
	{
		return medicoDAO.findOne(id);
	}

}
