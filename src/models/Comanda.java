package models;

import enums.StatusComanda;

import java.sql.Timestamp;
import java.util.List;

public class Comanda {
    private int id;
    private int mesaId;
    private int clienteId;
    private String codigo;
    private String observacoes;
    private StatusComanda statusComanda;
    private Timestamp criadoEM;
    private Timestamp alteradoEM;
    private String criadoPor;
    private String AlteradoPor;

    public Comanda() {

    }

    public Comanda(int id, int mesaId, int clienteId, String codigo, String observacoes, StatusComanda statusComanda, Timestamp criadoEM, Timestamp alteradoEM, String criadoPor, String alteradoPor) {
        this.id = id;
        this.mesaId = mesaId;
        this.clienteId = clienteId;
        this.codigo = codigo;
        this.observacoes = observacoes;
        this.statusComanda = statusComanda;
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

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public StatusComanda getStatusComanda() {
        return statusComanda;
    }

    public void setStatusComanda(StatusComanda statusComanda) {
        this.statusComanda = statusComanda;
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

    public int getMesaId() {
        return mesaId;
    }

    public void setMesaId(int mesaId) {
        this.mesaId = mesaId;
    }

    @Override
    public String toString() {
        return "Comanda{" + "\n" +
                "id=" + id + "\n" +
                ", mesaId=" + mesaId + "\n" +
                ", clienteId=" + clienteId + "\n" +
                ", codigo='" + codigo + "\n" +
                ", observacoes='" + observacoes + "\n" +
                ", statusComanda=" + statusComanda + "\n" +
                ", criadoEM=" + criadoEM + "\n" +
                ", alteradoEM=" + alteradoEM + "\n" +
                ", criadoPor='" + criadoPor + "\n" +
                ", AlteradoPor='" + AlteradoPor + "\n" +
                '}' + "\n" ;
    }
}
