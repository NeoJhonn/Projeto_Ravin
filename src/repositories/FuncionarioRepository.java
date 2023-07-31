package repositories;

import java.util.ArrayList;
import java.util.List;

import builders.Builder;
import interfaces.IRepositoryCRUD;
import models.Funcionario;

public class FuncionarioRepository implements IRepositoryCRUD {

	private List<Funcionario> funcionarios;

	public FuncionarioRepository() {

		funcionarios = new ArrayList<Funcionario>();
	}

	@Override
	public void salvar(Object entidade) {
		Funcionario funcionario = (entidade != null) ? buscarPorId(((Funcionario)entidade).getId()) : null;
		
		if(funcionario == null) {
			funcionarios.add((Funcionario) entidade);
		} else {
			// caso tenha um funcionário com o mesmo id da entidade passada como parâmetro
			// atribuir variável entidade em funcionário para atualizar a referência
			// com as atualizações
			funcionario = (Funcionario) entidade;
		}
		
	}

	@Override
	public List<Funcionario> listarTodos() {
		return this.funcionarios;
	}

	@Override
	public void excluir(Object entidade) {
		funcionarios.remove(entidade);
	}

	@Override
	public Funcionario buscarPorId(int id) {
		Funcionario funcionarioBuscado = null;
		for (Funcionario funcionario : funcionarios) {
			if (funcionario.getId() == id)
				funcionarioBuscado = funcionario;
		}

		return funcionarioBuscado;
	}

	public void deletarPeloId(Funcionario funcionario) {
		funcionarios.remove(funcionario);
	}

	public int contar() {
		return funcionarios.size();
	}
	
	public Funcionario buscarPorNome(String nome) {
		Funcionario funcionarioBuscado = null;

		for (Funcionario funcionario : funcionarios) {
			if (funcionario.getNome().equalsIgnoreCase(nome.trim())) {
				funcionarioBuscado = funcionario;
			}
		}

		return funcionarioBuscado;
	}

}
