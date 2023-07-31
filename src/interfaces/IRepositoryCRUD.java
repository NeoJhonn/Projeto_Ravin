package interfaces;

import models.Cardapio;

import javax.swing.text.html.parser.Entity;
import java.util.List;

public interface IRepositoryCRUD {
    void salvar(Object entidade);

    List<?> listarTodos();

    void excluir(Object entidade);

    Object buscarPorId(int id);

}
