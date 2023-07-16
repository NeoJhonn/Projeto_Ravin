package repositories;


import builders.Builder;
import models.Produto;
import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository {

    private List<Produto> produtos;

    public ProdutoRepository() {

        produtos = new ArrayList<Produto>();
    }

    public void salvar(Produto entidade) {
        Produto produto = (entidade != null) ? buscarPorId(entidade.getId()) : null;

        if(produto == null) {
            produtos.add(entidade);
        } else {
            // caso tenha um funcionário com o mesmo id da entidade passada como parâmetro
            // atribuir variável entidade em funcionário para atualizar a referência
            // com as atualizações
            produto = entidade;
        }

    }

    public List<Produto> listarTodos() {
        return produtos;
    }

    public void excluir(Produto entidade) {
        produtos.remove(entidade);
    }

    public Produto buscarPorId(int id) {
        Produto produtosBuscado = null;
        for (Produto produto : produtos) {
            if (produto.getId() == id)
                produtosBuscado = produto;
        }

        return produtosBuscado;
    }

    public void deletarPeloId(Produto produto) {
        produtos.remove(produto);
    }

    public int contar() {
        return produtos.size();
    }

    public Produto buscarPorNome(String nome) {
        return null;
    }
}
