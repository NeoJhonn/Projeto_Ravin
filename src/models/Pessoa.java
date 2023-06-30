package models;

import java.sql.Timestamp;
import java.util.Date;

public class Pessoa {
    private int id;
    private String nome;
    private String telefone;
    private String endereco;
    private String cpf;
    private Date dataNascimento;
    private boolean ativo;
    private Timestamp criadoEM;
    private Timestamp alteradoEM;
    private String criadoPor;
    private String AlteradoPor;

    public Pessoa() {

    }

    public Pessoa(int id, String nome, String telefone, String endereco, String cpf, Date dataNascimento, boolean ativo, Timestamp criadoEM, Timestamp alteradoEM, String criadoPor, String alteradoPor) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.ativo = ativo;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
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

    @Override
    public String toString() {
        return  "id=" + id + '\n' +
                ", nome='" + nome + '\n' +
                ", telefone='" + telefone + '\n' +
                ", endereco='" + endereco + '\n' +
                ", cpf='" + cpf + '\n' +
                ", dataNascimento=" + dataNascimento + '\n' +
                ", ativo=" + ativo + '\n' +
                ", criadoEM=" + criadoEM + '\n' +
                ", alteradoEM=" + alteradoEM + '\n' +
                ", criadoPor='" + criadoPor + '\n' +
                ", AlteradoPor='" + AlteradoPor + '\n';
    }
}
