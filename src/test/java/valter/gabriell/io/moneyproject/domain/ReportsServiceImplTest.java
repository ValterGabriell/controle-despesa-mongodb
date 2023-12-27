package valter.gabriell.io.moneyproject.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class ReportsServiceImplTest {


    @Test
    void it_should_return_false_when_last_month_is_different_current_month() {
        //somar os dias de acordo com o dia atual do mes para o teste funcionar, o dia sempre deve ser o 1 do mes
        LocalDate currentDate = LocalDate.now().plusDays(5);

        LocalDate lastDayFromLastMonth = currentDate.minusDays(1);

        boolean equals = currentDate.getMonth().equals(lastDayFromLastMonth.getMonth());

        Assertions.assertFalse(equals);
    }
}