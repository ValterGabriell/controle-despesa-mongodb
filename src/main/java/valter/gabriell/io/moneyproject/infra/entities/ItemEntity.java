package valter.gabriell.io.moneyproject.infra.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
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
