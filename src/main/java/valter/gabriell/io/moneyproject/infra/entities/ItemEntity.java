package valter.gabriell.io.moneyproject.infra.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
public class ItemEntity {
    @Id
    private String id;
    private String descricao;
    private Categoria categoria;
    private FormaPgto formaPgto;
    private double valor;
    private LocalDate date;

    public ItemEntity() {
    }

    public ItemEntity(String descricao, Categoria categoria, FormaPgto formaPgto, double valor, LocalDate date) {
        this.descricao = descricao;
        this.categoria = categoria;
        this.formaPgto = formaPgto;
        this.valor = valor;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public FormaPgto getFormaPgto() {
        return formaPgto;
    }

    public void setFormaPgto(FormaPgto formaPgto) {
        this.formaPgto = formaPgto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
