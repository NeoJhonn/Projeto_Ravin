package interfaces;

import models.Cardapio;

import javax.swing.text.html.parser.Entity;
import java.util.List;

public interface IRepositoryCRUD {

    void salvar(Object entidade);

    List<Object> listarTodos();

    void excluir(Object entidade);

    Entity buscarPorId(int id);

}
