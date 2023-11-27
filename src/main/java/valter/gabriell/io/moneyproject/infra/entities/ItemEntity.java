package valter.gabriell.io.moneyproject.infra.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
public class ItemEntity {
    @Id
    private String id;
    private String description;
    private Category category;
    private PaymentType paymentType;
    private double value;
    private LocalDate date;

    public ItemEntity() {
    }

    public ItemEntity(String id, String description, Category category, PaymentType paymentType, double value, LocalDate date) {
        this.id = id;
        this.description = description;
        this.category = category;
        this.paymentType = paymentType;
        this.value = value;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategoria() {
        return category;
    }

    public void setCategoria(Category category) {
        this.category = category;
    }

    public PaymentType getFormaPgto() {
        return paymentType;
    }

    public void setFormaPgto(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
