package valter.gabriell.io.moneyproject.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import valter.gabriell.io.moneyproject.exceptions.ex.FieldIsNullOrEmpty;
import valter.gabriell.io.moneyproject.exceptions.ex.FieldOutOfRangeOfLenghtException;
import valter.gabriell.io.moneyproject.infra.entities.Category;
import valter.gabriell.io.moneyproject.infra.entities.PaymentType;

class ItemTest {

    Item item;

    @BeforeEach
    void setup() {
        item = new Item(
                "23",
                "     ",
                Category.LOVE,
                PaymentType.CASH,
                30.5
        );
    }

    @Test
    void description_should_throw_an_api_handler_exception_when_lenght_is_out_of_range_of_6_to_200() {
        Assertions.assertThrows(FieldOutOfRangeOfLenghtException.class, ()->{
           item.validateDescriptionOrThrowApiException();
        });
    }

    @Test
    void description_should_throw_an_api_handler_exception_when_is_null_or_empty() {
        Assertions.assertThrows(FieldIsNullOrEmpty.class, ()->{
            item.validateDescriptionOrThrowApiException();
        });
    }
}