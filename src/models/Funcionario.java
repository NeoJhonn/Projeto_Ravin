package models;

import enums.*;

import java.sql.Timestamp;
import java.util.Date;

public class Funcionario extends Pessoa {
    private String rg;
    private EstadoCivil estadoCivil;
    private Escolaridade escolaridade;
    private Cargo cargo;
    private int pis;
    private Date dataAdmissao;
    private Date dataDemissap;
    private Disponibilidade disponibilidade;

    public Funcionario() {
        super();
    }

    public Funcionario(int id, String nome, String telefone, String endereco, String cpf, Date dataNascimento, boolean ativo, Timestamp criadoEM, Timestamp alteradoEM, String criadoPor, String alteradoPor, String rg, EstadoCivil estadoCivil, Escolaridade escolaridade, Cargo cargo, int pis, Date dataAdmissao, Date dataDemissap, Disponibilidade disponibilidade) {
        super(id, nome, telefone, endereco, cpf, dataNascimento, ativo, criadoEM, alteradoEM, criadoPor, alteradoPor);
        this.rg = rg;
        this.estadoCivil = estadoCivil;
        this.escolaridade = escolaridade;
        this.cargo = cargo;
        this.pis = pis;
        this.dataAdmissao = dataAdmissao;
        this.dataDemissap = dataDemissap;
        this.disponibilidade = disponibilidade;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Escolaridade getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(Escolaridade escolaridade) {
        this.escolaridade = escolaridade;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public int getPis() {
        return pis;
    }

    public void setPis(int pis) {
        this.pis = pis;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public Date getDataDemissap() {
        return dataDemissap;
    }

    public void setDataDemissap(Date dataDemissap) {
        this.dataDemissap = dataDemissap;
    }

    public Disponibilidade getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Disponibilidade disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    @Override
    public String toString() {
        return "Funcionario{" + '\n' +
                super.toString() +
                "rg='" + rg + '\n' +
                ", estadoCivil=" + estadoCivil + '\n' +
                ", escolaridade=" + escolaridade + '\n' +
                ", cargo=" + cargo + '\n' +
                ", pis=" + pis + '\n' +
                ", dataAdmissao=" + dataAdmissao + '\n' +
                ", dataDemissap=" + dataDemissap + '\n' +
                ", disponibilidade=" + disponibilidade + '\n' +
                "} ";
    }
}
