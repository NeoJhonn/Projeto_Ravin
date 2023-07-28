package models;

import enums.StatusPreparo;
import enums.StatusPreparo;

import java.sql.Timestamp;

public class Pedido {
    private int id;
    private Produto produto;
    private int clienteId;
    private Timestamp dataHoraSolicitacao;
    private Timestamp dataHoraInicioPreparo;
    private Timestamp tempoPreparoRestante;
    private StatusPreparo statusPreparo;
    private String observacao;
    private int quantidade;
    private Timestamp criadoEM;
    private Timestamp alteradoEM;
    private String criadoPor;
    private String AlteradoPor;

    public Pedido() {

    }

    public Pedido(int id, Produto produto, int clienteId, Timestamp dataHoraSolicitacao, Timestamp dataHoraInicioPreparo, Timestamp tempoPreparoRestante, StatusPreparo statusPreparo, String observacao, int quantidade, Timestamp criadoEM, Timestamp alteradoEM, String criadoPor, String alteradoPor) {
        this.id = id;
        this.produto = produto;
        this.clienteId = clienteId;
        this.dataHoraSolicitacao = dataHoraSolicitacao;
        this.dataHoraInicioPreparo = dataHoraInicioPreparo;
        this.tempoPreparoRestante = tempoPreparoRestante;
        this.statusPreparo = statusPreparo;
        this.observacao = observacao;
        this.quantidade = quantidade;
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

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Timestamp getDataHoraSolicitacao() {
        return dataHoraSolicitacao;
    }

    public void setDataHoraSolicitacao(Timestamp dataHoraSolicitacao) {
        this.dataHoraSolicitacao = dataHoraSolicitacao;
    }

    public Timestamp getDataHoraInicioPreparo() {
        return dataHoraInicioPreparo;
    }

    public void setDataHoraInicioPreparo(Timestamp dataHoraInicioPreparo) {
        this.dataHoraInicioPreparo = dataHoraInicioPreparo;
    }

    public Timestamp getTempoPreparoRestante() {
        return tempoPreparoRestante;
    }

    public void setTempoPreparoRestante(Timestamp tempoPreparoRestante) {
        this.tempoPreparoRestante = tempoPreparoRestante;
    }

    public StatusPreparo getStatusPreparo() {
        return statusPreparo;
    }

    public void setStatusPreparo(StatusPreparo statusPreparo) {
        this.statusPreparo = statusPreparo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
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

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }


    @Override
    public String toString() {
        return "Pedido{" + "\n"+
                "id=" + id + "\n"+
                ", produto=" + produto.getNome() + "\n"+
                ", clienteId=" + clienteId + "\n"+
                ", dataHoraSolicitacao=" + dataHoraSolicitacao + "\n"+
                ", dataHoraInicioPreparo=" + dataHoraInicioPreparo + "\n"+
                ", tempoPreparoRestante=" + tempoPreparoRestante + "\n"+
                ", statusPreparo=" + statusPreparo + "\n"+
                ", observacao='" + observacao + "\n"+
                ", quantidade=" + quantidade + "\n"+
                ", criadoEM=" + criadoEM + "\n"+
                ", alteradoEM=" + alteradoEM + "\n"+
                ", criadoPor='" + criadoPor + "\n"+
                ", AlteradoPor='" + AlteradoPor + "\n"+
                '}' + "\n";
    }
}
