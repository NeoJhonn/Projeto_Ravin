package models;

import enums.StatusMesa;

import java.sql.Timestamp;
import java.util.List;

public class Mesa {
    private int id;
    private Funcionario funcionario;
    private Cliente cliente;
    private String nome;
    private String codigo;
    private int numero;
    private int quantidadeMaximaPessoas;
    private StatusMesa statusMesa;
    private Timestamp criadoEM;
    private Timestamp alteradoEM;
    private String criadoPor;
    private String AlteradoPor;

    public Mesa() {

    }

    public Mesa(int id, Funcionario funcionario, String nome, String codigo, int numero, int quantidadeMaximaPessoas, StatusMesa statusMesa, Timestamp criadoEM, Timestamp alteradoEM, String criadoPor, String alteradoPor) {
        this.id = id;
        this.funcionario = funcionario;
        this.nome = nome;
        this.codigo = codigo;
        this.numero = numero;
        this.quantidadeMaximaPessoas = quantidadeMaximaPessoas;
        this.statusMesa = statusMesa;
        this.criadoEM = criadoEM;
        this.alteradoEM = alteradoEM;
        this.criadoPor = criadoPor;
        AlteradoPor = alteradoPor;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getQuantidadeMaximaPessoas() {
        return quantidadeMaximaPessoas;
    }

    public void setQuantidadeMaximaPessoas(int quantidadeMaximaPessoas) {
        this.quantidadeMaximaPessoas = quantidadeMaximaPessoas;
    }

    public StatusMesa getStatusMesa() {
        return statusMesa;
    }

    public void setStatusMesa(StatusMesa statusMesa) {
        this.statusMesa = statusMesa;
    }

    public Timestamp getCriadoEM() {
        return criadoEM;
    }

    public void setCriadoEM(Timestamp criadoEM) {
        this.criadoEM = criadoEM;
    }

    public Timestamp getAlteradoEM() {
        return alteradoEM;
    }

    public void setAlteradoEM(Timestamp alteradoEM) {
        this.alteradoEM = alteradoEM;
    }

    public String getCriadoPor() {
        return criadoPor;
    }

    public void setCriadoPor(String criadoPor) {
        this.criadoPor = criadoPor;
    }

    public String getAlteradoPor() {
        return AlteradoPor;
    }

    public void setAlteradoPor(String alteradoPor) {
        AlteradoPor = alteradoPor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Mesa{" + "\n" +
                "id=" + id + "\n" +
                ", funcionario=" + funcionario.getNome() + "\n" +
                ", Reservada Para=" + cliente.getNome() + "\n" +
                ", nome='" + nome + "\n" +
                ", codigo='" + codigo + "\n" +
                ", numero=" + numero + "\n" +
                ", quantidadeMaximaPessoas=" + quantidadeMaximaPessoas + "\n" +
                ", statusMesa=" + statusMesa + "\n" +
                ", criadoEM=" + criadoEM + "\n" +
                ", alteradoEM=" + alteradoEM + "\n" +
                ", criadoPor='" + criadoPor + "\n" +
                ", AlteradoPor='" + AlteradoPor + "\n" +
                '}' + "\n";
    }

    public String toString(Cliente cliente) {
        return "Mesa{" + "\n" +
                "id=" + id + "\n" +
                ", Reservada para=" + cliente.getNome() + "\n" +
                ", nome='" + nome + "\n" +
                ", codigo='" + codigo + "\n" +
                ", numero=" + numero + "\n" +
                ", quantidadeMaximaPessoas=" + quantidadeMaximaPessoas + "\n" +
                ", statusMesa=" + statusMesa + "\n" +
                ", criadoEM=" + criadoEM + "\n" +
                ", alteradoEM=" + alteradoEM + "\n" +
                ", criadoPor='" + criadoPor + "\n" +
                ", AlteradoPor='" + AlteradoPor + "\n" +
                '}' + "\n";
    }
}
