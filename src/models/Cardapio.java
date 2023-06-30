package models;

import enums.CategoriaCardapio;

import java.sql.Timestamp;
import java.util.List;

public class Cardapio {
    private int id;
    private List<Produto> produtos;
    private String nome;
    private String codigo;
    private String descricao;
    private CategoriaCardapio categoriaCardapio;
    private boolean ativo;
    private Timestamp criadoEM;
    private Timestamp alteradoEM;
    private String criadoPor;
    private String AlteradoPor;

    public Cardapio() {

    }

    public Cardapio(int id, List<Produto> produtos, String nome, String codigo, String descricao, CategoriaCardapio categoriaCardapio, boolean ativo, Timestamp criadoEM, Timestamp alteradoEM, String criadoPor, String alteradoPor) {
        this.id = id;
        this.produtos = produtos;
        this.nome = nome;
        this.codigo = codigo;
        this.descricao = descricao;
        this.categoriaCardapio = categoriaCardapio;
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

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public CategoriaCardapio getCategoriaCardapio() {
        return categoriaCardapio;
    }

    public void setCategoriaCardapio(CategoriaCardapio categoriaCardapio) {
        this.categoriaCardapio = categoriaCardapio;
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
}
