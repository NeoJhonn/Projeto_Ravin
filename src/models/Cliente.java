package models;

import java.sql.Timestamp;
import java.util.Date;

public class Cliente extends Pessoa {
    private String observacoes;
    private boolean temComandaFechada;
    private boolean vip;

    public Cliente() {
        super();
    }

    public Cliente(int id, String nome, String telefone, String endereco, String cpf, Date dataNascimento, boolean ativo, Timestamp criadoEM, Timestamp alteradoEM, String criadoPor, String alteradoPor, String observacoes, boolean vip) {
        super(id, nome, telefone, endereco, cpf, dataNascimento, ativo, criadoEM, alteradoEM, criadoPor, alteradoPor);
        this.observacoes = observacoes;
        this.vip = vip;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public boolean temComandaFechada() {
        return temComandaFechada;
    }

    public void setComandaFechada(boolean temComandaFechada) {
        this.temComandaFechada = temComandaFechada;
    }

    @Override
    public String toString() {
        return "Cliente{" + "\n"+
                super.toString() +
                "observacoes='" + observacoes + "\n"+
                ", vip=" + vip + "\n"+
                "} ";
    }
}
