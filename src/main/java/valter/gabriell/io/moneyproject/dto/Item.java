package valter.gabriell.io.moneyproject.dto;

import valter.gabriell.io.moneyproject.exceptions.ex.FieldIsNullOrEmpty;
import valter.gabriell.io.moneyproject.exceptions.ex.FieldOutOfRangeOfLenghtException;
import valter.gabriell.io.moneyproject.infra.entities.Category;
import valter.gabriell.io.moneyproject.infra.entities.PaymentType;

public record Item(String id, String description, Category category, PaymentType paymentType, double value
) {
    public void validateDescriptionOrThrowApiException() {
        if (description.isBlank() || description == null)
            throw new FieldIsNullOrEmpty("A descrição não pode estar vazia ou nula");
        if (description.length() < 6 || description.length() > 200)
            throw new FieldOutOfRangeOfLenghtException("A descrição precisa ter entre 6 e 200 caracteres");
    }
}
