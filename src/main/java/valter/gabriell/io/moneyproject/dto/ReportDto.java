package valter.gabriell.io.moneyproject.dto;

import valter.gabriell.io.moneyproject.infra.entities.Category;
import valter.gabriell.io.moneyproject.infra.entities.ItemEntity;
import valter.gabriell.io.moneyproject.infra.entities.PaymentType;

import java.util.List;

public class ReportDto {
    private String message;
    private Category mostUseCategory;
    private PaymentType mostUsePaymentType;
    private List<ItemEntity> lastMonthItemEntity;

    public ReportDto(String message, Category mostUseCategory, PaymentType mostUsePaymentType, List<ItemEntity> lastMonthItemEntity) {
        this.message = message;
        this.mostUseCategory = mostUseCategory;
        this.mostUsePaymentType = mostUsePaymentType;
        this.lastMonthItemEntity = lastMonthItemEntity;
    }

    public String getMessage() {
        return message;
    }

    public Category getMostUseCategory() {
        return mostUseCategory;
    }

    public PaymentType getMostUsePaymentType() {
        return mostUsePaymentType;
    }

    public List<ItemEntity> getLastMonthItemEntity() {
        return lastMonthItemEntity;
    }

    @Override
    public String toString() {
        return "ReportDto{" +
                "message='" + message + '\'' +
                ", mostUseCategory=" + mostUseCategory +
                ", mostUsePaymentType=" + mostUsePaymentType +
                ", lastMonthItemEntity=" + lastMonthItemEntity +
                '}';
    }
}
