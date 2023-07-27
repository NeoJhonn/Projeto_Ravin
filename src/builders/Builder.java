package builders;

import enums.*;
import models.*;
import util.HandleDates;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class Builder {
    public Builder() {

    }
    public static void seedFuncionarios(List<Funcionario> funcionarios) {
        funcionarios.add(new Funcionario(100, "Funcionario 1", "1213211", "dfgsdfgsdfg", "45646545646", HandleDates.criarDataAniverssario("07-05-1983"), true, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), "admim",  "admim","45454564", EstadoCivil.Casado, Escolaridade.Médio, Cargo.Gerente, 1212, HandleDates.criarDataAniverssario("01-07-2023"), null, Disponibilidade.DISPONIVEL));
        funcionarios.add(new Funcionario(200, "Funcionario 2", "12878211", "dfgsdfgsdfg", "45646545646", HandleDates.criarDataAniverssario("06-02-1989"), true, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), "admim",  "admim","45454564", EstadoCivil.Casado, Escolaridade.Médio, Cargo.Garcom, 1542, HandleDates.criarDataAniverssario("01-07-2023"), null, Disponibilidade.DISPONIVEL));
        funcionarios.add(new Funcionario(300, "Funcionario 3", "1245211", "dfgsdfgsdfg", "45646545646", HandleDates.criarDataAniverssario("26-11-1986"), true, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), "admim",  "admim","45454564", EstadoCivil.Casado, Escolaridade.Médio, Cargo.Garcom, 1132, HandleDates.criarDataAniverssario("01-07-2023"), null, Disponibilidade.DISPONIVEL));
    }

    public static void seedClientes(List<Cliente> clientes) {
        clientes.add(new Cliente(999, "Cliente 1", "845465456", "afdsfadsfas", "456455644564", HandleDates.criarDataAniverssario("03-01-1999"), true, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), "admim", "admim", "", true));
        clientes.add(new Cliente(998, "Cliente 2", "45645644", "afdsfadsfas", "456455644564", HandleDates.criarDataAniverssario("04-02-1998"), true, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), "admim", "admim", "", false));
        clientes.add(new Cliente(997, "Cliente 3", "4564564564", "afdsfadsfas", "456455644564", HandleDates.criarDataAniverssario("03-01-1999"), true, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), "admim", "admim", "", true));
    }

    public static void seedProdutos(List<Produto> produtos) {
        produtos.add(new Produto(899, "Coca-cola", "600ml", "001", 6, 10, "0", "", TipoProduto.Bebida, true, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), "admim", "admim"));
        produtos.add(new Produto(898, "Skoll", "600ml", "002", 8, 15, "0", "contém glútem", TipoProduto.Bebida, true, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), "admim", "admim"));
        produtos.add(new Produto(897, "X-salada", "pão, hamburguer e salada", "003", 10, 18, "30min", "contém glútem", TipoProduto.Lanche, true, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), "admim", "admim"));
        produtos.add(new Produto(896, "Porção de Batatas Fritas", "500g de batata", "004", 12, 20, "30min", "contém glútem", TipoProduto.Lanche, true, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), "admim", "admim"));
        produtos.add(new Produto(895, "Pudim de leite", "leite,ovos e leite condençado", "005", 13, 25, "60min", "contém lactose", TipoProduto.Sobremesa, true, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), "admim", "admim"));
        produtos.add(new Produto(894, "petit gateau", "uma bola de sorvete, bolo de chocalate com calda quente", "006", 20, 35, "60min", "contém glútem", TipoProduto.Sobremesa, true, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), "admim", "admim"));
    }

    public static void seedMesas(List<Mesa> mesas) {
        mesas.add(new Mesa(799, "Mesa 1", "001", 1, 8, StatusMesa.Livre, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), "admim", "admim"));
        mesas.add(new Mesa(798, "Mesa 2", "002", 2, 8, StatusMesa.Livre, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), "admim", "admim"));
        mesas.add(new Mesa(797, "Mesa 3", "003", 3, 8, StatusMesa.Livre, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), "admim", "admim"));
        mesas.add(new Mesa(796, "Mesa 4", "004", 4, 8, StatusMesa.Livre, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), "admim", "admim"));
    }
}
