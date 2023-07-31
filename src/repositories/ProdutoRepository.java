package repositories;


import builders.Builder;
import interfaces.IRepositoryCRUD;
import models.Produto;
import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository implements IRepositoryCRUD {

    private List<Produto> produtos;

    public ProdutoRepository() {

        produtos = new ArrayList<Produto>();
    }

    @Override
    public void salvar(Object entidade) {
        Produto produto = (entidade != null) ? buscarPorId(((Produto) entidade).getId()) : null;

        if(produto == null) {
            produtos.add((Produto) entidade);
        } else {
            // caso tenha um produto com o mesmo id da entidade passada como parâmetro
            // atribuir variável entidade em produto para atualizar a referência
            // com as atualizações
            produto = (Produto) entidade;
        }

    }

    @Override
    public List<Produto> listarTodos() {
        return produtos;
    }

    @Override
    public void excluir(Object entidade) {
        produtos.remove(entidade);
    }

    @Override
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
