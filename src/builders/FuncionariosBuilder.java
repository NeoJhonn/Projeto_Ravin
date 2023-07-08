package builders;

import enums.Cargo;
import enums.Disponibilidade;
import enums.Escolaridade;
import enums.EstadoCivil;
import models.Funcionario;
import util.HandleDates;

import java.sql.Timestamp;
import java.util.List;

public class FuncionariosBuilder {
    public FuncionariosBuilder() {

    }

    public static List<Funcionario> getFuncionarios() {
        return List.of(
            new Funcionario(100, "Funcionario 1", "1213211", "dfgsdfgsdfg", "45646545646", HandleDates.criarDataAniverssario("07-05-1983"), true, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), "admim",  "admim","45454564", EstadoCivil.Casado, Escolaridade.Médio, Cargo.Gerente, 1212, HandleDates.criarDataAniverssario("01-07-2023"), null, Disponibilidade.DISPONIVEL),
            new Funcionario(200, "Funcionario 2", "12878211", "dfgsdfgsdfg", "45646545646", HandleDates.criarDataAniverssario("06-02-1989"), true, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), "admim",  "admim","45454564", EstadoCivil.Casado, Escolaridade.Médio, Cargo.Garcom, 1212, HandleDates.criarDataAniverssario("01-07-2023"), null, Disponibilidade.DISPONIVEL),
            new Funcionario(300, "Funcionario 3", "1245211", "dfgsdfgsdfg", "45646545646", HandleDates.criarDataAniverssario("26-11-1986"), true, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), "admim",  "admim","45454564", EstadoCivil.Casado, Escolaridade.Médio, Cargo.Garcom, 1212, HandleDates.criarDataAniverssario("01-07-2023"), null, Disponibilidade.DISPONIVEL)
        );
    }
}
