package repositories;

import java.util.ArrayList;
import java.util.List;

import builders.Builder;
import models.Funcionario;

public class FuncionarioRepository {

	private List<Funcionario> funcionarios;

	public FuncionarioRepository() {

		funcionarios = new ArrayList<Funcionario>();
	}

	public void salvar(Funcionario entidade) {
		Funcionario funcionario = (entidade != null) ? buscarPorId(entidade.getId()) : null;
		
		if(funcionario == null) {
			funcionarios.add(entidade);
		} else {
			// caso tenha um funcionário com o mesmo id da entidade passada como parâmetro
			// atribuir variável entidade em funcionário para atualizar a referência
			// com as atualizações
			funcionario = entidade;
		}
		
	}

	public List<Funcionario> listarTodos() {
		return this.funcionarios;
	}

	public void excluir(Funcionario entidade) {
		funcionarios.remove(entidade);
	}

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
