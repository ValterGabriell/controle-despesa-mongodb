package valter.gabriell.io.moneyproject.dto;

import org.springframework.http.HttpStatus;
import valter.gabriell.io.moneyproject.exceptions.ApiHandlerException;
import valter.gabriell.io.moneyproject.infra.entities.Category;
import valter.gabriell.io.moneyproject.infra.entities.PaymentType;

import java.time.LocalDate;

public record Item(String id, String description, Category category, PaymentType paymentType, double value,
                   LocalDate date
) {
    public void validateDescriptionOrThrowApiException() {
        if (description.length() < 6 || description.length() > 200) {
            throw new ApiHandlerException("A descrição precisa ter entre 6 e 200 caracteres", HttpStatus.BAD_REQUEST);
        }

    }
}
